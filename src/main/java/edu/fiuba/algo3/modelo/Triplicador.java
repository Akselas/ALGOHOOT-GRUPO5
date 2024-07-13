package edu.fiuba.algo3.modelo;

public class Triplicador extends Poder implements PoderIndividual{
    public Triplicador(){
        this.nombre = "Triplicador";
        this.cantidad = 2;
    }


    public void aplicarUnico(Puntaje puntaje){
        puntaje.multiplicar(3);
        super.utilizarPoder();
    }

    @Override
    public boolean habilitarPoder(Pregunta pregunta){
        return pregunta instanceof PreguntaMCPenalidad || pregunta instanceof PreguntaVFPenalidad;
    }
}
