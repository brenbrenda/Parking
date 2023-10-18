package fr.isep.parking.view;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import fr.isep.parking.R;
import fr.isep.parking.model.ParkingJson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetchData model = new fetchData();
        model.start();

        Log.d("LatLng List Size", String.valueOf(model.latLngList.size()));
        for (LatLng latLng : model.latLngList) {
            Log.d("LatLng", latLng.toString());
        }
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                    @Override
                    public void onMapLoaded() {
                        LatLngBounds.Builder bounds = new LatLngBounds.Builder();
                        for (ParkingJson parking : model.parkingList) {
                            //todo when  does not catch the data
                            LatLng latLng = new LatLng(parking.getLatitude(), parking.getLongitude());

                            MarkerOptions marker = new MarkerOptions()
                                    .position(latLng)
                                    .title("Address: " + parking.getNumvoie() + " " + parking.getTypevoie() + "," + parking.getNomvoie() + "," + parking.getArrond() + "\n" +
                                            "Locate on: " + parking.getLocnum())
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

                            googleMap.addMarker(marker);
                            bounds.include(latLng);


                        }
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), 20));
                    }
                });
            }
        });


    }



    class fetchData extends Thread {
        String data = "";
        ArrayList<LatLng> latLngList = new ArrayList<LatLng>(); // Store LatLng objects
        ArrayList<String> result;
        ArrayList<ParkingJson> parkingList = new ArrayList<ParkingJson>();
        @Override
        public void run() {
            try {
                //to do when there is no internet connection use toast to show the situation
                URL apiUrl = new URL("https://opendata.paris.fr/api/explore/v2.1/catalog/datasets/stationnement-voie-publique-emplacements/records?limit=100");
                HttpURLConnection httpURLConnection = (HttpURLConnection) apiUrl.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bf;
                bf = new BufferedReader(new InputStreamReader(inputStream));

                String line = bf.readLine();

                while (line != null) {
                    data = data + line;
                    line = bf.readLine();
                }
                if (!data.isEmpty()) {
                    JSONObject jsonObject = new JSONObject(data);
                    Log.d("res::", data.toString());
                    JSONArray results = jsonObject.getJSONArray("results");
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject item = results.getJSONObject(i);
                        ParkingJson parking = new ParkingJson();
                        parking.setRegpri(item.getString("regpri"));
                        parking.setRegpar(item.getString("regpar"));
                        parking.setTypsta(item.getString("typsta"));
                        parking.setArrond(item.getInt("arrond"));
                        parking.setPlacal(item.getInt("placal"));
                        parking.setArrond(item.getInt("arrond"));
                        parking.setPlacal(item.getInt("placal"));
                        parking.setPlarel(item.getInt("plarel"));
                        parking.setZoneres(item.getString("zoneres"));
                        parking.setLocsta(item.getString("locsta"));
                        parking.setNumvoie(item.getString("numvoie"));
                        parking.setTypevoie(item.getString("typevoie"));
                        parking.setNomvoie(item.getString("nomvoie"));
                        parking.setCompnumvoie(item.getString("compnumvoie"));
                        parking.setLocnum(item.getString("locnum"));

                        JSONObject geoShape = item.getJSONObject("geo_shape");
                        JSONObject geometry = geoShape.getJSONObject("geometry");
                        JSONArray coordinates = geometry.getJSONArray("coordinates");
                        double lat = coordinates.getDouble(1);
                        double lon = coordinates.getDouble(0);
                        parking.setLatitude(lat);
                        parking.setLongitude(lon);

                        // Add the ParkingJson object to the list
                        parkingList.add(parking);

                        LatLng latlng = new LatLng(lat, lon);
                        latLngList.add(latlng);
                    }
                }
            } catch (MalformedURLException e) {
                Log.d("error","MalformedURLException");
                e.printStackTrace();
            } catch (JSONException e) {
                Log.d("error","JSONException");
                throw new RuntimeException(e);
            } catch (IOException e) {
                Log.d("error","IOException");
//                Toast.makeText(context, "Network error. Please check your internet connection.", Toast.LENGTH_LONG).show();

                throw new RuntimeException(e);
            }
        }
    }


}