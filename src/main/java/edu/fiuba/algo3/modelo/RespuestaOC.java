package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class RespuestaOC extends Respuesta{
    private ArrayList<Opcion> respuesta;

    public RespuestaOC() {
        this.respuesta = new ArrayList<>();
    }

    public void agregar(Opcion opcion){
        this.respuesta.add(opcion);
    }

    public Integer largo(){
        return this.respuesta.size();
    }

    public Opcion obtenerOpcion(Integer i){
        return this.respuesta.get(i);
    }

    public Boolean esIgual(RespuestaOC otraRespuesta){
        for (int i = 0; i < this.largo(); i++) {
            if(!otraRespuesta.obtenerOpcion(i).esIgual(this.respuesta.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean esIgual(Respuesta jugador) {
        RespuestaOC otraRespuesta = (RespuestaOC) jugador;

        if (otraRespuesta == null) return false;

        for (int i = 0; i < this.largo(); i++) {
            if(!otraRespuesta.obtenerOpcion(i).esIgual(this.respuesta.get(i))){
                return false;
            }
        }
        return true;
    }
}
