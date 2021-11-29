package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Vehicule;

import java.util.List;

public interface VehiculeDAORemote extends DAORemote <Vehicule> {
    List<Vehicule> getAllVehicules();
}
