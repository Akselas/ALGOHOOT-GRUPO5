package edu.fiuba.algo3.modelo;
import java.util.ArrayList;


public class Jugadores {
    private ArrayList<Jugador> jugadores;

    public Jugadores(){
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador){
        this.jugadores.add(jugador);
    }

}
