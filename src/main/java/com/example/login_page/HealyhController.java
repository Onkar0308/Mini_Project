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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

public class HealyhController implements Initializable {

    @FXML private Label bmilabel;
    @FXML
    private ImageView cycle;
    @FXML
    private Button back;
    @FXML
    private ImageView back1;

    @FXML
    private ImageView all;


    @FXML
    private Button bmi;
    int height,weight;

    public void backhandler(ActionEvent event)throws Exception{
        Parent table;
        table = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene=new Scene(table);
        scene.setRoot(table);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public void bmicalculator(int h,int w){
        height=h;
        weight=w;

    }
    public void bmihandler(ActionEvent event)throws Exception{
        float bmi;
        bmi=weight/(height*height);
        bmilabel.setText(String.valueOf(bmi));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("IMAGES/585e473bcb11b227491c3381.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        back1.setImage(brandingImage);
        File BrandingFile = new File("IMAGES/Signs-of-healthy-body-1.jpg");
        Image BrandingImage = new Image(BrandingFile.toURI().toString());
        all.setImage(BrandingImage);
        File Brandingfile = new File("IMAGES/BMIFinal.jpg");
        Image Brandingimage = new Image(Brandingfile.toURI().toString());
        cycle.setImage(Brandingimage);

    }
}
