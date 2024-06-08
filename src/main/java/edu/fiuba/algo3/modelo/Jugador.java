package edu.fiuba.algo3.modelo;

public class Jugador {
    private int puntaje; //usar clase puntaje para guardar el atributo
    final String nombre;
    private Respuesta respuesta;

    public Jugador(String nombre, Respuesta respuesta) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.respuesta = respuesta;
    }
    public Respuesta responder(){
        return this.respuesta;
    }
    public String obtenerNombre(){
        return this.nombre;
    }
    public void sumarPuntaje(Puntaje puntaje) {
        this.puntaje += puntaje.devolverPunto();
    }

    public int obtenerPuntaje() {
        return this.puntaje;
    }
}
