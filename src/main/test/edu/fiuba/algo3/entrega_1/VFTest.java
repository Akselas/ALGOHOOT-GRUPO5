package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador;

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

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("El tomate es una fruta?", new Verdadero(), new Clasico());

        Jugador j1 = new Jugador("Pepe");
        j1.agregarRespuesta(new Verdadero());
        Jugador j2 = new Jugador("Sandra");
        j2.agregarRespuesta(new Verdadero());

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

        //Arrange
        int puntajeEsperado1 = 0;
        int puntajeEsperado2 = 0;
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("El tomate es una fruta?", new Verdadero(), new Clasico());
        Jugador j1 = new Jugador("Pepe");
        j1.agregarRespuesta(new Falso());
        Jugador j2 = new Jugador("Sandra");
        j2.agregarRespuesta(new Falso());

        Jugadores jugadores = new Jugadores();
        jugadores.agregarJugador(j1);
        jugadores.agregarJugador(j2);

        //Act
        Puntajes puntajes = verdaderoFalso.calcularPuntaje(jugadores);
        jugadores.asignarPuntajes(puntajes);

        // Assert
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, j2.obtenerPuntaje());

    }

    @Test
    public void test03UnaPreguntaDeVFConPenalidadAsignaCorrectamenteElPuntaje() {

        //Arrange
        int puntajeEsperado1 = 1;
        int puntajeEsperado2 = 1;
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("El tomate es una fruta?", new Verdadero(), new Penalidad());

        Jugador j1 = new Jugador("Pablo");
        j1.agregarRespuesta(new Verdadero());
        Jugador j2 = new Jugador("Maria");
        j2.agregarRespuesta(new Verdadero());

        Jugadores jugadores = new Jugadores();
        jugadores.agregarJugador(j1);
        jugadores.agregarJugador(j2);

        // Act
        Puntajes puntajes = verdaderoFalso.calcularPuntaje(jugadores);
        jugadores.asignarPuntajes(puntajes);

        // Assert
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, j2.obtenerPuntaje());

    }

    @Test
    public void test04UnaPreguntaDeVFConPenalidadAsignaCorrectamenteElPuntaje() {

        //Arrange
        int puntajeEsperado1 = -1;
        int puntajeEsperado2 = -1;

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("El tomate es una fruta?", new Verdadero(), new Penalidad());

        Jugador j1 = new Jugador("Pablo");
        j1.agregarRespuesta(new Falso());
        Jugador j2 = new Jugador("Maria");
        j2.agregarRespuesta(new Falso());

        Jugadores jugadores = new Jugadores();
        jugadores.agregarJugador(j1);
        jugadores.agregarJugador(j2);

        // Act
        Puntajes puntajes = verdaderoFalso.calcularPuntaje(jugadores);
        jugadores.asignarPuntajes(puntajes);

        // Assert
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, j2.obtenerPuntaje());

    }

}
