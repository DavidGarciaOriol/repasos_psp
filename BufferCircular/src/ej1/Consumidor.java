package ej1;

/**
 * Método que produce consumiciones en el buffer circular
 */
public class Consumidor extends Thread
{
    private BufferCircular bc;
    private Integer numero;
    private int numConsumiciones;
    
    /**
     * Constructor de la clase Consumidor
     * @param bufferCircular Buffer circular donde se almacenan los datos
     */
    public Consumidor(BufferCircular bufferCircular, int numConsumiciones)
    {
        this.bc=bufferCircular;
        this.numero=null;
        this.numConsumiciones=numConsumiciones;
    }
    
    /**
     * Sobrecarga del método run
     */
    @Override
    public void run() 
    {   
        for(int i=0; i<this.numConsumiciones; i++)
        {
            try
            {   
                System.out.print(Thread.currentThread().getName() + " EN SU VUELTA: " + i + " --> " );
                
                numero=bc.remove();
                //numero=bc.removeAlways();
                if(numero!=null)
                    System.out.println("Consumido el número " + numero 
                            + " correctamente. Existen " + bc.cantidadElementos() 
                            + " elementos de una capacidad de " + bc.size());
                else
                    System.out.println("ERR: NO se ha podido consumir correctamente. Existen " 
                            + bc.cantidadElementos() + " elementos de una capacidad de " + bc.size());           
            } 
            catch (Exception ex) 
            {
                System.err.println(ex);
            }
        
        }
    }    
}
