package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Station;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class StationDAO implements StationDAOLocal, StationDAORemote{

    @Resource(lookup = "jdbc/Lab1_AMT")  // pour SGBD externe
    private DataSource dataSource;

    @Override
    public List<Station> getStations() {
        List<Station> stations = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT * FROM station");){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int id1 = rs.getInt(1);
                String adresse1 = rs.getString(2);
                Station station1 = new Station(id1,adresse1);

                stations.add(station1);
            }
        }   catch (SQLException e){
            Logger.getLogger(StationDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return stations;
    }

    @Override
    public void add(Station station) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement
                        ("INSERT INTO `Station` (`adresse`)\n" +
                                "VALUES (?)");) {
            pstmt.setString(1, station.getAdresse());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            Logger.getLogger(StationDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void create() {

    }

    @Override
    public List<Station> getAllStations() {
        return null;
    }
}
