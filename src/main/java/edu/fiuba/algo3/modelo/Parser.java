package edu.fiuba.algo3.modelo;

public class Parser {
    public PreguntaVF devolverPreguntaVF(){
        RespuestaVF correcta = new RespuestaVF();
        correcta.agregarOpcion(new Opcion("V"));
        return new PreguntaVF("El tomate es una fruta?", new Opciones(), correcta);
    }
}
