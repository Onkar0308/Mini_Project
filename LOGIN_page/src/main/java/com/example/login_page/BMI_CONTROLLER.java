package com.example.login_page;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
    private Object event;
    @FXML
    private Exception IOException;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("IMAGES/456.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

    }
        public void calculate_BMI(ActionEvent event) throws IOException{
            if (h1.getText().trim().isEmpty() || w1.getText().trim().isEmpty()) {
                Alert a = new Alert(AlertType.NONE);
                a.setContentText("Please Enter correct Height and Weight");
                a.setAlertType(AlertType.ERROR);
                a.show();
            } else {
                float a = Float.parseFloat(h1.getText());
                float b = Float.parseFloat(w1.getText());
                float bmi = b / (a * a);
                H1.setText("" + bmi);

                if (bmi <= 18.5) {
                    W1.setText("UnderWeight");
                } else if (bmi <= 24.9) {
                    W1.setText("Normal Weight");
                } else if (bmi <= 29.9) {
                    W1.setText("OverWeight");
                } else {
                    W1.setText("Obese");
                }


            }
        }

    }
