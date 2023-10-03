package com.example.login_page;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DatabaseConnection extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Page");

        // Create a grid pane for the login form
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Add username label and input field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        GridPane.setConstraints(usernameField, 0, 0);

        // Add password label and input field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        GridPane.setConstraints(passwordField, 0, 1);

        // Add login button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 0);

        // Handle the login button click event
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Validate username and password against the database here
            if (isValidLogin(username, password)) {
                // Successful login, you can open a new window or perform other actions
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
        });

        grid.getChildren().addAll(usernameField, passwordField, loginButton);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Replace this method with your actual database validation logic
    private boolean isValidLogin(String username, String password) {
        // Implement your database validation logic here
        // You should check the provided username and password against the database
        // and return true if they are valid, otherwise return false.
        // For security, you should also consider hashing and salting the passwords.
        return false;
    }
}
