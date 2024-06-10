package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.GroupChoice;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Message;
import edu.fiuba.algo3.modelo.RespuestaGC;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    @Test
    public void test10UnaPreguntaGroupChoiceAsignaCorrectamenteElPuntajeAQuienesAcertaron(){

        //Arrange
        RespuestaGC correcta = new RespuestaGC();

        GroupChoice groupChoice = new GroupChoice("Grupo A: Frutas, Grupo B: Verduras", new RespuestaGC());
        Jugador j1 = new Jugador("Pepe");
        Jugador j2 = new Jugador("Sandra");


        //Act
        //Assert
    }
}
