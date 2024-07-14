package edu.fiuba.algo3.vista;

import javafx.scene.control.TextField;
import edu.fiuba.algo3.modelo.*;
import java.util.ArrayList;
import java.util.List;

public class AtributosIniciales {
    private int numJugadores;
    private ArrayList<String> nombresJugadores;
    private int numPreguntas;
    private int puntajeParaGanar;
    private Jugadores jugadores;
    private List<Pregunta> preguntas;

    public AtributosIniciales(){
        nombresJugadores = new ArrayList<>();
        jugadores = new Jugadores();
    }
    // Getters y setters
    public int obtenerNumJugadores() {
        return numJugadores;
    }
    public void setCantidadDePreguntas(int cant){
        numPreguntas = cant;
    }
    public void guardarNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public void guardarJugador(String nombre){
        this.jugadores.agregarJugador(new Jugador(nombre));
    }

    public boolean hayGanador(){
        return jugadores.algunoSuperaPuntaje(puntajeParaGanar);
    }
    public String obtenerGanador(){return jugadores.obtenerJugadorConMayorPuntaje();}

    public int getNumPreguntas() {
        return numPreguntas;
    }

    public Jugadores getJugadores(){
        return jugadores;
    }

    public int getPuntajeParaGanar() {
        return puntajeParaGanar;
    }

    public void setPuntajeParaGanar(int puntajeParaGanar) {
        this.puntajeParaGanar = puntajeParaGanar;
    }

    public void guardarPreguntas(List<Pregunta> preguntas){
        this.preguntas = preguntas;
    }
    public Pregunta getPreguntaAleatoria(){
        return this.preguntas.remove(0);
    }
}
