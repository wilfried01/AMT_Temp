package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Utilisateur;

import java.util.List;

public interface UtilisateurDAORemote extends DAORemote <Utilisateur> {
    List<Utilisateur> getAllUtilisateurs();
}
