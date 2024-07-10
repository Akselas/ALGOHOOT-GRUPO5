package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class PoderesVista extends VBox{
    private ToggleGroup grupoPoderes;
    private Poder poderSeleccionado;
    private Jugador jugador;

public PoderesVista(Jugador jugador){
    poderSeleccionado = new Basico();
    grupoPoderes = new ToggleGroup();
    this.jugador = jugador;
    this.setSpacing(40);
    this.getStylesheets().add(getClass().getResource("/FaseJuego.css").toExternalForm());
    this.setPadding(new Insets(10, 10, 10, 10));
    this.setAlignment(Pos.CENTER);
}

public void agregarBotones(Pregunta pregunta){//se agregan los botones filtrando los poderes que no se pueden utilizar segun pregunta
    for(Poder poder: jugador.obtenerPoderes()){
        //mochila
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
    poderSeleccionado = new Basico();
}

private void cargarPoder(Poder poder){//se agregan los botones al layout, junto con la logica de boton seleccionado
    ToggleButton boton = new ToggleButton(poder.obtenerNombre()+" (" + poder.obtenerCantidad() + ")");
    boton.setMaxWidth(Double.MAX_VALUE);
    boton.setToggleGroup(grupoPoderes);
    boton.setUserData(poder);
    boton.getStyleClass().add("boton-poder");
    boton.setOnAction(event -> {
        if(boton.isSelected()){
            poderSeleccionado = poder;
            System.out.println("Poder seleccionado: " + poder.obtenerNombre());
        }else{
            System.out.println("Poder deseleccionado: " + poder.obtenerNombre());
            poderSeleccionado = new Basico();
            System.out.println("Poder seleccionado: " + poderSeleccionado.obtenerNombre());
        }
    });
    this.getChildren().add(boton);
}

public Poder obtenerPoderSeleccionado(){
    return poderSeleccionado;
}

}
