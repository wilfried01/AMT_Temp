package ch.heig.amt2021.bean;

import ch.heig.amt2021.model.Vehicule;

public class EmplacementUtilisation {

    private int station_id;
    private int emplacement_id;
    private int id = 0;
    private boolean occupe = false;
    private boolean reserve = false;
    private String adresse;
    private Vehicule vehicule;

    public EmplacementUtilisation() {

    }

    public EmplacementUtilisation(int station_id, int id, boolean occupe, String adresse) {
        this.station_id = station_id;
        this.emplacement_id = id;
        this.occupe = occupe;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean isReserve() {
        return reserve;
    }

    public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public int getEmplacement_id() {
        return emplacement_id;
    }

    public void setEmplacement_id(int emplacement_id) {
        this.emplacement_id = emplacement_id;
    }

    public boolean isOccupe() {
        return occupe;
    }

    public void setOccupe(boolean occupe) {
        this.occupe = occupe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

}
