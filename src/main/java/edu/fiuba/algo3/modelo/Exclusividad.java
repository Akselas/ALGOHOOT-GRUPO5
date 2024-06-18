package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Exclusividad{

    public void aplicar(ArrayList<Puntaje> puntajes){
        int cantidadCorrectas = 0;
        Puntaje puntajeAMultiplicar = new Puntaje();

        for(Puntaje p : puntajes){
            if(p.obtenerPuntuacion() > 0) {
                cantidadCorrectas++;
                puntajeAMultiplicar = p;
            }
        }

        if(cantidadCorrectas == 1) {
            puntajeAMultiplicar.sumar(puntajeAMultiplicar.obtenerPuntuacion());
        }
    }
}
