package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pregunta;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import edu.fiuba.algo3.modelo.*;

public abstract class VistaPregunta extends VBox {
    private final Label enunciadoLabel;
    private final Label turno;
    private final Label tema;
    public static final int anchoDeTexto = 400;
    private final Button responder;

    public VistaPregunta(){
        this.enunciadoLabel = new Label(){{
            setWrapText(true);
            setMaxWidth(anchoDeTexto);
        }};
        this.tema = new Label();
        this.turno = new Label();
        this.responder = new Button("Responder");
        this.getChildren().addAll(turno, tema, enunciadoLabel);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        this.setPadding(new Insets(30, 10, 70, 10)); // arriba, der, abajo, izq
    }

    public void mostrarPregunta(Pregunta pregunta, Jugador jugador){
        this.turno.setText("Turno: " + jugador.getNombre());
        turno.getStyleClass().add("titulo-pregunta");
        this.tema.setText("Tema: "+ pregunta.obtenerTema());
        tema.getStyleClass().add("titulo-pregunta");
        this.enunciadoLabel.setText(pregunta.obtenerTexto());
        enunciadoLabel.getStyleClass().add("titulo-pregunta");
    }

    public abstract void mostrarOpciones(Opciones ops);

    public Scene proyectar(PoderesVista poderesBox){
        HBox ventanaPregunta = new HBox(20, this, poderesBox);
        ventanaPregunta.setMaxWidth(Double.MAX_VALUE);
        ventanaPregunta.setPadding(new Insets(10, 10, 10, 10));
        ventanaPregunta.getStyleClass().add("pregunta");

        VBox ventanaFondo = crearVentanaFondo();

        ventanaFondo.getChildren().addAll(ventanaPregunta, this.responder);
        Scene scene = new Scene(ventanaFondo);
        scene.getStylesheets().add(getClass().getResource("/FaseJuego.css").toExternalForm());
        return scene;

    }
    private VBox crearVentanaFondo(){
        VBox ventana = new VBox();
        ventana.setId("VistaPrincipal");
        ventana.setSpacing(10);
        ventana.setPadding(new Insets(10));
        ventana.setAlignment(Pos.CENTER);
        return ventana;
    }

    public Button obtenerBotonResponder() {
        return this.responder;
    }

}


