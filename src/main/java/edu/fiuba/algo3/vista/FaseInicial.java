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

public class FaseInicial implements Fase{
    Stage ventanaPrincipal;
    FaseManejador manejador;

    public FaseInicial(Stage stage, FaseManejador manejador){
        this.ventanaPrincipal = stage;
        this.manejador = manejador;
        iniciar();
    }
    public void iniciar(){
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
            manejador.obtenerAtributos().guardarNumJugadores(Integer.parseInt(numJugadoresField.getText()));
            pedirNombresDeJugadores();
        });


        ImageView imageView = this.setPantallaInicial();
        layout.getChildren().addAll(imageView, numJugadoresField, nextButton);

        ventanaPrincipal.setScene(scene);
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
        layout.getChildren().addAll(label, numJugadoresField, nextButton);
        //scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        ventanaPrincipal.setScene(scene);
    }
    private void pedirNombresDeJugadores() {
        VBox layout = new VBox();
        Scene scene = new Scene(layout, 300, 200);
        List<TextField> jugadoresLista = new ArrayList<>();
        // Pedir nombres de los jugadores
        for (int i = 0; i < manejador.obtenerAtributos().obtenerNumJugadores(); i++) {
            Label label = new Label("Nombre del jugador " + (i+1) + ":");
            TextField nameField = new TextField();
            nameField.setPromptText("Ingrese el nombre del jugador " + (i+1) + ":");
            jugadoresLista.add(nameField);
            layout.getChildren().addAll(label, nameField);
        }

        Button nextButton = new Button("Siguiente");
        nextButton.setOnAction(e -> {
            manejador.obtenerAtributos().guardarNombres(jugadoresLista);
            pedirCondicionesDeFin();
        });

        layout.getChildren().add(nextButton);

        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setWidth(601);
        ventanaPrincipal.setHeight(500);
    }

    private void pedirCondicionesDeFin() {
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
            manejador.obtenerAtributos().guardarNumPreguntas(Integer.parseInt(preguntasField.getText()));
            manejador.obtenerAtributos().setPuntajeParaGanar(Integer.parseInt(puntajeField.getText()));

            fasePromover();//Aca capaz solo hacer fasePromover();

        });

        layout.getChildren().addAll(label1, preguntasField, label2, puntajeField, startGameButton);

        ventanaPrincipal.setScene(scene);
    }

    public void fasePromover(){
        System.out.println("Iniciando el juego con " + manejador.obtenerAtributos().getNumPreguntas() + " preguntas y " + manejador.obtenerAtributos().getPuntajeParaGanar() + " puntos para ganar.");
        manejador.cambiarFase(new FaseIntermedia(this.ventanaPrincipal, this.manejador));
    }
    public void mostrarFase(){
        ventanaPrincipal.show();
    }
}

