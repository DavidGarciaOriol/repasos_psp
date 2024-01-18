/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package iesmartinezm.psp.psp.ud1.a2;

import java.io.File;

/**
 *
 * @author ciclot
 */
public class PspUd1A2 {

    public static void main(String[] args) {
        
        
        if(args.length == 1){
            String ruta=args[0];
            
            File f = new File(ruta);
            
            if(f.exists()&& f.isDirectory()){
                
            }
            
        }else{
            //numero de argumento incorrecto
        }
        
        
        
    }
}
