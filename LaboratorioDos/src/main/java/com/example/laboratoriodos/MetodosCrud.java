package com.example.laboratoriodos;

import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class MetodosCrud {

    private static final Logger LOGGER = Logger.getLogger(Idioma.class.getName());
    public static final String RUTA_ARCHIVO_OBJETO = "LaboratorioDos/src/main/resources/Persistencia/objeto.txt";

    public static void Guardar(Object objeto, ResourceBundle bundle) {
        try {
            ArrayList<Object> objetos = (ArrayList<Object>) Utilidades.getInstance().deserializarXml("Personas.xml");
            objetos.add(objeto);
            Utilidades.getInstance().serializarXml("Personas.xml", objetos);
            Utilidades.getInstance().serializarBinario("PersonasB.dat", objetos);

            ArrayList<String> lista = new ArrayList<>();
            for (Object obj : objetos) {
                lista.add(obj.toString());
            }
            Utilidades.escribirArchivo(RUTA_ARCHIVO_OBJETO, lista, true);

            mostrarAlerta(bundle, "guardarTitulo", "guardarExito", Alert.AlertType.CONFIRMATION);
            Utilidades.guardarRegistroLog("Se creó un nuevo objeto ", 1, "Guardar", LOGGER);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void eliminar(int idBuscar, ResourceBundle bundle) {
        boolean encontrado = false;
        try {
            ArrayList<Persona> objetos = (ArrayList<Persona>) Utilidades.getInstance().deserializarBinario("PersonasB.dat");
            for (int i = 0; i < objetos.size(); i++) {
                if (objetos.get(i).getId() == idBuscar) {
                    objetos.remove(i);
                    mostrarAlerta(bundle, "eliminarTitulo", "eliminarExito", Alert.AlertType.CONFIRMATION);
                    encontrado = true;
                    Utilidades.guardarRegistroLog("Se eliminó un objeto ", 2, "Eliminar", LOGGER);
                    break;
                }
            }

            if (!encontrado) {
                mostrarAlerta(bundle, "noEncontradoTitulo", "noEncontradoMensaje", Alert.AlertType.INFORMATION);
                Utilidades.guardarRegistroLog("Se intentó eliminar un objeto ", 2, "Eliminar", LOGGER);
            }

            Utilidades.getInstance().serializarBinario("PersonasB.dat", objetos);
            Utilidades.getInstance().serializarXml("Personas.xml", objetos);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Persona Buscar(int idBuscar, ResourceBundle bundle) {
        boolean encontrado = false;
        Persona persona = new Persona();
        try {
            ArrayList<Persona> objetos = (ArrayList<Persona>) Utilidades.getInstance().deserializarBinario("PersonasB.dat");
            for (Persona obj : objetos) {
                if (obj.getId() == idBuscar) {
                    persona = obj;
                    encontrado = true;
                    Utilidades.guardarRegistroLog("Se buscó un objeto ", 1, "Buscar", LOGGER);
                    break;
                }
            }

            if (!encontrado) {
                mostrarAlerta(bundle, "noEncontradoTitulo", "noEncontradoMensaje", Alert.AlertType.INFORMATION);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return persona;
    }

    public static void Modificar(Persona personaModificar, ResourceBundle bundle) {
        boolean encontrado = false;
        try {
            ArrayList<Persona> objetos = (ArrayList<Persona>) Utilidades.getInstance().deserializarBinario("PersonasB.dat");
            for (int i = 0; i < objetos.size(); i++) {
                if (objetos.get(i).getId() == personaModificar.getId()) {
                    objetos.set(i, personaModificar);
                    encontrado = true;
                    mostrarAlerta(bundle, "modificarTitulo", "modificarExito", Alert.AlertType.CONFIRMATION);
                    Utilidades.guardarRegistroLog("Se modificó un objeto ", 1, "Modificar", LOGGER);
                    break;
                }
            }

            if (!encontrado) {
                mostrarAlerta(bundle, "noEncontradoTitulo", "noEncontradoMensaje", Alert.AlertType.INFORMATION);
            }

            Utilidades.getInstance().serializarBinario("PersonasB.dat", objetos);
            Utilidades.getInstance().serializarXml("Personas.xml", objetos);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void mostrarAlerta(ResourceBundle bundle, String tituloClave, String mensajeClave, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(bundle.getString(tituloClave));
        alert.setContentText(bundle.getString(mensajeClave));
        alert.showAndWait();
    }
}


