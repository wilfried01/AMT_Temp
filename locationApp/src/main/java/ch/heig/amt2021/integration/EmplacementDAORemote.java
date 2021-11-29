package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Emplacement;

import java.util.List;

public interface EmplacementDAORemote extends DAORemote <Emplacement> {
    List<Emplacement> getAllEmplacements();
}
