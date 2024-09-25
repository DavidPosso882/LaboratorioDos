package com.example.laboratoriodos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Idioma extends Application {

    private static final Logger LOGGER = Logger.getLogger(Idioma.class.getName());

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("crudView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Programación laboratorio_2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {

        FileHandler archivo = new FileHandler("Log.txt", true);
        archivo.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(archivo);

        launch();

    }
}
