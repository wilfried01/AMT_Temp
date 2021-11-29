package ch.heig.amt2021.integration;

import ch.heig.amt2021.model.Emplacement;

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
public class EmplacementDAO  implements  EmplacementDAOLocal{

    @Resource(lookup = "jdbc/Lab1_AMT")  // pour SGBD externe
    private DataSource dataSource;

    @Override
    public List<Emplacement> getEmplacements(){
        List<Emplacement> emplacements = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(
                "SELECT * FROM emplacement");){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int id1 = rs.getInt(1);
                int station_id1 = rs.getInt(2);
                Emplacement emplacement1 = new Emplacement(id1,station_id1);

                emplacements.add(emplacement1);
            }
        } catch(SQLException e){
            Logger.getLogger(EmplacementDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return emplacements;
    }
}
