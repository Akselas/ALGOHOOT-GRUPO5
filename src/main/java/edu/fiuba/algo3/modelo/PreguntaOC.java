package edu.fiuba.algo3.modelo;

public class PreguntaOC {
    private String textoPregunta;
    private RespuestaOC correcta;

    public PreguntaOC(String texto, RespuestaOC respuesta) {
        this.textoPregunta = texto;
        this.correcta = respuesta;
    }

    public Puntaje calcularPuntaje(RespuestaOC respuestaJugador){

        if(respuestaJugador.esIgual(this.correcta)) {
            return new Puntaje(1);
        }
        return new Puntaje(0);
    }
}
