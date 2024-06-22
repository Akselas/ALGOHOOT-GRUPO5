package edu.fiuba.algo3.modelo;

public abstract class Pregunta {
    protected String texto;
    protected final Respuesta correcta;

    public Pregunta(String texto, Respuesta correcta) {
        this.texto = texto;
        this.correcta = correcta;
    }

    public Puntaje calcularPuntaje(Respuesta respuestaJugador) {
        if(respuestaJugador.esIgual(this.correcta)) {
            return new Puntaje(1);
        }
        return new Puntaje(0);
    }
    public String obtenerTexto(){
        return this.texto;
    }
}
