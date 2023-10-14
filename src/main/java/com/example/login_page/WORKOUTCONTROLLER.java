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
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;;

public class WORKOUTCONTROLLER implements Initializable {
    @FXML
    private Button HIIT;

    @FXML
    private Button Lower;

    @FXML
    private ImageView Upper1;

    @FXML
    private ImageView all;

    @FXML
    private Button full;

    @FXML
    private ImageView full1;
    @FXML
    private ImageView back;
    @FXML
    private ImageView hiit1;

    @FXML
    private ImageView lower1;

    @FXML
    private Button upper;
    public void backhandler(ActionEvent event)throws Exception {
        Parent table;
        table = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene=new Scene(table);
        scene.setRoot(table);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    public void upparbody (ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("full_body.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
    public void fullbody (ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("upper.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
    public void hiit (ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("HIIT.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
    public void lowerbody (ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("LOWER.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File allfile = new File("IMAGES/shutterstock.jpg");
        Image allImage = new Image(allfile.toURI().toString());
        all.setImage(allImage);
        File upperfile = new File("IMAGES/Untitledh.png");
        Image upperImage = new Image(upperfile.toURI().toString());
        Upper1.setImage(upperImage);
        File lowerfile = new File("IMAGES/Untitled;l.png");
        Image lowerImage = new Image(lowerfile.toURI().toString());
        lower1.setImage(lowerImage);
        File hiitfile = new File("IMAGES/Untitled.png");
        Image hiitImage = new Image(hiitfile.toURI().toString());
        hiit1.setImage(hiitImage);
        File fullfile = new File("IMAGES/kl.png");
        Image fullImage = new Image(fullfile.toURI().toString());
        full1.setImage(fullImage);
        File backfile = new File("IMAGES/585e473bcb11b227491c3381.png");
        Image bImage = new Image(backfile.toURI().toString());
        back.setImage(bImage);

    }
}
