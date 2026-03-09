package com.lasalle.hadivina.adivina;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML private Label lblIntentos;
    @FXML private Label lblPista;
    @FXML private TextField txtNumero;
    @FXML private Button btnAdivinar;
    @FXML private Button btnNuevoJuego;

    private final AdivinaLogica logica = new AdivinaLogica();

    @FXML
    private void initialize() {
        // Estado inicial
        actualizarIntentos();
        setPistaNeutral("Piensa un número entre 1 y 50");
    }

    @FXML
    private void onAdivinar() {
        if (txtNumero.isDisabled()) return;

        String text = txtNumero.getText().trim();
        if (text.isEmpty()) return;

        try {
            int intento = Integer.parseInt(text);

            logica.incrementarIntentos();
            String resultado = logica.verificarIntento(intento);

            if (resultado.equals("Inválido")) {
                // No cuenta como intento válido
                logica.decrementarIntentos();
                setPistaError("El número debe estar entre 1 y 50");
            } else if (resultado.equals("¡Correcto!")) {
                setPistaOK("¡GANASTE! Era el " + logica.getNumeroSecreto()
                        + "\nLo lograste en " + logica.getIntentos() + " intentos");
                finalizarJuego();
            } else {
                // "Más alto" o "Más bajo"
                if (logica.puedeJugar()) {
                    actualizarIntentos();

                    if (resultado.equals("Más alto")) {
                        setPistaAviso("Más alto. Intenta de nuevo");
                    } else {
                        setPistaInfo("Más bajo. Intenta de nuevo");
                    }
                } else {
                    setPistaErrorGrande("¡PERDISTE!\nEl número era: " + logica.getNumeroSecreto());
                    finalizarJuego();
                }
            }

        } catch (NumberFormatException e) {
            setPistaError("Por favor, ingresa un número válido");
        } finally {
            txtNumero.clear();
        }
    }

    @FXML
    private void onNuevoJuego() {
        logica.iniciarNuevoJuego();
        txtNumero.setDisable(false);
        btnAdivinar.setVisible(true);
        btnNuevoJuego.setVisible(false);
        lblIntentos.setText("Tienes 5 intentos");
        setPistaNeutral("Piensa un número entre 1 y 50");
        txtNumero.requestFocus();
    }

    private void finalizarJuego() {
        txtNumero.setDisable(true);
        btnAdivinar.setVisible(false);
        btnNuevoJuego.setVisible(true);
        actualizarIntentos();
    }

    private void actualizarIntentos() {
        lblIntentos.setText("Te quedan " + logica.intentosRestantes() + " intentos");
    }

    // Estilos rápidos (sin CSS externo)
    private void setPistaNeutral(String msg) {
        lblPista.setText(msg);
        lblPista.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-background-color: rgba(0,0,0,0.30);"
                + "-fx-padding: 15; -fx-background-radius: 10;");
    }

    private void setPistaOK(String msg) {
        lblPista.setText(msg);
        lblPista.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-background-color: #27AE60;"
                + "-fx-padding: 15; -fx-background-radius: 10; -fx-font-weight: bold;");
    }

    private void setPistaAviso(String msg) {
        lblPista.setText(msg);
        lblPista.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-background-color: #E67E22;"
                + "-fx-padding: 15; -fx-background-radius: 10; -fx-font-weight: bold;");
    }

    private void setPistaInfo(String msg) {
        lblPista.setText(msg);
        lblPista.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-background-color: #3498DB;"
                + "-fx-padding: 15; -fx-background-radius: 10; -fx-font-weight: bold;");
    }

    private void setPistaError(String msg) {
        lblPista.setText("⚠ " + msg);
        lblPista.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-background-color: #E74C3C;"
                + "-fx-padding: 15; -fx-background-radius: 10; -fx-font-weight: bold;");
    }

    private void setPistaErrorGrande(String msg) {
        lblPista.setText(msg);
        lblPista.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-background-color: #E74C3C;"
                + "-fx-padding: 15; -fx-background-radius: 10; -fx-font-weight: bold;");
    }
}
