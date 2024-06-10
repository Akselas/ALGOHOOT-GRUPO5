package edu.fiuba.algo3.modelo;

public class PreguntaMCPenalidad {
    private String textoPregunta;
    private RespuestaMC correcta;

    public PreguntaMCPenalidad(String texto, RespuestaMC respuesta) {
        this.textoPregunta = texto;
        this.correcta = respuesta;
    }

    public Puntaje calcularPuntaje(RespuestaMC respuestaJugador){
        Puntaje p = new Puntaje(); //Puntaje lo creo aca asi cada clase de pregunta crea su propio tipo de puntaje.
        p.sumar(this.correcta.cantidadOpcionesIguales(respuestaJugador));
        p.restar(this.correcta.cantidadOpcionesDesiguales(respuestaJugador));

        return p;
    }
}
