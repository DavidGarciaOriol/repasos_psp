/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestiontareas;

/**
 *
 * @author losad
 */
public class Trabajador extends Thread {
    
    Trabajo trabajo;
    
    public Trabajador(Trabajo trabajo, String nombre){
        this.trabajo = trabajo;
        this.setName(nombre);
    }
    public void run(){
        int i = 0;
        int tareasAcumuladas = trabajo.tareas.size();
        while(!trabajo.quiebra && !trabajo.objetivoCumplido){
           trabajo.realizarTarea();
           i++;
        }
        System.out.println(Thread.currentThread().getName() + " ha terminado su trabajo con un total de " + i + " tareas realizadas");
    }
    
}
