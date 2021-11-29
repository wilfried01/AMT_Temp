package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Client;
import ch.heig.amt2021.model.Prix;

import java.util.List;

public interface ClientDAORemote extends DAORemote <Client> {
    List<Client> getAllClients();
}
