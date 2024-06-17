package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class RespuestaMC extends Respuesta {
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
            if(opcion.esIgual(otraOpcion)) return true;
        }
        return false;
    }

    public Boolean contieneOpcionNoSeleccionada(Opcion otraOpcion) {
        for(Opcion opcion : this.opcionesNoSeleccionadas) {
            if(opcion.esIgual(otraOpcion)) return true;
        }
        return false;
    }

    public Boolean esIgual(RespuestaMC otraRespuesta) {
        for(Opcion opcion : this.opcionesSeleccionadas) {
            if (!otraRespuesta.contieneOpcionSeleccionada(opcion)) {
                return false;
            }
        }
        for(Opcion opcion : this.opcionesNoSeleccionadas) {
            if (!otraRespuesta.contieneOpcionNoSeleccionada(opcion)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean esIgual(Respuesta jugador) {
        RespuestaMC otraRespuesta = (RespuestaMC) jugador;

        if (otraRespuesta == null) return false;

        for(Opcion opcion : this.opcionesSeleccionadas) {
            if (!otraRespuesta.contieneOpcionSeleccionada(opcion)) {
                return false;
            }
        }
        for(Opcion opcion : this.opcionesNoSeleccionadas) {
            if (!otraRespuesta.contieneOpcionNoSeleccionada(opcion)) {
                return false;
            }
        }
        return true;
    }

    public int cantidadOpcionesIguales(RespuestaMC otraRespuesta){
        int iguales = 0;
        for(Opcion opcion : this.opcionesSeleccionadas) {
            if (otraRespuesta.contieneOpcionSeleccionada(opcion)) {
                iguales++;
            }
        }
        for(Opcion opcion : this.opcionesNoSeleccionadas) {
            if (otraRespuesta.contieneOpcionNoSeleccionada(opcion)) {
                iguales++;
            }
        }
        return iguales;
    }

    public int cantidadOpcionesDesiguales(RespuestaMC otraRespuesta){
        return cantidadOpcionesTotales() - cantidadOpcionesIguales(otraRespuesta);
    }

    public int cantidadOpcionesTotales() {
        return (this.opcionesSeleccionadas.size() + this.opcionesNoSeleccionadas.size());
    }

    public boolean noSeleccionadasSeleccionadas(RespuestaMC otraRespuesta){
        for(Opcion opcion : this.opcionesNoSeleccionadas) {
            if(otraRespuesta.contieneOpcionSeleccionada(opcion)) return true;
        }
        return false;
    }

    public int cantidadOpcionesSeleccionadas() {
        return this.opcionesSeleccionadas.size();
    }
}
