package task1.services.DB;

import java.sql.Connection;

public interface DBI {
    Connection getConnection();
    void close();
}
