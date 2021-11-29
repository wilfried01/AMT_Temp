package ch.heig.amt2021.model;

import java.io.Serializable;
import java.util.Objects;

public class Emplacement implements Serializable {

    private int id;
    private int station_id;
    private boolean occupe = false;

    public Emplacement(){

    }

    public Emplacement(int id, int station_id) {
        this.id = id;
        this.station_id = station_id;
    }
    public void setId(int id) {  this.id = id;    }

    public int getId() { return id;    }

    public void setStation_id(int station_id) {   this.station_id = station_id;    }

    public int getStation_id() {  return station_id;    }

    public boolean isOccupe() {
        return occupe;
    }

    public void setOccupe(boolean occupe) {
        this.occupe = occupe;
    }

}
