package com.retirardinerocuenta;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author losad
 */
public class CuentaBancaria {
    
    private int saldoActual=50;
    
    public int getSaldoActual(){
        return this.saldoActual;
    }
    
    
    
    public void retirarDineroCuenta(int cantidad){
        saldoActual -= cantidad;
    }
    
}
