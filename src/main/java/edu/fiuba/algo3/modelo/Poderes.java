package edu.fiuba.algo3.modelo;

import java.util.ArrayList;


public class Poderes{
    private ArrayList<Poder> poderes;

    public Poderes(){
        poderes = new ArrayList<>();

    }


    public boolean vacio(){
        return poderes.isEmpty();
    }

    public ArrayList<Poder> devolverPoderes() {
        return poderes;
    }

    public void agregarPoder(Poder poder){
        if(!(poder instanceof Basico)){
            poderes.add(poder);
        }
    }

    public void eliminarPoderesDuplicados(){
        ArrayList<Poder> poderesUnicos = new ArrayList<>();
        for (Poder poder : poderes) {
            boolean duplicado = false;
            for (Poder poderUnico : poderesUnicos){
                if (poder.getClass().equals(poderUnico.getClass())){//aca es cuando ya lo ve que esta duplicaod
                    duplicado = true;
                    break;
                }
            }
            if (!duplicado){
                poderesUnicos.add(poder);
            }
        }
        poderes = poderesUnicos;
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
