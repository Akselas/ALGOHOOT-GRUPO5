package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    @Test
    public void test10UnaPreguntaGroupChoiceAsignaCorrectamenteElPuntajeAQuienesAcertaron(){

        //Arrange
        int puntajeEsperado = 1;
        Grupo frutas = new Grupo();
        frutas.agregar("tomate");
        frutas.agregar("mandarina");
        frutas.agregar("manzana");

        Grupo verduras = new Grupo();
        verduras.agregar("cebolla");
        verduras.agregar("lechuga");
        verduras.agregar("zanahoria");
        RespuestaGC correcta = new RespuestaGC(frutas, verduras);

        GroupChoice groupChoice = new GroupChoice("Grupo A: Frutas, Grupo B: Verduras", correcta);
        Jugador j1 = new Jugador("Pepe");

        Grupo r1_g1 = new Grupo();
        r1_g1.agregar("tomate");
        r1_g1.agregar("mandarina");
        r1_g1.agregar("manzana");

        Grupo r1_g2 = new Grupo();
        r1_g2.agregar("cebolla");
        r1_g2.agregar("lechuga");
        r1_g2.agregar("zanahoria");

        RespuestaGC r1 = new RespuestaGC(r1_g1, r1_g2);
        j1.agregarRespuesta(r1);

        Jugadores jugadores = new Jugadores();
        jugadores.agregarJugador(j1);
        //Act

        Puntajes puntajes = groupChoice.calcularPuntaje(jugadores);
        jugadores.asignarPuntajes(puntajes);

        //Assert
        assertEquals(puntajeEsperado, j1.obtenerPuntaje());

    }
}


