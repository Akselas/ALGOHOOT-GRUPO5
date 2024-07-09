package edu.fiuba.algo3.vista;

import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FaseInicial {
    Stage stagePrincipal;
    AtributosIniciales atributos;

    public FaseInicial(Stage stage){
        stagePrincipal = stage;
        atributos = new AtributosIniciales();
        VBox layout = new VBox();
        Scene scene = new Scene(layout, 300, 200);

        // Comienza con la selección del número de jugadores
        Label label = new Label("Selecciona el número de jugadores:");
        TextField numJugadoresField = new TextField();
        Button nextButton = new Button("Siguiente");
        nextButton.setOnAction(e -> {
            //Guardo en atributos el numero de jugadores.
            atributos.guardarNumJugadores(Integer.parseInt(numJugadoresField.getText()));
            showPlayerNamesPhase();
        });

        layout.getChildren().addAll(label, numJugadoresField, nextButton);
        //scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stagePrincipal.setScene(scene);
    }

    private void showPlayerNamesPhase() {
        VBox layout = new VBox();
        Scene scene = new Scene(layout, 300, 200);
        List<TextField> jugadoresLista = new ArrayList<>();
        // Pedir nombres de los jugadores
        for (int i = 0; i < atributos.obtenerNumJugadores(); i++) {
            Label label = new Label("Nombre del jugador " + (i+1) + ":");
            TextField nameField = new TextField();
            jugadoresLista.add(nameField);
            layout.getChildren().addAll(label, nameField);
        }

        Button nextButton = new Button("Siguiente");
        nextButton.setOnAction(e -> {
            atributos.guardarNombres(jugadoresLista);
            showGameConditionsPhase();
        });

        layout.getChildren().add(nextButton);

        stagePrincipal.setScene(scene);
    }

    private void showGameConditionsPhase() {
        VBox layout = new VBox();
        Scene scene = new Scene(layout, 300, 200);

        // Establecer las condiciones del juego
        Label label1 = new Label("Cantidad de preguntas:");
        TextField preguntasField = new TextField();
        Label label2 = new Label("Puntaje para ganar:");
        TextField puntajeField = new TextField();

        Button startGameButton = new Button("Iniciar Juego");
        startGameButton.setOnAction(e ->{
            atributos.guardarNumPreguntas(Integer.parseInt(preguntasField.getText()));
            atributos.setPuntajeParaGanar(Integer.parseInt(puntajeField.getText()));

            startGame();

        });

        layout.getChildren().addAll(label1, preguntasField, label2, puntajeField, startGameButton);

        stagePrincipal.setScene(scene);
    }

    private void startGame() {
        // Aquí puedes iniciar la fase intermedia del juego
        System.out.println("Iniciando el juego con " + atributos.getNumPreguntas() + " preguntas y " + atributos.getPuntajeParaGanar() + " puntos para ganar.");
    }
    public void mostrarFase(){
        stagePrincipal.show();
    }
}
