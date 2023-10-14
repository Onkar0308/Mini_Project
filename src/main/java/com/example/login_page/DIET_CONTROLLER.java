package com.example.login_page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;


public class DIET_CONTROLLER implements Initializable{
    @FXML
    private Label L1;
    @FXML
    private Button c1;
    @FXML
    private TextField h1;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private TextField w1;
    private Stage stage;
    @FXML
    private AnchorPane scene;
    private java.util.Objects Objects;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        
     File brandingFile = new File("IMAGES/456.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
    }
    public void DIET(ActionEvent event) throws IOException, SQLException {
        double h = Double.parseDouble(h1.getText());
        double w = Double.parseDouble(w1.getText());

        double BMI = w / (h * h);


        if (BMI <= 18.5) {
            L1.setText(" Increase calorie intake: Consume more calories than your body burns to promote weight gain.\n" +
                    "   - Balanced meals: Include protein-rich foods (lean meats, fish, poultry, beans), complex carbohydrates (whole grains, fruits, vegetables), and healthy fats (nuts, avocados, olive oil).\n" +
                    "   - Frequent meals: Eat 5-6 small, nutrient-dense meals/snacks throughout the day.\n" +
                    "   - Protein shakes or smoothies: These can be a convenient way to increase calorie and protein intake.\n" +
                    "   - Healthy snacks: Opt for nuts, seeds, yogurt, and cheese.");
        } else if (BMI <= 24.9) {
            L1.setText(" - Maintain a balanced diet: Continue eating a variety of foods from all food groups.\n" +
                    "   - Portion control: Be mindful of portion sizes to maintain your current weight.\n" +
                    "   - Nutrient-dense choices: Choose whole grains, lean proteins, and plenty of fruits and vegetables.\n" +
                    "   - Stay hydrated: Drink plenty of water throughout the day.\n" +
                    "   - Regular exercise: Engage in regular physical activity for overall health.\n");
        } else if (BMI <= 29.5) {
            L1.setText("*1. Calculate Your Daily Calorie Needs:*\n" +
                    "   - Start by determining your maintenance calorie intake (the number of calories you need to maintain your current weight). You can use online calculators or consult with a dietitian for a more accurate estimate.\n" +
                    "   - Create a calorie deficit by consuming fewer calories than your maintenance level.\n" +
                    "\n" +
                    "*2. Balanced Diet:*\n" +
                    "   - Focus on whole, unprocessed foods like fruits, vegetables, lean proteins, whole grains, and healthy fats.\n" +
                    "   - Avoid or limit sugary beverages, processed snacks, and foods high in added sugars and saturated fats.\n" +
                    "\n" +
                    "*3. Portion Control:*\n" +
                    "   - Be mindful of portion sizes to avoid overeating. Use smaller plates and utensils to help with this.\n" +
                    "   - Pay attention to hunger and fullness cues to avoid unnecessary snacking.");
        } else if (BMI >= 30) {
            L1.setText("- Calorie control: Reduce calorie intake to create a calorie deficit for weight loss.\n" +
                    "   - Portion control: Be mindful of portion sizes to avoid overeating.\n" +
                    "   - Balanced diet: Focus on whole, unprocessed foods such as fruits, vegetables, lean proteins, and whole grains.\n" +
                    "   - Limit sugary and high-fat foods: Reduce consumption of sugary beverages, fried foods, and sweets.\n" +
                    "   - Regular exercise: Combine a healthy diet with regular physical activity.");
        }
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

    public void settingshandler(ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("setting.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
    public void calculate_BMI(ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("BMI.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
    public void work(ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
}

