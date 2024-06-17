package edu.fiuba.algo3.modelo;

public class PreguntaVF {
    private final PreguntaCerrada pc;

    public PreguntaVF(String texto, RespuestaVF correcta){
        this.pc = new PreguntaCerrada(texto, correcta);
    }
    public Puntaje calcularPuntajeDe(RespuestaVF respuestaJugador){
        return this.pc.calcularPuntaje(respuestaJugador);
    }
}
