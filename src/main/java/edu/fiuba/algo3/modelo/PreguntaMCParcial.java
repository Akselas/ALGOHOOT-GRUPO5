package edu.fiuba.algo3.modelo;

public class PreguntaMCParcial {
    private final PreguntaCerrada pc;

    public PreguntaMCParcial(String texto, RespuestaMC correcta) {
        this.pc = new PreguntaCerrada(texto, correcta);

    }

    public Puntaje calcularPuntaje(Respuesta respuestaJugador){
        return this.pc.calcularPuntaje(respuestaJugador);
    }
}
