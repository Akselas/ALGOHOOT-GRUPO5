package edu.fiuba.algo3.modelo;

public class Exclusividad{

    public void aplicar(Puntajes puntajes){
        if(puntajes.obtenerCantidadPuntajesMayorQueCero() == 1) {
            puntajes.duplicarPuntajes();
        }
    }
}
