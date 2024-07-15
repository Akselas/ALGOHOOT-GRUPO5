package edu.fiuba.algo3.modelo;

public class RespuestaVF extends Respuesta {

    private Opcion elegida;

    public void agregarOpcion(Opcion opcion){
        this.elegida = opcion;
    }


    @Override
    public Boolean esIgual(Respuesta jugador) {

        RespuestaVF otraRespuesta = (RespuestaVF) jugador;
        if (otraRespuesta == null) return false;
        return (this.obtenerOpcion().esIgual(otraRespuesta.obtenerOpcion()));
    }

    public Opcion obtenerOpcion(){
        return this.elegida;
    }
}
