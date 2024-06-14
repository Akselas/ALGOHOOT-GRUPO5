package edu.fiuba.algo3.modelo;

public class PreguntaGC {

    private PreguntaCerrada pc;

    public PreguntaGC(String texto, RespuestaGC correcta){
        this.pc = new PreguntaCerrada(texto, correcta);
    }

    public Puntaje calcularPuntaje(RespuestaGC respuestaJugador){
        return this.pc.calcularPuntaje(respuestaJugador);
    }
}
