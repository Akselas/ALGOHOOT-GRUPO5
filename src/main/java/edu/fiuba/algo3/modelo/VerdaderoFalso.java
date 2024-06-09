package edu.fiuba.algo3.modelo;

public class VerdaderoFalso {
    private String texto;
    private Respuesta correcta;
    private Modalidad modalidad;

    public VerdaderoFalso(String texto, Respuesta correcta, Modalidad modalidad){
        this.texto = texto;
        this.correcta = correcta;
        this.modalidad = modalidad;
    }
    public Puntajes calcularPuntaje(Jugadores jugadores){
        Puntajes puntajes = new Puntajes();

        for(Jugador jugador : jugadores.devolverJugadores()){

            Puntaje p = new Puntaje(); //Puntaje lo creo aca asi cada clase de pregunta crea su propio tipo de puntaje.
            p.comparar(jugador.responder(),this.correcta);
            modalidad.modalizar(p);
            puntajes.agregar(jugador, p);
        }

        return puntajes;
    }
}
