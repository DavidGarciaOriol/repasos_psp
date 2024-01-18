/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package iesmartinezm.psp.psp.ud1.t2.v2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ciclot
 */
public class NavegadorWebTemporal {

    private static String ruta = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
    private static ProcessBuilder pb;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        String userInput = "";
        String url = "";
        do {
            System.out.println("¿Quieres abrir el navegador?(s/n)");
            userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("s")) {
                System.out.println("Introduzca la url deseado para abrir el navegador");
                url = sc.nextLine();
                abrirNavegador(url);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(NavegadorWebTemporal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } while (!userInput.equalsIgnoreCase("n"));

    }

    private static void abrirNavegador(String url) {
        try {
            pb = new ProcessBuilder(ruta, url);
            pb.start();
        } catch (IOException ex) {
            Logger.getLogger(NavegadorWebTemporal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
