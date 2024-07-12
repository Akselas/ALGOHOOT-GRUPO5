package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.PreguntaVF;
import edu.fiuba.algo3.modelo.*;
public class ControladorFactory {

    public ControladorPregunta crearControlador(Pregunta pregunta, Jugador jugador) {
        if (pregunta instanceof PreguntaVF|| pregunta instanceof PreguntaVFPenalidad) {
            return new ControladorVF(pregunta, jugador);
        } else if (pregunta instanceof PreguntaMC
                || pregunta instanceof PreguntaMCParcial
                || pregunta instanceof PreguntaMCPenalidad ) {
            return new ControladorMC(pregunta, jugador);

        } else if (pregunta instanceof PreguntaGC) {
            return new ControladorGC(pregunta, jugador);
        } else if (pregunta instanceof  PreguntaOC) {
            return new ControladorOC(pregunta, jugador);
        }
         else {
            throw new IllegalArgumentException("Tipo de pregunta desconocido La clase pregunta fue: "+pregunta.getClass());
        }
    }}
