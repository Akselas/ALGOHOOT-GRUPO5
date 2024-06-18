package edu.fiuba.algo3.modelo;

public class Triplicador implements Poder {

    public void aplicar(Puntaje puntaje){
        puntaje.sumar(puntaje.obtenerPuntuacion() * 2);
    }
}
