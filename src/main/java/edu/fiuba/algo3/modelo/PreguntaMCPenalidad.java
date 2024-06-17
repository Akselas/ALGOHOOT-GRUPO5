package edu.fiuba.algo3.modelo;

public class PreguntaMCPenalidad extends Pregunta {

    public PreguntaMCPenalidad(String texto, RespuestaMC respuesta) {
        super(texto, respuesta);
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
