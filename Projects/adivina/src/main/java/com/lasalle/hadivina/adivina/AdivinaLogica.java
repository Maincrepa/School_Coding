
package com.lasalle.hadivina.adivina;

public class AdivinaLogica {

    private int numeroSecreto;
    private int intentos;
    private static final int MAX_INTENTOS = 5;

    public AdivinaLogica() {
        iniciarNuevoJuego();
    }

    public int generarNumeroSecreto() { // generar número entre 1 y 50
        int numsecret = (int)(Math.random() * 50) + 1;
        return numsecret;
    }

    public String verificarIntento(int intento) {
        if (!(intento >= 1 && intento <= 50)) {
            return "Inválido"; // - si fuera de rango: "Inválido"
        } else { // valid;
            if (intento == numeroSecreto) {
                return "¡Correcto!"; // - si acierta: "¡Correcto!"
            } else if(intento < numeroSecreto) {
                return "Más alto"; // - si intento < numeroSecreto: "Más alto"
            } else if(intento > numeroSecreto) {
                return "Más bajo"; // - si intento > numeroSecreto: "Más bajo"
            }
        return "";
        }
    }

    public boolean puedeJugar() {
        int numIntentos = intentosRestantes();
        if (numIntentos > 0) { // té més d'un intent, pot continuar
            return true;
        } else {
            return false;
        }
    }

    public int intentosRestantes() { // calcular intentos
        int numIntentos = (MAX_INTENTOS - intentos);
        return numIntentos;
    }

/*----------------------------------------------------------------------*/
    // Auxiliares (NO TOCAR)
    public void iniciarNuevoJuego() {
        numeroSecreto = generarNumeroSecreto();
        intentos = 0;
    }

    public void incrementarIntentos() {
        intentos++;
    }

    public void decrementarIntentos() {
        intentos--;
    }

    public int getNumeroSecreto() {
        return numeroSecreto;
    }

    public int getIntentos() {
        return intentos;
    }
}
