package com.productorconsumidor;

public class BufferLetra {
	private char letra;
	private boolean estaNumero = false;

	public synchronized void dejarLetra(char n) {
		
                // ESPERA ACTIVA mientras se esté consumiendo
		while (estaNumero) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
                
		// 1. El número se coloca
		letra = n;

		// 2. El número ya está disponible para recogerlo
		estaNumero = true;

		// 3. Notifica al resto de hilos que están suspendidos (CONSUMIDORES)
		notifyAll();
	}

	public synchronized char cogerLetra() {
		char l = 0;

		// ESPERA ACTIVA mientras se esté produciendo
		
                while (!estaNumero) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
                

		// CONDICIÓN: Si hay algún número ya puesto, lo recojo
		// 1. El número se recoge
		l = letra;

		// 2. Vuelve a su estado inicial
		estaNumero = false;

		// 3. Notifica al resto de hilos que están suspendidos (PRODUCTORES)
		notifyAll();

		return l;
	}
}