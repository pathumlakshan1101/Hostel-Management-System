package com.hibernate.hostel_management_system.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/16/2022
 * Time        : 10:35 PM
 */
public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;
    private  DBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GameCafe", "root", "1101");
    }
    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        return (dbConnection==null)? dbConnection= new DBConnection(): dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}
