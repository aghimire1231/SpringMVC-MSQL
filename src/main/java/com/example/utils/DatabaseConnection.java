package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ashish on 11/8/2016.
 */
public class DatabaseConnection {

    public static Connection getDatabaseConnection() {
        Connection conn = null;
        String userName = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/hibernate";
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected.");
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}

