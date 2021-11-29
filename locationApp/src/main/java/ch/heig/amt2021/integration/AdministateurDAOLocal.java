package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Administrateur;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AdministateurDAOLocal {
    List<Administrateur> getAdmin();
}
