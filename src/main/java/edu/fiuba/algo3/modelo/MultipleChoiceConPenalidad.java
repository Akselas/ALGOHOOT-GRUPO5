package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class MultipleChoiceConPenalidad extends Modalidad{

    @Override
    public int calcularPuntaje(HashMap<String, Boolean> respuestasJugador, HashMap<String, Boolean> respuestasCorrectas) {
        int puntaje = 0;
        for (String opcion : respuestasCorrectas.keySet()) {
            if (respuestasCorrectas.get(opcion) == respuestasJugador.get(opcion)) {
                puntaje++;
            } else {
                puntaje--;
            }
        }
        return puntaje;
    }
}
