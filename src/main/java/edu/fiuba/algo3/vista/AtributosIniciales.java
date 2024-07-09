package edu.fiuba.algo3.vista;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class AtributosIniciales {
    private int numJugadores;
    private ArrayList<String> nombresJugadores;
    private int numPreguntas;
    private int puntajeParaGanar;

    public AtributosIniciales(){
        nombresJugadores = new ArrayList<>();
    }
    // Getters y setters
    public int obtenerNumJugadores() {
        return numJugadores;
    }

    public void guardarNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }


    public void guardarNombres(List<TextField> jugadores){
        for(int i=0; i<jugadores.size(); i++){
            nombresJugadores.add(jugadores.get(i).getText());
        }
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
