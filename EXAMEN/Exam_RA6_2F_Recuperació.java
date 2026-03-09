public class Exam_RA6_2F_Recuperació {
    
    public static void main(String[] args) {
        int participantA = 0;
        int participantB = 0;

        int[] historialDistanciaA = new int[5];
        int[] historialDistanciaB = new int[5];

        boolean finalzat = false;
        int ronda = 0;

        while (ronda <= 4 && !finalzat) {
            System.out.println("===========================");
            System.out.println("");
            System.out.println(" · Partida número: " + (ronda + 1) + " ·");
            System.out.println();


            int sumaP_A = (int)((Math.random()*6) + 5);
            if (!(sumaP_A % 2 == 0)) { // Si impar
                System.out.println("El participant A ha activat el turbo!");
                sumaP_A += 5; // Turbo
            }

            int sumaP_B = (int)((Math.random()*6) + 5);
            if (!(sumaP_B % 2 == 0)) { // Si impar
                System.out.println("El participant B ha activat el turbo!");
                sumaP_B += 5; // Turbo
            }

            
            historialDistanciaA[ronda] = participantA;
            historialDistanciaB[ronda] = participantB;

            boolean winA = false;
            boolean winB = false;

            if ((participantA + sumaP_A) > 49) {
                System.out.println("El participant A ha finalitzat la carrera!");
                finalzat = true;
                winA = true;
            } else {
                participantA = participantA + sumaP_A;
                System.out.println("El participant A ha avançat " + sumaP_A + " posicions.");
                System.out.println("Ara el participant A está en la posició " + participantA);
            }

            System.out.println();

            if ((participantB + sumaP_B) > 49) {
                System.out.println("El participant B ha finalitzat la carrera!");
                finalzat = true;
                winB = true;
            } else {
                participantB = participantB + sumaP_B;
                System.out.println("El participant B ha avançat " + sumaP_B + " posicions.");
                System.out.println("Ara el participant A está en la posició " + participantB);
            }
                        
            if (finalzat) {
                System.out.println();
                System.out.println(" $$ FINAL! $$");
                System.out.println();
                if (winA && winB) {
                    System.out.println("Els dos participants han empatat!");
                } else if (winA && (!winB)) {
                    System.out.println("El participant A ha guanyat!");
                } else if ((!winA) && winB) {
                    System.out.println("El participant B ha guanyat!");
                }
            }

            ronda++;
            System.out.println("");
        }
    }

}