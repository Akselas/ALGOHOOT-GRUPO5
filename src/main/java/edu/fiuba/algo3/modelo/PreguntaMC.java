package edu.fiuba.algo3.modelo;

public class PreguntaMC {
    private final PreguntaCerrada pc;

    public PreguntaMC(String texto, RespuestaMC correcta) {
        this.pc = new PreguntaCerrada(texto, correcta);
    }

    public Puntaje calcularPuntaje(RespuestaMC respuestaJugador){
        return this.pc.calcularPuntaje(respuestaJugador);
    }
}
