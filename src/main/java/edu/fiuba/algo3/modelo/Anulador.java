package edu.fiuba.algo3.modelo;

public class Anulador extends Poder implements PoderGrupal {
    public Anulador(){
        this.nombre = "Anulador";
        this.cantidad = 1;
    }
    public void aplicar(Puntajes puntajes){
        puntajes.anularPuntajes();
        super.utilizarPoder();
    }

    @Override
    public boolean habilitarPoder(Pregunta pregunta){
        return true;
    }
}
