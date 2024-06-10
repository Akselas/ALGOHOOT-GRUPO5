package edu.fiuba.algo3.modelo;

public class PreguntaOC {
    private String textoPregunta;
    private RespuestaOC correcta;

    public PreguntaOC(String texto, RespuestaOC respuesta) {
        this.textoPregunta = texto;
        this.correcta = respuesta;
    }

    public Integer calcularPuntaje(Jugadores jugadores) {
        Puntajes puntaje = new Puntajes();
        for (Jugador jugador : jugadores.devolverJugadores()) {
            int i = 0;
            Puntaje p = new Puntaje();
            while (i < this.correcta.largo() && !jugador.responder().obtenerOpcion(i).esIgual(correcta.obtenerOpcion(i))) {
                i++;
            }
            if (i == this.correcta.largo()) {
                return 0;
            }
            return 1;
        }
    }
}
