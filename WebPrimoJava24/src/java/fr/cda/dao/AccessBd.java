/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.cda.dao;

import java.sql.*;

/**
 *
 * @author kingafolabi
 */
public class AccessBd {
    
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    
    private static String dbName = "primowebcda24";
    
    private static String url = "jdbc:mysql://localhost/" + dbName + "?useSSL=false";
    
    private static String user = "root";
    
    private static String password = "";
    
    
    static {
        try {
            Class.forName(driverName).newInstance();
        }
        catch(Exception e){
            System.err.println("Le pilote n'a pas pu le charger ");
        }
    }
    
    
    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
    
    
    
}
