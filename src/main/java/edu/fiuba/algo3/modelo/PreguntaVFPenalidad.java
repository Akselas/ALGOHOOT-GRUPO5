package edu.fiuba.algo3.modelo;

public class PreguntaVFPenalidad {
    private final PreguntaCerrada pc;

    public PreguntaVFPenalidad(String texto, RespuestaVF correcta){
        this.pc = new PreguntaCerrada(texto, correcta);
    }

    public Puntaje calcularPuntajeDe(RespuestaVF respuestaJugador){//Recibe jugador para no tener que castear el tipo de respuesta
        Puntaje puntaje = this.pc.calcularPuntaje(respuestaJugador);

        if (puntaje.obtenerPuntuacion() == 0) puntaje.restar(1);

        return puntaje;
    }
}
