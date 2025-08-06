package com.example.login_page;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.mindrot.jbcrypt.BCrypt;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Statement;
import java.sql.SQLException;
import javafx.scene.control.ComboBox;
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
    private ComboBox<String> combo;

    @FXML
    private Button closeButton;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField genderField;


    @FXML
    private Label incorrect;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private ImageView shieldImageView;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Label registrationStatusLabel;

    @FXML
    public void backtoLogin(ActionEvent event) {
        try {
            Object root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene((Parent) root);
            Stage registerStage = new Stage();
            registerStage.setScene(scene);
            registerStage.show();
            registerStage.setResizable(false);
            registerStage.setTitle("Register");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }


}

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File shieldFile = new File("IMAGES/shield.jpg");
        Image shieldImage = new Image(shieldFile.toURI().toString());
        shieldImageView.setImage(shieldImage);

        ObservableList<String> list = FXCollections.observableArrayList("Male", "Female", "Other");
        combo.setItems(list);

    }

    public void registerButtonOnAction(ActionEvent event) {
        String username = usernameTextField.getText();
        String firstName = firstnameTextField.getText();
        String Email = emailTextField.getText();
        String selectedGender = combo.getValue();

        if (username.isEmpty() ||  firstName.isEmpty() || Email.isEmpty() || selectedGender.isEmpty() || selectedGender == null) {
            incorrect.setText("Please fill in all fields.");
            return;
        }


        if (!isValidUsername(username)) {
            incorrect.setText("Invalid username. Username must contain only letters and numbers.");
            return;
        }

        if (!isValidName(firstName)) {
            incorrect.setText("Invalid name. Name must contain only letters.");
            return;
        }

        if (!isValidEmail(Email)) {
           incorrect.setText("Invalid email address.");
            return;
        }

        if (!isValidGender(selectedGender)) {
            incorrect.setText("Invalid gender selection.");
            return;
        }
        String plainpassword = passwordField.getText();
        String hashedPassword = BCrypt.hashpw(plainpassword, BCrypt.gensalt(12));
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();

            String insertSQL = "INSERT INTO users (username, password, firstname, email, gender) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connectDB.prepareStatement(insertSQL);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, Email);
            preparedStatement.setString(5, selectedGender);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                incorrect.setText("You have registered successfully!");
            } else {
               incorrect.setText("An error occurred during registration.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            incorrect.setText("An error occurred during database operation");
            System.err.println("SQLException details:");
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Error Message: " + e.getMessage());
        }
    }

    private boolean isValidUsername(String username) {
        // Regular expression for username validation (letters and numbers only)
        String usernameRegex = "^[a-zA-Z0-9]*$";
        return username.matches(usernameRegex);
    }

    private boolean isValidName(String name) {
        // Regular expression for name validation (letters only)
        String nameRegex = "^[A-Za-z]*$";
        return name.matches(nameRegex);
    }

    private boolean isValidEmail(String email) {
        // Regular expression for a basic email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    private boolean isValidGender(String gender) {
        // Check that the gender is one of the allowed values (Male, Female, Other)
        return "Male".equals(gender) || "Female".equals(gender) || "Other".equals(gender);
    }
}
