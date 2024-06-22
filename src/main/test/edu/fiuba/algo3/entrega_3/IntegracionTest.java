package edu.fiuba.algo3.entrega_3;


import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegracionTest {
    @Test
    public void test01PreguntaVFDeCienciasRespondeCorrectamente(){
        //Arrange
        Jugador j1 = new Jugador("Axel");
        Jugadores jugadores = new Jugadores();
        jugadores.agregarJugador(j1);
        int puntajeEsperado1 = 1;
        String textoPregunta = "El punto de ebullición del agua a 3300m del mar es 100 grados centígrados";
        RespuestaVF correcta = new RespuestaVF();
        correcta.agregarOpcion(new Opcion("V"));

        PreguntaVF preguntaVF = new PreguntaVF(textoPregunta, correcta);

        //Act
        RespuestaVF resp = new RespuestaVF();
        resp.agregarOpcion(new Opcion("V"));
        j1.agregarRespuesta(resp);
        j1.sumarPuntaje(preguntaVF.calcularPuntaje(resp));

        //Assert
        assertEquals(puntajeEsperado1, j1.obtenerPuntaje());

    }
}
