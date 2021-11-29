package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Station;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface StationDAORemote extends DAORemote <Station> {
    List<Station> getAllStations();
}
