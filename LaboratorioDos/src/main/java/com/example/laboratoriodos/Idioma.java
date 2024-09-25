package com.example.laboratoriodos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Idioma extends Application {

    private static final Logger LOGGER = Logger.getLogger(Idioma.class.getName());
    public static final String RUTA_ARCHIVO_LOG = "LaboratorioDos/src/main/resources/Persistencia/log.txt";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Idioma.class.getResource("crudView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Programación laboratorio_2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {

        // Crear el directorio si no existe
        File logFile = new File(RUTA_ARCHIVO_LOG).getParentFile();
        if (!logFile.exists()) {
            logFile.mkdirs();
        }

        // Configurar el FileHandler una única vez
        FileHandler archivo = new FileHandler(RUTA_ARCHIVO_LOG, true);
        archivo.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(archivo);

        // Guardar log de inicio del programa
        Utilidades.guardarRegistroLog("Se inició el programa", 1, "Iniciar", LOGGER);

        launch();
        archivo.close();
    }
}
