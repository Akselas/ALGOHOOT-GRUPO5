package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Opciones;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;


public class VistaMC extends VistaPregunta{
    private List<CheckBox> botones;

    public VistaMC(){
        super();
        this.botones = new ArrayList<>();
        //10 10 10 10

    }
    @Override
    public void mostrarOpciones(Opciones ops) {
        VBox opciones = new VBox(20);
        opciones.setPadding(new Insets(10, 10, 10, 10));
        //opciones.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        opciones.getStyleClass().add("question-area");
        for(Opcion opcion: ops.devolverOpciones()){
            CheckBox boton = new CheckBox(opcion.obtenerTexto());
            boton.setUserData(opcion);
            botones.add(boton);
            opciones.getChildren().add(boton);
        }
        this.getChildren().add(opciones);

    }
    public List<CheckBox> obtenerBotones(){return this.botones;}
}
