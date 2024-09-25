package com.example.laboratoriodos;

import javafx.scene.control.Alert;

import java.io.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.util.ArrayList;

public class Utilidades {

    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/Persistencia/log.txt";
    public static final String RUTA_ARCHIVO_Objeto = "src/main/resources/Persistencia/objeto.txt";

    private static Utilidades instanciaUnica;
    private Utilidades() {
    }

    // Método para obtener la instancia única de la clase
    public static Utilidades getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new Utilidades();
        }
        return instanciaUnica;
    }

    public void serializarBinario(String nombre, Object objeto) throws IOException {
        ObjectOutputStream salida;
        salida= new ObjectOutputStream(new FileOutputStream(nombre));
        salida.writeObject(objeto);
        salida.close();
    }

    public Object deserializarBinario(String nombre)throws Exception{
        Object objeto;
        ObjectInputStream entrada;
        entrada=new ObjectInputStream(new FileInputStream(nombre));
        objeto=entrada.readObject();
        entrada.close();
        return objeto;
    }

    public  void serializarXml(String nombre, Object objeto)throws IOException{
        XMLEncoder codificador;
        codificador=new XMLEncoder(new FileOutputStream(nombre));
        codificador.writeObject(objeto);
        codificador.close();
    }

    public Object deserializarXml(String nombre)throws IOException{
        XMLDecoder decodificador;
        Object objeto;
        decodificador=new XMLDecoder(new FileInputStream(nombre));
        objeto=decodificador.readObject();
        decodificador.close();
        return objeto;
    }

    public void escribirArchivo(String archivo, ArrayList<String> texto, boolean adicionar) throws IOException {

        int n = 9;

        FileWriter archivoSalida = null;
        BufferedWriter bufferSalida;

        archivoSalida = new FileWriter(archivo, adicionar);
        bufferSalida = new BufferedWriter(archivoSalida);

        for (int i = 0; i < 10; i++) {
            String linea = texto.get(i);
            bufferSalida.write(linea + "\n");
            if (i==n){
                bufferSalida.flush();
                n +=10;
            }
        }
        bufferSalida.flush();
        bufferSalida.close();
        archivoSalida.close();
    }


}
