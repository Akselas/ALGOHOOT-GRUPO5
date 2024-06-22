package edu.fiuba.algo3.controlador;
import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;


public class ControladorMC {

    private CheckBox opcion1;
    private CheckBox opcion2;
    private CheckBox opcion3;
    private CheckBox opcion4;
    private Jugador jugador;

    public ControladorMC(CheckBox radioButton1, CheckBox radioButton2, CheckBox radioButton3, CheckBox radioButton4, Jugador jugador) {
        this.opcion1 = radioButton1;
        this.opcion2 = radioButton2;
        this.opcion3 = radioButton3;
        this.opcion4 = radioButton4;
        this.jugador = jugador;
    }
    public void handleAcceptButtonAction(ActionEvent event) {
        Opcion opcion = (Opcion) opcion1.getUserData();
        Opcion opcionDos = (Opcion) opcion2.getUserData();
        Opcion opcionTres = (Opcion) opcion3.getUserData();
        Opcion opcionCuatro = (Opcion) opcion4.getUserData();


        //Aca debería estar la logica de PreguntaMC
        if (opcion1.isSelected() && opcion3.isSelected() && opcion.esIgual(new Opcion("un numero par")) && opcionTres.esIgual(new Opcion("4")) && !opcion2.isSelected() && !opcion4.isSelected()){
            showScoreAlert(1);
        }
        else{ //if(opcion2.isSelected() && opcion4.isSelected() && opcionDos.esIgual(new Opcion("un numero impar")) && opcionCuatro.esIgual(new Opcion("todas las anteriores"))){
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