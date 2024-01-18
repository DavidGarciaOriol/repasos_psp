/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iesmartinezm.psp.psp.ud1.t2.v2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ciclot
 */
public class Shell {

    public static void main(String[] args) {
        System.out.println(args.length);
        if (args.length >= 1) {
            if (args.length < 2) {
                File f = new File(args[0]);

                if (f.exists()) {
                    boolean fichero;
                    if (f.isFile()) {
                        fichero = true;
                    } else {
                        fichero = false;
                    }
                    try {
                        ejecutarFichero(fichero, f);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    //error no existe
                    System.out.println("ERROR: El archivo no existe");
                }
            } else {
                //error mas de un parametro    
                System.out.println("ERROR: Se han encontrado mas de un parametro");
            }
        } else {
            //error no hay parametro
            System.out.println("ERROR: No se ha encontrado ningun parametro");
        }
    }

    private static void ejecutarFichero(boolean fichero, File f) throws InterruptedException {

        String[] cmds = new String[3];
        if (fichero) {
            cmds[0] = "more.com";
            cmds[1] = f.getAbsolutePath();
        } else {
            cmds[0] = "cmd.exe";
            cmds[1] = "/c";
            cmds[2] = "dir "+f.getAbsolutePath();
        }
        try {
            ProcessBuilder pb = new ProcessBuilder(cmds);
            Process p;
            p = pb.start();
            p.waitFor();

            mostrarResultadoBuffer(p);
            
        } catch (IOException ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void mostrarResultadoBuffer(Process p) {
        InputStream is = p.getInputStream();
        InputStreamReader ir = new InputStreamReader(is);
        BufferedReader buffer = new BufferedReader(ir);
        String linea = null;
        try {
            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException ex) {
            System.out.println("Error leyendo el buffer");
        }

    }

}
