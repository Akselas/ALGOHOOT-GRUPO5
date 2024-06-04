package edu.fiuba.algo3.entrega_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import edu.fiuba.algo3.modelo.Message;
import main.java.edu.fiuba.algo3.entrega_1.Clasico;
import main.java.edu.fiuba.algo3.entrega_1.Jugador;
import main.java.edu.fiuba.algo3.entrega_1.Modalidad;
import main.java.edu.fiuba.algo3.entrega_1.Pregunta;
import main.java.edu.fiuba.algo3.entrega_1.RespuestaVF;
import main.java.edu.fiuba.algo3.entrega_1.VFClasico;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VFTest {
    
    @Test
    public void test01UnaPreguntaRecibeUnaListaDeRespuestasVFYAsignaCorrectamenteElPuntaje() {
        // Arrange
        // Arrange
        int puntajeEsperado1 = 1;
        int puntajeEsperado2 = 1;
        Modalidad vfClasico = new VFClasico();
        HashMap<String, Boolean> opciones = new HashMap<>();
        List<Jugador> jugadores = new List<Jugador>();
        List<HashMap<String, Boolean>> respuestas = new ArrayList();

        opciones.put("Paris es la capital de Francia", true);
        Pregunta pregunta = new Pregunta("Paris es la capital de Francia?", opciones, vfClasico);

        Jugador j1 = new Jugador("Axel");
        HashMap<String, Boolean> respuestaJ1 = new HashMap<>();
        respuestaJ1.put("Paris es la capital de Francia", true);
        jugadores.add(j1);
        respuestas.add(respuestaJ1);

        Jugador j2 = new Jugador("Dani");
        HashMap<String, Boolean> respuestaJ2 = new HashMap<>();
        respuestaJ2.put("Paris es la capital de Francia", true);
        jugadores.add(j2);
        respuestas.add(respuestaJ2);

        // Act
        pregunta.evaluarRespuestas(respuestas, jugadores);

        // Assert
        assertEquals(puntajeEsperado1, jugador1.obtenerPuntaje());
        assertEquals(puntajeEsperado2, jugador2.obtenerPuntaje());
    }

    @Test
    public void test02UnaPreguntaRecibeUnaListaDeRespuestasVFYAsignaCorrectamenteElPuntaje() {

    }

    @Test
    public void test03UnaPreguntaRecibeUnaListaDeRespuestasVFYAsignaCorrectamenteElPuntaje() {
    }

    @Test
    public void test04UnaPreguntaRecibeUnaListaDeRespuestasVFYAsignaCorrectamenteElPuntaje() {

    }
}
