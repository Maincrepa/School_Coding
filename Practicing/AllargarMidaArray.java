/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.allargarmidaarray;

import java.util.Scanner;

/**
 *
 * @author rvirijac
 */
public class AllargarMidaArray {

    public static final int MAX_VALORS = 5;
  public static void main (String[] args) {
    //D'entrada, la mida serà 5.
    //S'escull un valor molt baix perquè de seguida es forci el canvi de mida.
    float[] arrayNotes = new float[MAX_VALORS];
    //Cal un comptador de posicions en què hi ha valors vàlids.
    int elements = 0;
    Scanner lector = new Scanner(System.in);
    System.out.print("Vés escrivint notes (valors reals entre 0 i 10).");
    System.out.println("En pots escriure diversos en una sola línia, separats per espais.");
    //Caldrà alguna manera de saber que s'ha acabat d'escriure.
    System.out.println("(Per acabar, escriu un -1)");
    //Anar llegint fins a trobar la marca de fi. Però el màxim és la mida de l'array.
    //Si s'entren més valors, canviem la mida de l'array i continuem llegint.
    //Estructura de repetició amb semàfor.
    boolean marcaFi = false;
    while (!marcaFi) {
      //Hi ha un real?
      if (lector.hasNextFloat()) {
        //Cal veure si és un valor vàlid o final de seqüència.
        float nota = lector.nextFloat();
        if ((nota >= 0)&&(nota <= 10)) {
          //Tot correcte. Però hi ha lloc a l'array?
          if (elements == arrayNotes.length) {
            //Cal canviar la mida de l'array. Es fa 5 posicions més llarg.
            //Per veure quan succeeix, avisem per pantalla.
            System.out.println("Capacitat superada. Afegim " + MAX_VALORS + " posicions...");
            float[] arrayNou = new float[arrayNotes.length + MAX_VALORS];
            for (int i = 0; i < arrayNotes.length; i++) {
              arrayNou[i] = arrayNotes[i];
            }
            arrayNotes = arrayNou;
          }
          //Afegim el nou valor. Segur que hi ha lloc.
          arrayNotes[elements] = nota;
          elements++;
        } else if (nota == -1) {
          //Marca de final, sortim del bucle.
          break;
        }
        //Si no és ni una cosa ni l'altra, ho ignorem.
      } else {
        //Si no era un real, l'ignorem.
        lector.next();
      }
    }
    //Ignorem els valors sobrants de la darrera línia.
    lector.nextLine();
    System.out.println("A l'array hi ha emmagatzemats " + elements + " elements: ");
    for (int i = 0; i < elements;i++) {
      System.out.println(arrayNotes[i]);
    }
  }
}
