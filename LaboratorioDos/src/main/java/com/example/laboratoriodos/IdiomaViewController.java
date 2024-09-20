package com.example.laboratoriodos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.util.Locale;
import java.util.ResourceBundle;


public class IdiomaViewController {

    @FXML
    private Button btnEspañol;

    @FXML
    private Button btnIngles;

    @FXML
    private Label lblAire;

    @FXML
    private Label lblBaño;

    @FXML
    private Label lblCalor;

    @FXML
    private Label lblDespedida;

    @FXML
    private Label lblDomingo;

    @FXML
    private Label lblFrio;

    @FXML
    private Label lblHambre;

    @FXML
    private Label lblInsulto;

    @FXML
    private Label lblLunes;

    @FXML
    private Label lblSaludo;

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
        lblBaño.setText(m.getString("baño"));    }

}
