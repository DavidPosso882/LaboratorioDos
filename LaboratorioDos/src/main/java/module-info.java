module com.example.laboratoriodos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laboratoriodos to javafx.fxml;
    exports com.example.laboratoriodos;
}