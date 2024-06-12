package edu.fiuba.algo3.modelo;

public class PreguntaMC {
    private String textoPregunta;
    private RespuestaMC correcta;

    public PreguntaMC(String texto, RespuestaMC respuesta) {
        this.textoPregunta = texto;
        this.correcta = respuesta;
    }

    public Puntaje calcularPuntaje(RespuestaMC respuestaJugador){

        if (respuestaJugador.esIgual(this.correcta)) {
            return new Puntaje(1);
        }
        return new Puntaje(0);
    }
}
