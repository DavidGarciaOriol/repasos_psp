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
public class MiHiloRunnableComplejo implements Runnable {
    
    
    boolean activado;
    Thread miHilo;
    
    public MiHiloRunnableComplejo(String nombreHilo){
        activado = true;
        miHilo = new Thread(this,nombreHilo);
    }
    
    
    @Override
    public void run() {
        
        int i = 0;
        while(activado){
            System.out.println("Soy el hilo miHilo.getName():" + miHilo.getName() + " y estoy en la vuelta" + i);
            System.out.println("Soy el hilo Thread.currentThread().getName():" + Thread.currentThread().getName() + " y estoy en la vuelta" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(MiHiloRunnableComplejo.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }    
    }  
    
    public void join(){
        try {
            miHilo.join();
        } catch (InterruptedException ex) {
            System.out.println("Error");
        }
    }
    
    public void iniciarHilo(){
        //System.out.println("Hilo " + miHilo.getName() + " ha sido iniciado por " + Thread.currentThread().getName());
        miHilo.start();
    }
    
    public void desactivarHilo(){
        activado = false;
        System.out.println("El Hilo (" + miHilo.getName() + ") ha sido desactivado por (" + Thread.currentThread().getName()+")");
    }
    
    public void activarHilo(){
        activado = true;
    }
    /*for (int i = 0; i < 100; i++) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MiHiloRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Soy el hilo " + Thread.currentThread().getName() + " y estoy en la vuelta" + i);
    }*/
  }


