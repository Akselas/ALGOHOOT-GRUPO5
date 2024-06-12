package edu.fiuba.algo3.modelo;

public class RespuestaGC extends Respuesta {
    private Grupo grupo1;
    private Grupo grupo2;

    public RespuestaGC(Grupo grupo1, Grupo grupo2){
        this.grupo1 = grupo1;
        this.grupo2 = grupo2;
    }
    public Boolean esIgual(RespuestaGC otraRespuesta){//Aca deberia comparar los de su tipo
        //Devuelve true si el jugador acerto, y devuelve false si no acerto
        return (this.grupo1.esIgual(otraRespuesta.obtenerGrupo1()) && this.grupo2.esIgual(otraRespuesta.obtenerGrupo2()));
    }
    public Grupo obtenerGrupo1(){
        return grupo1;
    }
    public Grupo obtenerGrupo2(){
        return grupo2;
    }

}
