/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.gestiontareas;

/**
 *
 * @author losad
 */
public class GestionTareas {
    
    
    
    public static void main(String[] args) {
        
        int numJefes = 1;
        int numTrabajadores = 20;
        Trabajo trabajo = new Trabajo(5000,500);
        
        for (int i = 1; i<=numJefes; i++){
            new Jefe(trabajo, "JEFE_" + i).start();
        }
        
        for (int i = 1; i<=numTrabajadores; i++){
            new Trabajador(trabajo, "TRABAJADOR_" + i).start();
        }
        
     /*   Jefe j1 = new Jefe(trabajo);
        Jefe j2 = new Jefe(trabajo);
        Jefe j3 = new Jefe(trabajo);
        Jefe j4 = new Jefe(trabajo);
        Jefe j5 = new Jefe(trabajo);
        Jefe j6 = new Jefe(trabajo);
        
        Trabajador t1 = new Trabajador(trabajo);
        Trabajador t2 = new Trabajador(trabajo);
        Trabajador t3 = new Trabajador(trabajo);
        Trabajador t4 = new Trabajador(trabajo);
        Trabajador t5 = new Trabajador(trabajo);
        Trabajador t6 = new Trabajador(trabajo);
        
        
        j1.setName("JEFE_1");
        j2.setName("JEFE_2");
        j3.setName("JEFE_3");
        j4.setName("JEFE_4");
        j5.setName("JEFE_5");
        j6.setName("JEFE_6");
        
        t1.setName("TRABAJADOR_1");
        t2.setName("TRABAJADOR_2");
        t3.setName("TRABAJADOR_3");
        t4.setName("TRABAJADOR_4");
        t5.setName("TRABAJADOR_5");
        t6.setName("TRABAJADOR_6");
        
        //j1.start();
        //j2.start();
        //j3.start();
        //j4.start();
        //j5.start();
        //j6.start();
        
        //t1.start();
        //t2.start();
        //t3.start();
        //t4.start();
        //t5.start();
        //t6.start();
        
       */ 
    }
}
