package ch.heig.amt2021.model;

import java.io.Serializable;

public class Client implements Serializable {

    private int utilisateur_id;
    private int trajet_id;
    private float solde;

    public Client(int utilisateur_id, int trajet_id, float solde) {
        this.utilisateur_id = utilisateur_id;
        this.trajet_id = trajet_id;
        this.solde = solde;

    }

    public int getUtilisateur_id() { return utilisateur_id;    }

    public void setUtilisateur_id(int utilisateur_id) { this.utilisateur_id = utilisateur_id;    }

    public int getTrajet_id() { return trajet_id;    }

    public void setTrajet_id(int trajet_id) {  this.trajet_id = trajet_id;    }

    public float getSolde() { return solde;    }

    public void setSolde(float solde) { this.solde = solde;    }
}
