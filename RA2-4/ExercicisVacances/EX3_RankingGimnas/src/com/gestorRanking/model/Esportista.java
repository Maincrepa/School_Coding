package com.GestorRanking.model;

import java.util.ArrayList;


public class Esportista {
    // Atributs privats
    private String nomIdentificador;
    private String nomMostra;
    private String disciplina;
    private int edat;
    private String dataIntroduccio; // Data de registre o data de la marca
    private final ArrayList<Double> resultatsArray; // Array de Resultats de les proves

    /*
    ==========================================
        CONSTRUCTOR
    ==========================================
    */

    public Esportista(String nomIdentificador, String nomMostra, String disciplina, int edat, String dataIntroduccio) {
        if (!verificarEsportista(nomIdentificador, nomMostra, disciplina, edat, dataIntroduccio)) {
            System.out.println("Error al crear l'esportista: dades no vàlides");
            throw new IllegalArgumentException("Dades no vàlides per a l'esportista"); // utilitzant noves técniques de debugging ;)
        }
        resultatsArray = new ArrayList<>(); // Inicialitzem l'ArrayList de resultats

        this.nomIdentificador = nomIdentificador;
        this.nomMostra = nomMostra;
        this.disciplina = disciplina;
        this.edat = edat;
        this.dataIntroduccio = dataIntroduccio;
    }

    /*
    ==========================================
        GETTERS
    ==========================================
    */

    public String getNomIdentificador() {
        return nomIdentificador;
    }

    public String getNomMostra() {
        return nomMostra;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public int getEdat() {
        return edat;
    }

    public String getDataIntroduccio() {
        return dataIntroduccio;
    }

    public ArrayList<Double> getResultats() {
        return resultatsArray;
    }
    

    /*
    ==========================================
        SETTERS
    ==========================================
    */

    public void setNomIdentificador(String nomIdentificador) {
        if (verificarNomIdentificador(nomIdentificador)) {
            this.nomIdentificador = nomIdentificador;
        } else {
            System.out.println("Error al modificar el nom identificador: dades no vàlides");
        }
    }

    public void setNomMostra(String nomMostra) {
        if (verificarNomMostra(nomMostra)) {
            this.nomMostra = nomMostra;
        } else {
            System.out.println("Error al modificar el nom de mostra: dades no vàlides");
        }
    }

    public void setDisciplina(String disciplina) {
        if (verificarDisciplina(disciplina)) {
            this.disciplina = disciplina;
        } else {
            System.out.println("Error al modificar la disciplina: dades no vàlides");
        }
    }

    public void setEdat(int edat) {
        if (verificarEdat(edat)) {
            this.edat = edat;
        } else {
            System.out.println("Error al modificar l'edat: dades no vàlides");
        }
    }

    public void setDataIntroduccio(String dataIntroduccio) {
        if (verificarDataIntroduccio(dataIntroduccio)) {
            this.dataIntroduccio = dataIntroduccio;
        } else {
            System.out.println("Error al modificar la data d'introducció: dades no vàlides");
        }
    }


    /*
    ==========================================
        RESULTATS
    ==========================================
    */

    public void afegirResultat(double resultat) {
        this.resultatsArray.add(resultat); // Afegim el resultat a l'ArrayList de resultats
    }

    public void modificarResultat(int index, double nouResultat) {
        if (index >= 0 && index < resultatsArray.size()) {
            this.resultatsArray.set(index, nouResultat); // Modifiquem el resultat a l'índex especificat
        } else {
            System.out.println("Error al modificar el resultat: índex fora de rang");
        }
    }

    public void eliminarResultat(int index) {
        if (index >= 0 && index < resultatsArray.size()) {
            this.resultatsArray.remove(index); // Eliminem el resultat a l'índex especificat
        } else {
            System.out.println("Error al eliminar el resultat: índex fora de rang");
        }
    }

    public void mostrarResultats() {
        System.out.println("Resultats de " + nomMostra + ":");
        for (int i = 0; i < resultatsArray.size(); i++) {
            System.out.println("Resultat " + (i + 1) + ": " + resultatsArray.get(i));
        }
    }

    /*
    ==========================================
        RANKING
    ==========================================
    */

    public double obtindrePuntuacio() {
        // calcular puntuació total a partir dels resultats de les proves
        double puntsTotal = 0;
        for (double resultat : resultatsArray) {
            puntsTotal += resultat;
        }
        return puntsTotal; // Retorna la puntuació total calculada
    }

    /*
    ==========================================
        VERIFICACIÓ
    ==========================================
    */

    private boolean verificarEsportista(String nomIdentificador, String nomMostra, String disciplina, int edat, String dataIntroduccio) {
        boolean totCorrecte = (
            verificarNomIdentificador(nomIdentificador) &&
            verificarNomMostra(nomMostra) &&
            verificarDisciplina(disciplina) &&
            verificarEdat(edat) &&
            verificarDataIntroduccio(dataIntroduccio)
        );

        return totCorrecte; // Retorna true si totes les dades són vàlides, false en cas contrari
    }        

    /*
- El nom no pot estar buit ni ser només espais,
- La disciplina no pot estar buida,
- La marca ha de ser un nombre positiu,
- L'edat ha de ser un nombre positiu i raonable.
    */

    private boolean verificarNomIdentificador(String nomIdentificador) {
        return nomIdentificador != null && !nomIdentificador.trim().isEmpty();
    }

    private boolean verificarNomMostra(String nomMostra) {
        return nomMostra != null && !nomMostra.trim().isEmpty();
    }

    private boolean verificarDisciplina(String disciplina) {
        return disciplina != null && !disciplina.trim().isEmpty();
    }

    private boolean verificarEdat(int edat) {
        return edat > 0 && edat <= 120;
    }

    private boolean verificarDataIntroduccio(String dataIntroduccio) {
        return dataIntroduccio != null && dataIntroduccio.matches("\\d{4}-\\d{2}-\\d{2}");
    }


    /*
    ==========================================
        ALTRES
    ==========================================
    */
}
