package edu.fiuba.algo3.vista;

import javafx.stage.Stage;

public class FaseManejador {
    Fase estadoFase;
    Stage fondo;
    AtributosIniciales atributos;

    public FaseManejador(Stage stage){
        this.fondo = stage;
        this.atributos = new AtributosIniciales();
        estadoFase = new FaseInicial(fondo, this);
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

}
