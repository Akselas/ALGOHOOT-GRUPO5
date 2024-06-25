package edu.fiuba.algo3.modelo;

public class PreguntaVF extends Pregunta {

    public PreguntaVF(String texto, Opciones opciones, RespuestaVF correcta) {
        super(texto, opciones, correcta);
    }
    public Opciones obtenerOpciones(){
       return this.opciones;
    }
}
