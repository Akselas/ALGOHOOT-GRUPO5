package edu.fiuba.algo3.controlador;
import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Alert;


public class ControladorVF {

    private RadioButton opcion1;
    private RadioButton opcion2;
    private Jugador jugador;

    public ControladorVF(RadioButton radioButton1, RadioButton radioButton2, Jugador jugador) {
        this.opcion1 = radioButton1;
        this.opcion2 = radioButton2;
        this.jugador = jugador;
    }
    public void handleAcceptButtonAction(ActionEvent event) {
        Opcion opcion = (Opcion) opcion1.getUserData();
        Opcion opcionDos = (Opcion) opcion2.getUserData();
        if (opcion1.isSelected() && opcion.esIgual(new Opcion("V"))) {
            showScoreAlert(1);
        }
        else if(opcion2.isSelected() && opcionDos.esIgual(new Opcion("F"))){
            showScoreAlert(0);
        }
    }
    private void showScoreAlert(int puntaje ) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Puntaje del Jugador");
        alert.setHeaderText(null);
        alert.setContentText("El puntaje del jugador " + jugador.obtenerNombre() + " es: " + puntaje);

        alert.showAndWait();
    }
}
