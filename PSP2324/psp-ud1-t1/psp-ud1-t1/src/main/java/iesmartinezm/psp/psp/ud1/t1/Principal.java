package iesmartinezm.psp.psp.ud1.t1;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ciclot
 */
public class Principal {

    public static void main(String[] args) {
        //controla cual es el primer parametro (true =  pb; false = rt)
        boolean par_1;
        
        //controla cual es el segundo parmetro (true = c; false = n)
        boolean par_2=false;
        
        if(args.length >=2 && args.length <= 3){
            //tiene 2 o 3 argumentos
            
            if("p".equals(args[0].toLowerCase()) || "r".equals(args[0].toLowerCase())){
                //primer parametro correcto
                
                par_1= ("p".equals(args[0].toLowerCase()));
                
                if("c".equals(args[1].toLowerCase()) ||"n".equals(args[1].toLowerCase())){
                    //segundo parametro correcto
                    par_2= ("c".equals(args[1].toLowerCase()));
                    
                    //detectar programa

                    String ruta = rutaPrograma(par_2);
                    
                    if(!ruta.equals("")){
                        //aplicacion encontrada
                        //System.out.println(ruta);
                        
                        //detectar archivo
                    
                        if(args.length == 3){
                            if(ficheroExiste(args[2])){
                                //fichero encontrado
                                
                                //ejecutar con parametro
                                ejecutarProceso(par_1,ruta,args[2]);
                            }else{
                                //fichero no encontrado
                                System.out.println("Archivo no encontrado.");
                            }
                        }else{
                            //ejecutar sin parametro
                            ejecutarProceso(par_1,ruta);
                        }
                        
                        
                        
                    }else{
                        //aplicacion no encontrada
                        System.out.println("Aplicacion no encontrada.");
                    }
                    
                }else{
                    //segundo parametro incorrecto
                    System.out.println("Segundo argumento no esperado");
                  
                }
                
            }else{
                //primer parametro incorrecto
                System.out.println("Primer argumento no esperado");
            }
            
        }else{
            //tiene un numero incorecto de argumentos
            System.out.println("numero incorrecto de argumentos.");
        }
        
        
    }

    private static String rutaPrograma(boolean par_2) {
        String ruta="";
        
        if(par_2){
            //chrome
            
            File chrome = new File("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            
            if(chrome.exists() && chrome.isFile()){
                //existe
                ruta=chrome.getAbsolutePath();
            } else {
                return "";
            }
        }else{
            //notepad
            
            File notepad = new File("C:\\Windows\\system32\\notepad.exe");
            
            if(notepad.exists() && notepad.isFile()){
                //existe
                ruta=notepad.getAbsolutePath();
            } else {
                return "";
            }
            
        }
        
        return ruta;
        
    }

    private static void ejecutarProceso(boolean par_1, String ruta) {
        
        if(par_1){
            try {
                //procesbuilder
                
                ProcessBuilder pb = new ProcessBuilder(ruta);
                pb.start();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                //runtime
                String[] cmds = {ruta};
                Runtime rt = Runtime.getRuntime();
                
                rt.exec(cmds);
                
                
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }

    private static void ejecutarProceso(boolean par_1, String ruta, String arg) {
        String[] cmds = {ruta,arg};
        if(par_1){
            try {
                //procesbuilder
                
                ProcessBuilder pb = new ProcessBuilder(cmds);
                pb.start();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                //runtime
                
                Runtime rt = Runtime.getRuntime();
                
                rt.exec(cmds);
                
                
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
        private static boolean ficheroExiste(String rutaf) {
        File f = new File(rutaf);
        
        return f.exists() && f.isFile();
    }
}
