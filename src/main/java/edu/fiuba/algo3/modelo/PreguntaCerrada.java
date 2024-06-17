package edu.fiuba.algo3.modelo;

public class PreguntaCerrada {
    private String texto;
    private Respuesta correcta;

    public PreguntaCerrada(String texto, Respuesta correcta) {
        this.texto = texto;
        this.correcta = correcta;
    }

    public Puntaje calcularPuntaje(Respuesta respuestaJugador) {
        if(respuestaJugador.esIgual(this.correcta)) {
            return new Puntaje(1);
        }
        return new Puntaje(0);

    }
}
