package edu.fiuba.algo3.modelo;

public class RespuestaGC extends Respuesta {
    private Grupo grupo1;
    private Grupo grupo2;

    public RespuestaGC(Grupo grupo1, Grupo grupo2){ //Crear metodo agregar Grupo / agregar opcion.
        this.grupo1 = grupo1;
        this.grupo2 = grupo2;
    }
    public Boolean esIgual(RespuestaGC otraRespuesta){
        //Devuelve true si el jugador acerto, y devuelve false si no acerto
        return (this.grupo1.esIgual(otraRespuesta.obtenerGrupo1()) && this.grupo2.esIgual(otraRespuesta.obtenerGrupo2()));
    }
    public Grupo obtenerGrupo1(){
        return grupo1;
    }
    public Grupo obtenerGrupo2(){
        return grupo2;
    }

    @Override
    public Boolean esIgual(Respuesta respuestaJugador) {
        RespuestaGC respuesta = (RespuestaGC) respuestaJugador;

        if ( respuesta == null ) {
            return false;
        }

        return (
            this.grupo1.esIgual(respuesta.grupo1) &&
            this.grupo2.esIgual(respuesta.grupo2)
        );
    }

}
