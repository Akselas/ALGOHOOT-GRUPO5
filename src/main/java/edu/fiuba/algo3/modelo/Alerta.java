package edu.fiuba.algo3.modelo;

import javafx.scene.control.Alert;

public class Alerta{
    public static void mostrarAlerta(String contenido){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
