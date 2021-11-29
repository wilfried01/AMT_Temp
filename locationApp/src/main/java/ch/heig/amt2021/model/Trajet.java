package ch.heig.amt2021.model;

import java.io.Serializable;

public class Trajet implements Serializable {

    private int id;
    private int vehicule_id;
    private int destination_emplacement_id;
    private int destination_station_id;
    private int duree;
    private float price;

    public Trajet(int id, int vehicule_id, int destination_emplacement_id, int destination_station_id, int duree, float price) {
        this.id = id;
        this.vehicule_id = vehicule_id;
        this.destination_emplacement_id = destination_emplacement_id;
        this.destination_station_id = destination_station_id;
        this.duree = duree;
        this.price = price;
    }

    public int getId() {  return id;    }

    public void setId(int id) {    this.id = id;    }

    public int getVehicule_id() {   return vehicule_id;    }

    public void setVehicule_id(int vehicule_id) {  this.vehicule_id = vehicule_id;    }

    public int getDestination_emplacement_id() {  return destination_emplacement_id;    }

    public void setDestination_emplacement_id(int destination_emplacement_id) { this.destination_emplacement_id = destination_emplacement_id;}

    public int getDestination_station_id() {   return destination_station_id;    }

    public void setDestination_station_id(int destination_station_id) {   this.destination_station_id = destination_station_id;    }

    public int getDuree() {  return duree;    }

    public void setDuree(int duree) { this.duree = duree;    }

    public float getPrice() {  return price;    }

    public void setPrice(float price) {   this.price = price;   }
}
