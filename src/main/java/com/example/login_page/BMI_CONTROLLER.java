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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.mindrot.jbcrypt.BCrypt;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
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
    private TextField usernameField;

    @FXML
    private ImageView brandingImageView;

    @FXML
    private ImageView yogaimage;

    @FXML
    private Button calculatebmi;

    @FXML
    private Button graph;

    @FXML
    private Button Diet;

    @FXML
    private AnchorPane scene;

    Stage stage;

    @FXML
    private Exception IOException;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("IMAGES/456.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File yogaFile = new File("IMAGES/yoga12.jpg");
        Image yogaImage = new Image(yogaFile.toURI().toString());
        yogaimage.setImage(yogaImage);

        // Fetch the username and set it in the usernameField
        int userId = 123; // Replace with the actual user ID
        String username = fetchUsernameFromDatabase(userId);
        usernameField.setText(username);
    }

    private String fetchUsernameFromDatabase(int userId) {
        Connection connectDB = null;
        String username = null;

        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            connectDB = connectNow.getConnection();

            String query = "SELECT username FROM users WHERE user_id = ?";
            PreparedStatement preparedStatement = connectDB.prepareStatement(query);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                username = resultSet.getString("username");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorAlert("An error occurred while retrieving the username from the database.");
        } finally {
            if (connectDB != null) {
                try {
                    connectDB.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return username;
    }
//private int getUserIdFromUsername(String username) {
//    String query = "SELECT user_id FROM users WHERE username = ?";
//
//    try (Connection connectDB = DatabaseConnection.getConnection();
//         PreparedStatement preparedStatement = connectDB.prepareStatement(query)) {
//
//        preparedStatement.setString(1, username);
//        try (ResultSet resultSet = preparedStatement.executeQuery()) {
//            if (resultSet.next()) {
//                return resultSet.getInt("user_id");
//            }
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//        showErrorAlert("An error occurred while retrieving the user ID. Please check your database configuration.");
//    }
//    return -1;
//}


    public void calculate_BMI(ActionEvent event) throws IOException, SQLException {
        double h, w;

        try {
            h = Double.parseDouble(h1.getText());
            w = Double.parseDouble(w1.getText());
        } catch (NumberFormatException e) {
            showErrorAlert("Please enter valid height and weight values.");
            return;
        }

        if (h <= 0 || w <= 0) {
            showErrorAlert("Please enter correct height and weight values.");
            return;
        }

        double bmi = w / (h * h);
        H1.setText(String.format("%.2f", bmi));

        String category = calculateBMICategory(bmi);
        W1.setText(category);

        // Use the username to fetch the user's ID
        String username = usernameField.getText();
        int userId = getUserIdFromUsername(username);

        if (userId != -1) {
            // Store the BMI value in the database
            saveBMIValue(userId, bmi);
        } else {
            showErrorAlert("User not found in the database.");
        }
    }

    private String calculateBMICategory(double bmi) {
        if (bmi <= 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal Weight";
        } else if (bmi <= 29.5) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    private int getUserIdFromUsername(String username) {
        Connection connectDB = null;
        int userId = -1;

        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            connectDB = connectNow.getConnection();

            String query = "SELECT user_id FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connectDB.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userId = resultSet.getInt("user_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorAlert("An error occurred while retrieving the user ID. Please check your database configuration.");
        } finally {
            if (connectDB != null) {
                try {
                    connectDB.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return userId;
    }

    private void saveBMIValue(int userId, double bmi) {
        Connection connectDB = null;

        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            connectDB = connectNow.getConnection();

            String insertQuery = "INSERT INTO bmi_records (user_id, bmi, record_date) VALUES (?, ?, NOW())";
            PreparedStatement preparedStatement = connectDB.prepareStatement(insertQuery);
            preparedStatement.setInt(1, userId);
            preparedStatement.setDouble(2, bmi);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("BMI record inserted successfully.");
            } else {
                System.out.println("Failed to insert BMI record.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorAlert("An error occurred while interacting with the database. Please check your database configuration.");
        } finally {
            if (connectDB != null) {
                try {
                    connectDB.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void LOGOUTBUTTON(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("LOGOUT");
        alert.setHeaderText("YOU're about to logout");
        alert.setContentText("DO YOU WANT TO SAVE BEFORE EXITING?:");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scene.getScene().getWindow();
            System.out.println("You successfully logged out");
            stage.close();
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

    public void work(ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void Diet() {
        try {
            Object root = FXMLLoader.load(getClass().getResource("Diet.fxml"));
            Scene scene = new Scene((Parent) root);
            Stage Diet = new Stage();
            Diet.setScene(scene);
            Diet.show();
            Diet.initStyle(StageStyle.UNDECORATED);
            Diet.setResizable(false);
            Diet.setTitle("Diet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void diethandler(ActionEvent event) throws Exception {
        Parent table = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(table);
        scene.setRoot(table);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void showHistory(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("his.fxml"));
        Parent historyView = loader.load();
        history_controller historyController = loader.getController();

        // Get the username from the TextField
        String username = usernameField.getText();

        // Use the username to fetch the user's ID
        int userId = getUserIdFromUsername(username);

        if (userId != -1) {
            // Set the user ID in the history controller
            historyController.setUserId(userId);

            // Show the history view
            Scene historyScene = new Scene(historyView);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(historyScene);
            window.show();
        } else {
            showErrorAlert("User not found in the database.");
        }
    }
}
