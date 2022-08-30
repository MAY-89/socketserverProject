package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    
    private final static String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private final static String user = "postgre";
    private final static String password = "root";

    private static Connection conn = null;

    public static Connection getConnection(){

        if(conn == null){
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("DB Connection Complate");
            } catch (ClassNotFoundException | SQLException e) {
                
                System.out.println("DB Connect Error " + e.getStackTrace());
            }
        }
        return conn;
    }

    public static void close(AutoCloseable closer){

        if(closer != null){
            try {
                closer.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
