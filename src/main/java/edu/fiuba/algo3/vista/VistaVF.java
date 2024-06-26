package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.PreguntaOC;
import edu.fiuba.algo3.modelo.PreguntaVF;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import edu.fiuba.algo3.modelo.*;

public class VistaVF {

    private VBox layout;
    private ToggleGroup grupoOpciones;
    private RadioButton boton1;
    private RadioButton boton2;
    private Button botonResponder;
    private Label titulo;

    public VistaVF(){


        this.grupoOpciones = new ToggleGroup();
        this.titulo = new Label();
        this.boton1 = new RadioButton("Verdadero");
        boton1.setUserData(new Opcion("V"));
        boton1.setToggleGroup(grupoOpciones);

        this.boton2 = new RadioButton("Falso");
        boton2.setUserData(new Opcion("F"));
        boton2.setToggleGroup(grupoOpciones);

        this.botonResponder = new Button("Responder"); //Capaz el boton responder debería estar afuera

        setupLayout();
    }
    public void setupLayout(){
        HBox opciones = new HBox(100, this.boton1, this.boton2); //Botones estandar, siempre van a estar

        VBox layoutPregunta = new VBox(100,titulo, opciones);
        layoutPregunta.setAlignment(Pos.CENTER);
        layoutPregunta.setPadding(new Insets(5));
        layoutPregunta.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");

        VBox principal = new VBox(layoutPregunta, this.botonResponder);
        principal.setSpacing(10);
        principal.setPadding(new Insets(10));
        principal.setAlignment(Pos.CENTER);

        this.layout = principal;
    }
    public VBox getLayout() {
        return this.layout;
    }

    public void mostrarPregunta(Pregunta pregunta, Opciones ops) {
        this.titulo.setText(pregunta.obtenerTexto());
    }
    public Button obtenerBotonResponder(){
        return this.botonResponder;
    }
    public ToggleGroup obtenerGrupoOpciones(){
        return this.grupoOpciones;
    }
}
