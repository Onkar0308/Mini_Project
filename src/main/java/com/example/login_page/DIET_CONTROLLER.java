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


        if (BMI <= 18.5 ) {
            L1.setText("Breakfast:\n" +
                    "Scrambled eggs with spinach and tomatoes,\n" +
                    "Whole-grain toast with almond butter or peanut butter,\n" +
                    "A piece of fruit (e.g., banana or an apple),\n" +
                    "A glass of whole milk or a dairy-free alternative (e.g., almond milk).\n" +
                    "Mid-Morning Snack:\n" +
                    "Greek yogurt with honey and mixed berries,\n" +
                    "Handful of mixed nuts (almonds, walnuts, or cashews).\n" +
                    "Lunch:\n" +
                    "Grilled chicken or tofu and vegetable stir-fry,\n" +
                    "Brown rice or quinoa,Steamed broccoli or other vegetables,\n" +
                    "A side salad with olive oil and vinegar dressing.\n" +
                    "Afternoon Snack:\n" +
                    "Hummus with carrot and cucumber sticks,\n" +
                    "Whole-grain crackers,A piece of string cheese (or a dairy-free alternative).\n" +
                    "Dinner:\n" +
                    "Baked salmon or a plant-based protein source (e.g., lentils),\n" +
                    "Sweet potato or quinoa ,Steamed or roasted mixed vegetables,\n" +
                    "A side salad with a healthy dressing.\n" +
                    "Evening Snack:\n" +
                    "Greek yogurt or a protein-rich smoothie (with banana, protein powder, and almond milk),\n" +
                    "A small handful of dried fruits and nuts.");
        } else if (BMI <= 24.9) {
            L1.setText(" Breakfast:\n" +
                    "Oatmeal topped with sliced bananas, berries, and a sprinkle of nuts (e.g.,almonds or walnuts),\n" +
                    "A glass of freshly squeezed orange juice or a piece of whole fruit.\n" +
                    "Mid-Morning Snack:\n" +
                    "Greek yogurt with a drizzle of honey and a handful of granola,\n" +
                    "A serving of baby carrots or cucumber slices.\n" +
                    "Lunch:\n" +
                    "Grilled chicken or tofu and vegetable wrap with whole-grain tortilla,\n" +
                    "A side of mixed greens with balsamic vinaigrette dressing,\n" +
                    "A piece of fruit (e.g.,apple or pear).\n" +
                    "Afternoon Snack:\n" +
                    "A smoothie with spinach, banana, and protein powder,\n" +
                    "Whole-grain crackers with hummus or peanut butter.\n" +
                    "Dinner:\n" +
                    "Baked or grilled fish (e.g.,salmon) or a plant-based protein source (e.g.,beans or lentils),\n" +
                    "Quinoa or brown rice,\n" +
                    "Steamed or roasted vegetables (e.g., broccoli, carrots, or asparagus)\n" +
                    "A side salad with a variety of fresh vegetables.\n");
        } else if (BMI <= 29.5) {
            L1.setText("Breakfast:\n" +
                    "Scrambled egg whites with sautéed spinach and tomatoes,\n" +
                    "A small portion of oatmeal with a sprinkle of chia seeds or flaxseeds,\n" +
                    "A piece of fruit (e.g., a medium-sized apple or a small banana),\n" +
                    "A glass of water or herbal tea.\n" +
                    "Mid-Morning Snack:\n" +
                    "A serving of Greek yogurt or low-fat yogurt,\n" +
                    "A handful of berries or a small piece of fruit.\n" +
                    "Lunch:\n" +
                    "Grilled chicken or a plant-based protein source (tofu or beans),\n" +
                    "A large salad with a variety of colorful vegetables, such as lettuce, tomatoes, cucumbers, and peppers,\n" +
                    "A vinaigrette dressing with lower fat content,A small serving of brown rice or quinoa.\n" +
                    "Afternoon Snack:\n" +
                    "Sliced cucumbers or carrot sticks with hummus,\n" +
                    "A piece of string cheese or a small handful of almonds.\n" +
                    "Dinner:\n" +
                    "Baked or broiled fish (e.g., salmon or tilapia) or a lean protein source,\n" +
                    "Steamed or roasted non-starchy vegetables (e.g., broccoli, cauliflower, or asparagus),\n" +
                    "A side salad with a light dressing,\n" +
                    "A small serving of whole grains (e.g., quinoa or wild rice).\n" +
                    "Evening Snack:\n" +
                    "A small bowl of mixed berries or a small apple,\n" +
                    "A cup of herbal tea or water.");
        } else if (BMI >= 30) {
            L1.setText("Breakfast:\n" +
                    "Scrambled eggs with spinach and mushrooms,Whole-grain toast,\n" +
                    "A serving of mixed berries,A glass of water or herbal tea.\n" +
                    "Mid-Morning Snack:\n" +
                    "A small handful of mixed nuts (unsalted),\n" +
                    "A piece of fruit (e.g., an orange or a small apple).\n" +
                    "Lunch:\n" +
                    "Grilled chicken or chickpea salad with a variety of colorful vegetables(e.g.,cherry tomatoes, bell peppers, and cucumbers),\n" +
                    "Olive oil and balsamic vinegar dressing,\n" +
                    "A small serving of quinoa ,A glass of water or herbal tea,\n" +
                    "Afternoon Snack:\n" +
                    "Greek yogurt with a drizzle of honey and a few sliced strawberries,\n" +
                    "A glass of water.\n" +
                    "Dinner:\n" +
                    "Baked or grilled fish (e.g., cod or haddock) or a lean protein source,\n" +
                    "Steamed broccoli and cauliflower,\n" +
                    "A small serving of brown rice,\n" +
                    "A side salad with a light dressing,\n" +
                    "A glass of water.\n" +
                    "Evening Snack:\n" +
                    "Sliced cucumber and carrot sticks with hummus\n" +
                    "A cup of herbal tea or water");
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

