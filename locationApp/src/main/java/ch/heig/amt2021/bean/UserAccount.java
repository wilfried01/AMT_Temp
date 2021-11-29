package ch.heig.amt2021.bean;

import ch.heig.amt2021.model.Trajet;
import ch.heig.amt2021.model.Vehicule;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {

    private String userName;
    private String password;
    private List<String> roles;
    private int id;
    private boolean admin = false;
    private int trajetId = 0;
    private float solde = 0;
    private Trajet trajet;
    private Vehicule vehicule;

    public UserAccount() {

    }

    public UserAccount(String userName, String password, String... roles) {
        this.userName = userName;
        this.password = password;

        this.roles = new ArrayList<String>();
        if (roles != null) {
            for (String r : roles) {
                this.roles.add(r);
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public int getTrajetId() { return trajetId;    }

    public void setTrajetId(int trajetId) { this.trajetId = trajetId;    }

    public float getSolde() { return solde;    }

    public void setSolde(float solde) {  this.solde = solde;    }

    public boolean isAdmin() {        return admin;    }

    public void setAdmin(boolean admin) {        this.admin = admin;    }

    public int getId() { return id;    }

    public void setId(int id) { this.id = id;    }

    public Trajet getTrajet() { return trajet; }

    public void setTrajet(Trajet trajet) { this.trajet = trajet;    }

    public Vehicule getVehicule() { return vehicule;    }

    public void setVehicule(Vehicule vehicule) { this.vehicule = vehicule;    }

}