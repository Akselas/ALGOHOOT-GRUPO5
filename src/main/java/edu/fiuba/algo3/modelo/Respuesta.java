package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Respuesta {
    public Boolean esIgual(Respuesta otraRespuesta){
        return this.getClass() == otraRespuesta.getClass();
    }
    //public Boolean (Respuesta otraRespuesta);
}
