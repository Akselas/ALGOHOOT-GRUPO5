package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        layout.setAlignment(Pos.CENTER);
        layout.setId("VistaInicial");
        Scene scene = new Scene(layout, 300, 200);
        scene.getStylesheets().add(getClass().getResource("/FaseInicial.css").toExternalForm());////////

        // Comienza con la selección del número de jugadores
        TextField numJugadoresField = new TextField();
        numJugadoresField.setPromptText("Selecciona el número de jugadores:");
        Button nextButton = new Button("Siguiente");
        nextButton.setOnAction(e -> {
            //Guardo en atributos el numero de jugadores.
            atributos.guardarNumJugadores(Integer.parseInt(numJugadoresField.getText()));
            showPlayerNamesPhase();
        });


        ImageView imageView = this.setPantallaInicial();
        layout.getChildren().addAll(imageView, numJugadoresField, nextButton);

        stagePrincipal.setScene(scene);
    }

    private ImageView setPantallaInicial(){
        String imagePath = getClass().getResource("/imagen2.png").toExternalForm(); ////////////// Ajusta la ruta a tu imagen
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(300);
        imageView.setFitHeight(250);
        imageView.setPreserveRatio(true);
        imageView.setTranslateY(-30);
        return imageView;
    }


    private void showPlayerNamesPhase() {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 200);
        scene.getStylesheets().add(getClass().getResource("/FaseInicial.css").toExternalForm());
        layout.setId("VistaAjustesIniciales");
        List<TextField> jugadoresLista = new ArrayList<>();
        // Pedir nombres de los jugadores
        for (int i = 0; i < atributos.obtenerNumJugadores(); i++) {
            Label label = new Label("Jugador " + (i+1) + ":");
            TextField nameField = new TextField();
            nameField.setPromptText("Ingrese el nombre del jugador " + (i+1) + ":");
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
        stagePrincipal.setWidth(601);
        stagePrincipal.setHeight(500);
    }

    private void showGameConditionsPhase() {
        VBox layout = new VBox();
        Scene scene = new Scene(layout, 300, 200);
        scene.getStylesheets().add(getClass().getResource("/FaseInicial.css").toExternalForm());
        layout.setId("VistaAjustesIniciales");

        // Establecer las condiciones del juego
        Label label1 = new Label("Cantidad de preguntas:");
        TextField preguntasField = new TextField();
        preguntasField.setPromptText("Ingrese la cantidad de preguntas:");
        Label label2 = new Label("Puntaje para ganar:");
        TextField puntajeField = new TextField();
        puntajeField.setPromptText("Ingrese puntaje para ganar:");


        Button startGameButton = new Button("Iniciar Juego");
        startGameButton.setOnAction(e ->{
            atributos.guardarNumPreguntas(Integer.parseInt(preguntasField.getText()));
            atributos.setPuntajeParaGanar(Integer.parseInt(puntajeField.getText()));

            startGame();

        });

        layout.getChildren().addAll(label1, preguntasField, label2,puntajeField, startGameButton);

        stagePrincipal.setScene(scene);
        stagePrincipal.setWidth(602);
        stagePrincipal.setHeight(500);
    }

    private void startGame() {
        // Aquí puedes iniciar la fase intermedia del juego
        System.out.println("Iniciando el juego con " + atributos.getNumPreguntas() + " preguntas y " + atributos.getPuntajeParaGanar() + " puntos para ganar.");
    }
    public void mostrarFase(){
        stagePrincipal.show();
    }
}
