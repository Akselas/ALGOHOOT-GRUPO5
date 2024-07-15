package edu.fiuba.algo3.modelo;

public class PreguntaMCParcial extends Pregunta {

    public PreguntaMCParcial(String texto, String tema, String tipo, Opciones opciones, Respuesta correcta, String textoRespuesta) {
        super(texto, tema, tipo, opciones, correcta, textoRespuesta);
    }

    @Override
    public Puntaje calcularPuntaje(Respuesta respuestaJugador){
        RespuestaMC respuesta = (RespuestaMC) respuestaJugador; // se podria validar que respuesta no sea null
        RespuestaMC respuestaCorrecta = (RespuestaMC) this.correcta;

        Puntaje p = new Puntaje();

        //Puntaje lo creo aca asi cada clase de pregunta crea su propio tipo de puntaje
        if (!respuestaCorrecta.noSeleccionadasSeleccionadas(respuesta)) {
            p.sumar(respuesta.cantidadOpcionesIguales(respuestaCorrecta));
        }

        return p;
    }
}
