package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Grupo {
    private ArrayList<Opcion> opciones;
    public Grupo(){
        this.opciones = new ArrayList<Opcion>();
    }
    public void agregar(Opcion opcion){
        this.opciones.add(opcion);
    }
    public Boolean esIgual(Grupo otroGrupo){
        for(Opcion opcion: this.opciones){
            if(!otroGrupo.opcionIncluida(opcion)){
                return false;
            }
        }
        return true;
    }
    public Boolean opcionIncluida(Opcion otra){
        for(Opcion opcion: this.opciones){
            if(opcion.esIgual(otra)){
                return true;
            }
        }
        return false;
    }
}

/*public class Grupo {
    private ArrayList<String> opciones;
    public Grupo(){
        this.opciones = new ArrayList<String>();
    }
    public void agregar(String opcion){
        this.opciones.add(opcion);
    }
}*/
