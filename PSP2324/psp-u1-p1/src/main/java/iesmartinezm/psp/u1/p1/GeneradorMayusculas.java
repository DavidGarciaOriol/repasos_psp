/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iesmartinezm.psp.u1.p1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manue
 */
public class GeneradorMayusculas {
     public static void main(String[] args) {
        if(args.length == 1){
            System.out.println(args[0].toUpperCase());
            try {
                File f = new File("PALABRAS.txt");
                FileWriter fw = new FileWriter(f);
                fw.write(args[0].toUpperCase());
                fw.close();
            } catch (IOException ex) {
                System.exit(-2);
            }
            System.exit(50);
        }else {
            System.exit(-1);
        }
    }
}
