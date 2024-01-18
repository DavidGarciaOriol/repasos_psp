/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iesmartinezm.psp.u1.p1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ciclot
 */
public class Prueba {

    public static void main(String[] args) {

        try {
            Process p = ProcesoJava.execNavegador("www.google.es");
            p.waitFor();
            String[] argumentos={""};
            Process p2=ProcesoJava.execCMD("dir",argumentos);
            p2.waitFor();
        } catch (IOException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
