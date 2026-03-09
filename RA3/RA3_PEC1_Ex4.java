/*
Crea un joc on l'usuari trii pedra, paper o tisores, i l'ordinador trii aleatòriament. Determina el
guanyador
*/

import java.util.Scanner;

public class RA3_PEC1_Ex4 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("/// Joc de Pedra, Paper o Tisores ///");

        System.out.println("Escull el teu atac:");
        System.out.println("1 : Pedra");
        System.out.println("2 : Paper");
        System.out.println("3 : Tisores");
        System.out.println("4 : Aleatori");

        int PlayerPlay = scanner.nextInt(); // Player's Play
        if (PlayerPlay == 4) {
            PlayerPlay = (int) (Math.random() * 3) + 1; // randomizar jugada
        }

        int ComputerPlay = (int) (Math.random() * 3) + 1; // Computer's Random Play

        int Winner = 0;

        if (PlayerPlay == ComputerPlay) {
            Winner = 3; // empate
            System.out.println("Ambdos escullen la mateixa jugada"); // empate
        } else {
            switch (PlayerPlay) { // Jugador prints
                case 1:
                    System.out.println("El jugador escull Pedra");
                    break;
                case 2:
                    System.out.println("El jugador escull Paper");
                    break;
                case 3:
                    System.out.println("El jugador escull Tisores");
                    break;

                default:
                    break;
            }
            switch (ComputerPlay) { // Computer prints
                case 1:
                    System.out.println("L'ordenador escull Pedra");
                    break;
                case 2:
                    System.out.println("L'ordenador escull Paper");
                    break;
                case 3:
                    System.out.println("L'ordenador escull Tisores");
                    break;

                default:
                    break;
            }

        }

        /*
         * 1 beats 3
         * 2 beats 1
         * 3 beats 2
         */

        if (Winner == 0) { // ensure no winner is yet chosen
            if (PlayerPlay == 1 && ComputerPlay == 3) { // Rock beats scissor
                Winner = 1;
            } else if (PlayerPlay == 2 && ComputerPlay == 1) { // paper beats rock
                Winner = 1;
            } else if (PlayerPlay == 3 && ComputerPlay == 2) { // sciessor beats paper
                Winner = 1;
            }

            else if (ComputerPlay == 1 && PlayerPlay == 3) { // Rock beats scissor
                Winner = 2;
            } else if (ComputerPlay == 2 && PlayerPlay == 1) { // paper beats rock
                Winner = 2;
            } else if (ComputerPlay == 3 && PlayerPlay == 2) { // sciessor beats paper
                Winner = 2;
            }

            else {
                System.err.println("Error");
                Winner = 0; // anything else is error
            }
        }

        switch (Winner) {
            case 1:
                System.out.println( // Player Victory Case
                        "El jugador sorgeix guanyador.");
                break;

            case 2:
                System.out.println( // Computer Victory Case
                        "L'ordenador sorgeix guanyador.");
                break;

            case 3:
                System.out.println("Empat. Ningù guanya"); // Empate Case
                break;

            default:
                System.out.println("ERROR: No hi ha guanyador"); // Error Case
                break;
        }

    }
}