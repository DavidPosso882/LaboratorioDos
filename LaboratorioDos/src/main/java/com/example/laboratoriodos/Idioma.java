package com.example.laboratoriodos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("idiomaView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static final String RUTA_ARCHIVO_Objeto = "src/main/resources/Persistencia/objeto.txt";

    public static void main(String[] args) throws IOException {

        FileHandler archivo = new FileHandler("Log.txt", true);
        archivo.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(archivo);



        ArrayList<String> lista = new ArrayList<>();
        lista.add("Camilo");
        lista.add("David");
        
        Utilidades.escribirArchivo(RUTA_ARCHIVO_Objeto,lista,true);

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
