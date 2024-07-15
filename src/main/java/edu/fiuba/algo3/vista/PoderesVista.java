package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class PoderesVista extends VBox{
    private ToggleGroup grupoPoderes;
    private Poder poderSeleccionado;
    private Jugador jugador;
    private ToggleButton botonSeleccionado;

public PoderesVista(Jugador jugador, Pregunta pregunta){
    poderSeleccionado = new Basico();
    grupoPoderes = new ToggleGroup();
    this.jugador = jugador;
    this.setSpacing(40);
    this.getStylesheets().add(getClass().getResource("/FaseJuego.css").toExternalForm());
    this.setPadding(new Insets(10, 10, 10, 10));
    this.setAlignment(Pos.CENTER);
    agregarBotones(pregunta);
}

private void agregarBotones(Pregunta pregunta){//se agregan los botones filtrando los poderes que no se pueden utilizar segun pregunta
    for(Poder poder: jugador.obtenerPoderes()){
        if(poder.habilitarPoder(pregunta)) {
            cargarPoder(poder);
        }
    }
}

public void actualizarPoderes(){//actualiza TODOS los poderes
    for(Node nodo: this.getChildren()){
        if (nodo instanceof ToggleButton) {
            ToggleButton boton = (ToggleButton) nodo;
            Poder poder = (Poder)boton.getUserData();
            boton.setText(poder.obtenerNombre() + " (" + poder.obtenerCantidad() + ")");
        }
    }
}

private void cargarPoder(Poder poder){//se agregan los botones al layout, junto con la logica de boton seleccionado
    ToggleButton boton = new ToggleButton(poder.obtenerNombre()+" (" + poder.obtenerCantidad() + ")");
    boton.setMaxWidth(Double.MAX_VALUE);
    boton.setToggleGroup(grupoPoderes);
    boton.setUserData(poder);
    boton.getStyleClass().add("boton-poder");
    boton.setOnAction(event -> {
        if (boton.isSelected()) {
            if(!poder.agotado()){
                poderSeleccionado = poder;
                if (botonSeleccionado != null) {
                    botonSeleccionado.getStyleClass().remove("boton-poder-seleccionado");
                }
                boton.getStyleClass().add("boton-poder-seleccionado");
                botonSeleccionado = boton;
            }else{
                Alerta.mostrarAlerta("Agotaste el poder " + poder.obtenerNombre());
            }
        } else {
            poderSeleccionado = new Basico();
            botonSeleccionado.getStyleClass().remove("boton-poder-seleccionado");
            botonSeleccionado = null;
        }
    });
    this.getChildren().add(boton);
}

public Poder obtenerPoderSeleccionado(){
    return poderSeleccionado;
}

}
