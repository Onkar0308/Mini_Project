package com.example.login_page;

import java.sql.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName  = "mysql1";
        String databaseUser   = "root";
        String databasePassword = "12345";
        String url ="jdbc:mysql://localhost:3306/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
            System.out.println("not done");
        }
        return databaseLink;
    }
}
