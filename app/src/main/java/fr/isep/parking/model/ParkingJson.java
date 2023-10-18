package fr.isep.parking.model;


import java.util.List;
public class ParkingJson {

    private String regpri;
    private String regpar;
    private String typsta;
    private int arrond;
    private int placal;
    private int plarel;
    private String zoneres;
    private String locsta;
    private String numvoie;
    private String typevoie;
    private String nomvoie;
    private String compnumvoie;
    private String locnum;
    private String parite;
    private double lon;
    private double lar;
    //        private double surfaceCalculee;
    private String signhor;
    private String signvert;
    private String confsign;
    private String typemob;
    private int nummob;
    private String plageHor1Debut;
    private String plageHor1Fin;
    private String plageHor2Debut;
    private String plageHor2Fin;
    private String plageHor3Debut;
    private String plageHor3Fin;
    private String id;
    private String idOld;
    private String cVoieVp;
    private String nSqTv;
    private String numilot;
    private String numiris;
    private String zoneasp;
    private String stv;
    private String prefet;
    private String mtlastEditDateField;
    private String datereleve;
    private int nVoieadd;
    private int nVoieadf;
    private double latitude;
    private double longitude;
    private Geo_shape geo_shape;
    private Geo_point_2d geo_point_2d;

    public static class Geo {
        private double lon;
        private double lat;
    }

    public static class Geo_shape {
        private Geo geo;
    }

    public static class Geo_point_2d {
        private double lon;
        private double lat;
    }


    // Constructors
//    public ParkingJson(String regpri, String regpar, String typsta, int arrond, int placal, int plarel, String zoneres, String locsta, int numvoie, String typevoie, String nomvoie, String compnumvoie, String locnum, String parite, double lon, double lar, double surfaceCalculee, String signhor, String signvert, String confsign, String typemob, int nummob, Geo geo, Geo_shape geo_shape) {
//        this.regpri = regpri;
//        this.regpar = regpar;
//        this.typsta = typsta;
//        this.arrond = arrond;
//        this.placal = placal;
//        this.plarel = plarel;
//        this.zoneres = zoneres;
//        this.locsta = locsta;
//        this.numvoie = numvoie;
//        this.typevoie = typevoie;
//        this.nomvoie = nomvoie;
//        this.compnumvoie = compnumvoie;
//        this.locnum = locnum;
//        this.parite = parite;
//        this.lon = lon;
//        this.lar = lar;
//        this.surfaceCalculee = surfaceCalculee;
//        this.signhor = signhor;
//        this.signvert = signvert;
//        this.confsign = confsign;
//        this.typemob = typemob;
//        this.nummob = nummob;
//        this.geo = geo;
//        this.geo_shape = geo_shape;
//    }


    // Getter and setter methods for each field

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

    public String getTypsta() {
        return typsta;
    }

    public void setTypsta(String typsta) {
        this.typsta = typsta;
    }

    public int getArrond() {
        return arrond;
    }

    public void setArrond(int arrond) {
        this.arrond = arrond;
    }

    public int getPlacal() {
        return placal;
    }

    public void setPlacal(int placal) {
        this.placal = placal;
    }

    public int getPlarel() {
        return plarel;
    }

    public void setPlarel(int plarel) {
        this.plarel = plarel;
    }

    public String getZoneres() {
        return zoneres;
    }

    public void setZoneres(String zoneres) {
        this.zoneres = zoneres;
    }

    public String getLocsta() {
        return locsta;
    }

    public void setLocsta(String locsta) {
        this.locsta = locsta;
    }

    public String getNumvoie() {
        return numvoie;
    }

    public void setNumvoie(String numvoie) {
        this.numvoie = numvoie;
    }

    public String getTypevoie() {
        return typevoie;
    }

    public void setTypevoie(String typevoie) {
        this.typevoie = typevoie;
    }

    public String getNomvoie() {
        return nomvoie;
    }

    public void setNomvoie(String nomvoie) {
        this.nomvoie = nomvoie;
    }

    public String getCompnumvoie() {
        return compnumvoie;
    }

    public void setCompnumvoie(String compnumvoie) {
        this.compnumvoie = compnumvoie;
    }

    public String getLocnum() {
        return locnum;
    }

