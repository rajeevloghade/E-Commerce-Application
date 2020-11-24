package mypkg;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionData {

    public static Connection connect() throws Exception {
        //Driver-Loading
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Loaded");
        //Connection-Establishment
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ECOM", "root", "root");
        System.out.println("Connection Established");
        return con;
    }
}
