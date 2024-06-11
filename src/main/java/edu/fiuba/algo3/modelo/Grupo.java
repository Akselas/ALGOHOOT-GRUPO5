package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Grupo {
    private ArrayList<String> opciones;
    public Grupo(){
        this.opciones = new ArrayList<String>();
    }
    public void agregar(String opcion){
        this.opciones.add(opcion);
    }
}
