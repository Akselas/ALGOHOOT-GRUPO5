package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Opciones implements Iterable<Opcion> {
    private final ArrayList<Opcion> opciones;

    public Opciones() {
        this.opciones = new ArrayList<>();
    }

    public void agregarOpcion(Opcion opcion) {
        this.opciones.add(opcion);
    }

    @Override
    public Iterator<Opcion> iterator() {
        return opciones.iterator();
    }

    public ArrayList<Opcion> devolverOpciones(){
        return opciones;
    }
}
