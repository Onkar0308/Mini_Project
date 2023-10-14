package com.example.login_page;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BMI_CONTROLLER implements Initializable {
    @FXML
    private Label H1;

    @FXML
    private Label W1;

    @FXML
    private TextField h1;

    @FXML
    private TextField w1;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView yogaimage;
    @FXML
    private Object event;
    @FXML
    private Button calculatebmi;

    @FXML
    private Button graph;
    @FXML
    private Button Diet;

    @FXML
    private AnchorPane scene;
    Stage stage;

    @FXML
    private Exception IOException;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("IMAGES/456.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File yogaFile = new File("IMAGES/yoga12.jpg");
        Image yogaImage = new Image(yogaFile.toURI().toString());
        yogaimage.setImage(yogaImage);
    }

    public void calculate_BMI(ActionEvent event) throws IOException, SQLException {
        double h = Double.parseDouble(h1.getText());
        double w = Double.parseDouble(w1.getText());

        double bmi = w / (h * h);
        H1.setText(" " + bmi);

        if (bmi <= 18.5) {
            W1.setText("UnderWeight");
        } else if (bmi <= 24.9) {
            W1.setText("Normal Weight");
        } else if (bmi <= 29.5) {
            W1.setText("OverWeight");
        } else if (bmi >= 30) {
            W1.setText("Obese");

            Connection connectDB = null;
            try {
                DatabaseConnection connectNow = new DatabaseConnection();
                connectDB = connectNow.getConnection();

                Double BMI = Double.valueOf(H1.getText());

                String insertFields = "insert into bmi (BMI) values ('";
                PreparedStatement preparedStatement = connectDB.prepareStatement(insertFields);
                preparedStatement.setDouble(1,BMI );

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("BMI record inserted successfully.");
                } else {
                    System.out.println("Failed to insert BMI record.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Database Error");
                alert.setHeaderText(null);
                alert.setContentText("An error occurred while interacting with the database. Please check your database configuration.");
                alert.showAndWait();
            } finally {
                if (connectDB != null) {
                    try {
                        connectDB.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void GRAPH() {
        try {
            Object root = FXMLLoader.load(getClass().getResource("GRAPH.fxml"));
            Scene scene = new Scene((Parent) root);
            Stage graph = new Stage();
            graph.setScene(scene);
            graph.show();
            graph.initStyle(StageStyle.UNDECORATED);
            graph.setResizable(false);
            graph.setTitle("Graph");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void LOGOUTBUTTON(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("LOGOUT");
        alert.setHeaderText("YOU're about to logout");
        alert.setContentText("DO YOU WANT TO SAVE BEFORE EXITING?:");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scene.getScene().getWindow();
            System.out.println("You sucessfully logged out");
            stage.close();
            ;
        }
    }
    public void settingshandler(ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("setting.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
    public void work(ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }



    public void Diet() {
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

        public void diethandler(ActionEvent event)throws Exception{
            Parent table = FXMLLoader.load(getClass().getResource("main.fxml"));
            Scene scene=new Scene(table);
            scene.setRoot(table);
            Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();

        }
    }

