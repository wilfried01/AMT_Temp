package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Emplacement;

import javax.ejb.Local;
import java.util.List;

@Local
public interface EmplacementDAOLocal {
    List<Emplacement> getEmplacements();
}
