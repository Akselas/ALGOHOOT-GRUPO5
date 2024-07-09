package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Poderes{
    private ArrayList<Poder> poderes;

    public Poderes(){
        poderes = new ArrayList<>();
        poderes.add(new Duplicador());
        poderes.add(new Triplicador());
        poderes.add(new Anulador());
        poderes.add(new Exclusividad());
    }


    public ArrayList<Poder> devolverPoderes() {
        return poderes;
    }

    /* private Poder buscarPoder(Poder poder){
        for(Poder poderAux: poderes){
            if(poderAux.getClass().equals(poder.getClass())){
                return poderAux;
            }
        }
        return null;
    }*/

}
