package edu.fiuba.algo3.entrega_3;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {


    @Test
    public void test01ParserLeeUnArchivoYCreaUnaClasePregunta(){
        //Arrange
        Parser parchu = new Parser();
        String nombreFile = "src/main/resources/ParserTestFile.json";
        String esperado = "El punto de ebullición del agua a 3300m del mar es 100 grados centígrados";

        //Act
        try {
            parchu.leer(nombreFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Assert
        Pregunta preguntaObtenida = parchu.devolverPrimeraPregunta();
        String txtObtenido = preguntaObtenida.obtenerTexto();
        assertEquals(txtObtenido, esperado);
    }
}
