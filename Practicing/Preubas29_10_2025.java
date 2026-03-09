/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.preubas29_10_2025;

import java.util.Scanner;

/**
 *
 * @author rvirijac
 */
public class Preubas29_10_2025 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Introdueix un número sencer positiu: ");
        int num = in.nextInt();

        int suma = 0;
        int uDigit;

        while (num > 0) {
            uDigit = num % 10;     // agafa l’última xifra
            suma = suma + uDigit;  // l’afegeix a la suma total
            num = num / 10;        // elimina l’última xifra
        }

        System.out.println("La suma de les xifres és: " + suma);
    }
}
