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
        frutas.agregar(new Opcion("tomate"));
        frutas.agregar(new Opcion("mandarina"));
        frutas.agregar(new Opcion("manzana"));

        Grupo verduras = new Grupo();
        verduras.agregar(new Opcion("cebolla"));
        verduras.agregar(new Opcion("lechuga"));
        verduras.agregar(new Opcion("zanahoria"));
        RespuestaGC correcta = new RespuestaGC(frutas, verduras);

        GroupChoice groupChoice = new GroupChoice("Grupo A: Frutas, Grupo B: Verduras", correcta);
        Jugador j1 = new Jugador("Pepe");

        Grupo r1_g1 = new Grupo();
        r1_g1.agregar(new Opcion("tomate"));
        r1_g1.agregar(new Opcion("mandarina"));
        r1_g1.agregar(new Opcion("manzana"));

        Grupo r1_g2 = new Grupo();
        r1_g2.agregar(new Opcion("cebolla"));
        r1_g2.agregar(new Opcion("lechuga"));
        r1_g2.agregar(new Opcion("zanahoria"));

        RespuestaGC r1 = new RespuestaGC(r1_g1, r1_g2);
        j1.agregarRespuesta(r1);

        //Act

        Puntaje puntaje = groupChoice.calcularPuntaje(r1);
        j1.sumarPuntaje(puntaje);

        //Assert
        assertEquals(puntajeEsperado, j1.obtenerPuntaje());

    }
}


