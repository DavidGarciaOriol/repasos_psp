/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package iesmm.psp.u1.t3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author manue
 */
public class LanzadorSuma {

     public static void main(String[] args) {

        int num1=2;
        int num2=9;

        String[] argumentos = {String.valueOf(num1), String.valueOf(num2)};

        try {
            Process hijo1 = ProcesoJava.exec(Sumador.class,argumentos);
            Process hijo2 = ProcesoJava.exec(Sumador.class,argumentos);
            int salida1 = hijo1.waitFor();
            int salida2 = hijo2.waitFor();
            if(salida1>=0){
                System.out.println( mostrarResultadoBuffer(hijo1));
               
            }else{
                System.out.println("ERROR:Se ha detectado mas de dos argumentos");
            }
            if(salida2>=0){
                
                
                File f= new File("hijo2.txt");
                
                FileWriter fw = new FileWriter(f);
                
                fw.write(mostrarResultadoBuffer(hijo2));
                fw.close();
            }else{
                System.out.println("ERROR:Se ha detectado mas de dos argumentos");
            }
            
            
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static String mostrarResultadoBuffer(Process p) {
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
