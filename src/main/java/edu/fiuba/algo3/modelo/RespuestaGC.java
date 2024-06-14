package edu.fiuba.algo3.modelo;

public class RespuestaGC extends Respuesta {
    private Grupo grupo1;
    private Grupo grupo2;

    public RespuestaGC(Grupo grupo1, Grupo grupo2){ //Crear metodo agregar Grupo / agregar opcion.
        this.grupo1 = grupo1;
        this.grupo2 = grupo2;
    }

    @Override
    public Boolean esIgual(Respuesta jugador) {
        RespuestaGC otraRespuesta = (RespuestaGC) jugador;

        if ( otraRespuesta == null ) {
            return false;
        }

        return (
            this.grupo1.esIgual(otraRespuesta.grupo1) &&
            this.grupo2.esIgual(otraRespuesta.grupo2)
        );
    }
}
