package com.example.laboratoriodos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


public class crudViewController {
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEdad;
    @FXML
    private ChoiceBox<String> idiomaChoice;
    @FXML
    private Label lblId;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblApellido;
    @FXML
    private Label lblEdad;
    @FXML
    private Label lblRegistro;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnModificar;

    @FXML
    public void listaIdiomas(ResourceBundle bundle){
        lblRegistro.setText(bundle.getString("registro"));
        lblId.setText(bundle.getString("id"));
        lblNombre.setText(bundle.getString("nombre"));
        lblApellido.setText(bundle.getString("apellido"));
        lblEdad.setText(bundle.getString("edad"));
        btnBuscar.setText(bundle.getString("buscar"));
        btnGuardar.setText(bundle.getString("guardar"));
        btnModificar.setText(bundle.getString("modificar"));
        btnEliminar.setText(bundle.getString("eliminar"));
    }
    

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
                listaIdiomas(bundle);
                break;
            case "Inglés":
                bundle = ResourceBundle.getBundle("Idioma", new Locale("en", "US"));
                listaIdiomas(bundle);
                break;
            case "Alemán":
                bundle = ResourceBundle.getBundle("Idioma", new Locale("de", "De"));
                listaIdiomas(bundle);
                break;
        }
    }

    @FXML
    void Guardar(ActionEvent event) throws IOException {
        Persona persona=new Persona(Integer.parseInt(txtId.getText()),txtNombre.getText(),txtApellido.getText(),Integer.parseInt(txtEdad.getText()));
        MetodosCrud.Guardar(persona);
    }

    @FXML
    void Eliminar(ActionEvent event) throws IOException {
        MetodosCrud.eliminar(Integer.parseInt(txtId.getText()));
    }
    @FXML
    void Buscar(ActionEvent event) throws IOException {
        Persona persona=MetodosCrud.Buscar(Integer.parseInt(txtId.getText()));
        if(persona!=null){
            txtNombre.setText(persona.getNombre());
            txtApellido.setText(persona.getApellido());
            txtEdad.setText(String.valueOf(persona.getEdad()));
        }
    }

    @FXML
    void Modificar(ActionEvent event) throws IOException {
        Persona persona=new Persona(Integer.parseInt(txtId.getText()),txtNombre.getText(),txtApellido.getText(),Integer.parseInt(txtEdad.getText()));
        MetodosCrud.Modificar(persona);
    }


}
