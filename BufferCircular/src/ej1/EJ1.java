package ej1;

import java.util.Random;

/**
 * Crea un programa con dos hilos productores y un hilo consumidor. 
 * Los hilos productores almacenan números en un array. 
 * El hilo consumidor saca elementos del array de uno en uno. 
 * Uno de los productores genera sólo números pares y el otro números impares. 
 * El array tendrá capacidad para almacenar 10 números enteros y su estructura será la de un buffer circular. 
 * El sistema está obligado a impedir la superposición de operaciones sobre el array.  
 * Además  no se podrá consumir si el almacenamiento está vacío o producir si está lleno.
 */
public class EJ1 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException 
    {
        //BufferCircular compartido por los hilos.
        BufferCircular bc=new BufferCircular(10);
        
        Thread prodPares = new Productor(bc,Productor.T_PAR,15);
        prodPares.setName("PRODUCTOR_DE_PARES");
        
        Thread prodImpares = new Productor(bc,Productor.T_IMPAR,30);
        prodImpares.setName("PRODUCTOR_DE_IMPARES");
        
        prodPares.start();
        prodImpares.start();
        
        Thread c = new Consumidor(bc,10);
        c.setName("CONSUMIDOR");
        c.start();
        
        
        
     /*   for(int i=0; i<6; i++)
        {
            //Producimos un número aleatorio
            Random r = new Random();
            Thread p = new Productor(bc, r.nextInt(999));
            p.start();
        }   

        for(int i=0; i<110; i++)
        {
            Thread c = new Consumidor(bc);
            c.start();
        } 

       */
    }  
}
