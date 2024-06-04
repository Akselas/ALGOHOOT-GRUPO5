package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMCTest {
    @Test
    public void testPreguntaMCClasicoRecibeRespuestaCorrectaYAsignaPuntaje() {
        // Arrange
        int puntajeEsperado1 = 1;
        int puntajeEsperado2 = 1;

        List<HashMap<String, Boolean>> respuestas = new ArrayList<>();
        List<Jugador> jugadores = new ArrayList<>();
        HashMap<String, Boolean> opciones = new HashMap<>();
        opciones.put("Elefante", true);
        opciones.put("Araña", false);
        opciones.put("Tiburón", false);

        Modalidad clasico = new MultipleChoiceClasico();
        Pregunta pregunta = new Pregunta("Qué animales son mamíferos?", opciones, clasico);

        // Act
        Jugador jugador1 = new Jugador("j1");
        HashMap<String, Boolean> respuestasJugador1 = new HashMap<>();
        respuestasJugador1.put("Elefante", true);
        respuestasJugador1.put("Araña", false);
        respuestasJugador1.put("Tiburón", false);
        jugadores.add(jugador1);
        respuestas.add(respuestasJugador1);

        Jugador jugador2 = new Jugador("j2");
        HashMap<String, Boolean> respuestasJugador2 = new HashMap<>();
        respuestasJugador2.put("Elefante", true);
        respuestasJugador2.put("Araña", false);
        respuestasJugador2.put("Tiburón", false);
        jugadores.add(jugador2);
        respuestas.add(respuestasJugador2);

        pregunta.evaluarRespuestas(respuestas, jugadores);

        // Assert
        assertEquals(puntajeEsperado1, jugador1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, jugador2.obtenerPuntaje());
    }

    @Test
    public void testPreguntaMCClasicoRecibeRespuestaIncorrectaYAsignaPuntaje() {
        // Arrange
        int puntajeEsperado1 = 0;
        int puntajeEsperado2 = 0;

        List<HashMap<String, Boolean>> respuestas = new ArrayList<>();
        List<Jugador> jugadores = new ArrayList<>();
        HashMap<String, Boolean> opciones = new HashMap<>();
        opciones.put("Elefante", true);
        opciones.put("Araña", false);
        opciones.put("Tiburón", false);

        Modalidad clasico = new MultipleChoiceClasico();
        Pregunta pregunta = new Pregunta("Qué animales son mamíferos?", opciones, clasico);

        // Act
        Jugador jugador1 = new Jugador("j1");
        HashMap<String, Boolean> respuestasJugador1 = new HashMap<>();
        respuestasJugador1.put("Elefante", true);
        respuestasJugador1.put("Araña", false);
        respuestasJugador1.put("Tiburón", true);
        jugadores.add(jugador1);
        respuestas.add(respuestasJugador1);

        Jugador jugador2 = new Jugador("j2");
        HashMap<String, Boolean> respuestasJugador2 = new HashMap<>();
        respuestasJugador2.put("Elefante", false);
        respuestasJugador2.put("Araña", false);
        respuestasJugador2.put("Tiburón", false);
        jugadores.add(jugador2);
        respuestas.add(respuestasJugador2);

        pregunta.evaluarRespuestas(respuestas, jugadores);

        // Assert
        assertEquals(puntajeEsperado1, jugador1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, jugador2.obtenerPuntaje());
    }

    @Test
    public void testPreguntaMCConPenalidadRecibeRespuestaCorrectaYAsignaPuntaje() {
        // Arrange
        int puntajeEsperado1 = 3;
        int puntajeEsperado2 = 3;

        List<HashMap<String, Boolean>> respuestas = new ArrayList<>();
        List<Jugador> jugadores = new ArrayList<>();
        HashMap<String, Boolean> opciones = new HashMap<>();
        opciones.put("Elefante", true);
        opciones.put("Araña", false);
        opciones.put("Tiburón", false);

        Modalidad clasico = new MultipleChoiceConPenalidad();
        Pregunta pregunta = new Pregunta("Qué animales son mamíferos?", opciones, clasico);

        // Act
        Jugador jugador1 = new Jugador("j1");
        HashMap<String, Boolean> respuestasJugador1 = new HashMap<>();
        respuestasJugador1.put("Elefante", true);
        respuestasJugador1.put("Araña", false);
        respuestasJugador1.put("Tiburón", false);
        jugadores.add(jugador1);
        respuestas.add(respuestasJugador1);

        Jugador jugador2 = new Jugador("j2");
        HashMap<String, Boolean> respuestasJugador2 = new HashMap<>();
        respuestasJugador2.put("Elefante", true);
        respuestasJugador2.put("Araña", false);
        respuestasJugador2.put("Tiburón", false);
        jugadores.add(jugador2);
        respuestas.add(respuestasJugador2);

        pregunta.evaluarRespuestas(respuestas, jugadores);

        // Assert
        assertEquals(puntajeEsperado1, jugador1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, jugador2.obtenerPuntaje());
    }

    @Test
    public void testPreguntaMCConPenalidadRecibeRespuestaIncorrectaYAsignaPuntaje() {
        // Arrange
        int puntajeEsperado1 = 1;
        int puntajeEsperado2 = -3;

        List<HashMap<String, Boolean>> respuestas = new ArrayList<>();
        List<Jugador> jugadores = new ArrayList<>();
        HashMap<String, Boolean> opciones = new HashMap<>();
        opciones.put("Elefante", true);
        opciones.put("Araña", false);
        opciones.put("Tiburón", false);

        Modalidad clasico = new MultipleChoiceConPenalidad();
        Pregunta pregunta = new Pregunta("Qué animales son mamíferos?", opciones, clasico);

        // Act
        Jugador jugador1 = new Jugador("j1");
        HashMap<String, Boolean> respuestasJugador1 = new HashMap<>();
        respuestasJugador1.put("Elefante", true);
        respuestasJugador1.put("Araña", false);
        respuestasJugador1.put("Tiburón", true);
        jugadores.add(jugador1);
        respuestas.add(respuestasJugador1);

        Jugador jugador2 = new Jugador("j2");
        HashMap<String, Boolean> respuestasJugador2 = new HashMap<>();
        respuestasJugador2.put("Elefante", false);
        respuestasJugador2.put("Araña", true);
        respuestasJugador2.put("Tiburón", true);
        jugadores.add(jugador2);
        respuestas.add(respuestasJugador2);

        pregunta.evaluarRespuestas(respuestas, jugadores);

        // Assert
        assertEquals(puntajeEsperado1, jugador1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, jugador2.obtenerPuntaje());
    }
}
