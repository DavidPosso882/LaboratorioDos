package com.example.laboratoriodos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.util.Locale;
import java.util.ResourceBundle;


public class IdiomaViewController {

    /*@FXML
    private Label lblSaludo;

    @FXML
    private ChoiceBox<String> idiomaChoice;

    @FXML
    public void initialize() {
        // Inicializar el ChoiceBox con los nombres de los idiomas
        idiomaChoice.getItems().addAll("Español", "Inglés", "Alemán");

        // Establecer un valor por defecto
        idiomaChoice.setValue("Español");

        // Establecer un listener para cambiar el idioma cuando se seleccione uno del ChoiceBox
        idiomaChoice.setOnAction(this::desplegarIdioma);
    }

    @FXML
    void desplegarIdioma(ActionEvent event) {
        String selectedLanguage = idiomaChoice.getValue();
        ResourceBundle bundle;

        switch (selectedLanguage) {
            case "Español":
                bundle = ResourceBundle.getBundle("Idioma", new Locale("es", "ES"));
                lblSaludo.setText(bundle.getString("saludo"));
                break;
            case "Inglés":
                bundle = ResourceBundle.getBundle("Idioma", new Locale("en", "US"));
                lblSaludo.setText(bundle.getString("saludo"));
                break;
            case "Alemán":
                bundle = ResourceBundle.getBundle("Idioma", new Locale("de", "De"));
                lblSaludo.setText(bundle.getString("saludo"));
                break;
        }
    }





    @FXML
    void ponerEspañol(ActionEvent event) {
        ResourceBundle m;
        m=ResourceBundle.getBundle("Idioma", new Locale("es","ES"));

        lblSaludo.setText(m.getString("saludo"));
        lblDespedida.setText(m.getString("despedida"));
        lblInsulto.setText(m.getString("insulto"));
        lblDomingo.setText(m.getString("domingo"));
        lblLunes.setText(m.getString("lunes"));
        lblAire.setText(m.getString("aire"));
        lblFrio.setText(m.getString("frio"));
        lblCalor.setText(m.getString("calor"));
        lblHambre.setText(m.getString("hambre"));
        lblBaño.setText(m.getString("baño"));
    }

    @FXML
    void ponerIngles(ActionEvent event) {
        ResourceBundle m;
        m=ResourceBundle.getBundle("Idioma", new Locale("en","US"));

        lblSaludo.setText(m.getString("saludo"));
        lblDespedida.setText(m.getString("despedida"));
        lblInsulto.setText(m.getString("insulto"));
        lblDomingo.setText(m.getString("domingo"));
        lblLunes.setText(m.getString("lunes"));
        lblAire.setText(m.getString("aire"));
        lblFrio.setText(m.getString("frio"));
        lblCalor.setText(m.getString("calor"));
        lblHambre.setText(m.getString("hambre"));
        lblBaño.setText(m.getString("baño"));    }*/

}
