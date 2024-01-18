/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ejemplojoins;

import java.util.Random;

/**
 *
 * @author losad
 */
public class Corredor extends Thread {
	
       
	
	private final int M = 10; // Número máximo aleatorio

	public Corredor(int dorsal) {
		this.setName("Corredor_"+ dorsal);
	}

	private int aleatorio(int min, int max) {
		Random r = new Random();
		return min + r.nextInt(max - min + 1); // Entre min y max -> [min,max];
	}

	public void run() {
		
                int numaleatorio = aleatorio(0, M);
                System.out.println("Soy el corredor " + this.getName() + ", corriendo...");
		try {
			Thread.sleep(numaleatorio * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
                System.out.println("Soy el coredor " + this.getName() + " y he corrido en " + numaleatorio + " segundos");
	}


}

