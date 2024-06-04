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

public class MessageTest {
    /*
     * @Test
     * public void messageGreeting() {
     * Message message = new Message("Hola Mundo!", "Hello world!");
     * 
     * assertEquals("Hello world!", message.greet("us"));
     * }
     * 
     * @Test
     * public void messageGreetingDefaultLanguage() {
     * Message message = new Message("Hola Mundo!", "Hello world!");
     * 
     * assertEquals("Hola Mundo!", message.greet());
     * }
     */
    @Test
    public void test01UnaPreguntaRecibeUnaListaDeRespuestasVFYAsignaCorrectamenteElPuntaje() {
        // Arrange
        Modalidad vfClasico = new VFClasico();
        HashMap<String, Boolean> opciones = new HashMap<>();
        List<Jugador> jugadores = new List<Jugador>();
        List<HashMap<String, Boolean>> respuestas = new ArrayList();

        opciones.put("Paris es la capital de Francia", true);
        Pregunta pregunta = new Pregunta("Paris es la capital de Francia?", opciones, vfClasico);

        Jugador j1 = new Jugador("Axel");
        HashMap<String, Boolean> respuestaJ1 = new HashMap<>();
        respuestaJ1.put("Paris es la capital de Francia", false);
        jugadores.add(j1);
        respuestas.add(respuestaJ1);

        Jugador j2 = new Jugador("Dani");
        HashMap<String, Boolean> respuestaJ2 = new HashMap<>();
        respuestaJ2.put("Paris es la capital de Francia", true);
        jugadores.add(j2);
        respuestas.add(respuestaJ2);

        Jugador j3 = new Jugador("Juani");
        HashMap<String, Boolean> respuestaJ3 = new HashMap<>();
        respuestaJ3.put("Paris es la capital de Francia", true);
        jugadores.add(j3);
        respuestas.add(respuestaJ3);

        Jugador j4 = new Jugador("Denisse");
        HashMap<String, Boolean> respuestaJ4 = new HashMap<>();
        respuestaJ4.put("Paris es la capital de Francia", false);
        jugadores.add(j3);
        respuestas.add(respuestaJ4);

        // Act
        pregunta.evaluarRespuestas(respuestas); // Aca tendria que mandarle tambien por parametro una lista de los
                                                // jugadores.

        // Assert
        // assertEquals()
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
