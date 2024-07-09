package edu.fiuba.algo3.modelo;

public class Basico extends Poder implements PoderIndividual{
    public Basico(){
        this.nombre = "Basico";
        this.cantidad = 99999;
    }

    public void aplicarUnico(Puntaje puntaje){

    }

    @Override
    public boolean habilitarPoder(Pregunta pregunta){
        return true;
    }
}
