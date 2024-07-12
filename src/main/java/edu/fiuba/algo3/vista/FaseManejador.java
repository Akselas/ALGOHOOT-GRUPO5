package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Parser;
import edu.fiuba.algo3.modelo.Pregunta;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class FaseManejador {
    Fase estadoFase;
    Stage fondo;
    AtributosIniciales atributos;
    Parser parser;

    public FaseManejador(Stage stage, String ruta) throws IOException {
        this.fondo = stage;
        this.atributos = new AtributosIniciales();
        estadoFase = new FaseInicial(fondo, this);
        this.parser = new Parser(ruta);
        parser.leer(ruta);
    }
    public void iniciarFase(){
        estadoFase.iniciar();
    }
    public void cambiarFase(Fase nuevaFase){
        estadoFase = nuevaFase;
    }
    public AtributosIniciales obtenerAtributos(){
        return atributos;
    }
    public void configurarCantidadPreguntas(int cantidad){
        atributos.setCantidadDePreguntas(cantidad);
        atributos.guardarPreguntas(parser.devolverPreguntasRandom(cantidad));
    }
}
