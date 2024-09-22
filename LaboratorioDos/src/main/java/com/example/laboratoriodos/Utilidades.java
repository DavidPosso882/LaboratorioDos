package com.example.laboratoriodos;

import java.io.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

public class Utilidades {
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

    public static void serializarBinario(String nombre, Object objeto) throws IOException {
        ObjectOutputStream salida;
        salida= new ObjectOutputStream(new FileOutputStream(nombre));
        salida.writeObject(objeto);
        salida.close();
    }

    public static Object deserializarBinario(String nombre)throws Exception{
        Object objeto;
        ObjectInputStream entrada;
        entrada=new ObjectInputStream(new FileInputStream(nombre));
        objeto=entrada.readObject();
        entrada.close();
        return objeto;
    }

    public static void serializarXml(String nombre, Object objeto)throws IOException{
        XMLEncoder codificador;
        codificador=new XMLEncoder(new FileOutputStream(nombre));
        codificador.writeObject(objeto);
        codificador.close();
    }

    public static Object deserializarXml(String nombre)throws IOException{
        XMLDecoder decodificador;
        Object objeto;
        decodificador=new XMLDecoder(new FileInputStream(nombre));
        objeto=decodificador.readObject();
        decodificador.close();
        return objeto;
    }

}
