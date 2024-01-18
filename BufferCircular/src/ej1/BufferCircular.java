package ej1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Buffer circular
 */
public class BufferCircular 
{
    private Integer[] buffer=null;
     int addIndex;           //Por donde se sacan los datos
     int removeIndex;        //Por donde se insertan los datos
    private int cantidad;
    
    /**
     * Constructor
     */
    public BufferCircular()
    {
         buffer=new Integer[10];
         addIndex=removeIndex=0;
         cantidad=0;
         for(int i=0;i<buffer.length;i++)
             buffer[i]=null;
    }  
    
    /**
     * Constructor
     * @param size  Tamaño máximo del buffer circular
     */
    public BufferCircular(int size)
    {
         buffer=new Integer[size];
         addIndex=removeIndex=0;
         cantidad=0;
         for(int i=0;i<buffer.length;i++)
             buffer[i]=null;
    }     
    
    /**
     * Método para insertar valores en un buffer circular
     * @param numero Número a insertar
     * @return true si se insertó; false si está lleno el buffer
     */
    public synchronized boolean add(int numero)
    {
        //Estará lleno si addIndex está justo delante de removeIndex
        //O por ser circular, addIndex está el último y removeIndex el primero
        if (cantidad==buffer.length)
        {   
            return false;   //No podemos insertar por estar lleno
        }
        else
        {
            buffer[addIndex]=numero;
            System.out.println(Thread.currentThread().getName() + " --> Elemento " + numero + " insertado en la posición " + addIndex);
            addIndex++;
            cantidad++;
            notifyAll();
            if(addIndex>=buffer.length) 
                addIndex=0;       
            
            return true;
        }
    }
    
    /**
     * Método para eliminar y leer valores en un buffer circular
     * @return true si se eliminó; false si está vacío el buffer
     */
    public synchronized Integer remove()
    {                
        
        if(cantidad==0)
        {
            return null;    //Buffer vacío
        }
        else
        {
            int valor=buffer[removeIndex];
            buffer[removeIndex]=null;
            System.out.println(Thread.currentThread().getName() + " --> Elemento " + valor + " eliminado de la posición " + removeIndex);
            removeIndex++;
            cantidad--;
            if(removeIndex>=buffer.length)  //Circular
                removeIndex=0;                       
        
            return valor;
        }         
    }  
    
        public synchronized Integer removeAlways()
    {                
        //Si coinciden en posición, es que está vacío el buffer
        while(cantidad==0)
        {   
            try {
                wait();    //Buffer vacío
            } catch (InterruptedException ex) {
                Logger.getLogger(BufferCircular.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        int valor=buffer[removeIndex];
        System.out.println(Thread.currentThread().getName() + " --> Elemento " + valor + " eliminado de la posición " + removeIndex);
        buffer[removeIndex]=null;
        removeIndex++;
        cantidad--;
        if(removeIndex>=buffer.length)  //Circular
            removeIndex=0;                       

        return valor;
                
    }  
    
    /**
     * Indica cuantos elementos hay insertados
     * @return Devuelve el tamaño del buffer
     */
    public int cantidadElementos()
    {
        return cantidad;
    }
    
    /**
     * Indica el tamaño máximo del buffer
     * @return Devuelve el tamaño del buffer
     */
    public int size()
    {
        return buffer.length;
    }    
}
