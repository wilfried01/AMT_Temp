package ch.heig.amt2021.integration;

import ch.heig.amt2021.bean.UserAccount;
import ch.heig.amt2021.model.Client;
import ch.heig.amt2021.model.Trajet;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ClientDAOLocal {
    List<Client> getClient();
    void setTrajet(int trajet, int user);
    void deleteTrajet(int userID);
    void setSolde(float montant, int userID);
    Client getClient(int id);
    void addClient(int id);
    void deleteClient(int utilisateur_id);
}
