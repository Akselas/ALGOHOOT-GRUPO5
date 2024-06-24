package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.controlador.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.util.ArrayList;

public class Vistaa extends Application {
    @Override
    public void start(Stage stage) {
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(new Opcion("Messi ganó un mundial"));
        opciones.add(new Opcion("El hombre llegó la luna"));
        opciones.add(new Opcion("Abrió la UBA"));




        RespuestaOC respuestaCorrecta = new RespuestaOC();

        respuestaCorrecta.agregar(new Opcion("El hombre llegó la luna"));
        respuestaCorrecta.agregar(new Opcion("Abrió la UBA"));
        respuestaCorrecta.agregar(new Opcion("Messi ganó un mundial"));

        PreguntaOC preguntaOC = new PreguntaOC("Ordenar cronologicamente:", respuestaCorrecta);
        Jugador j1 = new Jugador("Pepe");
//       Jugador j2 = new Jugador("Maria");
//        Jugador j3 = new Jugador("Santy");
//        Jugador j4 = new Jugador("Pia");
        PreguntaOCVista vista = new PreguntaOCVista();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(j1);
//        jugadores.add(j2);
//        jugadores.add(j3);
//        jugadores.add(j4);

        for(Jugador jugador: jugadores){
            ControladorOC controlador = new ControladorOC(opciones,jugador,preguntaOC, vista);
        }
        stage.setWidth(400);
        stage.setHeight(400);
        Scene scene = new Scene(vista);
        stage.setScene(scene);
        stage.setTitle("Ordered Choice");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
