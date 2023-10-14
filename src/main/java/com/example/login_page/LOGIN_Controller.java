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
import javafx.scene.Node;

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
    private Stage stage;
    private Scene scene;

    @FXML
    private PasswordField enterPasswordField;

    @FXML
    private TextField enterUserField;

    @FXML
    private Hyperlink hyperlink;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private Hyperlink forgotPassword;

    @FXML
    private Button back;
    private DatabaseConnection connectNow;

    private ActionEvent e;

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
    void loginButtonOnAction(ActionEvent e) throws SQLException {
        if (!enterUserField.getText().isBlank()  && !enterPasswordField.getText().isBlank() ) {
            validateLogin(e);
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }

        }

        public void validateLogin(ActionEvent e) {
            String username = enterUserField.getText();
            String password = enterPasswordField.getText();

            // Check if both username and password fields are empty

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
                    openMainAppWindow(e);
                } else {
                    loginMessageLabel.setText("Invalid login. Please Try Again");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                loginMessageLabel.setText("An error occurred during login. Please try again later.");
            } //finally {
                try {
                    if (connection1 != null) {
                        connection1.close();
                    }
                } catch (SQLException ep) {
                    ep.printStackTrace();
                }
            }

    private void openMainAppWindow(ActionEvent e) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BMI.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();

        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException event) {
            throw new RuntimeException(String.valueOf(e));
        }
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Dashboard");
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
    public void forgetpassword() {
        try {
            Object root = FXMLLoader.load(getClass().getResource("FORGOT PASSWORD.fxml"));
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