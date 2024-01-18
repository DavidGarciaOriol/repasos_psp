/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebahilos;

/**
 *
 * @author usuario
 */
public class MiHiloThread extends Thread{
     @Override
     public void run() {
         int i = 0;
         while(i < 5){
             System.out.println("Soy el hilo " + Thread.currentThread().getName() + " y estoy en la vuelta " + i);
             i++;
         }
     /*for (int i = 0; i < 500; i++) {
            System.out.println("Soy un hilo y esto es lo que hago");
     }*/
  }

}
