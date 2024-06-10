package edu.fiuba.algo3.modelo;

public class PreguntaMC {
    private String textoPregunta;
    private RespuestaMC correcta;
    private Modalidad modalidad;

    public PreguntaMC(String texto, Modalidad modalidad) {
        this.textoPregunta = texto;
        this.modalidad = modalidad;
    }

    public Puntaje compararRespuesta(RespuestaMC respuestaJugador){
        Puntaje p = new Puntaje(); //Puntaje lo creo aca asi cada clase de pregunta crea su propio tipo de puntaje.
        if(this.correcta.esIgual(respuestaJugador)) {
            p.sumar();
        }
        puntajes.agregar(jugador, p);
        return p;
    }
}
