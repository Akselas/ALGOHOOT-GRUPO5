package edu.fiuba.algo3.modelo;

public class PreguntaOC {
    private String textoPregunta;
    private RespuestaOC correcta;

    public PreguntaOC(String texto, RespuestaOC respuesta) {
        this.textoPregunta = texto;
        this.correcta = respuesta;
    }

    public Puntaje calcularPuntaje(RespuestaOC respuestaJugador){
        Puntaje puntaje = new Puntaje();
        if(respuestaJugador.esIgual(this.correcta)) {
            puntaje.sumar();
        }
        return puntaje;
    }
}
