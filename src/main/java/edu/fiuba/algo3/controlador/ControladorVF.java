package edu.fiuba.algo3.controlador;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.VistaPrincipal;
import edu.fiuba.algo3.vista.VistaVF;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;


public class ControladorVF {

    private VistaVF vistaVF;
    private Jugador jugador;
    private Pregunta pregunta;
    private VistaPrincipal vistaPrincipal;
    public ControladorVF(VistaVF vistaVF, Jugador jugador, Pregunta pregunta, VistaPrincipal vistaPrincipal) {
        this.vistaVF = vistaVF;
        /*this.opcion1 = (Opcion) radioButton1.getUserData();
        this.opcion2 = (Opcion) radioButton2.getUserData();*/
        this.jugador = jugador;
        this.pregunta = pregunta;
    }
    public void handleAcceptButtonAction(ActionEvent event) {


        //pregunta.calcularPuntaje(respuesta);
        //aca no sé si usar puntaje y asignarselo al jugador o esperar despues y usar el multiplicador

        /* Logica de pregunta vf
        if (boton1.isSelected() && opcion.esIgual(new Opcion("V"))) {
            showScoreAlert(1);
        }
        else if(boton2.isSelected() && opcion2.esIgual(new Opcion("F"))){
            showScoreAlert(0);
        }
        */
    }
    private void showScoreAlert(int puntaje ) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Puntaje del Jugador");
        alert.setHeaderText(null);
        alert.setContentText("El puntaje del jugador " + jugador.obtenerNombre() + " es: " + puntaje);

        alert.showAndWait();
    }
}
