package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Administrateur;

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
public class AdministrateurDAO implements AdministateurDAOLocal{

    @Resource(lookup = "jdbc/Lab1_AMT")  // pour SGBD externe
    private DataSource dataSource;

    @Override
    public List<Administrateur> getAdmin() {
        List<Administrateur> administrateurs = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT * FROM administrateur");) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int utilisateur_id1 = rs.getInt(1);
                Administrateur admin1 = new Administrateur(utilisateur_id1);
                administrateurs.add(admin1);
            }
        } catch (SQLException e) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return administrateurs;
    }
}
