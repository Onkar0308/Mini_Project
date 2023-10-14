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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;;

public class DietController implements Initializable {

    @FXML
    private ImageView all;

    @FXML
    private Button back;

    @FXML
    private ImageView back1;

    @FXML
    private ImageView diet;
    public void backhandler(ActionEvent event)throws Exception {
        Parent table;
        table = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene=new Scene(table);
        scene.setRoot(table);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        File allfile = new File("IMAGES/Untitled5.png");
        Image allImage = new Image(allfile.toURI().toString());
        all.setImage(allImage);

        File backfile = new File("IMAGES/585e473bcb11b227491c3381.png");
        Image backImage = new Image(backfile.toURI().toString());
        back1.setImage(backImage);

        File Dfile = new File("IMAGES/nm.png");
        Image BImage = new Image(Dfile.toURI().toString());
        diet.setImage(BImage);
    }
}

