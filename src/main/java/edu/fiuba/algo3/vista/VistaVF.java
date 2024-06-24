package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Pregunta;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;


public class VistaVF {

    private VBox layout;
    private Pregunta pregunta;
    private ToggleGroup grupoPoderes;
    private ToggleGroup grupoOpciones;
    private RadioButton boton1;
    private RadioButton boton2;
    private Button botonResponder;


    public VistaVF(Pregunta pregunta){
        this.pregunta = pregunta;

        this.grupoOpciones = new ToggleGroup();

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
        HBox opciones = new HBox(100, this.boton1, this.boton2);

        VBox layoutPregunta = new VBox(100, new Label(this.pregunta.obtenerTexto()), opciones);
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

    public ToggleGroup getGrupoOpciones() {
        return this.grupoOpciones;
    }
}
