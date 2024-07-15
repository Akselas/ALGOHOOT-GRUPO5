package edu.fiuba.algo3.modelo;

public class Exclusividad extends Poder implements PoderGrupal {

    public Exclusividad(){
        this.nombre = "Exclusividad";
        cantidad = 1;
    }

    @Override
    public boolean habilitarPoder(Pregunta pregunta){
        return !(pregunta instanceof PreguntaMCPenalidad || pregunta instanceof PreguntaVFPenalidad);
    }


    public void aplicar(Puntajes puntajes){
        puntajes.exclusividadPuntajes();
        super.utilizarPoder();
    }
}
