package ch.heig.amt2021.integration;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class InitDAO implements InitDAORemote {

    @Resource(lookup = "jdbc/Lab1_AMT")
    private DataSource dataSource;

    @Override
    public void executeScriptSqlFile(String pahtFile) throws IOException, SQLException {
        Connection connection = null;
        BufferedReader reader = null;
        try {
            connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            reader = new BufferedReader(new FileReader(pahtFile));
            String line;
            while ((line = reader.readLine()) != null) {
                stmt.execute(line);
            }
        } catch (SQLException  | IOException e) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
