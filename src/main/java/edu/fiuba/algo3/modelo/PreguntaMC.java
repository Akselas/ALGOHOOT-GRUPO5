package edu.fiuba.algo3.modelo;

public class PreguntaMC extends Pregunta{
    public PreguntaMC(String texto, String tema, String tipo, Opciones opciones, Respuesta correcta, String textoRespuesta) {
        super(texto, tema, tipo, opciones, correcta, textoRespuesta);
    }

    public String obtenerTexto(){
       return super.obtenerTexto();
    }

    public Respuesta obtenerRespuesta(){
        return super.obtenerRespuesta();
    }
}
