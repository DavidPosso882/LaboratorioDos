package com.example.laboratoriodos;

import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.ArrayList;

public class MetodosCrud {
    public static void Guardar(Object objeto){
        try{
            ArrayList<Object> objetos= (ArrayList<Object>) Utilidades.getInstance().deserializarXml("Personas.xml");
            objetos.add(objeto);
            Utilidades.getInstance().serializarXml("Personas.xml",objetos);
            Utilidades.getInstance().serializarBinario("PersonasB.dat",objetos);
            mostrarAlerta("Guardar","Se guardo exitosamente", Alert.AlertType.CONFIRMATION);

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
