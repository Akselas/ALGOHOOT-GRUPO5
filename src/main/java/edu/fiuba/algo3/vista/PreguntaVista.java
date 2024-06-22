package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pregunta;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class PreguntaVista {

    private VBox container;
    private Pregunta pregunta;
    private ToggleGroup grupoOpciones;
    private ToggleGroup grupoPoderes;

    public PreguntaVista(Pregunta pregunta){
        this.pregunta = pregunta;
        this.container = new VBox(20);
        //aca lo dejamos impecable para luego agregarle lo que querramos al vbox
        this.container.getChildren().add(new Label(pregunta.obtenerTexto()));
        //this.container.getChildren().add(botones de this.grupoOpciones);
    }
    public VBox getView() {
        return container;
    }

    public void display() {
        container.getChildren().clear();

        RadioButton opcionVerdadero = new RadioButton("Verdadero");
        opcionVerdadero.setUserData("V");
        opcionVerdadero.setToggleGroup(grupoOpciones);

        RadioButton opcionFalso = new RadioButton("Falso");
        opcionFalso.setUserData("F");
        opcionFalso.setToggleGroup(grupoOpciones);

        container.getChildren().addAll(opcionVerdadero, opcionFalso);
    }
}
