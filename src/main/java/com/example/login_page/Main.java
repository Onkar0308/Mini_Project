package com.example.login_page;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main implements Initializable {
    @FXML
    private Button diet;

    @FXML
    private ImageView all;
    @FXML
    private Button health;

    @FXML
    private Label name;

    @FXML
    private ImageView image2;
    @FXML
    private Button setting;

    @FXML
    private Button sport;
    @FXML
    private ImageView heartImageview;
    @FXML
    private ImageView gym1;

    @FXML
    private ImageView brand;
    @FXML
    private ImageView image;
    @FXML
    private ImageView back;



    private java.util.Objects Objects;


//    public void getInfoFromSignup(account acc){
//        name.setText(acc.getFN());
//    }





    public void initialize(URL url, ResourceBundle rb) {
        File heartfile = new File("IMAGES/heartbeat-512.png");
        Image heartImage = new Image(heartfile.toURI().toString());
        heartImageview.setImage(heartImage);

        File gymfile = new File("IMAGES/Sports-Dumbbell-icon.png");
        Image gymImage = new Image(gymfile.toURI().toString());
        gym1.setImage(gymImage);

        File brandfile = new File("IMAGES/Tools-PNG-Transparent-Image.png");
        Image brandImage = new Image(brandfile.toURI().toString());
        brand.setImage(brandImage);

        File allfile = new File("IMAGES/gui2.jpeg");
        Image allImage = new Image(allfile.toURI().toString());
        all.setImage(allImage);


        File dfile = new File("IMAGES/vegetarian-food.png");
        Image dImage = new Image(dfile.toURI().toString());
        image.setImage(dImage);

        File Backfile = new File("IMAGES/585e473bcb11b227491c3381.png");
        Image dackImage = new Image(Backfile.toURI().toString());
        back.setImage(dackImage);
//       ile heartfile = new File( F"IMAGES/heartbeat-512.png");
//        Image heartImage = new Image(heartfile.toURI().toString());
//        heartImageview.setImage(heartImage);
//        Image image = new Image(Objects.requireNonNull(getClass().getResource("/IMAGES/heartbeat-512.png")).toString());
//        Image image1 = new Image(Objects.requireNonNull(getClass().getResource("/IMAGES/Sports-Dumbbell-icon.png")).toString());
//        Image image2 = new Image(Objects.requireNonNull(getClass().getResource("IMAGES/vegetarian-food.png.jpg")).toString());
//        Image image3 = new Image(Objects.requireNonNull(getClass().getResource("/IMAGES/Tools-PNG-Transparent-Image.png")).toString());
//        Image image4 = new Image(Objects.requireNonNull(getClass().getResource("/IMAGES/gui2.jpeg")).toString());

    }


    public void healthhandler(ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("health.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public void diethandler(ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("Diet1.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public void workouthandler(ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("WORKOUT.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public void settingshandler(ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("setting.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
    public void back(ActionEvent event)throws Exception{
        Parent table;
        table = FXMLLoader.load(getClass().getResource("BMI.fxml"));
        Scene scene=new Scene(table);
        scene.setRoot(table);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }


}
