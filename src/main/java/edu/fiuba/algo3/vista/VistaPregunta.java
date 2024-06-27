package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pregunta;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import edu.fiuba.algo3.modelo.*;

public abstract class VistaPregunta extends VBox {
    protected Label enunciadoLabel;

    public VistaPregunta(){
        this.enunciadoLabel = new Label();
        this.getChildren().add(enunciadoLabel);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        this.setPadding(new Insets(30, 10, 70, 10)); // arriba, der, abajo, izq
        this.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
    }

    public void mostrarPregunta(Pregunta pregunta){
        this.enunciadoLabel.setText(pregunta.obtenerTexto());
    }

    public abstract void mostrarOpciones(Opciones ops);
}
