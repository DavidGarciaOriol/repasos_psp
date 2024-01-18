/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.psp.dgo.padrehijo.practica1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class LanzadorSumador {

    public static void main(String[] args) {
        String[] numeros = {"5", "5"};
        String[] numeros2 = {"10", "10"};
        
        try {
            
            Process procesoHijo1 = ProcesoJava.exec(Sumador.class, numeros);
            Process procesoHijo2 = ProcesoJava.exec(Sumador.class, numeros2);
            
            int resultado = procesoHijo1.waitFor();
            int resultado2 = procesoHijo2.waitFor();
            
            mostrarResultadoBuffer(procesoHijo1);
            
            try {
                FileWriter writer = new FileWriter(new File("res" + File.separator + "SalidaHijo2.txt"));
                writer.write(String.valueOf(mostrarResultadoBuffer(procesoHijo2)));
                writer.close();
            } catch (IOException e) {
                System.err.println("ERROR: " + e.getMessage());
            }
            
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
    }
    
    public static String mostrarResultadoBuffer(Process p) {
            // Creamos el flujo de lectura con el proceso
            String out = "";
            BufferedReader leer = new BufferedReader(new InputStreamReader(p.getInputStream()));

            try {
                // Guardamos la primera línea
                String linea = leer.readLine();
                // Leemos las líneas y las mostramos por panatalla
                while (linea != null) {
                    System.out.println(linea);
                    out += linea;
                    linea = leer.readLine();
                }
            } catch (IOException e) {
                // Controlamos el error por si hay error en el flujo de lectura
                System.out.println("Error en el flujo de lectura");
                // e.printStackTrace();
            } return out;
        }
}
