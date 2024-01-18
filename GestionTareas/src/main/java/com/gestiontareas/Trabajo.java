/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestiontareas;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author losad
 */
public class Trabajo {
    
    List<String> tareas = new ArrayList<String>();
    public int trabajoRealizado = 0;
    public int picoMaximoTrabajoAcumulado = 0;        
    public boolean quiebra = false;
    public boolean objetivoCumplido = false;
    
    public static int trabajoSoportado;
    public static int objetivo;

    
    public Trabajo(int obetivo, int maximoSoportado){
        this.trabajoSoportado = maximoSoportado;
        this.objetivo = obetivo;
    }
    public synchronized void asignarTarea (String t) {
        if(tareas.size() < trabajoSoportado){
            tareas.add(t);
            System.out.println(Thread.currentThread().getName() + " ha añadido la tarea " + t + " Hay un total de " + tareas.size() + " pendientes" );
            notifyAll();
            if(tareas.size() > picoMaximoTrabajoAcumulado){
                picoMaximoTrabajoAcumulado = tareas.size();
            }
        }else{
            quiebra = true;
            //System.out.println(Thread.currentThread().getName() + " ha añadido la tarea " + t + " Se han s " + tareas.size() + " pendientes" );
            System.out.println("QUIEBRA: Se han superado las "  + trabajoSoportado + " tareas pendientes la empresa necesita contratar más trabajadores");
        }
    }
    
    public synchronized void realizarTarea () {
        
        if(tareas.size() > 0){
            String t = tareas.get(0);
            tareas.remove(0);
            trabajoRealizado = trabajoRealizado + 1;
            System.out.println(Thread.currentThread().getName() + " ha realizado la tarea " + t + " Quedan ahora " + tareas.size() + " pendientes" );
            if(this.trabajoRealizado >=objetivo){
               this.objetivoCumplido = true;
               System.out.println("OBJETIVO CUMPLIDO: La empresa ha realizado un total de " + this.trabajoRealizado + " tareas");
           }
        }else{
            //System.out.println(Thread.currentThread().getName() + " ha añadido la tarea " + t + " Se han s " + tareas.size() + " pendientes" );
            //System.out.println("SITUACIÓN IDEAL: No hay tareas pendientes de realizar espero a que haya trabajo");
            try {
                wait();   
            } catch (Exception ex) {
                Logger.getLogger(Trabajo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    
    }
    
    
}
