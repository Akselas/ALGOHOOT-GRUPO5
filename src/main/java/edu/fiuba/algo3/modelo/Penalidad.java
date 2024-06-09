package edu.fiuba.algo3.modelo;

public class Penalidad implements Modalidad {
    public void modalizar(Puntaje puntaje){
        puntaje.modificar(-1);
    }
}
