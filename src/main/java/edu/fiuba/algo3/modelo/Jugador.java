package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private Puntaje puntaje; //usar clase puntaje para guardar el atributo
    final String nombre;
    private Poderes poderes;
    private Respuesta respuesta;
    private Puntaje puntajeRonda;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntaje();
        this.puntajeRonda = new Puntaje();
        this.poderes = new Poderes();
    }

    public void agregarRespuesta(Respuesta respuesta){
        this.respuesta = respuesta;
    }


    public String getNombre(){
        return this.nombre;
    }

    public void sumarPuntaje(Puntaje puntaje) {
        this.puntaje.sumar(puntaje);
    }

    public int getPuntaje() {
        return this.puntaje.obtenerPuntuacion();
    }

    public ArrayList<Poder> obtenerPoderes(){
        return poderes.devolverPoderes();
    }

    public void cargarPuntajeRonda(Puntaje puntaje){
        this.puntajeRonda = puntaje;
    }

    public void actualizarPuntaje(){
        sumarPuntaje(puntajeRonda);
    }
}
