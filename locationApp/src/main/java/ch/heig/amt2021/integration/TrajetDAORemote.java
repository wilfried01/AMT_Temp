package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Trajet;

import java.util.List;

public interface TrajetDAORemote extends DAORemote <Trajet> {
    List<Trajet> getAllTrajets();
}
