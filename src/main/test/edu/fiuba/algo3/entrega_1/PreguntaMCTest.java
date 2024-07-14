package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMCTest {
    //@Test
//    public void testPreguntaMCClasicoRecibeRespuestaCorrectaYAsignaPuntaje() {
//        //Arrange
//        int puntajeEsperado1 = 1;
//
//        RespuestaMC respuestaCorrecta = new RespuestaMC();
//
//        Opcion opcion1 = new Opcion("Elefante");
//        Opcion opcion2 = new Opcion("Tiburon");
//        Opcion opcion3 = new Opcion("Pato");
//
//        respuestaCorrecta.agregarOpcionSeleccionada(opcion1);
//        respuestaCorrecta.agregarOpcionNoSeleccionada(opcion2);
//        respuestaCorrecta.agregarOpcionNoSeleccionada(opcion3);
//
//        PreguntaMC preguntaMC = new PreguntaMC("Que animal es mamifero?", new Opciones(), respuestaCorrecta);
//
//        Jugador j1 = new Jugador("Pepe");
//        RespuestaMC respuestaJugador = new RespuestaMC();
//
//        Opcion opcionJugador1 = new Opcion("Elefante");
//        Opcion opcionJugador2 = new Opcion("Tiburon");
//        Opcion opcionJugador3 = new Opcion("Pato");
//
//        respuestaJugador.agregarOpcionSeleccionada(opcionJugador1);
//        respuestaJugador.agregarOpcionNoSeleccionada(opcionJugador2);
//        respuestaJugador.agregarOpcionNoSeleccionada(opcionJugador3);
//
//        Jugadores jugadores = new Jugadores();
//        jugadores.agregarJugador(j1);
//
//        // Act
//        Puntaje puntaje = preguntaMC.calcularPuntaje(respuestaJugador);
//        j1.sumarPuntaje(puntaje);
//
//        //Assert Check implementacion antes de correrlo
//        assertEquals(puntajeEsperado1, j1.getPuntaje());
//    }
//
//    @Test
//    public void testPreguntaMCClasicoRecibeRespuestaIncorrectaYAsignaPuntaje() {
//        //Arrange
//        int puntajeEsperado1 = 0;
//
//        RespuestaMC respuestaCorrecta = new RespuestaMC();
//
//        Opcion opcion1 = new Opcion("Elefante");
//        Opcion opcion2 = new Opcion("Tiburon");
//        Opcion opcion3 = new Opcion("Pato");
//
//        respuestaCorrecta.agregarOpcionSeleccionada(opcion1);
//        respuestaCorrecta.agregarOpcionNoSeleccionada(opcion2);
//        respuestaCorrecta.agregarOpcionNoSeleccionada(opcion3);
//
//        PreguntaMC preguntaMC = new PreguntaMC("Que animal es mamifero?", new Opciones(),respuestaCorrecta);
//
//        Jugador j1 = new Jugador("Pepe");
//        RespuestaMC respuestaJugador = new RespuestaMC();
//
//        Opcion opcionJugador1 = new Opcion("Elefante");
//        Opcion opcionJugador2 = new Opcion("Tiburon");
//        Opcion opcionJugador3 = new Opcion("Pato");
//
//        respuestaJugador.agregarOpcionSeleccionada(opcionJugador2);
//        respuestaJugador.agregarOpcionNoSeleccionada(opcionJugador1);
//        respuestaJugador.agregarOpcionNoSeleccionada(opcionJugador3);
//
//        Jugadores jugadores = new Jugadores();
//        jugadores.agregarJugador(j1);
//
//        // Act
//        Puntaje puntaje = preguntaMC.calcularPuntaje(respuestaJugador);
//        j1.sumarPuntaje(puntaje);
//
//        //Assert Check implementacion antes de correrlo
//        assertEquals(puntajeEsperado1, j1.getPuntaje());
//    }
//
//    @Test
//    public void testPreguntaMCConPenalidadRecibeRespuestaCorrectaYAsignaPuntaje() {
//        //Arrange
//        int puntajeEsperado1 = 3;
//
//        RespuestaMC respuestaCorrecta = new RespuestaMC();
//
//        Opcion opcion1 = new Opcion("Elefante");
//        Opcion opcion2 = new Opcion("Tiburon");
//        Opcion opcion3 = new Opcion("Pato");
//
//        respuestaCorrecta.agregarOpcionNoSeleccionada(opcion1);
//        respuestaCorrecta.agregarOpcionSeleccionada(opcion2);
//        respuestaCorrecta.agregarOpcionSeleccionada(opcion3);
//
//        PreguntaMCPenalidad preguntaMC = new PreguntaMCPenalidad("Que animales no son mamiferos?", new Opciones() ,respuestaCorrecta);
//
//        Jugador j1 = new Jugador("Pepe");
//        RespuestaMC respuestaJugador = new RespuestaMC();
//
//        Opcion opcionJugador1 = new Opcion("Elefante");
//        Opcion opcionJugador2 = new Opcion("Tiburon");
//        Opcion opcionJugador3 = new Opcion("Pato");
//
//        respuestaJugador.agregarOpcionNoSeleccionada(opcionJugador1);
//        respuestaJugador.agregarOpcionSeleccionada(opcionJugador2);
//        respuestaJugador.agregarOpcionSeleccionada(opcionJugador3);
//
//        Jugadores jugadores = new Jugadores();
//        jugadores.agregarJugador(j1);
//
//        // Act
//        Puntaje puntaje = preguntaMC.calcularPuntaje(respuestaJugador);
//        j1.sumarPuntaje(puntaje);
//
//        //Assert Check implementacion antes de correrlo
//        assertEquals(puntajeEsperado1, j1.getPuntaje());
//    }
//
//    @Test
//    public void testPreguntaMCConPenalidadRecibeRespuestaIncorrectaYAsignaPuntaje() {
//        //Arrange
//        int puntajeEsperado1 = 1;
//
//        RespuestaMC respuestaCorrecta = new RespuestaMC();
//
//        Opcion opcion1 = new Opcion("Elefante");
//        Opcion opcion2 = new Opcion("Tiburon");
//        Opcion opcion3 = new Opcion("Pato");
//
//        respuestaCorrecta.agregarOpcionNoSeleccionada(opcion1);
//        respuestaCorrecta.agregarOpcionSeleccionada(opcion2);
//        respuestaCorrecta.agregarOpcionSeleccionada(opcion3);
//
//        PreguntaMCPenalidad preguntaMC = new PreguntaMCPenalidad("Que animales no son mamiferos?", new Opciones(), respuestaCorrecta);
//
//        Jugador j1 = new Jugador("Pepe");
//        RespuestaMC respuestaJugador = new RespuestaMC();
//
//        Opcion opcionJugador1 = new Opcion("Elefante");
//        Opcion opcionJugador2 = new Opcion("Tiburon");
//        Opcion opcionJugador3 = new Opcion("Pato");
//
//        respuestaJugador.agregarOpcionSeleccionada(opcionJugador1);
//        respuestaJugador.agregarOpcionSeleccionada(opcionJugador2);
//        respuestaJugador.agregarOpcionSeleccionada(opcionJugador3);
//
//        Jugadores jugadores = new Jugadores();
//        jugadores.agregarJugador(j1);
//
//        // Act
//        Puntaje puntaje = preguntaMC.calcularPuntaje(respuestaJugador);
//        j1.sumarPuntaje(puntaje);
//
//        //Assert Check implementacion antes de correrlo
//        assertEquals(puntajeEsperado1, j1.getPuntaje());
//    }
//
//    @Test
//    public void testPreguntaMCConPenalidadRecibeRespuestasIncorrectasYAsignaPuntaje() {
//        //Arrange
//        int puntajeEsperado1 = -1;
//
//        RespuestaMC respuestaCorrecta = new RespuestaMC();
//
//        Opcion opcion1 = new Opcion("Elefante");
//        Opcion opcion2 = new Opcion("Tiburon");
//        Opcion opcion3 = new Opcion("Pato");
//
//        respuestaCorrecta.agregarOpcionSeleccionada(opcion1);
//        respuestaCorrecta.agregarOpcionNoSeleccionada(opcion2);
//        respuestaCorrecta.agregarOpcionNoSeleccionada(opcion3);
//
//        PreguntaMCPenalidad preguntaMC = new PreguntaMCPenalidad("Que animales son mamiferos?", new Opciones() ,respuestaCorrecta);
//
//        Jugador j1 = new Jugador("Pepe");
//        RespuestaMC respuestaJugador = new RespuestaMC();
//
//        Opcion opcionJugador1 = new Opcion("Elefante");
//        Opcion opcionJugador2 = new Opcion("Tiburon");
//        Opcion opcionJugador3 = new Opcion("Pato");
//
//        respuestaJugador.agregarOpcionSeleccionada(opcionJugador1);
//        respuestaJugador.agregarOpcionSeleccionada(opcionJugador2);
//        respuestaJugador.agregarOpcionSeleccionada(opcionJugador3);
//
//        Jugadores jugadores = new Jugadores();
//        jugadores.agregarJugador(j1);
//
//        // Act
//        Puntaje puntaje = preguntaMC.calcularPuntaje(respuestaJugador);
//        j1.sumarPuntaje(puntaje);
//
//        //Assert Check implementacion antes de correrlo
//        assertEquals(puntajeEsperado1, j1.getPuntaje());
//    }

}