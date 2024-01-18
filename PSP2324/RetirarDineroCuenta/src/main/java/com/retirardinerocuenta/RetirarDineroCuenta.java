/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.retirardinerocuenta;

/**
 *
 * @author losad
 */
public class RetirarDineroCuenta {

    public static void main(String[] args) {
        CajeroAutomatico cajero = new CajeroAutomatico();
        Thread pepito = new Thread(cajero, "pepito");
        Thread juanito = new Thread(cajero, "Juanito");
        
        pepito.start();
        juanito.start();
    }
}
