/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iesmm.psp.u1.t4;

import java.util.Random;

public class GeneradorAleatorios {
    public static void main(String[] args) {
        try {
            Random random = new Random();
            int num = random.nextInt(0, 10);
            System.out.println(num);
            System.exit(num);
        }catch (Exception e){
            System.exit(-1);
        }
    }
}
