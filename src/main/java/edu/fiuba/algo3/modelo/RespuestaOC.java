package edu.fiuba.algo3.modelo;

public class RespuestaOC implements Respuesta{
    private Opcion[] respuesta;
    public RespuestaOC(Opcion[] respuesta){
        this.respuesta = respuesta;
    }
    public Integer largo(){return respuesta.length;}

    public Opcion obtenerOpcion(Integer i){
        return respuesta[i];
    }

}
