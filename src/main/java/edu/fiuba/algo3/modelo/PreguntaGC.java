package edu.fiuba.algo3.modelo;

public class PreguntaGC {
    private String texto;
    private RespuestaGC correcta;
    public PreguntaGC(String texto, RespuestaGC correcta){
        this.texto = texto;
        this.correcta = correcta;
    }

    public Puntaje calcularPuntaje(RespuestaGC respuestaJugador){

        if(this.correcta.esIgual(respuestaJugador)) {
            return new Puntaje(1);
        }
        return new Puntaje(0);
    }
}
