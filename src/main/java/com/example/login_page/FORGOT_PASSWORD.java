package com.example.login_page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FORGOT_PASSWORD {
    @FXML
    private Button BACK;

    @FXML
    private TextField CNFPASS;

    @FXML
    private TextField EMAIL;

    @FXML
    private Button ENTER;

    @FXML
    private TextField PASSWORD;

    @FXML
    private TextField USER;
    @FXML
    private Label incorrect;

    @FXML
    private Label incorrect1;
    @FXML
    private Label incorrect2;

    Connection con;
    PreparedStatement pst;


    public void forgetpassword(ActionEvent event){
        System.out.println("Button clicked!");
        if (!EMAIL.getText().isBlank() && !USER.getText().isBlank()
                && !PASSWORD.getText().isBlank() && !CNFPASS.getText().isBlank()){
            forgotPassword(event);
        }
        else {
            incorrect.setText(null);
            incorrect1.setStyle(null);
            incorrect2.setStyle(null);
        }
        if(EMAIL.getText().isBlank()){
            incorrect1.setText("⚠ Please enter email-id!");
            EMAIL.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 15px");
        }
        else {
            incorrect1.setText(null);
            EMAIL.setStyle(null);
        }
        if(PASSWORD.getText().isBlank()){
            incorrect.setText("⚠ Please enter your mobile no!");
            PASSWORD.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 15px");
        }
        else {
            incorrect.setText(null);
            PASSWORD.setStyle(null);
        }



    }

    public void forgotPassword(ActionEvent event) {
        System.out.println(PASSWORD.getText());
        System.out.println(CNFPASS.getText());
        String l = PASSWORD.getText();
        String m = CNFPASS.getText();
        if (l.equals(m)){

            DatabaseConnection connection = new DatabaseConnection();
            Connection connection1 = connection.getConnection();

            System.out.println("inside if");
            String verifylogin = "select count(1) from user_account where  Email_ID  = '" + EMAIL.getText() + "' and username = '" + USER.getText() + "'";
            Statement statement = null;
            try {
                statement = connection1.createStatement();
                ResultSet queryResult = statement.executeQuery(verifylogin);
                while(queryResult.next()){
                    System.out.println("inside while");
                    if (queryResult.getInt(1)==1) {
                        System.out.println("inside if");
                        try {
                            System.out.println("Inside try");
                            String insertUserDetails = "UPDATE `mysql1`.`user_account` SET `password` = '" + PASSWORD.getText() + "' WHERE (`email_id` = '" + EMAIL.getText() + "')\n";
                            statement = connection1.createStatement();
                            int b = statement.executeUpdate(insertUserDetails);
                            if (b == 1) {
                                System.out.println("Inserted data!");
                            } else {
                                System.out.println("Failed to insert data");
                            }
                            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")); //pass scene name here
                            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    else {
                        incorrect2.setText("⚠ Invalid User!");

                        incorrect1.setText(null);
                        incorrect.setText(null);
                        incorrect.setText(null);
                        EMAIL.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 15px");
                        EMAIL.setText("");
                        USER.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 15px");
                        USER.setText("");
                        PASSWORD.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 15px");
                        PASSWORD.setText("");
                        CNFPASS.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 15px");
                        CNFPASS.setText("");

                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            incorrect.setText("⚠ Both password fields should have same value");
            PASSWORD.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 15px");
            CNFPASS.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 15px");
        }
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToHome(ActionEvent e) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLDocument.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException event ) {
            throw new RuntimeException(event);
        }
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Login");
    }


}
