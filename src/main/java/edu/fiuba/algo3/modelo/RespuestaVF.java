package edu.fiuba.algo3.modelo;

public class RespuestaVF extends Respuesta {

    private Opcion elegida;

    public void agregarOpcion(Opcion opcion){
        this.elegida = opcion;
    }

    public Boolean esIgual(RespuestaVF otraRespuesta){//Aca deberia comparar los de su tipo
        return elegida.esIgual(otraRespuesta.obtenerOpcion());
    }

    @Override
    public Boolean esIgual(Respuesta jugador) {
        return null;
    }

    public Opcion obtenerOpcion(){
        return this.elegida;
    }
}
