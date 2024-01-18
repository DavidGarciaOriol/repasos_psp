/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplojoins;

/**
 *
 * @author losad
 */
public class Carrera {
        
        private final static int N = 4; // Número de corredores (de hilos)
                
    	public static void main(String[] args) {

		Corredor participantes[] = new Corredor[N];

		// Creación de hilos
		for (int i = 0; i < N; i++){
			participantes[i] = new Corredor(i + 1);
                }         
		
                System.out.println("Todos los " + N + " hilos creados\n");

		// Ejecución de hilos
		for (Corredor p : participantes) {
			p.start();
			// p.join lo que provoca es que se paren todos los demás hilos en ejecución hasta que finalice "p"
                        // Una vez finalice su ejecución se retomarán todos los hilos.
                        // Esto es lo que hace que: "hasta que no termine un corredo, no salga el siguiente "corredor"
                        // O lo que es lo mismo:   "Hasta que no finalice un hilo, no se ejecute el siguiente hilo"
                        try {
				p.join();
                                // Equivalente:
				// while (p.isAlive()) {}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
                        System.out.println("Terminé. Paso el testigo al siguiente corredor");
		}

		System.out.println("\nTodos los corredores terminaron");
	}
    
}
