package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Opcion;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import edu.fiuba.algo3.modelo.*;

public class VistaVF extends VistaPregunta{

    private ToggleGroup grupoOpciones;

    public VistaVF(){
        super();
        this.grupoOpciones = new ToggleGroup();
    }

    @Override
    public void mostrarOpciones(Opciones ops) {
        HBox opciones = new HBox(100);
        for(Opcion opcion: ops.devolverOpciones()){
            RadioButton boton1 = new RadioButton(opcion.obtenerTexto());
            boton1.setUserData(opcion);
            boton1.setToggleGroup(grupoOpciones);
            opciones.getChildren().add(boton1);
        }
        this.getChildren().add(opciones);

    }
    public ToggleGroup obtenerGrupoOpciones(){
        return this.grupoOpciones;
    }
}
