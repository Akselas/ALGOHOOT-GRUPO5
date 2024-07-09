package edu.fiuba.algo3.modelo;

public class Exclusividad extends Poder implements PoderGrupal {

    public Exclusividad(){
        this.nombre = "Exclusividad";
        this.cantidad = 1;
    }

    @Override
    public boolean habilitarPoder(Pregunta pregunta){
        return !(pregunta instanceof PreguntaMCPenalidad || pregunta instanceof PreguntaVFPenalidad);
    }


    public void aplicar(Puntajes puntajes){
        if(puntajes.haySoloUnaCorrecta()) {
            puntajes.duplicarPuntajes();
            return;
        }
        puntajes.anularPuntajes();//Si dos o mas jugadores aciertan entonces no se otorgan puntos
        super.utilizarPoder();
    }
}
