package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Poderes{
    private ArrayList<Poder> poderes;

    public Poderes(){
        poderes = new ArrayList<>();

    }


    public ArrayList<Poder> devolverPoderes() {
        return poderes;
    }

    public void agregarPoder(Poder poder){
        if(!this.yaAgregado(poder)){
            poderes.add(poder);
        }
    }
    private boolean yaAgregado(Poder poder) {
        for (Poder p : poderes) {
            if (p.getClass().equals(poder.getClass())) {
                return true;
            }
        }
        return false;
    }

    public void aplicarPoderesGrupales(Puntajes puntajes){
        for(Poder poder: poderes){
            if(poder instanceof PoderGrupal){
                ((PoderGrupal) poder).aplicar(puntajes);
            }
        }
    }

    public static void verificarPoder(Poder poderSeleccionado, Puntaje puntaje ){
        if(poderSeleccionado instanceof PoderIndividual){
            PoderIndividual poder = (PoderIndividual) poderSeleccionado;
            poder.aplicarUnico(puntaje);
        }
    }
}
