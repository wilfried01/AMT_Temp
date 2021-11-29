package ch.heig.amt2021.model;

import java.io.Serializable;

public class Vehicule implements Serializable {

    private int id;
    private String matricule;
    private int emplacement_id;
    private int station_id;
    private String categorie;

    public Vehicule(){

    }

    public Vehicule(int id, String matricule, int emplacement_id, int station_id, String categorie) {
        this.id = id;
        this.matricule = matricule;
        this.emplacement_id = emplacement_id;
        this.station_id = station_id;
        this.categorie = categorie;
    }

    public int getId() { return id;    }

    public void setId(int id) { this.id = id;    }

    public String getMatricule() {    return matricule;    }

    public void setMatricule(String matricule) {  this.matricule = matricule;    }

    public int getEmplacement_id() { return emplacement_id;    }

    public void setEmplacement_id(int emplacement_id) {  this.emplacement_id = emplacement_id;    }

    public int getStation_id() { return station_id;    }

    public void setStation_id(int station_id) { this.station_id = station_id;    }

    public String getCategorie() {  return categorie;    }

    public void setCategorie(String categorie) { this.categorie = categorie;    }
}