    public void setLocnum(String locnum) {
        this.locnum = locnum;
    }

    public String getParite() {
        return parite;
    }

    public void setParite(String parite) {
        this.parite = parite;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLar() {
        return lar;
    }

    public void setLar(double lar) {
        this.lar = lar;
    }

//        public double getSurfaceCalculee() {
//            return surfaceCalculee;
//        }
//
//        public void setSurfaceCalculee(double surfaceCalculee) {
//            this.surfaceCalculee = surfaceCalculee;
//        }

    public String getSignhor() {
        return signhor;
    }

    public void setSignhor(String signhor) {
        this.signhor = signhor;
    }

    public String getSignvert() {
        return signvert;
    }

    public void setSignvert(String signvert) {
        this.signvert = signvert;
    }

    public String getConfsign() {
        return confsign;
    }

    public void setConfsign(String confsign) {
        this.confsign = confsign;
    }

    public String getTypemob() {
        return typemob;
    }

    public void setTypemob(String typemob) {
        this.typemob = typemob;
    }

    public int getNummob() {
        return nummob;
    }

    public void setNummob(int nummob) {
        this.nummob = nummob;
    }

    public String getPlageHor1Debut() {
        return plageHor1Debut;
    }

    public void setPlageHor1Debut(String plageHor1Debut) {
        this.plageHor1Debut = plageHor1Debut;
    }

    public String getPlageHor1Fin() {
        return plageHor1Fin;
    }

    public void setPlageHor1Fin(String plageHor1Fin) {
        this.plageHor1Fin = plageHor1Fin;
    }

    public String getPlageHor2Debut() {
        return plageHor2Debut;
    }

    public void setPlageHor2Debut(String plageHor2Debut) {
        this.plageHor2Debut = plageHor2Debut;
    }

    public String getPlageHor2Fin() {
        return plageHor2Fin;
    }

    public void setPlageHor2Fin(String plageHor2Fin) {
        this.plageHor2Fin = plageHor2Fin;
    }

    public String getPlageHor3Debut() {
        return plageHor3Debut;
    }

    public void setPlageHor3Debut(String plageHor3Debut) {
        this.plageHor3Debut = plageHor3Debut;
    }

    public String getPlageHor3Fin() {
        return plageHor3Fin;
    }

    public void setPlageHor3Fin(String plageHor3Fin) {
        this.plageHor3Fin = plageHor3Fin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOld() {
        return idOld;
    }

    public void setIdOld(String idOld) {
        this.idOld = idOld;
    }

    public String getCVoieVp() {
        return cVoieVp;
    }

    public void setCVoieVp(String cVoieVp) {
        this.cVoieVp = cVoieVp;
    }

    public String getNSqTv() {
        return nSqTv;
    }

    public void setNSqTv(String nSqTv) {
        this.nSqTv = nSqTv;
    }

    public String getNumilot() {
        return numilot;
    }

    public void setNumilot(String numilot) {
        this.numilot = numilot;
    }

    public String getNumiris() {
        return numiris;
    }

    public void setNumiris(String numiris) {
        this.numiris = numiris;
    }

    public String getZoneasp() {
        return zoneasp;
    }

    public void setZoneasp(String zoneasp) {
        this.zoneasp = zoneasp;
    }

    public String getStv() {
        return stv;
    }

    public void setStv(String stv) {
        this.stv = stv;
    }

    public String getPrefet() {
        return prefet;
    }

    public void setPrefet(String prefet) {
        this.prefet = prefet;
    }

    public String getMtlastEditDateField() {
        return mtlastEditDateField;
    }

    public void setMtlastEditDateField(String mtlastEditDateField) {
        this.mtlastEditDateField = mtlastEditDateField;
    }

    public String getDatereleve() {
        return datereleve;
    }

    public void setDatereleve(String datereleve) {
        this.datereleve = datereleve;
    }

    public int getNVoieadd() {
        return nVoieadd;
    }

    public void setNVoieadd(int nVoieadd) {
        this.nVoieadd = nVoieadd;
    }

    public int getNVoieadf() {
        return nVoieadf;
    }

    public void setNVoieadf(int nVoieadf) {
        this.nVoieadf = nVoieadf;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
