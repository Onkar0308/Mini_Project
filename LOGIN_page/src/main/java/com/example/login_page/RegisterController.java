package com.example.login_page;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

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

    @FXML
    void backtoLogin(ActionEvent event) {}

    public void initialize(URL url , ResourceBundle resourceBundle) {
        File shieldFile = new File("IMAGES/shield.jpg");
        Image shieldImage = new Image(shieldFile.toURI().toString());
        shieldImageView.setImage(shieldImage);
    }
    public void registerButtonOnAction(ActionEvent event) throws IOException {
        registerButton.setOnAction(e -> {
            if (Password.getText().equals(confirmPassword.getText())){
                //registeruser();
                incorrect.setText("you are set");
            }else {
                incorrect.setText("Password does not match");
            }

        });
    }

 //   private void registeruser() {
  //  }

    public void backtoLogin() {
       try {
           Object root = FXMLLoader.load(getClass().getResource("FXMLDocument"));
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
}