package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public interface Modalidad {
    public abstract int calcularPuntaje(HashMap<String, Boolean> respuestasJugador, HashMap<String, Boolean> respuestasCorrectas);
}
