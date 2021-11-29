package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Trajet;

import javax.ejb.Local;
import java.util.List;

@Local
public interface TrajetDAOLocal {
    List<Trajet> getTrajets();
    void addTrajet( int vehiculeID, int emplacementDestination,int stationDestination);
    Trajet getTrajetViaVehicule(int vehiculeID);
    void supTrajet(int id);
}
