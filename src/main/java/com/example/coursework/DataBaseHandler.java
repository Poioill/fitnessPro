package com.example.coursework;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseHandler{
    public static DataBaseHandler da = new DataBaseHandler("jdbc:postgresql://localhost:8080/fintess", "postgres", "janara2004");
    public Connection connection;
    private static Connection connection2;

    public static DataBaseHandler getDataBaseHandler() {
        return da;
    }

    // first way connect to database
    public DataBaseHandler(String dbUrl, String usr, String password) {
        try {
            connection = DriverManager.getConnection(dbUrl, usr, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // second way of connecting with database
    public static Connection getConnect() {
        try {
            connection2 = DriverManager.getConnection("jdbc:postgresql://localhost:8080/fintess", "postgres", "janara2004");
        } catch (SQLException e) {
            Logger.getLogger(DataBaseHandler.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection2;
    }
//
//    public static Connection dbConnection;
//    public Connection connection;
//
//    public DataBaseHandler(String dbUrl, String usr, String password) {
//        try {
//            connection = DriverManager.getConnection(dbUrl, usr, password);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    public static Connection getDbConnection() {
//        try {
//            dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:8080/fintess", "postgres", "janara2004");
//        } catch (SQLException e) {
//            Logger.getLogger(DataBaseHandler.class.getName()).log(Level.SEVERE, null, e);
//        }
//        return dbConnection;
//    }


}
