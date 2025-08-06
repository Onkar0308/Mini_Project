package com.example.login_page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.sql.DriverManager;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class history_controller {
    @FXML
    private Button Diet;

    @FXML
    private Button meal_plan;

    @FXML
    private TableColumn<BMIRecord, Double> bmiColumn;

    @FXML
    private ImageView brandingImageView;

    @FXML
    private TableColumn<BMIRecord, String> dateColumn;

    @FXML
    private Button graph;

    @FXML
    private Button graph1;

    @FXML
    private TableView<BMIRecord> historyTable;
    private int userId;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Correctly load the branding image
        File allfile = new File("IMAGES/456.jpg");
        Image allImage = new Image(allfile.toURI().toString());
        brandingImageView.setImage(allImage);

        // Initialize the table columns and set their cell value factories
//        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
//        bmiColumn.setCellValueFactory(new PropertyValueFactory<>("bmi"));

        // Create an ObservableList to hold BMI records
//
    }

    public void main(ActionEvent event) {
        try {
            Object root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Scene scene = new Scene((Parent) root);
            Stage Diet = new Stage();
            Diet.setScene(scene);
            Diet.show();
            Diet.initStyle(StageStyle.UNDECORATED);
            Diet.setResizable(false);
            Diet.setTitle("Diet");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void showHistory(ActionEvent event) {
        // Implement this method to show the history as needed
        ObservableList<BMIRecord> bmiRecords = FXCollections.observableArrayList();

        // Connect to the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1", "root", "12345")) {
            // Construct the SQL query to retrieve BMI records from the joined table
            String query = "SELECT bmi_records.record_date, bmi_records.bmi FROM bmi_records  " +
                    "INNER JOIN users  ON bmi_records.user_id = users.user_id " +
                    "WHERE users.username = ?";

            // Replace 'username' with the actual username you want to retrieve the records for
            String username = "desired_username";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        // Map the database records to BMIRecord instances
                        String date = resultSet.getString("record_date");
                        double bmi = resultSet.getDouble("bmi");
                        bmiRecords.add(new BMIRecord(date, bmi));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set the data source for the TableView
        historyTable.setItems(bmiRecords);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        bmiColumn.setCellValueFactory(new PropertyValueFactory<>("bmi"));

    }


    public void calculate_BMI(ActionEvent event) {
        try {
            Object root = FXMLLoader.load(getClass().getResource("BMI.fxml"));
            Scene scene = new Scene((Parent) root);
            Stage Diet = new Stage();
            Diet.setScene(scene);
            Diet.show();
            Diet.initStyle(StageStyle.UNDECORATED);
            Diet.setResizable(false);
            Diet.setTitle("Diet");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void meal_plan(ActionEvent event) {
        try {
            Object root = FXMLLoader.load(getClass().getResource("Diet.fxml"));
            Scene scene = new Scene((Parent) root);
            Stage Diet = new Stage();
            Diet.setScene(scene);
            Diet.show();
            Diet.initStyle(StageStyle.UNDECORATED);
            Diet.setResizable(false);
            Diet.setTitle("Diet");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public class BMIRecord {
        private String date;
        private double bmi;

        public BMIRecord(String date, double bmi) {
            this.date = date;
            this.bmi = bmi;
        }

        public String getDate() {
            return date;
        }

        public double getBmi() {
            return bmi;
        }
    }
}
