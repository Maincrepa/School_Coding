/*
L’empresa PixelCheck Solutions, especialitzada en processament d’imatges tècniques d’enginyeria, necessita validar un conjunt de dades matricials procedents de sensors. Cada imatge en baixa resolució es representa com una matriu de 5×5 on cada cel·la conté un valor entre 0 i 255.

Tasques a realitzar:
1. Genera una matriu de 5×5 amb valors aleatoris entre 0 i 255.
2. Mostra la matriu original en format ordenat.
3. Genera la matriu transposada (intercanviant files per columnes).
4. Mostra la matriu transposada.
5. Compara la matriu original i la transposada i indica:
    # si existeix almenys una fila de la matriu original que coincideixi exactament amb una columna de la transposada;
    # si són idèntiques (cosa que només passa si la matriu és simètrica).
 */

public class MAB_EX_1 { // finished
    public static void main(String[] args) {
        System.out.println("/ / Control de qualitat d'imatges tècniques / /");

        final int SIZE = 5; // només un valor perquè una matriu ha de ser simetrica

        int[][] matriu = new int[SIZE][SIZE]; // matriu original
        int[][] matriuTr = new int[SIZE][SIZE]; // matriu trasposada

        System.out.println();
        System.out.println("Matriu 5x5:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int rand = (int) (Math.random() * 255);
                System.out.printf("%-5d", rand);
                matriuTr[j][i] = rand; // assign to trasposada, inverted i & j
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Matriu 5x5 Trasposada:");

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%-5d", matriuTr[i][j]);
            }
            System.out.println();
        }

        // l'enunciat de "si existeix almenys una fila de la matriu original que coincideixi exactament amb una columna de la transposada;" és incorrecte, ja que sempre hi haurá una columna de la trasposada igual a una fila de la original

        System.out.println();
        System.out.println(" / / /");
        System.out.print("Identica? ");

        boolean coincideix = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (matriu[i][j] != matriuTr[i][j]) { // comparació del mateix num en les dues taules.
                    coincideix = false;
                }
            }
        }

        if (coincideix) {
            System.out.println("La matriu original i la matriu trasposada SÍ són identiques.");
        } else {
            System.out.println("La matriu original i la matriu trasposada NO són identiques.");
        }
    }
}
