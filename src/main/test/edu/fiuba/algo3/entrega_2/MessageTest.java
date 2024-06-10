package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    @Test
    public void test01JugadorRespondeCorrectamenteUnaPreguntaOC() {
        //Arrange
        int puntajeEsperado1 = 1;

        PreguntaOC preguntaOC = new PreguntaOC("Ordenar cronologicamente:", new RespuestaOC(new Opcion[]{new Opcion("El hombre llega a la luna"), new Opcion("Se abre la UBA"), new Opcion("Messi gana un mundial")}));

        Jugador j1 = new Jugador("Pepe");
        j1.agregarRespuesta(new Verdadero());

        Jugadores jugadores = new Jugadores();
        jugadores.agregarJugador(j1);

        // Act
        Puntajes puntajes = preguntaOC.calcularPuntaje(jugadores);
        jugadores.asignarPuntajes(puntajes);

        //Assert Check implementacion antes de correrlo
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
    }


}
