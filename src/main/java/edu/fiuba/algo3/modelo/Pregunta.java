package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Pregunta {
    private String textoPregunta;
    private HashMap<String, Boolean> opciones;
    private Modalidad modalidad;

    public Pregunta(String texto, HashMap<String, Boolean> opciones, Modalidad modalidad) {
        this.textoPregunta = texto;
        this.opciones = opciones;
        this.modalidad = modalidad;
    }

    public void evaluarRespuestas(HashMap<String, Boolean>[] respuestasJugador, Jugador[] jugadores) {
        for (int i = 0; i < respuestasJugador.length; i++) {
            evaluarRespuesta(respuestasJugador[i], jugadores[i]);
        }
    }

    public void evaluarRespuesta(HashMap<String, Boolean> respuestaJugador, Jugador jugador) {
        int puntajeCorrespondiente = this.modalidad.calcularPuntaje(respuestaJugador, this.opciones);
        asignarPuntaje(jugador, puntajeCorrespondiente);
    }

    private void asignarPuntaje(Jugador jugador, int puntaje) {
        jugador.sumarPuntaje(puntaje);
    }
}
