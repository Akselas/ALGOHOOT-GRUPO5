package main.java.edu.fiuba.algo3.entrega_1;

import java.util.HashMap;

public class VFConPenalidad extends Modalidad {

    @Override

    public int calcularPuntaje(HashMap<String, Boolean> respuestasJugador,
            HashMap<String, Boolean> respuestasCorrectas) {
        int puntaje = 0;
        for (String opcion : respuestasCorrectas.keyset())
            if (respuestasCorrectas.get(opcion) == respuestasJugador(opcion)) {
                puntaje++;
            } else {
                puntaje--;
            }
        return puntaje;

    }
}