package edu.fiuba.algo3.modelo;

public class Duplicador implements Poder {

    public void aplicar(Puntaje puntaje){
        puntaje.sumar(puntaje.obtenerPuntuacion());
    }
}
