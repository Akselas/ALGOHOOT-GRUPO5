package edu.fiuba.algo3.modelo;

public class Duplicador extends Poder implements PoderIndividual{

    public Duplicador(){
        this.nombre = "Duplicador";
        this.cantidad = 2;
    }

    public void aplicarUnico(Puntaje puntaje){
        puntaje.multiplicar(2);
        super.utilizarPoder();
    }

    @Override
    public boolean habilitarPoder(Pregunta pregunta){
        return pregunta instanceof PreguntaMCPenalidad || pregunta instanceof PreguntaVFPenalidad;
    }

}
