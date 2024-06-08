package edu.fiuba.algo3.entrega_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modalidad;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.VFClasico;
import edu.fiuba.algo3.modelo.VFConPenalidad;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VFTest {

    @Test
    public void test01UnaPreguntaVFRecibeUnaListaDeRespuestasYAsignaCorrectamenteElPuntaje() {
        /*VerdadFalso p = VerdadFalse("Pregunta?", new Verdadero("opt1"), new Falso("opt2"));

        Puntaje x = p.respuesta( new Respuesta("opt2"));
        */
        //Arrange
        int puntajeEsperado1 = 1;
        int puntajeEsperado2 = 1;

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("El tomate es una fruta?", new Respuesta("si"));

        Jugador j1 = new Jugador("Pepe", new Respuesta("si"));
        Jugador j2 = new Jugador("Sandra", new Respuesta("si"));

        Jugadores jugadores = new Jugadores();
        jugadores.agregarJugador(j1);
        jugadores.agregarJugador(j2);

        // Act
        Puntajes puntajes = verdaderoFalso.calcularPuntaje(jugadores);
        jugadores.asignarPuntajes(puntajes);

        //Assert Check implementacion antes de correrlo
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, j2.obtenerPuntaje());

    }

    @Test
    public void test02UnaPreguntaVFRecibeUnaListaDeRespuestasAsignaCorrectamenteElPuntajeAQuienesFallaron() {
        // Arrange
        int puntajeEsperado1 = 0;
        int puntajeEsperado2 = 0;
        Modalidad vfClasico = new VFClasico();
        HashMap<String, Boolean> opciones = new HashMap<>();
        List<Jugador> jugadores = new ArrayList<>();
        List<HashMap<String, Boolean>> respuestas = new ArrayList<>();

        opciones.put("Paris es la capital de Francia?", true);
        Pregunta pregunta = new Pregunta("Paris es la capital de Francia?", opciones, vfClasico);

        Jugador j1 = new Jugador("Axel");
        HashMap<String, Boolean> respuestaJ1 = new HashMap<>();
        respuestaJ1.put("Paris es la capital de Francia?", false);
        jugadores.add(j1);
        respuestas.add(respuestaJ1);

        Jugador j2 = new Jugador("Dani");
        HashMap<String, Boolean> respuestaJ2 = new HashMap<>();
        respuestaJ2.put("Paris es la capital de Francia?", false);
        jugadores.add(j2);
        respuestas.add(respuestaJ2);

        // Act
        pregunta.evaluarRespuestas(respuestas, jugadores);

        // Assert
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, j2.obtenerPuntaje());

    }

    @Test
    public void test03UnaPreguntaDeVFConPenalidadAsignaCorrectamenteElPuntaje() {

        int puntajeEsperado1 = 1;
        int puntajeEsperado2 = 1;
        Modalidad vfConPenalidad = new VFConPenalidad();
        HashMap<String, Boolean> opciones = new HashMap<>();
        List<Jugador> jugadores = new ArrayList<>();
        List<HashMap<String, Boolean>> respuestas = new ArrayList<>();

        opciones.put("Paris es la capital de Francia?", true);
        Pregunta pregunta = new Pregunta("Paris es la capital de Francia?", opciones, vfConPenalidad);

        Jugador j1 = new Jugador("Axel");
        HashMap<String, Boolean> respuestaJ1 = new HashMap<>();
        respuestaJ1.put("Paris es la capital de Francia?", true);
        jugadores.add(j1);
        respuestas.add(respuestaJ1);

        Jugador j2 = new Jugador("Dani");
        HashMap<String, Boolean> respuestaJ2 = new HashMap<>();
        respuestaJ2.put("Paris es la capital de Francia?", true);
        jugadores.add(j2);
        respuestas.add(respuestaJ2);

        // Act
        pregunta.evaluarRespuestas(respuestas, jugadores);

        // Assert
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, j2.obtenerPuntaje());

    }

    @Test
    public void test04UnaPreguntaDeVFConPenalidadAsignaCorrectamenteElPuntaje() {
        int puntajeEsperado1 = -1;
        int puntajeEsperado2 = -1;
        Modalidad vfConPenalidad = new VFConPenalidad();
        HashMap<String, Boolean> opciones = new HashMap<>();
        List<Jugador> jugadores = new ArrayList<>();
        List<HashMap<String, Boolean>> respuestas = new ArrayList<>();

        opciones.put("Paris es la capital de Francia?", true);
        Pregunta pregunta = new Pregunta("Paris es la capital de Francia?", opciones, vfConPenalidad);

        Jugador j1 = new Jugador("Axel");
        HashMap<String, Boolean> respuestaJ1 = new HashMap<>();
        respuestaJ1.put("Paris es la capital de Francia?", false);
        jugadores.add(j1);
        respuestas.add(respuestaJ1);

        Jugador j2 = new Jugador("Dani");
        HashMap<String, Boolean> respuestaJ2 = new HashMap<>();
        respuestaJ2.put("Paris es la capital de Francia?", false);
        jugadores.add(j2);
        respuestas.add(respuestaJ2);

        // Act
        pregunta.evaluarRespuestas(respuestas, jugadores);

        // Assert
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, j2.obtenerPuntaje());

    }
}
