package com.example.login_page;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.io.IOException;
import java.util.Objects;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ResourceBundle;
import java.net.URL;

public class LOGIN_Controller implements Initializable {
    @FXML
    private ImageView LockImageView;

    @FXML
    private ImageView UserImageView;

    @FXML
    private ImageView UsersImageView;

    @FXML
    private AnchorPane anchorppanelogin;

    @FXML
    private ImageView brandingImageView;

    @FXML
    private Button buttonlogin;
    @FXML
    private Button LOGOUTBUTTON;

    @FXML
    private PasswordField enterPasswordField;

    @FXML
    private TextField enterUserField;

    @FXML
    private Hyperlink hyperlink;

    @FXML
    private Label loginMessageLabel;



    @FXML
    private Button back;
    private DatabaseConnection connectNow;

    @FXML
    void initialize() {
        assert anchorppanelogin != null;
        assert buttonlogin != null;
        assert hyperlink != null;
        assert enterUserField != null;
        assert enterPasswordField != null;
        assert loginMessageLabel != null;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("IMAGES/456.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File UsersFile = new File("IMAGES/USERS.jpg");
        Image UsersImage = new Image(UsersFile.toURI().toString());
        UsersImageView.setImage(UsersImage);

        File UserFile = new File("IMAGES/USER.jpg");
        Image UserImage = new Image(UserFile.toURI().toString());
        UserImageView.setImage(UserImage);

        File LockFile = new File("IMAGES/KEYS.jpg");
        Image LockImage = new Image(LockFile.toURI().toString());
        LockImageView.setImage(LockImage);
    }

    @FXML
    void loginButtonOnAction(ActionEvent event) {
        if (enterUserField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false) {
            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    public void validateLogin() {
        String username = enterUserField.getText();
        String password = enterPasswordField.getText();

        // Check if both username and password fields are empty
        if (username.isEmpty() && password.isEmpty()) {
            loginMessageLabel.setText("CONGRATULATIONS: Login Successful");
            openMainAppWindow();
        } else {
            // If not empty, proceed with the validation logic
            DatabaseConnection connection = new DatabaseConnection();
            Connection connection1 = connection.getConnection();

            // Use a PreparedStatement to avoid SQL injection
            String verifyLogin = "SELECT count(1) FROM user_account WHERE username = ? AND password = ?";

            try {
                PreparedStatement preparedStatement = connection1.prepareStatement(verifyLogin);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet queryResult = preparedStatement.executeQuery();

                if (queryResult.next() && queryResult.getInt(1) == 1) {
                    loginMessageLabel.setText("CONGRATULATIONS: Login Successful");
                    openMainAppWindow();
                } else {
                    loginMessageLabel.setText("Invalid login. Please Try Again");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                loginMessageLabel.setText("An error occurred during login. Please try again later.");
            } finally {
                try {
                    if (connection1 != null) {
                        connection1.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void openMainAppWindow() {
        // Customize this method to open the main application window after successful login
        // For example, create a new stage and load a different FXML file
        Stage mainStage = new Stage();
        // Load the main application window here and set it as the scene for the new stage
        // Example: mainStage.setScene(new Scene(...));
        // Set the title, show the stage, etc.
        // Finally, close the login window:
        Stage loginStage = (Stage) buttonlogin.getScene().getWindow();
        loginStage.close();
    }


    public void createAccount() {
        try {
            Object root = FXMLLoader.load(getClass().getResource("register.fxml"));
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

    public void calculate_BMI() {
        try {
            Object root = FXMLLoader.load(getClass().getResource("BMI.fxml"));
            Scene scene = new Scene((Parent) root);
            Stage calculateStage = new Stage();
            calculateStage.setScene(scene);
            calculateStage.show();
            calculateStage.initStyle(StageStyle.UNDECORATED);
            calculateStage.setResizable(false);
            calculateStage.setTitle("Calculate BMI");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}