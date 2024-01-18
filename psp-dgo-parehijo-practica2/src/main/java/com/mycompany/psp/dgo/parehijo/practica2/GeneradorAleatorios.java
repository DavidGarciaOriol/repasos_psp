/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp.dgo.parehijo.practica2;

import java.util.Random;

/**
 *
 * @author usuario
 */
public class GeneradorAleatorios {
    
    public static void main(String[] args) throws InterruptedException{
        int numeroAleatorio = aleatorio(0,10);
        System.out.println(numeroAleatorio);
        System.exit(numeroAleatorio);
    }
    
    public static int aleatorio (int min, int max)
    {
        Random r = new Random();
        return min + r.nextInt(max-min+1);  // Entre min y max -> [min, max];
    }
}
