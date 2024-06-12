package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VFTest {

    @Test
    public void test01UnaPreguntaVFRecibeUnaListaDeRespuestasYAsignaCorrectamenteElPuntaje() {

        //Arrange
        int puntajeEsperado1 = 1;
        int puntajeEsperado2 = 1;

        RespuestaVF correcta = new RespuestaVF();//Estado inconsistente no debería haber una respuesta sin opcion
        correcta.agregarOpcion(new Opcion("V"));
        PreguntaVF preguntaVF = new PreguntaVF("El tomate es una fruta?", correcta);

        /*
        RespuestaVF correcta = new RespuestaVF();//Estado inconsistente no debería haber una respuesta sin opcion
        correcta.agregarOpcion(new Opcion("V"));
        RespuestaVF incorrecta = new RespuestaVF(new Opcion("F"));
        */
        //PreguntaVF preguntaVF = new PreguntaVF("El tomate es una fruta?", correcta, );

        Jugador j1 = new Jugador("Pepe");
        RespuestaVF r1 = new RespuestaVF();
        r1.agregarOpcion(new Opcion("V"));
        j1.agregarRespuesta(r1);

        Jugador j2 = new Jugador("Sandra");
        RespuestaVF r2 = new RespuestaVF();
        r2.agregarOpcion(new Opcion("V"));
        j2.agregarRespuesta(r2);

        // Act
        j1.sumarPuntaje(preguntaVF.calcularPuntajeDe(r1));
        j2.sumarPuntaje(preguntaVF.calcularPuntajeDe(r2));

        //Assert Check implementacion antes de correrlo
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, j2.obtenerPuntaje());
    }

    @Test
    public void test02UnaPreguntaVFRecibeUnaListaDeRespuestasAsignaCorrectamenteElPuntajeAQuienesFallaron() {

        //Arrange
        int puntajeEsperad1 = 0;
        int puntajeEsperad2 = 0;
        RespuestaVF correcta = new RespuestaVF();
        correcta.agregarOpcion(new Opcion("V"));
        PreguntaVF preguntaVF = new PreguntaVF("El tomate es una fruta?", correcta);
        Jugador j1 = new Jugador("Pepe");
        RespuestaVF r1 = new RespuestaVF();
        r1.agregarOpcion(new Opcion("F"));
        j1.agregarRespuesta(r1);

        Jugador j2 = new Jugador("Sandra");
        RespuestaVF r2 = new RespuestaVF();
        r2.agregarOpcion(new Opcion("F"));
        j2.agregarRespuesta(r2);

        //Act
        j1.sumarPuntaje(preguntaVF.calcularPuntajeDe(r1));
        j2.sumarPuntaje(preguntaVF.calcularPuntajeDe(r2));

        // Assert
        assertEquals(puntajeEsperad1, j1.obtenerPuntaje());
        assertEquals(puntajeEsperad2, j2.obtenerPuntaje());

    }

    @Test
    public void test03UnaPreguntaDeVFConPenalidadAsignaCorrectamenteElPuntajeAQuienesAcertaron() {

        //Arrange
        int puntajeEsperado1 = 1;
        int puntajeEsperado2 = 1;

        RespuestaVF correcta = new RespuestaVF();
        correcta.agregarOpcion(new Opcion("V"));
        PreguntaVFPenalidad preguntaVF = new PreguntaVFPenalidad("El tomate es una fruta?", correcta);

        Jugador j1 = new Jugador("Pepe");
        RespuestaVF r1 = new RespuestaVF();
        r1.agregarOpcion(new Opcion("V"));
        j1.agregarRespuesta(r1);

        Jugador j2 = new Jugador("Sandra");
        RespuestaVF r2 = new RespuestaVF();
        r2.agregarOpcion(new Opcion("V"));
        j2.agregarRespuesta(r2);

        // Act
        j1.sumarPuntaje(preguntaVF.calcularPuntajeDe(r1));
        j2.sumarPuntaje(preguntaVF.calcularPuntajeDe(r2));

        //Assert Check implementacion antes de correrlo
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, j2.obtenerPuntaje());
    }

    @Test
    public void test04UnaPreguntaDeVFConPenalidadAsignaCorrectamenteElPuntajeAQuienesFallaron() {

        //Arrange
        int puntajeEsperado1 = -1;
        int puntajeEsperado2 = -1;

        RespuestaVF correcta = new RespuestaVF();
        correcta.agregarOpcion(new Opcion("V"));
        PreguntaVFPenalidad preguntaVF = new PreguntaVFPenalidad("El tomate es una fruta?", correcta);

        Jugador j1 = new Jugador("Pepe");
        RespuestaVF r1 = new RespuestaVF();
        r1.agregarOpcion(new Opcion("F"));


        Jugador j2 = new Jugador("Sandra");
        RespuestaVF r2 = new RespuestaVF();
        r2.agregarOpcion(new Opcion("F"));


        // Act
        j1.sumarPuntaje(preguntaVF.calcularPuntajeDe(r1));//preguntavf.responder()
        j2.sumarPuntaje(preguntaVF.calcularPuntajeDe(r2));

        //Assert Check implementacion antes de correrlo
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, j2.obtenerPuntaje());

    }

}


