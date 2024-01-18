/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp.dgo.padrehijo.practica1;
/**
 *
 * @author usuario
 */
public class Sumador {	
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 2) {
            System.out.println("Debe proporcionar dos números como argumentos.");
            System.exit(1);
        }
        
        try {
            int numero1 = Integer.parseInt(args[0]);
            int numero2 = Integer.parseInt(args[1]);
            System.out.println("Suma: " + (numero1 + numero2));
            System.exit(0);
        } catch (NumberFormatException e){
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}