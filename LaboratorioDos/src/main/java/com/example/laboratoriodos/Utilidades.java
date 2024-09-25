package com.example.laboratoriodos;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utilidades {

    static String fechaSistema;

    private static Utilidades instanciaUnica;

    private Utilidades() {
    }

    public static Utilidades getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new Utilidades();
        }
        return instanciaUnica;
    }

    public void serializarBinario(String nombre, Object objeto) throws IOException {
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombre));
        salida.writeObject(objeto);
        salida.close();
    }

    public Object deserializarBinario(String nombre) throws IOException, ClassNotFoundException {
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombre));
        Object objeto = entrada.readObject();
        entrada.close();
        return objeto;
    }

    public void serializarXml(String nombre, Object objeto) throws IOException {
        XMLEncoder codificador = new XMLEncoder(new FileOutputStream(nombre));
        codificador.writeObject(objeto);
        codificador.close();
    }

    public Object deserializarXml(String nombre) throws IOException {
        XMLDecoder decodificador = new XMLDecoder(new FileInputStream(nombre));
        Object objeto = decodificador.readObject();
        decodificador.close();
        return objeto;
    }

    public static void escribirArchivo(String nombre, ArrayList<String> texto, boolean adicionar) throws IOException {
        FileWriter archivoSalida;
        BufferedWriter bufferSalida;

        archivoSalida = null;
        archivoSalida = new FileWriter(nombre, adicionar);
        bufferSalida = new BufferedWriter(archivoSalida);

        int i = 0;
        for (String linea : texto) {
            bufferSalida.write(linea + "\n");
            i++;
            if (i == 10){
                bufferSalida.flush();
                i = 0;
            }
        }
        bufferSalida.flush();
        bufferSalida.close();
        archivoSalida.close();
    }

    public static void guardarRegistroLog(String mensajeLog, int nivel, String accion, Logger logger) {
        cargarFechaSistema();

        switch (nivel) {
            case 1:
                logger.log(Level.INFO, accion + "," + mensajeLog + "," + fechaSistema);
                break;
            case 2:
                logger.log(Level.WARNING, accion + "," + mensajeLog + "," + fechaSistema);
                break;
            case 3:
                logger.log(Level.SEVERE, accion + "," + mensajeLog + "," + fechaSistema);
                break;
            default:
                break;
        }
    }

    private static void cargarFechaSistema() {
        Calendar cal = Calendar.getInstance();
        int dia = cal.get(Calendar.DATE);
        int mes = cal.get(Calendar.MONTH) + 1;
        int año = cal.get(Calendar.YEAR);
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        int minuto = cal.get(Calendar.MINUTE);

        fechaSistema = String.format("%04d-%02d-%02d %02d:%02d", año, mes, dia, hora, minuto);
    }
}