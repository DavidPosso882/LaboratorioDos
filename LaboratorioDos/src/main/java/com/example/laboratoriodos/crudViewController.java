package com.example.laboratoriodos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class crudViewController {
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtID;
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
    private Label lblTitulo;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnModificar;

    private ResourceBundle bundle;

    @FXML
    public void listaIdiomas(ResourceBundle bundle) {
        lblRegistro.setText(bundle.getString("registro"));
        lblId.setText(bundle.getString("id"));
        lblNombre.setText(bundle.getString("nombre"));
        lblApellido.setText(bundle.getString("apellido"));
        lblEdad.setText(bundle.getString("edad"));
        btnBuscar.setText(bundle.getString("buscar"));
        btnGuardar.setText(bundle.getString("guardar"));
        btnModificar.setText(bundle.getString("modificar"));
        btnEliminar.setText(bundle.getString("eliminar"));
        lblTitulo.setText(bundle.getString("titulo"));
    }

    @FXML
    public void initialize() {
        // Inicializar el ChoiceBox con los nombres de los idiomas
        idiomaChoice.getItems().addAll("Español", "Inglés", "Alemán");

        // Establecer un valor por defecto
        idiomaChoice.setValue("Español");

        // Establecer un listener para cambiar el idioma cuando se seleccione uno del ChoiceBox
        idiomaChoice.setOnAction(this::desplegarIdioma);

        // Cargar el idioma inicial
        desplegarIdioma(null);
    }

    private ResourceBundle obtenerBundle() {
        String selectedLanguage = idiomaChoice.getValue();
        switch (selectedLanguage) {
            case "Español":
                return ResourceBundle.getBundle("Idioma", new Locale("es", "ES"));
            case "Inglés":
                return ResourceBundle.getBundle("Idioma", new Locale("en", "US"));
            case "Alemán":
                return ResourceBundle.getBundle("Idioma", new Locale("de", "DE"));
            default:
                return ResourceBundle.getBundle("Idioma", new Locale("es", "ES"));
        }
    }

    @FXML
    void desplegarIdioma(ActionEvent event) {
        bundle = obtenerBundle();
        listaIdiomas(bundle);
    }

    @FXML
    void Guardar(ActionEvent event) throws IOException {
        // Verificar si los campos están vacíos
        if (txtID.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtEdad.getText().isEmpty()) {
            MetodosCrud.mostrarAlerta(bundle, "errorTitulo", "camposVacios", Alert.AlertType.ERROR);
            return;
        }

        try {
            // Intentar convertir los valores de 'id' y 'edad' a números
            int iD = Integer.parseInt(txtID.getText());
            int edad = Integer.parseInt(txtEdad.getText());

            // Crear una nueva instancia de la clase Persona
            Persona persona = new Persona(iD, txtNombre.getText(), txtApellido.getText(), edad);

            // Llamar al metodo Guardar
            MetodosCrud.Guardar(persona, bundle);

        } catch (NumberFormatException e) {
            // Si la conversión falla, mostrar un error específico para ID y Edad
            MetodosCrud.mostrarAlerta(bundle, "errorTitulo", "formatoNumerico", Alert.AlertType.ERROR);
        }
    }


    @FXML
    void Eliminar(ActionEvent event) throws IOException {
        if (txtId.getText().isEmpty()) {
            MetodosCrud.mostrarAlerta(bundle, "errorTitulo", "idVacio", Alert.AlertType.ERROR);
            return;
        }

        try {
            int id = Integer.parseInt(txtId.getText());
            MetodosCrud.eliminar(id, bundle);

        } catch (NumberFormatException e) {
            MetodosCrud.mostrarAlerta(bundle, "errorTitulo", "formatoNumerico", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void Buscar(ActionEvent event) throws IOException {
        if (txtId.getText().isEmpty()) {
            MetodosCrud.mostrarAlerta(bundle, "errorTitulo", "idVacio", Alert.AlertType.ERROR);
            return;
        }

        try {
            int id = Integer.parseInt(txtId.getText());
            Persona persona = MetodosCrud.Buscar(id, bundle);

            if (persona != null) {
                txtNombre.setText(persona.getNombre());
                txtApellido.setText(persona.getApellido());
                txtEdad.setText(String.valueOf(persona.getEdad()));
            }

        } catch (NumberFormatException e) {
            MetodosCrud.mostrarAlerta(bundle, "errorTitulo", "formatoNumerico", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void Modificar(ActionEvent event) throws IOException {
        if (txtID.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtEdad.getText().isEmpty()) {
            MetodosCrud.mostrarAlerta(bundle, "errorTitulo", "camposVacios", Alert.AlertType.ERROR);
            return;
        }

        try {
            int iD = Integer.parseInt(txtID.getText());
            int edad = Integer.parseInt(txtEdad.getText());

            Persona persona = new Persona(iD, txtNombre.getText(), txtApellido.getText(), edad);
            MetodosCrud.Modificar(persona, bundle);

        } catch (NumberFormatException e) {
            MetodosCrud.mostrarAlerta(bundle, "errorTitulo", "formatoNumerico", Alert.AlertType.ERROR);
        }
    }
}

    /*
    @FXML
    void Guardar(ActionEvent event) throws IOException {
        // Validar que los campos no estén vacíos antes de intentar convertirlos
        if (txtID.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtEdad.getText().isEmpty()) {
            // Mostrar mensaje de error o advertencia al usuario (puedes implementar un diálogo si lo deseas)
            System.out.println("Todos los campos deben estar llenos.");
            return;
        }

        try {
            // Intentar parsear los valores y guardar la persona
            int id = Integer.parseInt(txtID.getText());
            int edad = Integer.parseInt(txtEdad.getText());

            Persona persona = new Persona(id, txtNombre.getText(), txtApellido.getText(), edad);
            MetodosCrud.Guardar(persona);

            // Mostrar mensaje de éxito
            System.out.println("Persona guardada con éxito.");

        } catch (NumberFormatException e) {
            // Manejar el caso de formato incorrecto
            System.out.println("Error: los campos de ID y Edad deben ser números.");
        }
    }


    @FXML
    void Eliminar(ActionEvent event) throws IOException {
        // Verificar que el campo ID no esté vacío
        if (txtId.getText().isEmpty()) {
            // Mostrar mensaje de advertencia
            System.out.println("Debe proporcionar un ID para eliminar.");
            return;
        }

        try {
            // Convertir el ID a un número entero y eliminar la persona
            int id = Integer.parseInt(txtId.getText());
            MetodosCrud.eliminar(id);

            // Mostrar mensaje de éxito
            System.out.println("Persona eliminada con éxito.");

        } catch (NumberFormatException e) {
            // Manejar el caso de formato incorrecto
            System.out.println("Error: el campo de ID debe ser un número.");
        }
    }


    @FXML
    void Buscar(ActionEvent event) throws IOException {
        // Verificar que el campo ID no esté vacío
        if (txtId.getText().isEmpty()) {
            // Mostrar mensaje de advertencia
            System.out.println("Debe proporcionar un ID para buscar.");
            return;
        }

        try {
            // Convertir el ID a un número entero
            int id = Integer.parseInt(txtId.getText());

            // Buscar la persona por ID
            Persona persona = MetodosCrud.Buscar(id);

            // Si se encuentra la persona, llenar los campos con sus datos
            if (persona != null) {
                txtNombre.setText(persona.getNombre());
                txtApellido.setText(persona.getApellido());
                txtEdad.setText(String.valueOf(persona.getEdad()));
                System.out.println("Persona encontrada: " + persona.getNombre());
            } else {
                // Mostrar mensaje si no se encuentra la persona
                System.out.println("Persona no encontrada con el ID proporcionado.");
            }

        } catch (NumberFormatException e) {
            // Manejar el caso de formato incorrecto
            System.out.println("Error: el campo de ID debe ser un número.");
        }
    }


    @FXML
    void Modificar(ActionEvent event) throws IOException {
        // Validar que los campos no estén vacíos
        if (txtID.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtEdad.getText().isEmpty()) {
            // Mostrar mensaje de error o advertencia al usuario
            System.out.println("Todos los campos deben estar llenos para modificar.");
            return;
        }

        try {
            // Convertir los valores a números y modificar la persona
            int id = Integer.parseInt(txtID.getText());
            int edad = Integer.parseInt(txtEdad.getText());

            Persona persona = new Persona(id, txtNombre.getText(), txtApellido.getText(), edad);
            MetodosCrud.Modificar(persona);

            // Mostrar mensaje de éxito
            System.out.println("Persona modificada con éxito.");

        } catch (NumberFormatException e) {
            // Manejar el caso de formato incorrecto
            System.out.println("Error: los campos de ID y Edad deben ser números.");
        }
    }*/

