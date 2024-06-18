package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Anulador {
    public void aplicar(ArrayList<Puntaje> puntajes){
        for(Puntaje puntaje: puntajes){
            puntaje.restar(puntaje.obtenerPuntuacion());
        }
    }
}
