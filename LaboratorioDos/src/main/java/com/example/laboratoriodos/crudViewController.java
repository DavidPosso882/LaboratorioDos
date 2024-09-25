package com.example.laboratoriodos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;


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
