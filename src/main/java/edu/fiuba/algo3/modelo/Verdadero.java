package edu.fiuba.algo3.modelo;

public class Verdadero implements Respuesta {
    @Override
    public Boolean esIgual(Respuesta otraRespuesta) {
        return this.getClass() == otraRespuesta.getClass();
    }
}
