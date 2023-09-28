module com.example.login_page {

    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;


    opens com.example.login_page to javafx.fxml;
    exports com.example.login_page;

}