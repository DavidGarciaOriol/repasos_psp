package com.productorconsumidor;

public class Abecedario {
	public static void main(String args[]) {
		int N = 5;

		BufferLetra buffer = new BufferLetra();
		H1 p = new H1(buffer, N);
		H2 c = new H2(buffer, N, "Consumer1");
                //H2 c2 = new H2(buffer, N,"Consumer2");

		p.start();
		c.start();
                //c2.start();

		// Espera de finalización de todo lo consumido
		try {
			c.join();
		} catch (InterruptedException e) {
		}
		System.out.println("Generación de " + N + " letras acabada");
                
        }
}
