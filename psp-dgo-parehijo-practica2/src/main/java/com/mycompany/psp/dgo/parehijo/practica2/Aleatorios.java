/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.psp.dgo.parehijo.practica2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author usuario
 */
public class Aleatorios {

    public static void main(String[] args) {
        try {
            
            Scanner scanner = new Scanner(System.in);
            
            do{
                Process procesoHijo1 = ProcesoJava.exec(GeneradorAleatorios.class);
                int salida = procesoHijo1.waitFor();
                int aleatorioHijo = Integer.parseInt(mostrarResultadoBuffer(procesoHijo1));

                System.out.println("Salida proceso hijo: " + salida);
                System.out.println("Numero Aleatorio: " + aleatorioHijo);
                
                if (salida == aleatorioHijo){
                    System.out.println("La salida y el número son el mismo.");
                } else {
                    System.err.println("La salida y el número no coinciden.");
                }
                
                System.out.println("\n¿Desea detener el programa? (si/no)");
                
            } while (!scanner.nextLine().equals("si"));
            
            
            
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    
    private static void getSalidaProceso(Process p) throws IOException {
		String line;
		InputStream is = p.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		// Se muestra la salida del proceso por pantalla
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		// Cuando finaliza se cierra el descriptor del proceso
		is.close();
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
                    // System.out.println(linea);
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
