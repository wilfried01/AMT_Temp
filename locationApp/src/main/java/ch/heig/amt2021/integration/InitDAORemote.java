package ch.heig.amt2021.integration;

import javax.ejb.Remote;
import java.io.IOException;
import java.sql.SQLException;

@Remote
public interface InitDAORemote {
    void executeScriptSqlFile(String pahtFile) throws IOException, SQLException;
}
