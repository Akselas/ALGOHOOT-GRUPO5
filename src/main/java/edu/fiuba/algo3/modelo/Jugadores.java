package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;


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

    public Iterator<Jugador> iterador() {
        return jugadores.iterator();
    }

    public String obtenerJugadorConMayorPuntaje(){
        int maximo = 0;
        String nombreDelMayor = "";
        for (Jugador j : jugadores){
            if(j.getPuntaje() >= maximo){
                maximo = j.getPuntaje();
                nombreDelMayor = j.getNombre();
            }
        }
        return nombreDelMayor;
    }
}
