package com.GestorRanking.view;

import java.util.Scanner;

import com.GestorRanking.controller.GestorRanking;

public class Menu {
    static Scanner input = new Scanner(System.in);
    static boolean active;

    /*
    ==========================================
        MÉTODE PRINCIPAL
    ==========================================
    */

    public void mostrarMenuPrincipal(GestorRanking gestorRanking) {
        while (active) {
            
            int menu_option = printMenuPrincipal();

            switch (menu_option) {
                case 1: // Registrar esportista
                    registrarEsportista(gestorRanking);
                break;
                case 2: // Consultar rànquing
                    consultarRanking(gestorRanking);
                break;
                case 3: // Eliminar esportista
                    eliminarEsportista(gestorRanking);
                break;
                case 4: // Veure estadístiques
                    veureEstadistiques(gestorRanking);
                break;
                case 5: // Buscar esportistes per nom o per disciplina
                    buscarEsportistes(gestorRanking);
                break;
                case 6: // Modificar la marca d'un esportista existent
                    modificarMarcaEsportista(gestorRanking);
                break;
                case 7: // Mostrar el rànquing per disciplina específica
                    mostrarRankingDisciplina(gestorRanking);
                break;
                case 0: // Sortir de l'aplicació
                    active = false;
                break;
                default:
                    active = false;
                break;
            }
        }
    }

    private int printMenuPrincipal() {
        int menu_option = -1;

        System.out.println("""

        ==========================================
            MENÚ PRINCIPAL

            1. Registrar esportista
            2. Consultar rànquing
            3. Eliminar esportista
            4. Veure estadístiques
            5. Buscar esportistes per nom o per disciplina,
            6. Modificar la marca d'un esportista existent,
            7. Mostrar el rànquing per disciplina específica.

            0. Sortir de l'aplicació

        ==========================================
        """);

        while (!(menu_option >= 0 && menu_option <= 7)) { // Opcions: 0-7
            System.out.print("Introdueix l'opció: ");
            menu_option = input.nextInt();
        }

        return menu_option;
    }

    private void registrarEsportista(GestorRanking gestorRanking) {

    }

    private void consultarRanking(GestorRanking gestorRanking) {
    }

    private void eliminarEsportista(GestorRanking gestorRanking) {
    }

    private void veureEstadistiques(GestorRanking gestorRanking) {
        /*
- Millor marca general
- Pitjor marca
- Marca mitjana del rànquing
- Nombre d'esportistes per disciplina
- Nombre d'esportistes actius
- Edat mitjana
        */
    }

    private void buscarEsportistes(GestorRanking gestorRanking) {
    }

    private void modificarMarcaEsportista(GestorRanking gestorRanking) {
    }

    private void mostrarRankingDisciplina(GestorRanking gestorRanking) {
    }
}
