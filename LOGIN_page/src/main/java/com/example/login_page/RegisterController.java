package com.example.login_page;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

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

public class RegisterController implements Initializable {

    @FXML
    private Button Back;

    @FXML
    private TextField Password;

    @FXML
    private Button closeButton;

    @FXML
    private TextField confirmPassword;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private Label incorrect;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private Button registerButton;

    @FXML
    private Label registrationMessageLabel;

    @FXML
    private ImageView shieldImageView;

    @FXML
    private TextField usernameTextField;

    Connection con;
    PreparedStatement pst;

    @FXML
    void backtoLogin(ActionEvent event) {
        try {
            Object root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene((Parent) root);
            Stage registerstage = new Stage();
            registerstage.setScene(scene);
            registerstage.show();
            registerstage.setResizable(false);
            registerstage.setTitle("Login");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void initialize(URL url , ResourceBundle resourceBundle) {
        File shieldFile = new File("IMAGES/shield.jpg");
        Image shieldImage = new Image(shieldFile.toURI().toString());
        shieldImageView.setImage(shieldImage);
    }
    public void registerButtonOnAction(ActionEvent event) throws IOException , ClassNotFoundException {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String username = usernameTextField.getText();
        String password = Password.getText();
        String firstname = firstnameTextField.getText();
        String Email_ID= lastnameTextField.getText();


        String insertFields = "insert into user_account (username,password,firstname,Email_ID ) values ('";
        String insertValues = username + "','" + password + "','" + firstname + "','" + Email_ID + "')";
        String insertToRegister1 = insertFields + insertValues;


        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister1);
            incorrect.setText("You have registered successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

};


 //   private void registeruser() {
