/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package iesmartinezm.psp.u1.p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manue
 */
public class Mayusculas {

    private static FileWriter fw;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        try {
            fw = new FileWriter(new File("ERRORES.DAT"));

            do {
                System.out.print("Frase a convertir: ");
                s = sc.nextLine();
                String argumentos[] = {s};
                try {
                    Process hijo1 = ProcesoJava.exec(GeneradorMayusculas.class, argumentos);
                    int salida1 = hijo1.waitFor();
                    if (salida1 >= 0) {
                        System.out.println("Frase convertida: " + getResultadoBuffer(hijo1));
                    } else if (salida1 == -1) {
                        fw.write("ERROR:Se ha detectado mas de un argumentos");
                    } else if (salida1 == 2) {
                        fw.write("ERROR: Al crear el fichero PALABRAS.txt");
                    }

                } catch (InterruptedException e) {
                    fw.write("ERROR: Al llamar al proceso hijo");
                }
                System.out.println("Desea continuar (S/N): ");
                s = sc.nextLine();
            } while (s.toUpperCase().equals("S"));
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Mayusculas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getResultadoBuffer(Process p) {
        // Creamos el flujo de lectura con el proceso
        BufferedReader leer = new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuilder resultado = new StringBuilder();

        try {
            String linea = leer.readLine();
            while (linea != null) {
                resultado.append(linea).append("\n");  // Agregamos la línea al StringBuilder
                linea = leer.readLine();
            }
            return resultado.toString();  // Devolvemos la cadena completa
        } catch (IOException e) {
            System.out.println("Error en el flujo de lectura");
            return null;
        }
    }
}
