package com.example.laboratoriodos;

import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class MetodosCrud {

    private static final Logger LOGGER = Logger.getLogger(Idioma.class.getName());
    public static final String RUTA_ARCHIVO_OBJETO = "LaboratorioDos/src/main/resources/Persistencia/objeto.txt";

    public static void Guardar(Object objeto){
        try{
            ArrayList<Object> objetos= (ArrayList<Object>) Utilidades.getInstance().deserializarXml("Personas.xml");
            objetos.add(objeto);
            Utilidades.getInstance().serializarXml("Personas.xml",objetos);
            Utilidades.getInstance().serializarBinario("PersonasB.dat",objetos);

            ArrayList<String> lista = new ArrayList<>();

            for (int i = 0; i < objetos.size(); i++) {
                lista.add(objetos.get(i).toString());
            }

            Utilidades.escribirArchivo(RUTA_ARCHIVO_OBJETO, lista, true);

            mostrarAlerta("Guardar","Se guardo exitosamente", Alert.AlertType.CONFIRMATION);
            Utilidades.guardarRegistroLog("Se creo un nuevo objeto ", 1, "Guardar", LOGGER);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void eliminar(int idBuscar){
        boolean encontrado=false;
        //Persona persona=new Persona();
        try {
            ArrayList<Persona>objetos= (ArrayList<Persona>) Utilidades.getInstance().deserializarBinario("PersonasB.dat");
            for(int i=0;i<objetos.size();i++){
                if(objetos.get(i).getId()==idBuscar){
                    objetos.remove(i);
                    mostrarAlerta("Eliminado con exito","Se elimino con exitos", Alert.AlertType.CONFIRMATION);
                    encontrado=true;
                    Utilidades.guardarRegistroLog("Se elimino un objeto ", 2, "Eliminar", LOGGER);

                }}
                if(encontrado==false){
                    mostrarAlerta("No encontrado","No se encontrarón resultados ", Alert.AlertType.INFORMATION);
                    Utilidades.guardarRegistroLog("Se intento elimina un objeto ", 2, "Eliminar", LOGGER);

                }

            Utilidades.getInstance().serializarBinario("PersonasB.dat",objetos);
            Utilidades.getInstance().serializarXml("Personas.xml",objetos);
    } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Persona Buscar(int idBuscar){
            boolean encontrado=false;
            Persona persona=new Persona();
            try {
                ArrayList<Persona>objetos= (ArrayList<Persona>) Utilidades.getInstance().deserializarBinario("PersonasB.dat");
                for(int i=0;i<objetos.size();i++){
                    if(objetos.get(i).getId()==idBuscar){
                        persona=objetos.get(i);
                        //mostrarAlerta("Eliminado con exito","Se elimino con exitos", Alert.AlertType.CONFIRMATION);
                        encontrado=true;
                        Utilidades.guardarRegistroLog("Se busco un objeto ", 1, "Eliminar", LOGGER);
                    }}
                    if(encontrado==false){
                        mostrarAlerta("No encontrado","No se encontrarón resultados ", Alert.AlertType.INFORMATION);
                    }

                return persona;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

  public static void Modificar(Persona persona){
      boolean encontrado=false;
      try {
          ArrayList<Persona>objetos= (ArrayList<Persona>) Utilidades.getInstance().deserializarXml("Personas.xml");
          for(int i=0;i<objetos.size();i++){
              if(objetos.get(i).getId()==persona.getId()){
                  Utilidades.guardarRegistroLog("Se modifico el objeto: "+persona.getId()+" "+persona.getNombre()+" "+persona.getApellido()+" "+persona.getEdad(), 2, "Modificar", LOGGER);
                  objetos.set(i,persona);
                  mostrarAlerta("Modificado exitosamente ","Se modifico con exitos", Alert.AlertType.CONFIRMATION);
                  encontrado=true;

              }}
          if(encontrado==false){
              mostrarAlerta("No encontrado","No se encontrarón resultados ", Alert.AlertType.INFORMATION);
          }

          Utilidades.getInstance().serializarBinario("PersonasB.dat",objetos);
          Utilidades.getInstance().serializarXml("Personas.xml",objetos);

      } catch (Exception e) {
          throw new RuntimeException(e);
      }
  }


    public static void mostrarAlerta(String titulo, String encabezado, Alert.AlertType tipoAlerta) {
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(titulo);        // Establece el título de la alerta
        alerta.setHeaderText(encabezado); // Establece el encabezado de la alerta
        //alerta.setContentText(contenido); // Establece el contenido de la alerta
        alerta.showAndWait();           // Muestra la alerta y espera a que el usuario interactúe
    }
}
