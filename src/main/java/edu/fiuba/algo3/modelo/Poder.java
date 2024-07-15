package edu.fiuba.algo3.modelo;

public abstract class Poder {
    protected String nombre;
    protected int cantidad;



    public String obtenerNombre(){return nombre;}

    public int obtenerCantidad(){return cantidad;}

    protected void utilizarPoder(){
        cantidad--;
    }
    public abstract boolean habilitarPoder(Pregunta pregunta);










    /*void aplicar(Puntaje puntaje);
    String obtenerNombre();
    int obtenerCantidad();
    boolean habilitarPoder(Pregunta pregunta);
    void utilizarPoder();*/
}
