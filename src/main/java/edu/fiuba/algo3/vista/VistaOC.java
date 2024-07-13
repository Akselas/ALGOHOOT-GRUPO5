package edu.fiuba.algo3.vista;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import edu.fiuba.algo3.modelo.*;


public class VistaOC extends VistaPregunta {
    private ListView<Opcion> opcionesListView;

    public VistaOC() {
        super();
        this.opcionesListView = new ListView<>();
    }
    @Override
    public void mostrarOpciones(Opciones ops){
        opcionesListView.setItems(FXCollections.observableArrayList(ops.devolverOpciones()));
        opcionesListView.setMaxHeight(200);
        opcionesListView.setPrefHeight(200);
        this.getChildren().add(opcionesListView);
    }

    public ListView<Opcion> obtenerOpcionesListView(){
        return this.opcionesListView;
    }
}


