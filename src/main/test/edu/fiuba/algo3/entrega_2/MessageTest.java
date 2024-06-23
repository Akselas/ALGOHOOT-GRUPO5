package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    @Test
    public void test01JugadorRespondeCorrectamenteUnaPreguntaOC() {
        //Arrange
        int puntajeEsperado1 = 1;

        RespuestaOC respuestaCorrecta = new RespuestaOC();

        respuestaCorrecta.agregar(new Opcion("El hombre llegó la luna"));
        respuestaCorrecta.agregar(new Opcion("Abrió la UBA"));
        respuestaCorrecta.agregar(new Opcion("Messi ganó un mundial"));

        PreguntaOC preguntaOC = new PreguntaOC("Ordenar cronologicamente:", new Opciones(), respuestaCorrecta);

        Jugador j1 = new Jugador("Pepe");
        RespuestaOC respuestaJugador = new RespuestaOC();

        respuestaJugador.agregar(new Opcion("El hombre llegó la luna"));
        respuestaJugador.agregar(new Opcion("Abrió la UBA"));
        respuestaJugador.agregar(new Opcion("Messi ganó un mundial"));

        Jugadores jugadores = new Jugadores();
        jugadores.agregarJugador(j1);

        // Act
        Puntaje puntaje = preguntaOC.calcularPuntaje(respuestaJugador);
        j1.sumarPuntaje(puntaje);

        //Assert Check implementacion antes de correrlo
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
    }

    @Test
    public void test02JugadorRespondeIncorrectamenteUnaPreguntaOC() {
        //Arrange
        int puntajeEsperado1 = 0;

        RespuestaOC respuestaCorrecta = new RespuestaOC();

        respuestaCorrecta.agregar(new Opcion("El hombre llegó la luna"));
        respuestaCorrecta.agregar(new Opcion("Abrió la UBA"));
        respuestaCorrecta.agregar(new Opcion("Messi ganó un mundial"));

        PreguntaOC preguntaOC = new PreguntaOC("Ordenar cronologicamente:", new Opciones(), respuestaCorrecta);

        Jugador j1 = new Jugador("Pepe");
        RespuestaOC respuestaJugador = new RespuestaOC();

        respuestaJugador.agregar(new Opcion("Abrió la UBA"));
        respuestaJugador.agregar(new Opcion("El hombre llegó la luna"));
        respuestaJugador.agregar(new Opcion("Messi ganó un mundial"));

        // Act
        Puntaje puntaje = preguntaOC.calcularPuntaje(respuestaJugador);
        j1.sumarPuntaje(puntaje);

        //Assert Check implementacion antes de correrlo
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
    }

    @Test
    public void testPreguntaMCParcialRecibeRespuestasCorrectasYAsignaPuntaje() {
        //Arrange
        int puntajeEsperado1 = 1;

        RespuestaMC respuestaCorrecta = new RespuestaMC();

        respuestaCorrecta.agregarOpcionSeleccionada(new Opcion("Elefante"));
        respuestaCorrecta.agregarOpcionNoSeleccionada(new Opcion("Tiburon"));
        respuestaCorrecta.agregarOpcionNoSeleccionada(new Opcion("Pato"));

        PreguntaMCParcial preguntaMC = new PreguntaMCParcial("Que animales son mamiferos?", new Opciones(), respuestaCorrecta);

        Jugador j1 = new Jugador("Pepe");
        RespuestaMC respuestaJugador = new RespuestaMC();

        respuestaJugador.agregarOpcionSeleccionada(new Opcion("Elefante"));
        respuestaJugador.agregarOpcionNoSeleccionada(new Opcion("Tiburon"));
        respuestaJugador.agregarOpcionNoSeleccionada(new Opcion("Pato"));

        Jugadores jugadores = new Jugadores();
        jugadores.agregarJugador(j1);

        // Act
        Puntaje puntaje = preguntaMC.calcularPuntaje(respuestaJugador);
        j1.sumarPuntaje(puntaje);

        //Assert Check implementacion antes de correrlo
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
    }

    @Test
    public void testPreguntaMCParcialRecibeRespuestasIncorrectasYAsignaPuntaje() {
        //Arrange
        int puntajeEsperado1 = 0;

        RespuestaMC respuestaCorrecta = new RespuestaMC();

        Opcion opcion1 = new Opcion("Elefante");
        Opcion opcion2 = new Opcion("Tiburon");
        Opcion opcion3 = new Opcion("Pato");

        respuestaCorrecta.agregarOpcionSeleccionada(opcion1);
        respuestaCorrecta.agregarOpcionNoSeleccionada(opcion2);
        respuestaCorrecta.agregarOpcionNoSeleccionada(opcion3);

        PreguntaMCParcial preguntaMC = new PreguntaMCParcial("Que animales son mamiferos?", new Opciones(), respuestaCorrecta);

        Jugador j1 = new Jugador("Pepe");
        RespuestaMC respuestaJugador = new RespuestaMC();

        Opcion opcionJugador1 = new Opcion("Elefante");
        Opcion opcionJugador2 = new Opcion("Tiburon");
        Opcion opcionJugador3 = new Opcion("Pato");

        respuestaJugador.agregarOpcionSeleccionada(opcionJugador1);
        respuestaJugador.agregarOpcionSeleccionada(opcionJugador2);
        respuestaJugador.agregarOpcionNoSeleccionada(opcionJugador3);

        Jugadores jugadores = new Jugadores();
        jugadores.agregarJugador(j1);

        // Act
        Puntaje puntaje = preguntaMC.calcularPuntaje(respuestaJugador);
        j1.sumarPuntaje(puntaje);

        //Assert Check implementacion antes de correrlo
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
    }

}
