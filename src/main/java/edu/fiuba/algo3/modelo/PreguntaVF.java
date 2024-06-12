package edu.fiuba.algo3.modelo;

public class PreguntaVF {
    private String texto;
    private RespuestaVF correcta;

    public PreguntaVF(String texto, RespuestaVF correcta){
        this.texto = texto;
        this.correcta = correcta;
    }
    public Puntaje calcularPuntajeDe(RespuestaVF otra){
        if(otra.esIgual(this.correcta)) {
            return new Puntaje(1);
        }
        return new Puntaje(0);
    }
}
