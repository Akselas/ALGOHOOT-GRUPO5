package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class VistaPrincipal extends Application {
    private Stage ventanaPrincipal;
    private Button responder;
    private VBox vistaPrincipal;
    private PoderesVista poderesBox;
    private Parser creador;

    @Override
    public void start(Stage stage) throws IOException {
        this.ventanaPrincipal = stage;
        //FaseManejador manejadorDeFases = new FaseManejador(ventanaPrincipal);
        //manejadorDeFases.iniciarFase();
//        FaseInicial faseInicial = new FaseInicial(stage);
//        faseInicial.mostrarFase();



        Poderes poderes = new Poderes();
        List<Jugador> jugadores= new ArrayList<>();
        jugadores.add(new Jugador("Denu"));
        jugadores.add(new Jugador("Juani"));
        jugadores.add(new Jugador("Axel"));
        VistaRonda vistaRonda = new VistaRonda(stage,jugadores, poderes);;
        vistaRonda.mostrarVistaRonda();



        responder = new Button("Responder");
        this.responder.getStyleClass().add("answer-button");
        ventanaPrincipal.setWidth(500);
        ventanaPrincipal.setHeight(500);
        this.vistaPrincipal = establecerVistaPrincipal();
        Jugador jugador = new Jugador("Axel");
        this.poderesBox = new PoderesVista(jugador);
        this.creador = new Parser();
        creador.leer("src/main/resources/ParserTestFile.json");
        //creador.devolverPrimeraPregunta();
        //mostrarVistaVF(jugador);
        //mostrarVistaOC(jugador);
        //mostrarVistaMC(jugador);
        //mostrarVistaGC(jugador);

    }


    public void mostrarVistaGC(Jugador jugador) { //debería ser mostrarVistaPregunta para encapsular
        PreguntaGC preguntaGC = creador.devolverPreguntaGC();
        poderesBox.agregarBotones(preguntaGC);
        VistaGC vistaGC = new VistaGC();

        //Controlador llama una funcion mostrarPregunta para setear la vista
        ControladorGC controladorGC = new ControladorGC(vistaGC, jugador, preguntaGC, poderesBox, responder);
        proyectarVista(vistaGC);
    }

    public void mostrarVistaVF(Jugador jugador) { //debería ser mostrarVistaPregunta para encapsular
        PreguntaVF preguntaVF = creador.devolverPreguntaVF();
        poderesBox.agregarBotones(preguntaVF);
        VistaVF vistaVF = new VistaVF();

        //Controlador llama una funcion mostrarPregunta para setear la vista
        ControladorVF controladorVF = new ControladorVF(vistaVF, jugador, preguntaVF, poderesBox, responder);
        proyectarVista(vistaVF);
    }

    public void mostrarVistaMC(Jugador jugador) {

        PreguntaMC preguntaMC = creador.devolverPreguntaMC();
        poderesBox.agregarBotones(preguntaMC);

        VistaMC vistaMC = new VistaMC();
        ControladorMC controlador = new ControladorMC(jugador, preguntaMC, vistaMC, poderesBox, responder);
        proyectarVista(vistaMC);
    }

    public void mostrarVistaOC(Jugador jugador){
        //return new VistaX().show()
        PreguntaOC preguntaOC = creador.devolverPreguntaOC();
        poderesBox.agregarBotones(preguntaOC);
        VistaOC vistaOC = new VistaOC();
        ControladorOC controlador = new ControladorOC(jugador,preguntaOC, vistaOC, poderesBox, responder);
        proyectarVista(vistaOC);
    }

    private void proyectarVista(VistaPregunta vistaPregunta) {
        HBox ventanaPregunta = new HBox(20, vistaPregunta, poderesBox);
        ventanaPregunta.setMaxWidth(Double.MAX_VALUE);
        ventanaPregunta.setPadding(new Insets(10, 10, 10, 10));
        //ventanaPregunta.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        ventanaPregunta.getStyleClass().add("pregunta");

        vistaPrincipal.getChildren().clear();
        vistaPrincipal.getChildren().addAll(ventanaPregunta, responder);

        Scene scene = new Scene(vistaPrincipal);
        scene.getStylesheets().add(getClass().getResource("/FaseJuego.css").toExternalForm());
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("AlgoHoot");
        ventanaPrincipal.show();
    }

    public VBox establecerVistaPrincipal(){
        VBox vista = new VBox();
        vista.setId("VistaPrincipal");
        vista.setSpacing(10);
        vista.setPadding(new Insets(10));
        vista.setAlignment(Pos.CENTER);
        return vista;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
