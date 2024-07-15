package edu.fiuba.algo3.modelo;

public class PreguntaMCPenalidad extends Pregunta {

    public PreguntaMCPenalidad(String texto, String tema, String tipo, Opciones opciones, Respuesta correcta, String textoRespuesta) {
        super(texto, tema, tipo, opciones, correcta, textoRespuesta);
    }

    @Override
    public Puntaje calcularPuntaje(Respuesta respuestaJugador){
        RespuestaMC respuesta = (RespuestaMC) respuestaJugador; // se podria validar que respuesta no sea null
        RespuestaMC respuestaCorrecta = (RespuestaMC) this.correcta;

        Puntaje p = new Puntaje();
        p.sumar(respuesta.cantidadOpcionesIguales(respuestaCorrecta));
        p.restar(respuesta.cantidadOpcionesDesiguales(respuestaCorrecta));

        return p;
    }
}
