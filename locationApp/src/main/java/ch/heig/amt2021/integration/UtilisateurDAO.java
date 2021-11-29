package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Client;
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
public class UtilisateurDAO implements UtilisateurDAOLocal{


    @Resource(lookup = "jdbc/Lab1_AMT")  // pour SGBD externe
    private DataSource dataSource;


    /**
     * Liste de tous les contacts
     */
    public List<Utilisateur> getUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT * FROM utilisateur");) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt(1);
                String login1 = rs.getString(2);
                String password1 = rs.getString(3);
                Utilisateur utilisateur1 = new Utilisateur(id1,login1,password1);
                utilisateurs.add(utilisateur1);
            }
        } catch (SQLException e) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return utilisateurs;
    }

    /**
     * Ajoute un nouveau contact (sans conjoint)
     *   (doublons encore à gérer)
     */
    public void add(Utilisateur utilisateur) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement
                        ("insert into utilisateur (login, password) values (?,?)");) {

            pstmt.setString(1, utilisateur.getLogin());
            pstmt.setString(2, utilisateur.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Utilisateur getUtilisateur(String login){
        Utilisateur utilisateur1 = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT * FROM utilisateur " +
                             "where login=?");) {
            pstmt.setString(1,login);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
               int id1 = rs.getInt(1);
               String login1 = rs.getString(2);
               String password1 = rs.getString(3);

                utilisateur1 = new Utilisateur(id1, login1, password1);
            }
        } catch (SQLException e) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return utilisateur1;
    }

    @Override
    public void deleteUtilisateur(int id){
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement
                        ("delete from utilisateur where id=?");) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
