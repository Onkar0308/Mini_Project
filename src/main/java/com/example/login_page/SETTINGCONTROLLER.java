package com.example.login_page;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextInputDialog;

public class SETTINGCONTROLLER implements Initializable {

    private Stage stage;

    @FXML
    private Button back;

    @FXML
    private Button logout;
    @FXML
    private ImageView all;
    @FXML
    private ImageView back1;
    @FXML
    private ImageView setting;
    @FXML
    private Button password;


    public void backhandler(ActionEvent event)throws Exception{
        Parent table;
        table = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene=new Scene(table);
        scene.setRoot(table);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public void logouthandler(ActionEvent event)throws Exception{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("LOGOUT");
        alert.setHeaderText("YOU're about to logout");
        alert.setContentText("DO YOU WANT TO SAVE BEFORE EXITING?:");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) stage.getScene().getWindow();
            System.out.println("You sucessfully logged out");
            stage.close();
            ;
        }

    }
    public void personalinformation(ActionEvent event)throws Exception{
        Parent table;
        table = FXMLLoader.load(getClass().getResource("personalinformation.fxml"));
        Scene scene=new Scene(table);
        scene.setRoot(table);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File allfile = new File("IMAGES/health-and-fitness-events-in-boston-rally-sports-and-general-assembly1j.jpg");
        Image allImage = new Image(allfile.toURI().toString());
        all.setImage(allImage);

        File backfile = new File("IMAGES/585e473bcb11b227491c3381.png");
        Image backImage = new Image(backfile.toURI().toString());
        back1.setImage(backImage);

        File settingfile = new File("IMAGES/Tools-PNG-Transparent-Image.png");
        Image settingImage = new Image(settingfile.toURI().toString());
        setting.setImage(settingImage);

    }
    public void managepassword(ActionEvent event) {
        // Create a dialog for entering the password
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Password Confirmation");
        dialog.setHeaderText("Enter your password:");
        dialog.setContentText("Password:");

        // Show the dialog and process the result
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(enteredPassword -> {
            // Replace "your_actual_hashed_password" with the hashed password you want to compare
            String storedHashedPassword = "$2a$10$examplehashhere"; // Replace with the actual hashed password
            String storedUsername = "exampleUsername"; // Replace with the actual username stored in the database

            if (BCrypt.checkpw(enteredPassword, storedHashedPassword)) {
                // Display the username
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Password Correct");
                alert.setHeaderText("Welcome, " + storedUsername);
                alert.showAndWait();
            } else {
                // Display an error message
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Password Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid password. Please try again.");
                alert.showAndWait();
            }
        });
    }

}