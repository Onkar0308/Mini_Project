package com.example.login_page;

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

public class FULLCONTROLLER implements Initializable {


    @FXML
    private Button back;

    @FXML
    private ImageView back11;

    @FXML
    private Button b;

    @FXML
    private ImageView all;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;
    @FXML
    private ImageView diet;



    @Override
    public void initialize(URL url, ResourceBundle rb) {

        File allfile = new File("IMAGES/15MinBodyWeightHIITWorkout-752x472.jpg");
        Image allImage = new Image(allfile.toURI().toString());
        all.setImage(allImage);

        File backfile = new File("IMAGES/full.jpg");
        Image backImage = new Image(backfile.toURI().toString());
        image2.setImage(backImage);

        File Dfile = new File("IMAGES/full body.jpg");
        Image BImage = new Image(Dfile.toURI().toString());
        image1.setImage(BImage);

        File Bfile = new File("IMAGES/585e473bcb11b227491c3381.png");
        Image CImage = new Image(Bfile.toURI().toString());
        back11.setImage(CImage);

    }

    public void backhandler(ActionEvent event)throws Exception {
        Parent table;
        table = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene=new Scene(table);
        scene.setRoot(table);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}

