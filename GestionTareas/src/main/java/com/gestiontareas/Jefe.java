/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestiontareas;

/**
 *
 * @author losad
 */
public class Jefe extends Thread{
    
    Trabajo trabajo;
    
    public Jefe(Trabajo trabajo, String nombre){
        this.trabajo = trabajo;
        this.setName(nombre);
    }
    public void run(){
        int i = 1; 
       
        while(!trabajo.quiebra && !trabajo.objetivoCumplido){
           trabajo.asignarTarea("Tarea_" + i +" de " + Thread.currentThread().getName() );
           i++;
        }
        
        System.out.println(Thread.currentThread().getName() + " Terminado. Tareas realizadas: " + trabajo.trabajoRealizado + "; Tareas pendientes " + trabajo.tareas.size() + "; Máximo pico de trabajo acymulado: " + trabajo.picoMaximoTrabajoAcumulado);
    }
    
    
}
