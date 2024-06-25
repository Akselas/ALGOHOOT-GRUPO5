package edu.fiuba.algo3.modelo;

public abstract class Pregunta {
    protected String texto;
    protected final Respuesta correcta;
    private final Opciones opciones;

    public Pregunta(String texto, Opciones opciones, Respuesta correcta) {
        this.texto = texto;
        this.correcta = correcta;
        this.opciones = opciones;
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

    public Opciones obtenerOpciones() {
        return this.opciones;
    }

    public Respuesta obtenerRespuesta() {
        return this.correcta;
    }
}
