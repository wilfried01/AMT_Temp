package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Prix;
import ch.heig.amt2021.model.Station;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class PrixDAO implements PrixDAOLocal{

    @Resource(lookup = "jdbc/Lab1_AMT")  // pour SGBD externe
    private DataSource dataSource;

    @Override
    public List<Prix> getPrix() {
        List<Prix> prix = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT * FROM price");){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                String categorie1 = rs.getString(1);
                float price1 = rs.getFloat(2);
                float price2 = rs.getFloat(3);
                float price3 = rs.getFloat(4);
                Prix prix1 = new Prix(categorie1,price1,price2,price3);

                prix.add(prix1);
            }
        }   catch (SQLException e){
            Logger.getLogger(StationDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return prix;
    }
}
