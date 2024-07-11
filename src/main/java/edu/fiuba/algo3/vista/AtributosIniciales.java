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

    public AtributosIniciales(){
        nombresJugadores = new ArrayList<>();
        jugadores = new Jugadores();
    }
    // Getters y setters
    public int obtenerNumJugadores() {
        return numJugadores;
    }

    public void guardarNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public List<String> getNombres(){
        return nombresJugadores;
    }
    public void guardarJugador(String nombre){
        this.jugadores.agregarJugador(new Jugador(nombre));
    }
    public int getNumPreguntas() {
        return numPreguntas;
    }

    public void guardarNumPreguntas(int numPreguntas) {
        this.numPreguntas = numPreguntas;
    }

    public int getPuntajeParaGanar() {
        return puntajeParaGanar;
    }

    public void setPuntajeParaGanar(int puntajeParaGanar) {
        this.puntajeParaGanar = puntajeParaGanar;
    }
}
