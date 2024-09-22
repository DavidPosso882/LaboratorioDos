package com.example.laboratoriodos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Idioma extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("idiomaView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

        Persona persona=new Persona(1,"Daniela","Arboleda",20);
        try{
            Utilidades.getInstance().serializarXml("Personas.xml",persona);
            Persona personita=(Persona)Utilidades.deserializarXml("Personas.xml");
            System.out.println("Este objeto fue serializado y deserializado de un archivo .XML "+personita.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Utilidades.serializarBinario("Personas1.dat",persona);
            Persona persona1=(Persona) Utilidades.deserializarBinario("Personas1.dat");
            System.out.println("Este objeto fue serializado y deserializado de un archivo .dat "+persona1.toString());

        }
         catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
