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

    public boolean algunoSuperaPuntaje(int numero){
        for (Jugador j : jugadores){
            if(j.getPuntaje() >= numero){
                return true;
            }
        }
        return false;
    }

    public void actualizarPuntajes(){
        for(Jugador jugador: jugadores){
            jugador.actualizarPuntaje();
        }
    }
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
}
