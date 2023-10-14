package com.example.login_page;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GRAPH_controller implements Initializable {
    @FXML
    private CategoryAxis X;

    @FXML
    private NumberAxis Y;

    @FXML
    private ImageView brandingImageView;

    @FXML
    private LineChart<?, ?> chart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    @FXML
    private Button calculatebmi;

    @FXML
    private Button graph;

    @FXML
    private TextField h1;

    @FXML
    private TextField w1;
    @FXML
    private Exception IOException;
    private Stage stage;
    @FXML
    private AnchorPane scene;

    public void initialize(URL url, ResourceBundle resourceBundle) {
//        File brandingFile = new File("IMAGES/456.jpg");
//        Image brandingImage = new Image(brandingFile.toURI().toString());
//        brandingImageView.setImage(brandingImage);

        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("1",30)) ;
        chart.getData().addAll(series);
    }
    public void LOGOUTBUTTON(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("LOGOUT");
        alert.setHeaderText("YOU're about to logout");
        alert.setContentText("DO YOU WANT TO SAVE BEFORE EXITING?:");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scene.getScene().getWindow();
            System.out.println("You sucessfully logged out");
            stage.close();
            ;
        }
    }

    public void GRAPH(ActionEvent event) throws IOException{

   }
}
