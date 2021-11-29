package ch.heig.amt2021.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Station implements Serializable {

    private int id;
    private String adresse;


    public Station(int id, String adresse) {
        this.id = id;
        this.adresse = adresse;
    }

    public Station() {
        this(0, "");
    }

    public Station(String adresse) {
        this(0, adresse);
    }

    public void setId(int id){this.id = id;}

    public int getId() { return id;  }

    public void setAdresse(String adresse) { this.adresse = adresse;  }

    public String getAdresse() { return adresse; }

}
