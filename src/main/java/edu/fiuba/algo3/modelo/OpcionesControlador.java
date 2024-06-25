package edu.fiuba.algo3.modelo;

import javafx.scene.control.CheckBox;

import java.awt.*;
import java.util.ArrayList;

public class OpcionesControlador {
    private final ArrayList<CheckBox> opciones;

    public OpcionesControlador() {
        opciones = new ArrayList<>();
    }

    public void agregarOpcion(CheckBox checkBox){
        this.opciones.add(checkBox);
    }

    public CheckBox getOpcion(int numero){
        if(!opciones.isEmpty()){
        return this.opciones.get(numero);
        }
        return null;
    }

    public ArrayList<CheckBox> getOpciones() {
        return this.opciones;
    }
}
