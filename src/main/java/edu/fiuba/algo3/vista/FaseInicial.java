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


public class FaseInicial implements Fase{
    Stage ventanaPrincipal;
    FaseManejador manejador;
    int jugadorActual = 0;
    public static final int anchoVentana = 600;
    public static final int altoVentana = 400;

    public FaseInicial(Stage stage, FaseManejador manejador){
        this.ventanaPrincipal = stage;
        this.manejador = manejador;
        iniciar();
    }
    public void iniciar(){
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setId("VistaInicial");
        Scene scene = new Scene(layout, anchoVentana, altoVentana);
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


        ImageView imageView = this.agregarImagen();
        layout.getChildren().addAll(imageView, numJugadoresField, nextButton);

        ventanaPrincipal.setScene(scene);
        mostrarFase();
    }

    private ImageView agregarImagen(){
        String imagePath = getClass().getResource("/imagen2.png").toExternalForm(); ////////////// Ajusta la ruta a tu imagen
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(300);
        imageView.setFitHeight(250);
        imageView.setPreserveRatio(true);
        imageView.setTranslateY(-30);
        return imageView;
    }


    private void pedirNombresDeJugadores() {
        if(jugadorActual < manejador.obtenerAtributos().obtenerNumJugadores()){
            VBox layout = new VBox();
            layout.setAlignment(Pos.CENTER);
            layout.setPrefWidth(600);  // Establecer un ancho prefijado
            layout.setPrefHeight(400);

            Scene scene = new Scene(layout, anchoVentana, altoVentana);
            scene.getStylesheets().add(getClass().getResource("/FaseInicial.css").toExternalForm());
            layout.setId("VistaAjustesIniciales");
            // Pedir nombres de los jugadores
            Label label = new Label("Jugador " + (jugadorActual + 1) + ":");
            TextField nameField = new TextField();
            nameField.setPromptText("Ingrese el nombre del jugador " + (jugadorActual + 1) + ":");
            layout.getChildren().addAll(label, nameField);

            Button nextButton = new Button("Siguiente");
            nextButton.setOnAction(e -> {
                //Guarda el nombre en Atributos
                manejador.obtenerAtributos().guardarJugador(nameField.getText());
                jugadorActual++;
                pedirNombresDeJugadores();
            });

            layout.getChildren().add(nextButton);

            ventanaPrincipal.setScene(scene);
            ventanaPrincipal.centerOnScreen();
        } else {
            pedirCondicionesDeFin();
        }

    }



    private void pedirCondicionesDeFin() {
        VBox layout = new VBox();
        Scene scene = new Scene(layout, anchoVentana, altoVentana);
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
            manejador.configurarCantidadPreguntas(Integer.parseInt(preguntasField.getText()));
            manejador.obtenerAtributos().setPuntajeParaGanar(Integer.parseInt(puntajeField.getText()));

            fasePromover();

        });

        layout.getChildren().addAll(label1, preguntasField, label2, puntajeField, startGameButton);

        ventanaPrincipal.setScene(scene);
    }
    @Override
    public void fasePromover(){
        System.out.println("Iniciando el juego con " + manejador.obtenerAtributos().getNumPreguntas() + " preguntas y " + manejador.obtenerAtributos().getPuntajeParaGanar() + " puntos para ganar.");
        manejador.cambiarFase(new FaseIntermedia(this.ventanaPrincipal, this.manejador));
        manejador.iniciarFase();
    }
    public void mostrarFase(){
        ventanaPrincipal.show();
    }
}

