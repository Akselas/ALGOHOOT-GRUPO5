package edu.fiuba.algo3.modelo;

public class PreguntaMC {
    private String textoPregunta;
    private Respuesta correcta;
    private Modalidad modalidad;

    public PreguntaMC(String texto, Modalidad modalidad) {
        this.textoPregunta = texto;
        this.modalidad = modalidad;
    }

    public Puntajes calcularPuntaje(Jugadores jugadores){
        Puntajes puntajes = new Puntajes();

        for(Jugador jugador : jugadores.devolverJugadores()){

            Puntaje p = new Puntaje(); //Puntaje lo creo aca asi cada clase de pregunta crea su propio tipo de puntaje.
            if(this.correcta.esIgual(jugador.responder())) {
                p.sumar();
            }
            puntajes.agregar(jugador, p);

        }
        return puntajes;
    }
}
