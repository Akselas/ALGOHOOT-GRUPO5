package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.controlador.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;

import java.util.ArrayList;


public class VistaPrincipal extends Application {
    private Stage ventanaPrincipal;
    private Button responder;
    private VBox vistaPrincipal;
    private PoderesVista poderesBox;
    private Parser creador;

    @Override
    public void start(Stage stage) {
        this.ventanaPrincipal = stage;
        responder = new Button("Responder");
        ventanaPrincipal.setWidth(500);
        ventanaPrincipal.setHeight(500);
        this.vistaPrincipal = establecerVistaPrincipal();
        this.poderesBox = new PoderesVista();
        this.creador = new Parser();

        //mostrarVistaVF();
        //mostrarVistaOC();
        mostrarVistaMC();
        //mostrarVistaGC();
    }

    public void mostrarVistaGC() { //debería ser mostrarVistaPregunta para encapsular
        PreguntaGC preguntaGC = creador.devolverPreguntaGC();
        Jugador jugador = new Jugador("Axel");
        VistaGC vistaGC = new VistaGC();

        //Controlador llama una funcion mostrarPregunta para setear la vista
        ControladorGC controladorGC = new ControladorGC(vistaGC, jugador, preguntaGC, poderesBox);
        HBox ventanaPregunta = new HBox(20, vistaGC.getLayout(), poderesBox.obtenerLayout());//tiene la pregunta y los poderes.
        ventanaPregunta.setMaxWidth(Double.MAX_VALUE);
        ventanaPregunta.setPadding(new Insets(10, 10 , 10 , 10));
        ventanaPregunta.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");

        Scene scene = new Scene(ventanaPregunta);
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("AlgoHoot");
        ventanaPrincipal.show();
    }

    public void mostrarVistaVF() { //debería ser mostrarVistaPregunta para encapsular
        PreguntaVF preguntaVF = creador.devolverPreguntaVF();
        Jugador jugador = new Jugador("Axel");
        VistaVF vistaVF = new VistaVF();

        //Controlador llama una funcion mostrarPregunta para setear la vista
        ControladorVF controladorVF = new ControladorVF(vistaVF, jugador, preguntaVF, poderesBox);
        HBox ventanaPregunta = new HBox(20, vistaVF.getLayout(), poderesBox.obtenerLayout());//tiene la pregunta y los poderes.
        ventanaPregunta.setMaxWidth(Double.MAX_VALUE);
        ventanaPregunta.setPadding(new Insets(10, 10 , 10 , 10));
        ventanaPregunta.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");

        Scene scene = new Scene(ventanaPregunta);
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("AlgoHoot");
        ventanaPrincipal.show();
    }
    public VBox establecerVistaPrincipal(){
        VBox vista = new VBox();
        vista.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        vista.setSpacing(10);
        vista.setPadding(new Insets(10));
        vista.setAlignment(Pos.CENTER);
        return vista;
    }

    public void mostrarVistaMC() {
        RespuestaMC correcta = new RespuestaMC();

        Opcion opcion1 = new Opcion("4");
        Opcion opcion2 = new Opcion("Un numero par");
        Opcion opcion3 = new Opcion("2");
        Opcion opcion4 = new Opcion("Un numero impar");

        correcta.agregarOpcionSeleccionada(opcion1);
        correcta.agregarOpcionSeleccionada(opcion2);
        correcta.agregarOpcionNoSeleccionada(opcion3);
        correcta.agregarOpcionNoSeleccionada(opcion4);

        Opciones opciones = new Opciones();
        opciones.agregarOpcion(opcion1);
        opciones.agregarOpcion(opcion2);
        opciones.agregarOpcion(opcion3);
        opciones.agregarOpcion(opcion4);

        PreguntaMC preguntaMC = new PreguntaMC("Cuanto es 2+2?", opciones, correcta);
        Jugador jugador = new Jugador("Axel");

        VistaMC vistaMC = new VistaMC(preguntaMC, responder);
        ControladorMC controlador = new ControladorMC(jugador, preguntaMC, vistaMC, poderesBox);

        HBox ventanaPregunta = new HBox(20, vistaMC.getLayout(), poderesBox.obtenerLayout());//tiene la pregunta y los poderes.
        ventanaPregunta.setMaxWidth(Double.MAX_VALUE);
        ventanaPregunta.setPadding(new Insets(10, 10 , 10 , 10));
        ventanaPregunta.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");

        Scene scene = new Scene(ventanaPregunta);
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("AlgoHoot");
        ventanaPrincipal.show();
    }

    public void mostrarVistaOC(){

        //return new VistaX().show()
        PreguntaOC preguntaOC = creador.devolverPreguntaOC();

        Jugador j1 = new Jugador("Pepe");
        PreguntaOCVista vistaPreguntaOC = new PreguntaOCVista(responder);

        ControladorOC controlador = new ControladorOC(j1,preguntaOC, vistaPreguntaOC, poderesBox);

        HBox ventanaPregunta = new HBox(20, vistaPreguntaOC.getLayout(), poderesBox.obtenerLayout());//tiene la pregunta y los poderes.
        ventanaPregunta.setMaxWidth(Double.MAX_VALUE);
        ventanaPregunta.setPadding(new Insets(10, 10 , 10 , 10));


        ventanaPregunta.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        vistaPrincipal.getChildren().addAll(ventanaPregunta, responder);


        Scene scene = new Scene(vistaPrincipal);
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("Ordered Choice");
        ventanaPrincipal.show();
    }
    public Button obtenerBotonResponder() {
        return this.responder;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
