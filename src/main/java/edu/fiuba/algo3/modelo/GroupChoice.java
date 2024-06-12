package edu.fiuba.algo3.modelo;

public class GroupChoice {
    private String texto;
    private RespuestaGC correcta;
    public GroupChoice(String texto, RespuestaGC correcta){
        this.texto = texto;
        this.correcta = correcta;
    }

    public Puntaje calcularPuntaje(RespuestaGC respuestaJugador){
        Puntaje puntaje = new Puntaje();
        if(this.correcta.esIgual(respuestaJugador)) {
            puntaje.sumar();
        }
        return puntaje;
    }
}
