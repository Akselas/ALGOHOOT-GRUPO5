package edu.fiuba.algo3.modelo;

import java.lang.foreign.StructLayout;
import java.util.ArrayList;
import java.util.Objects;

public class RespuestaMC {
    private ArrayList<Opcion> opcionesSeleccionadas;
    private ArrayList<Opcion> opcionesNoSeleccionadas;

    public RespuestaMC() {
        this.opcionesSeleccionadas = new ArrayList<>();
        this.opcionesNoSeleccionadas = new ArrayList<>();
    }

    public void agregarOpcionSeleccionada(Opcion nuevaOpcion) {
        this.opcionesSeleccionadas.add(nuevaOpcion);
    }

    public void agregarOpcionNoSeleccionada(Opcion nuevaOpcion) {
        this.opcionesNoSeleccionadas.add(nuevaOpcion);
    }

    public Boolean contieneOpcionSeleccionada(Opcion otraOpcion) {
        for(Opcion opcion : this.opcionesSeleccionadas) {
            if(opcion.equals(otraOpcion)) return true;
        }
        return false;
    }

    public Boolean contieneOpcionNoSeleccionada(Opcion otraOpcion) {
        for(Opcion opcion : this.opcionesNoSeleccionadas) {
            if(opcion.equals(otraOpcion)) return true;
        }
        return false;
    }

    public Boolean esIgual(RespuestaMC otraRespuesta) {
        for(Opcion opcion : this.opcionesSeleccionadas) {
            if (otraRespuesta.contieneOpcionSeleccionada(opcion)) {
                return false;
            }
        }
        for(Opcion opcion : otraRespuesta.obtenerOpciones()) {
            if (this.opcionesNoSeleccionadas.contains(opcion)) {
                return false;
            }
        }
        return false;
    }
}
