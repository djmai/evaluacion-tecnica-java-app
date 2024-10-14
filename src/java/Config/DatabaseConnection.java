/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

/**
 *
 * @author Miguel Martinez <mmartinezdev.com>
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/castores_db?autoReconnect=true&useSSL=false";
    private static final String USER = "toor";  // Cambia esto por tu usuario de MySQL
    private static final String PASSWORD = "root";  // Cambia esto por tu contraseña de MySQL

    /*public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }*/
    
    Connection con;
    String url = "jdbc:mysql://localhost:3306/castores_db?autoReconnect=true&useSSL=false";
    String user = "root";
    String pass = "toor";
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("Conectado a DB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return con;
    }
}

