/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package iesmm.psp.u1.t4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aleatorios {
    public static void main(String[] args) throws IOException {

        try {
            Process p = ProcesoJava.exec(GeneradorAleatorios.class);
            int salida=p.waitFor();

            if(salida!=-1){
                String standard = mostrarResultadoBuffer(p);
                if(Integer.parseInt(standard)==salida){
                    System.out.println("Son iguales");
                }
            }else{
                System.err.println(salida);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


    public static String mostrarResultadoBuffer(Process p) {
        // Creamos el flujo de lectura con el proceso
        BufferedReader leer = new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuilder salidastandad= new StringBuilder();
        try {
            // Guardamos la primera línea
            String linea = leer.readLine();

            // Leemos las líneas y las mostramos por panatalla
            while (linea != null) {
                salidastandad.append(linea);
                System.out.println(linea);
                linea = leer.readLine();
            }
            return salidastandad.toString();
        } catch (IOException e) {
            // Controlamos el error por si hay error en el flujo de lectura
            System.out.println("Error en el flujo de lectura");
            // e.printStackTrace();
        }
        return "";
    }

}