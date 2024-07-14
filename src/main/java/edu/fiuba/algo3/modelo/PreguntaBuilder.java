package edu.fiuba.algo3.modelo;

public class PreguntaBuilder {
    private String texto;
    private String tipo;
    private String tema;
    private Opciones opciones;
    private Respuesta correcta;
    private String textoRespuesta;
    private String grupo1;
    private String grupo2;

    public PreguntaBuilder conTipo(String tipo){
        this.tipo = tipo;
        return this;
    }
    public PreguntaBuilder conTexto(String texto) {
        this.texto = texto;
        return this;
    }

    public PreguntaBuilder conTema(String tema) {
        this.tema = tema;
        return this;
    }

    public PreguntaBuilder conOpciones(Opciones opciones) {
        this.opciones = opciones;
        return this;
    }

    public PreguntaBuilder conCorrecta(Respuesta correcta) {
        this.correcta = correcta;
        return this;
    }

    public PreguntaBuilder conTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
        return this;
    }
    public PreguntaBuilder conGrupo1(String grupo1) {
        this.grupo1 = grupo1;
        return this;
    }
    public PreguntaBuilder conGrupo2(String grupo2) {
        this.grupo2 = grupo2;
        return this;
    }

    public PreguntaVF buildVF() {
        return new PreguntaVF(texto, tema, tipo, opciones, correcta, textoRespuesta);
    }
    public PreguntaGC buildGC(){
        return new PreguntaGC(texto,tema,tipo,opciones,grupo1,grupo2,(RespuestaGC) correcta,textoRespuesta);
    }
    public PreguntaMC buildMC(){
        return new PreguntaMC(texto,tema,tipo,opciones,correcta,textoRespuesta);
    }
    public PreguntaMCParcial buildMCParcial(){
        return new PreguntaMCParcial(texto,tema,tipo,opciones,correcta,textoRespuesta);
    }
    public PreguntaMCPenalidad buildMCPenalidad(){
        return new PreguntaMCPenalidad(texto,tema,tipo,opciones,correcta,textoRespuesta);
    }
    public PreguntaOC buildOC(){
        return new PreguntaOC(texto,tema,tipo,opciones,correcta,textoRespuesta);
    }
    public String getTipo(){
        return tipo;
    }
}
