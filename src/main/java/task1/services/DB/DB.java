package task1.services.DB;
import java.sql.*;

public class DB implements DBI{
    private Connection conn;

    private static DB db;

    private DB(){
        try {
            Class.forName("org.postgresql.Driver");
            credentials cr = new credentials();
            conn = DriverManager.getConnection(cr.getUrl(), cr.getUsername(), cr.getPassword());
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DB getInstance(){
        if (db == null){
            db = new DB();
        }
        return db;
    }

    @Override
    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Connection getConnection() {
        return conn;
    }

}
