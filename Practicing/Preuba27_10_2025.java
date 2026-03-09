/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.preuba27_10_2025;

import java.util.Scanner;

/**
 *
 * @author rvirijac
 */
public class Preuba27_10_2025 {

    public static void main(String[] args) {
        Scanner lector= new Scanner(System.in);
        System.out.println("Jugarem a girar els nombres, acceptes? (s/n)");
        char resp=lector.next().charAt(0);
                
         while (resp == 's') {
            System.out.println("Introdueix un número:");
            int num = lector.nextInt();

            int girat = 0; //  cal reiniciar cada vegada
            int uDigit;

            while (num > 0) {
                uDigit = num % 10;
                girat = girat * 10 + uDigit;
                num = num / 10;
            }

            System.out.println("Número girat: " + girat);

            System.out.println("Continuem? (s/n)");
            resp = lector.next().charAt(0); //  llegim de nou aquí
        }

        System.out.println("Fi del joc!");
    }
}
