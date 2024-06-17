package edu.fiuba.algo3.modelo;

public class PreguntaOC {
    private final PreguntaCerrada pc;

    public PreguntaOC(String texto, RespuestaOC correcta) {
        this.pc = new PreguntaCerrada(texto, correcta);
    }

    public Puntaje calcularPuntaje(RespuestaOC respuestaJugador){
        return this.pc.calcularPuntaje(respuestaJugador);
    }
}
