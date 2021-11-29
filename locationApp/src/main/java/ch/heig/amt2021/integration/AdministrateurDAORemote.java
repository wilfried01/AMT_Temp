package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Administrateur;

import java.util.List;

public interface AdministrateurDAORemote extends DAORemote<Administrateur>{
    List<Administrateur> getAllAdministrateurs();
}
