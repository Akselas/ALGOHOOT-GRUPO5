package edu.fiuba.algo3.modelo;

public class PreguntaMCParcial {
    private String textoPregunta;
    private RespuestaMC correcta;

    public PreguntaMCParcial(String texto, RespuestaMC respuesta) {
        this.textoPregunta = texto;
        this.correcta = respuesta;
    }

    public Puntaje calcularPuntaje(RespuestaMC respuestaJugador){
        Puntaje p = new Puntaje(); //Puntaje lo creo aca asi cada clase de pregunta crea su propio tipo de puntaje
        if (!this.correcta.noSeleccionadasSeleccionadas(respuestaJugador)) {
            p.sumar(respuestaJugador.cantidadOpcionesSeleccionadas());
        }

        return p;
    }
}
