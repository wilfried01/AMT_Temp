package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Vehicule;

import javax.ejb.Local;
import java.util.List;

@Local
public interface VehiculeDAOLocal {
    List<Vehicule> getVehiculeViaID();
    void setEmplacement(int id, int noEmplacementDepart, int numeroStationDepart);
    Vehicule getVehiculeViaID(int id);
}
