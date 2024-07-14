package edu.fiuba.algo3.modelo;

public class PreguntaGC extends Pregunta{
    private final String nombreG1;
    private final String nombreG2;


    public PreguntaGC(String texto, String tema, String tipo, Opciones opciones, String nombreG1, String nombreG2, RespuestaGC correcta, String textoRespuesta){
        super(texto, tema, tipo, opciones, correcta, textoRespuesta);
        this.nombreG1 = nombreG1;
        this.nombreG2 = nombreG2;
    }

    public String obtenerNombreGrupo1() {
        return this.nombreG1;
    }

    public String obtenerNombreGrupo2() {
        return this.nombreG2;
    }
}
