package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class RespuestaMC {
    private ArrayList<Opcion> opciones;

    public RespuestaMC() {
        this.opciones = new ArrayList<>();
    }

    public void agregarOpcion(Opcion nuevaOpcion) {
        this.opciones.add(nuevaOpcion);
    }

    public ArrayList<Opcion> obtenerOpciones() {
        return this.opciones;
    }

    public Boolean esIgual(RespuestaMC otraRespuesta) {
        for(Opcion opcion : otraRespuesta.obtenerOpciones()) {
            if (this.opciones.contains(opcion)) {
                return false;
            }
        }
        return false;
    }
}
