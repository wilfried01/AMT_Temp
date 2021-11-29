package ch.heig.amt2021.integration;

import ch.heig.amt2021.bean.UserAccount;
import ch.heig.amt2021.model.Client;
import ch.heig.amt2021.model.Trajet;
import ch.heig.amt2021.model.Utilisateur;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class ClientDAO implements ClientDAOLocal{

    @Resource(lookup = "jdbc/Lab1_AMT")  // pour SGBD externe
    private DataSource dataSource;


    @Override
    public List<Client> getClient() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT * FROM client");) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int utilisateur_id1 = rs.getInt(1);
                int trajet_id1 = rs.getInt(2);
                float solde1 = rs.getFloat(3);
                Client client = new Client(utilisateur_id1,trajet_id1,solde1);
                clients.add(client);
            }
        } catch (SQLException e) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return clients;
        }

    @Override
        public void setTrajet(int trajetId, int userID){
            try(
                    Connection connection = dataSource.getConnection();
                    PreparedStatement pstmt = connection.prepareStatement
                    ("update client set trajet_id=? where utilisateur_id =?");){
                pstmt.setInt(1, trajetId);
                pstmt.setInt(2, userID);
                pstmt.executeUpdate();
            }catch(SQLException e){
        Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, e);
    }


        }

    @Override
        public void deleteTrajet(int userID) {
            try (
                    Connection connection = dataSource.getConnection();
                    PreparedStatement pstmt = connection.prepareStatement
                            ("update client set trajet_id=? where utilisateur_id =?");) {
                pstmt.setNull(1, Types.NULL);
                pstmt.setInt(2, userID);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    @Override
    public void setSolde(float montant, int userID) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement
                        ("update client set solde=? where utilisateur_id =?");) {
            pstmt.setFloat(1, montant);
            pstmt.setInt(2, userID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Client getClient(int utilisateurId) {
        Client client = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT * FROM client " +
                             "where utilisateur_id=?");) {
            pstmt.setInt(1,utilisateurId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int utilisateur_id = rs.getInt(1);
                int trajet_id = rs.getInt(2);
                float solde = rs.getFloat(3);

                client = new Client(utilisateur_id, trajet_id, solde);
            }
        } catch (SQLException e) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return client;
    }

    @Override
    public void addClient(int id){
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement
                        ("insert into client (utilisateur_id, trajet_id, solde) values (?, null, 0)");) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void deleteClient(int utilisateur_id){
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement
                        ("delete from client where utilisateur_id=?");) {

            pstmt.setInt(1, utilisateur_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }


}
