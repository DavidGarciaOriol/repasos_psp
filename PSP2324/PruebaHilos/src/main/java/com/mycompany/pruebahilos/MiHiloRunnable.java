/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebahilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class MiHiloRunnable implements Runnable {
    
        public void run() {
        
            int i = 0;
            while(i <5){
                System.out.println("Soy el hilo Thread.currentThread().getName():" + Thread.currentThread().getName() + " y estoy en la vuelta" + i);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MiHiloRunnable.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
        }    
    }  
    
}
