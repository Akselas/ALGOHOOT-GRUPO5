package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;

public class Pregunta {
    private String textoPregunta;
    private HashMap<String, Boolean> opciones;

    public Pregunta(String texto, HashMap<String, Boolean> opciones) {
        this.textoPregunta = texto;
        this.opciones = opciones;
        //this.modalidad = modalidad;
    }

    public void evaluarRespuestas(List<HashMap<String, Boolean>> respuestas, List<Jugador> jugadores) {
        for (int i = 0; i < respuestas.size(); i++) {
            HashMap<String, Boolean> resp = respuestas.get(i);
            Jugador jugador = jugadores.get(i);
            evaluarRespuesta(resp, jugador);
        }
    }

    public void evaluarRespuesta(HashMap<String, Boolean> respuestaJugador, Jugador jugador) {
        //int puntaje = this.modalidad.calcularPuntaje(respuestaJugador, this.opciones);
        //jugador.sumarPuntaje(puntaje);
    }
}
