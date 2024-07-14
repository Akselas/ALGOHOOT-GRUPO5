package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Puntajes;
import javafx.stage.Stage;

public class FaseFinal implements Fase {
    Stage fondo;
    FaseManejador manejador;

    public FaseFinal(Stage stage, FaseManejador manejador){
        this.fondo = stage;
        this.manejador = manejador;
    }
    @Override
    public void iniciar(){

    }
    @Override
    public void fasePromover(){

    }



}
