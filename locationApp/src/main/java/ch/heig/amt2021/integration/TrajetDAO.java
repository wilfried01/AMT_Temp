package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Trajet;
import ch.heig.amt2021.model.Utilisateur;

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
public class TrajetDAO implements TrajetDAOLocal {

    @Resource(lookup = "jdbc/Lab1_AMT")  // pour SGBD externe
    private DataSource dataSource;

    @Override
    public List<Trajet> getTrajets() {
        List<Trajet> trajets = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT * FROM trajet");) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt(1);
                int vehicule_id1 = rs.getInt(2);
                int destination_emplacement_id1 = rs.getInt(3);
                int destination_station_id1 = rs.getInt(4);
                int duree1 = rs.getInt(5);
                float price1 = rs.getFloat(6);

                Trajet trajet1 = new Trajet(id1, vehicule_id1, destination_emplacement_id1, destination_station_id1, duree1, price1);
                trajets.add(trajet1);
            }
        } catch (SQLException e) {
            Logger.getLogger(TrajetDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return trajets;
    }

    @Override
    public void addTrajet(int vehiculeID, int emplacementDestination,int stationDestination) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement
                        ("insert into trajet (vehicule_id, destination_emplacement_id, destination_Station_id, duree, price) values (?,?,?, null, null)");) {

            pstmt.setInt(1, vehiculeID);
            pstmt.setInt(2, emplacementDestination);
            pstmt.setInt(3, stationDestination);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(TrajetDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void supTrajet(int id) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement
                        ("delete from trajet where id=?");) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(TrajetDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    public Trajet getTrajetViaVehicule(int vehiculeID){

            Trajet trajet = null;
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement pstmt = connection.prepareStatement(
                         "SELECT * FROM trajet " +
                                "where vehicule_id=?");) {
                pstmt.setInt(1,vehiculeID);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    int id1 = rs.getInt(1);
                    int vehicule_id1 = rs.getInt(2);
                    int destination_emplacement_id1 = rs.getInt(3);
                    int destination_station_id1 = rs.getInt(4);
                    int duree1 = rs.getInt(5);
                    float price1 = rs.getFloat(6);

                    trajet = new Trajet(id1, vehicule_id1, destination_emplacement_id1, destination_station_id1, duree1, price1);


                }
            } catch (SQLException e) {
                Logger.getLogger(TrajetDAO.class.getName()).log(Level.SEVERE, null, e);
            }
            return trajet;
        }

}
