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

        Opcion opcion1 = new Opcion("El hombre llegó la luna");
        Opcion opcion2 = new Opcion("Abrió la UBA");
        Opcion opcion3 = new Opcion("Messi ganó un mundial");

        respuestaCorrecta.agregar(opcion1);
        respuestaCorrecta.agregar(opcion2);
        respuestaCorrecta.agregar(opcion3);

        PreguntaOC preguntaOC = new PreguntaOC("Ordenar cronologicamente:", respuestaCorrecta);


        Jugador j1 = new Jugador("Pepe");
        RespuestaOC respuestaJugador = new RespuestaOC();

        Opcion opcionJugador1 = new Opcion("El hombre llegó la luna");
        Opcion opcionJugador2 = new Opcion("Abrió la UBA");
        Opcion opcionJugador3 = new Opcion("Messi ganó un mundial");

        respuestaJugador.agregar(opcionJugador1);
        respuestaJugador.agregar(opcionJugador2);
        respuestaJugador.agregar(opcionJugador3);

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

        Opcion opcion1 = new Opcion("El hombre llegó la luna");
        Opcion opcion2 = new Opcion("Abrió la UBA");
        Opcion opcion3 = new Opcion("Messi ganó un mundial");

        respuestaCorrecta.agregar(opcion1);
        respuestaCorrecta.agregar(opcion2);
        respuestaCorrecta.agregar(opcion3);

        PreguntaOC preguntaOC = new PreguntaOC("Ordenar cronologicamente:", respuestaCorrecta);

        Jugador j1 = new Jugador("Pepe");
        RespuestaOC respuestaJugador = new RespuestaOC();

        Opcion opcionJugador2 = new Opcion("El hombre llegó la luna");
        Opcion opcionJugador1 = new Opcion("Abrió la UBA");
        Opcion opcionJugador3 = new Opcion("Messi ganó un mundial");

        respuestaJugador.agregar(opcionJugador1);
        respuestaJugador.agregar(opcionJugador2);
        respuestaJugador.agregar(opcionJugador3);

        // Act
        Puntaje puntaje = preguntaOC.calcularPuntaje(respuestaJugador);
        j1.sumarPuntaje(puntaje);

        //Assert Check implementacion antes de correrlo
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
    }


}
