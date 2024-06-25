package edu.fiuba.algo3.modelo;

public class PreguntaMC extends Pregunta{
    public PreguntaMC(String texto, Opciones opciones, RespuestaMC correcta) {
        super(texto, opciones, correcta);
    }

    public String obtenerTexto(){
       return super.obtenerTexto();
    }

    public Respuesta obtenerRespuesta(){
        return super.obtenerRespuesta();
    }
}
