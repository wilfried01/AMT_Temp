package ch.heig.amt2021.model;

import java.io.Serializable;

public class Administrateur implements Serializable {

    private int utilisateur_id;

    public Administrateur(int utilisateur_id){
        this.utilisateur_id = utilisateur_id;
    }

    public int getUtilisateur_id() { return utilisateur_id;    };

    public void setUtilisateur_id(int utilisateur_id) { this.utilisateur_id = utilisateur_id;    };
}
