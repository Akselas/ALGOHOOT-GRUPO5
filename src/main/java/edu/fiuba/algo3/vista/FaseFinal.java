package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Puntajes;
import edu.fiuba.algo3.vista.recursos.Sonidos;
import javafx.stage.Stage;

public class FaseFinal implements Fase {
    Stage fondo;
    FaseManejador manejador;
    Sonidos sonidoFinal;

    public FaseFinal(Stage stage, FaseManejador manejador){
        this.fondo = stage;
        this.manejador = manejador;
        this.sonidoFinal = new Sonidos("musicaFinal.mp3");
    }
    @Override
    public void iniciar(){

    }
    @Override
    public void fasePromover(){

    }



}
