module com.example.laboratoriodos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens com.example.laboratoriodos to javafx.fxml;
    exports com.example.laboratoriodos;
}