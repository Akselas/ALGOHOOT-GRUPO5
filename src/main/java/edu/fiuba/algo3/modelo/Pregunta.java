package edu.fiuba.algo3.modelo;

public abstract class Pregunta {
    protected String texto;
    protected final Respuesta correcta;
    private final String tema;
    private final String tipo;
    public final Opciones opciones;
    public final String textoRespuesta;

    public Pregunta(String texto, String tema, String tipo, Opciones opciones, Respuesta correcta, String textoRespuesta) {
        this.texto = texto;
        this.correcta = correcta;
        this.opciones = opciones;
        this.tema = tema;
        this.tipo = tipo;
        this.textoRespuesta = textoRespuesta;
    }

    public Puntaje calcularPuntaje(Respuesta respuestaJugador) {
        if(respuestaJugador.esIgual(this.correcta)) {
            return new Puntaje(1);
        }
        return new Puntaje(0);
    }


    public String obtenerTema() {
        return tema;
    }

    public String obtenerTipo() {
        return tipo;
    }

    public String obtenerTextoRespuesta() {
        return textoRespuesta;
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
