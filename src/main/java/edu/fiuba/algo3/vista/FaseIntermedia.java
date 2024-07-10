package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import edu.fiuba.algo3.controlador.*;

import java.util.List;

public class FaseIntermedia implements Fase{
    Parser lector;
    Stage fondo;
    FaseManejador manejador;
    Puntajes puntajesParciales;
    Puntajes puntajesGenerales;

    public FaseIntermedia(Stage stage, FaseManejador manejador){
        this.fondo = stage;
        this.manejador = manejador;
        this.puntajesParciales = new Puntajes();
        this.puntajesGenerales = new Puntajes();
    }

    public void iniciar (){
        // Crear n jugadores y guardarlos
        // Crear la tabla general de puntajes y asociarla a los jugadores, no se si crear un objeto tabla
        // Crear tabla parcial de puntajes y asignarselos a los jugadores
        // Esto lo vamos a mandar a fase inicial y acá directamente arrancamos el juego.

        Pregunta pregunta = lector.devolverPrimeraPregunta();
        List<String> jugadoresNombres = manejador.obtenerAtributos().getNombres();
        //
        // int i =0;
        // while(terminoJuego(i, manejador)){}
        // List<Pregunta> ListaDePreguntasQueLeyoElParser = lector.devolverPreguntas();
        // Pregunta pregunta = obtenerPreguntaRandom(ListaDePregnuntasQueLeyoElParser);

        //for (Jugador jugador: manejador.obtenerAtributos().obtenerJugadores());

            //mostrarPreguntaParaJugador(Pregunta pregunta, Jugador jugador)
        for(String nombre : jugadoresNombres){
            //esto deberia estar afuera para crear el puntaje general y coso
            Jugador jugador = new Jugador(nombre);
            mostrarPreguntaParaJugador(pregunta, jugador);
        }
    }
    public void mostrarPreguntaParaJugador(Pregunta pregunta, Jugador jugador){
        Button responder = new Button("Responder");
        //Mostrar vista esto no me acuerdo como es
        //Actualizamos puntajesParciales para sumar o restar lo del jugador
    }


}
