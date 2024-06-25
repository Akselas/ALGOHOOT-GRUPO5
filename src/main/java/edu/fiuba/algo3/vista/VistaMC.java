package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OpcionesControlador;
import edu.fiuba.algo3.modelo.Pregunta;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import java.util.ArrayList;
import java.util.Iterator;


public class VistaMC {

    private VBox layout;
    private Pregunta pregunta;
    private ToggleGroup grupoPoderes;
    private OpcionesControlador botones;
    private Button botonResponder;

    public VistaMC(Pregunta pregunta){
        this.pregunta = pregunta;

        this.botones = new OpcionesControlador();

        Iterator<Opcion> opcion = pregunta.obtenerOpciones().iterator();

        while(opcion.hasNext()){
            Opcion opcionAux = opcion.next();
            CheckBox boton = new CheckBox(opcionAux.obtenerTexto());
            boton.setUserData(new Opcion(opcionAux.obtenerTexto()));
            this.botones.agregarOpcion(boton);
        }

        this.botonResponder = new Button("Responder"); //Capaz el boton responder debería estar afuera

        setupLayout();
    }
    public void setupLayout(){
        HBox opciones1 = new HBox(100, this.botones.getOpcion(0), this.botones.getOpcion(1));
        HBox opciones2 = new HBox(100, this.botones.getOpcion(2), this.botones.getOpcion(3));

        VBox layoutPregunta = new VBox(100, new Label(this.pregunta.obtenerTexto()), opciones1, opciones2);
        layoutPregunta.setAlignment(Pos.CENTER);
        layoutPregunta.setPadding(new Insets(5));

        VBox principal = new VBox(layoutPregunta, this.botonResponder);
        principal.setSpacing(10);
        principal.setPadding(new Insets(10));
        principal.setAlignment(Pos.CENTER);

        this.layout = principal;
    }
    public VBox getLayout() {
        return this.layout;
    }
    public Button getBotonResponder() {
        return this.botonResponder;
    }

    public OpcionesControlador getBotones() {
        return this.botones;
    }
}
