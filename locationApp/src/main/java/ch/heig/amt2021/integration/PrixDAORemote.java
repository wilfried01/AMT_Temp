package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Prix;

import java.util.List;

public interface PrixDAORemote extends DAORemote <Prix> {
    List<Prix> getAllPrices();
}
