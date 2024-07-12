package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.stage.Stage;
import edu.fiuba.algo3.controlador.*;

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
        // Crear la tabla general de puntajes y asociarla a los jugadores, no se si crear un objeto tabla
        // Crear tabla parcial de puntajes y asignarselos a los jugadores
        // Esto lo vamos a mandar a fase inicial y acá directamente arrancamos el juego.
        int contador = 0;

        while (!terminoJuego(contador)){
            Pregunta pregunta = manejador.obtenerAtributos().getPreguntaAleatoria();
            Jugadores jugadores = manejador.obtenerAtributos().getJugadores();
            Poderes poderesUsados = new Poderes();

            for(Jugador jugador: jugadores.getJugadores()){
                mostrarPreguntaParaJugador(pregunta, jugador, poderesUsados);
                puntajesParciales.agregarPuntaje(jugador.getPuntajeParcial());
            }
            poderesUsados.aplicarPoderesGrupales(puntajesParciales);
            jugadores.actualizarPuntajes();
            VistaRonda rondaTerminada = new VistaRonda(fondo, jugadores, poderesUsados);
            rondaTerminada.mostrar();
            contador++;
        }
    }

    public boolean terminoJuego(int i) {
        int limitePreguntas = manejador.obtenerAtributos().getNumPreguntas();
        boolean hayGanador = manejador.obtenerAtributos().hayGanador();
        return (i > limitePreguntas || hayGanador);
    }

    public void mostrarPreguntaParaJugador(Pregunta pregunta, Jugador jugador, Poderes usados){
        //PoderesVista poderesBox = new PoderesVista(jugador, pregunta); mandarlo por parametro en un refactor
        ControladorFactory controladorFactory = new ControladorFactory();
        // Dependiendo la pregunta esto deberia devolver un controlador espeifico
        ControladorPregunta controlador = controladorFactory.crearControlador(pregunta, jugador);
        controlador.mostrarVentanaPregunta(fondo);
        usados.agregarPoder(controlador.poderUsado());
    }
}