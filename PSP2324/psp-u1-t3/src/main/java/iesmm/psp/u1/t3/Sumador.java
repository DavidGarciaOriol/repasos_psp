/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iesmm.psp.u1.t3;

/**
 *
 * @author manue
 */
public class Sumador {
     public static void main(String[] args) {
        if(args.length == 2){
            int suma = Integer.valueOf(args[0])+Integer.valueOf(args[1]);
            System.out.println("La suma da como resultado "+suma);
            System.exit(50);
        }else {
            System.exit(-1);
        }
    }
}
