package main.java.edu.fiuba.algo3.entrega_1;

import java.util.HashMap;

public class Pregunta {

    public Pregunta(HashMap<string, bool> opciones, Modalidad modalidad) {
        this.opciones = opciones;
        this.modalidad = modalidad;
    }

    public void evaluarRespuestas(List<HashMap<string, bool>> respuestas, List<Jugador> jugadores) {

        for (int i = 0; i < respuestas.size(); i++) {
            HashMap<String, Boolean> resp = respuestas.get(i);
            Jugador jugador = jugadores.get(i);
            this.modalidad.evaluarRespuesta(resp, jugador);
        }
    }

    public void evaluarRespuesta(HashMap<string, bool> respuestaJugador, Jugador jugador) {
        int puntaje = this.modalidad.calcularPuntaje(HashMap < string, bool > respuestaJugador, this.opciones);
        jugador.asignarPuntaje(puntaje);
    }

    private void asignarPuntaje(Jugador jugador, int puntaje) {
        jugador.sumarPuntaje(puntaje);
    }
}
