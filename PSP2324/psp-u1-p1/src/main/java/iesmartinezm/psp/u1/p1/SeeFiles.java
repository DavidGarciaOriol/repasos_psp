/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package iesmartinezm.psp.u1.p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ciclot
 */
public class SeeFiles {

    public static void main(String[] args) {
        int cont = 1;
        for (String path : args) {
            File file = new File(path);
            if (file.exists() && file.isFile()) {
                String[] argumentos = {file.getPath()};
                try {
                    Process p = ProcesoJava.execCMD("more", argumentos);
                    String[] contenido = getFileContent(p);

                    System.out.println(contenido[0]);

                    File propiedades_fichero = new File("Fichero" + cont + ".txt");
                    FileWriter fw = new FileWriter(propiedades_fichero);

                    fw.write(file.getPath() + "\n");
                    fw.write("Lineas: " + contenido[1] + "\n");
                    fw.write("Palabras: " + contenido[2] + "\n");
                    fw.close();
                } catch (IOException e) {
                    System.err.println("ERROR: Al leer el fichero " + file.getPath());
                    try {
                        FileWriter erroresWriter = new FileWriter(new File("ERRORES.DAT"), true);
                        erroresWriter.write(LocalDateTime.now() + "ERROR: Al leer el fichero " + file.getPath());
                        erroresWriter.write(e.getStackTrace().toString());
                    } catch (IOException ex) {
                        Logger.getLogger(SeeFiles.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                FileWriter erroresWriter;
                try {
                    erroresWriter = new FileWriter(new File("ERRORES.DAT"), true);
                    erroresWriter.write(LocalDateTime.now() + "ERROR: " + file.getPath() + " no encontrado");
                } catch (IOException ex) {
                    Logger.getLogger(SeeFiles.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            cont++;
        }
    }

    public static String[] getFileContent(Process p) {
        // Creamos el flujo de lectura con el proceso
        BufferedReader leer = new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuilder resultado = new StringBuilder();
        String[] contenido = new String[3];
        try {
            int palabras = 0, lineas = 0;
            String linea = leer.readLine();
            while (linea != null) {
                lineas++;
                palabras += contarPalabras(linea);
                resultado.append(linea).append("\n");  // Agregamos la línea al StringBuilder
                linea = leer.readLine();
            }

            contenido[0] = resultado.toString();
            contenido[1] = String.valueOf(lineas);
            contenido[2] = String.valueOf(palabras);
            return contenido;  // Devolvemos la cadena completa
        } catch (IOException e) {
            System.out.println("Error en el flujo de lectura");
            return null;
        }
    }

    //Método que recibe un String y devuelve el número de palabras que contiene
    public static int contarPalabras(String s) {
        int contador = 1, pos;
        s = s.trim(); //eliminar los posibles espacios en blanco al principio y al final
        if (s.isEmpty()) { //si la cadena está vacía
            contador = 0;
        } else {
            pos = s.indexOf(" "); //se busca el primer espacio en blanco
            while (pos != -1) { //mientras que se encuentre un espacio enblanco 
                contador++; //se cuenta una palabra
                pos = s.indexOf(" ", pos + 1); //se busca el siguiente espacio en blanco
            } //a continuación del actual
        }
        return contador;
    }

}
