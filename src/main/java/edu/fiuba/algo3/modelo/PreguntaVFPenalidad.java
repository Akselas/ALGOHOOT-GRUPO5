package edu.fiuba.algo3.modelo;

public class PreguntaVFPenalidad extends Pregunta {

    public PreguntaVFPenalidad(String texto, RespuestaVF correcta){
        super(texto, correcta);
    }

    @Override
    public Puntaje calcularPuntaje(Respuesta respuestaJugador){//Recibe jugador para no tener que castear el tipo de respuesta
        if(respuestaJugador.esIgual(this.correcta)) {
            return new Puntaje(1);
        }
        return new Puntaje(-1);
    }
}
