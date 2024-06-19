package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Puntajes {
    private List<Puntaje> puntajes;

    public Puntajes() {
        this.puntajes = new ArrayList<>();
    }

    public void agregarPuntaje(Puntaje puntaje) {
        puntajes.add(puntaje);
    }

    public int obtenerCantidadPuntajesMayorQueCero() {
        int cantidad = 0;
        for (Puntaje p : puntajes) {
            if(p.obtenerPuntuacion() > 0) cantidad++;
        }
        return cantidad;
    }

    public void duplicarPuntajes() {
        for (Puntaje p : puntajes) {
            p.multiplicar(2);
        }
    }

    public void anularPuntajes() {
        for (Puntaje p : puntajes) {
            p.restar(p.obtenerPuntuacion());
        }
    }
}
