package edu.fiuba.algo3.modelo;

public class GroupChoice {
    private String texto;
    private RespuestaGC correcta;
    public GroupChoice(String texto, RespuestaGC correcta){
        this.texto = texto;
        this.correcta = correcta;
    }

    public Puntajes calcularPuntaje(Jugadores jugadores){
        Puntajes puntajes = new Puntajes();
        for(Jugador jugador : jugadores.devolverJugadores()){
            Puntaje p = new Puntaje();
            //this.modalidad.modalizar(p, jugador.responder().esIgual(correcta));
            puntajes.agregar(jugador, p);
        }
        return puntajes;
    }
}
