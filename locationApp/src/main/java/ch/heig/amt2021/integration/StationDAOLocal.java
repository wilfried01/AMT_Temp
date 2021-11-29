package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Station;

import javax.ejb.Local;
import java.util.List;

@Local
public interface StationDAOLocal {
    List<Station> getStations();
}
