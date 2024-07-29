/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author gcardenas
 */
public class DatabaseConnection {


    public static Connection connect(){
        
        String Server = "jdbc:mysql://localhost:3306/supermercado";
        String User = "root";
        String Password = "123456789";
        Connection conn = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(Server, User, Password);
            System.out.println("Connection to MySQL has been established.");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }
}
