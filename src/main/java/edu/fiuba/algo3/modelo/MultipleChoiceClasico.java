package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class MultipleChoiceClasico implements Modalidad{

    @Override
    public int calcularPuntaje(HashMap<String, Boolean> respuestasJugador, HashMap<String, Boolean> respuestasCorrectas) {
        for (String opcion : respuestasCorrectas.keySet()) {
            if (respuestasCorrectas.get(opcion) != respuestasJugador.get(opcion)) {
                return 0;
            }
        }
        return 1;
    }
}
