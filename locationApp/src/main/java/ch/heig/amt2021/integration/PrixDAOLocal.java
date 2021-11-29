package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Prix;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PrixDAOLocal {
    List<Prix> getPrix();
}
