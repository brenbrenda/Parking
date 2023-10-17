package fr.isep.parking.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
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
                        for (LatLng latlng : model.latLngList) {

                            MarkerOptions marker = new MarkerOptions()
                                    .position(latlng)
                                            .title("Mark");
                            googleMap.addMarker(marker);
                            bounds.include(latlng);
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
        @Override
        public void run() {
            try {
                URL apiUrl = new URL("https://opendata.paris.fr/api/explore/v2.1/catalog/datasets/stationnement-voie-publique-emplacements/records?limit=10");
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
                    JSONArray results = jsonObject.getJSONArray("results");
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject item = results.getJSONObject(i);
                        String regpri = item.getString("regpri");
                        JSONObject geoShape = item.getJSONObject("geo_shape");
                        JSONObject geometry = geoShape.getJSONObject("geometry");
                        JSONArray coordinates = geometry.getJSONArray("coordinates");

                        double lat = coordinates.getDouble(1);
                        double lon = coordinates.getDouble(0);
                        System.out.println(String.format("Lat: %f, Lon: %f", lat, lon));
                        LatLng latlng = new LatLng(lat, lon);
                        latLngList.add(latlng);
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}