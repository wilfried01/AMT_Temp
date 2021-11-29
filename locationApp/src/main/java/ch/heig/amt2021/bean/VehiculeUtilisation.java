package ch.heig.amt2021.bean;

public class VehiculeUtilisation {

    int id;
    String matricule;
    int emplacement_id;
    int station_id;
    String categorie;
    int user_id;
    int trajet_id = 0;
    boolean reserve = false;


    public VehiculeUtilisation(){

    }
    public VehiculeUtilisation(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getEmplacement_id() {
        return emplacement_id;
    }

    public void setEmplacement_id(int emplacement_id) {
        this.emplacement_id = emplacement_id;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isReserve() {
        return reserve;
    }

    public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }

    public int getTrajet_id() {
        return trajet_id;
    }

    public void setTrajet_id(int trajet_id) {
        this.trajet_id = trajet_id;
    }


}
