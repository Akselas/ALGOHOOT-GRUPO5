package edu.fiuba.algo3.modelo;

public class Falso implements Respuesta {
    @Override
    public Boolean esIgual(Respuesta otraRespuesta) {
        return this.getClass() == otraRespuesta.getClass();
    }
}