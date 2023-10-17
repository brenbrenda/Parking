package fr.isep.parking.model;


import org.json.JSONException;
import org.json.JSONObject;

public class ParkingJson {
    // Define fields that match your JSON keys
    private String regpri;
    private String regpar;
    private Geo geo;
//    private int arrond;
    private String typsta;
//    private int placal;
//    private int plarel;
//    private String zoneres;
//    private String locsta;
//    private String numvoie;
//    private String typevoie;
//    private String nomvoie;
//    private String compnumvoie;
//    private String locnum;
//    private String parite;
//    private double lon;
//    private double lar;
//    private double surface_calculee;
//    private String signhor;
//    private String signvert;
//    private String confsign;
//    private String typemob;
//    private int nummob;
//    private String plage_hor1_debut;
//    private String plage_hor1_fin;
//    private String plage_hor2_debut;
//    private String plage_hor2_fin;
//    private String plage_hor3_debut;
//    private String plage_hor3_fin;
//    private String id;
//    private String id_old;
//    private String c_voie_vp;
//    private String n_sq_tv;
//    private String numilot;
//    private String numiris;
//    private String zoneasp;
//    private String stv;
//    private String prefet;
//    private String mtlast_edit_date_field;
//    private String datereleve;
//    private int n_voieadd;
//    private int n_voieadf;
    private Geo_shape geo_shape;
//    private Geo_point_2d geo_point_2d;

    public String getRegpri() {
        return regpri;
    }

    public void setRegpri(String regpri) {
        this.regpri = regpri;
    }

    public String getRegpar() {
        return regpar;
    }

    public void setRegpar(String regpar) {
        this.regpar = regpar;
    }

    public double getLat() {
        return geo.lat;
    }

    public void setLat(double lat) {
        this.geo.lat = lat;
    }

    public double getLon() {
        return geo.lon;
    }

    public void setLon(double lon) {
        this.geo.lon = lon;
    }


    public class Geo {
        private double lon;
        private double lat;
    }

    public class Geo_shape {
        private Geo geo;
    }

    public class Geo_point_2d {
        private double lon;
        private double lat;
    }


    private ParkingJson parseParkingData(JSONObject json) {
        // Implement parsing logic based on your API response structure
        ParkingJson parkingData = new ParkingJson();
        try {
            parkingData.setRegpri(json.getString("regpri"));
            parkingData.setRegpar(json.getString("regpar"));

            parkingData.setLon(json.getDouble("lon"));
            parkingData.setLat(json.getDouble("lar"));
//            parkingData.setSurface_calculee(json.getDouble("surface_calculee"));
//            parkingData.setSignhor(json.getString("signhor"));
//            parkingData.setSignvert(json.getString("signvert"));
//            parkingData.setConfsign(json.getString("confsign"));
//            parkingData.setTypemob(json.getString("typemob"));
//            parkingData.setNummob(json.getInt("nummob"));
//            parkingData.setPlage_hor1_debut(json.getString("plage_hor1_debut"));
//            parkingData.setPlage_hor1_fin(json.getString("plage_hor1_fin"));
//            parkingData.setPlage_hor2_debut(json.getString("plage_hor2_debut"));
//            parkingData.setPlage_hor2_fin(json.getString("plage_hor2_fin"));
//            parkingData.setPlage_hor3_debut(json.getString("plage_hor3_debut"));
//            parkingData.setPlage_hor3_fin(json.getString("plage_hor3_fin"));
//            parkingData.setId(json.getString("id"));
//            parkingData.setId_old(json.getString("id_old"));
//            parkingData.setC_voie_vp(json.getString("c_voie_vp"));
//            parkingData.setN_sq_tv(json.getString("n_sq_tv"));
//            parkingData.setNumilot(json.getString("numilot"));
//            parkingData.setNumiris(json.getString("numiris"));
//            parkingData.setZoneasp(json.getString("zoneasp"));
//            parkingData.setStv(json.getString("stv"));
//            parkingData.setPrefet(json.getString("prefet"));
//            parkingData.setMtlast_edit_date_field(json.getString("mtlast_edit_date_field"));
//            parkingData.setDatereleve(json.getString("datereleve"));
//            parkingData.setN_voieadd(json.getInt("n_voieadd"));
//            parkingData.setN_voieadf(json.getInt("n_voieadf"));
            // Add other fields here
            // You might need to implement geo_shape and geo_point_2d parsing logic if needed
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return parkingData;
    }
}