package ej1;

import java.util.Random;

/**
 * Método que produce inserciones en el buffer circular
 */
public class Productor extends Thread
{
    private BufferCircular bc;
    private Integer numerosAGenerar;
    private int tipoProductor; 
    public static final int T_PAR=0;
    public static final int T_IMPAR=1;
    
    /**
     * Constructor clase Productor
     * @param bufferCircular buffer circular donde se almacenan los datos
     * @param num 
     */
    public Productor(BufferCircular bufferCircular, int tipo, int num)
    {
        this.bc=bufferCircular;
        this.tipoProductor = tipo;
        this.numerosAGenerar=num;
    }
    
     /**
     * Sobrecarga del método run
     */
    @Override
    public void run() 
    {
        for(int i=1; i<this.numerosAGenerar; i++){
            
            Random r = new Random();
            int numero = r.nextInt(499);
            
            if (this.tipoProductor == T_PAR ){
                numero = (2*numero);
            }else{
                numero = (2*numero)+ 1;
            }
            try 
            {   
                
                System.out.print(Thread.currentThread().getName() + " EN SU VUELTA: " + i + " --> " );
                if(bc.add(numero))
                    System.out.println("Introducido " + numero + " correctamente. Existen " 
                            + bc.cantidadElementos() + " elementos de una capacidad de " + bc.size());
                else   
                    System.out.println("ERR: NO se ha podido introducir " + numero 
                            + " correctamente. Existen " + bc.cantidadElementos() 
                            + " elementos de una capacidad de " + bc.size());
            } 
            catch (Exception ex) 
            {
                System.err.println(ex);
            }
        }

    }    
}
