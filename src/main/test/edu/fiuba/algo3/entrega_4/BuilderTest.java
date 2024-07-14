package edu.fiuba.algo3.entrega_4;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderTest {

    @Test
    public void preguntaBuilderCreaUnPreguntaVFCorrectamente(){
        //Arrange
        PreguntaBuilder builder = new PreguntaBuilder();
        builder.conTipo("Verdadero Falso");
        builder.conTema("Cocina");
        builder.conTexto("El tomate es una fruta");
        builder.conOpciones(new Opciones());
        builder.conCorrecta(new RespuestaVF());
        builder.conTextoRespuesta("Los tomates son rojos");
        //Act
        Pregunta preguntaVF = builder.buildVF();
        //Assert
        assertEquals("Verdadero Falso", preguntaVF.obtenerTipo());
        assertEquals(true, preguntaVF instanceof PreguntaVF);
    }
    @Test
    public void preguntaBuilderCreaUnPreguntaMCCorrectamente(){
        //Arrange
        PreguntaBuilder builder = new PreguntaBuilder();
        builder.conTipo("Multiple Choice");
        builder.conTema("Cocina");
        builder.conTexto("Seleccione las frutas");
        builder.conOpciones(new Opciones());
        builder.conCorrecta(new RespuestaVF());
        builder.conTextoRespuesta("Las frutas tienen semillas");
        //Act
        Pregunta preguntaMC = builder.buildMC();
        //Assert
        assertEquals("Verdadero Falso", preguntaMC.obtenerTipo());
        assertEquals(true, preguntaMC instanceof PreguntaVF);
    }
    @Test
    public void preguntaBuilderCreaUnPreguntaGCCorrectamente(){
        //Arrange
        PreguntaBuilder builder = new PreguntaBuilder();
        builder.conTipo("Group Choice");
        builder.conTema("Cocina");
        builder.conTexto("Indique frutas y verduras");
        builder.conOpciones(new Opciones());
        builder.conGrupo1("Verduras");
        builder.conGrupo2("Frutas");
        builder.conCorrecta(new RespuestaGC(new Grupo(), new Grupo()));
        builder.conTextoRespuesta("Los tomates");
        //Act
        Pregunta preguntaGC = builder.buildGC();
        //Assert
        assertEquals("Group Choice", preguntaGC.obtenerTipo());
        assertEquals(true, preguntaGC instanceof PreguntaGC);
    }
}
