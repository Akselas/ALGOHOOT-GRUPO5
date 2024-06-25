package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.controlador.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;


public class VistaPrincipal extends Application {
    private Stage ventanaPrincipal;
    private Button responder;
    private VBox vistaPrincipal;

    @Override
    public void start(Stage stage) {
        this.ventanaPrincipal = stage;
        ventanaPrincipal.setWidth(400);
        ventanaPrincipal.setHeight(400);
        this.vistaPrincipal = establecerVistaPrincipal();
        //mostrarVistaVF();
        //mostrarVistaOC();
        //mostrarVistaMC();
        //mostrarVistaGC();
    }

    public void mostrarVistaVF() { //debería ser mostrarVistaPregunta para encapsular
        RespuestaVF correcta = new RespuestaVF();
        correcta.agregarOpcion(new Opcion("V"));
        PreguntaVF preguntaVF = new PreguntaVF("El tomate es una fruta?", new Opciones(), correcta);
        Jugador jugador = new Jugador("Axel");

        VistaVF vistaVF = new VistaVF(preguntaVF);

        //Controlador debe llamar una funcion mostrarPregunta para setear las caracteristicas
        //ControladorVF controladorVF = new ControladorVF(vistaVF, jugador, preguntaVF, this);

        Scene scene = new Scene(vistaVF.getLayout());
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("AlgoHoot");
        ventanaPrincipal.show();
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

        VistaMC vistaMC = new VistaMC(preguntaMC);
        ControladorMC controlador = new ControladorMC(jugador, preguntaMC, vistaMC);

        Scene scene = new Scene(vistaMC.getLayout());
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("AlgoHoot");
        ventanaPrincipal.show();
    }

    public void mostrarVistaOC(){
        Opciones opciones = new Opciones();
        opciones.agregarOpcion(new Opcion("Messi ganó un mundial"));
        opciones.agregarOpcion(new Opcion("El hombre llegó la luna"));
        opciones.agregarOpcion(new Opcion("Abrió la UBA"));

        RespuestaOC respuestaCorrecta = new RespuestaOC();

        respuestaCorrecta.agregar(new Opcion("El hombre llegó la luna"));
        respuestaCorrecta.agregar(new Opcion("Abrió la UBA"));
        respuestaCorrecta.agregar(new Opcion("Messi ganó un mundial"));

        responder = new Button("Responder");

        PreguntaOC preguntaOC = new PreguntaOC("Ordenar cronologicamente:", opciones, respuestaCorrecta);
        Jugador j1 = new Jugador("Pepe");
        PreguntaOCVista vistaPreguntaOC = new PreguntaOCVista(responder);

        ControladorOC controlador = new ControladorOC(j1,preguntaOC, vistaPreguntaOC);

        HBox ventanaPregunta = new HBox(20, vistaPreguntaOC.getLayout()/*, poderesBox*/);//tiene la pregunta y los poderes.
        ventanaPregunta.setMaxWidth(Double.MAX_VALUE);
        ventanaPregunta.setPadding(new Insets(10, 10 , 10 , 10));


        //poderesBox.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        ventanaPregunta.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        vistaPrincipal.getChildren().addAll(ventanaPregunta, responder);



        ventanaPrincipal.setWidth(400);
        ventanaPrincipal.setHeight(400);
        Scene scene = new Scene(vistaPrincipal);
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("Ordered Choice");
        ventanaPrincipal.show();
    }
    public Button obtenerBotonResponder() {
        return this.responder;
    }
    public VBox establecerVistaPrincipal(){
        VBox vista = new VBox();
        vista.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        vista.setSpacing(10);
        vista.setPadding(new Insets(10));
        vista.setAlignment(Pos.CENTER);
        return vista;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
