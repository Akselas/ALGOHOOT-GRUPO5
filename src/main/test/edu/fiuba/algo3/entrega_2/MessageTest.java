package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    @Test
    public void test01() {
        //Arrange
        int puntajeEsperado1 = 1;

        OrderedChoice orderedChoice = new OrderedChoice("El tomate es una fruta?", new Verdadero(), new Clasico());

        Jugador j1 = new Jugador("Pepe");
        j1.agregarRespuesta(new Verdadero());

        Jugadores jugadores = new Jugadores();
        jugadores.agregarJugador(j1);

        // Act
        Puntajes puntajes = verdaderoFalso.calcularPuntaje(jugadores);
        jugadores.asignarPuntajes(puntajes);

        //Assert Check implementacion antes de correrlo
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
    }


}
