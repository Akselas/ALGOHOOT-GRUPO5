package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Puntajes {
    private HashMap<String, Puntaje> puntajes;

    public Puntajes(){
        this.puntajes = new HashMap<>();
    }
    public void agregar(Jugador jugador, Puntaje puntaje){
        this.puntajes.put(jugador.obtenerNombre(), puntaje);
    }
    public Puntaje obtenerPuntaje(Jugador jugador){
        return this.puntajes.get(jugador.obtenerNombre());
    }
}
