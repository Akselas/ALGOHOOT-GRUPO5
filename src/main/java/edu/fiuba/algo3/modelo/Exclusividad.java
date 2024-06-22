package edu.fiuba.algo3.modelo;

public class Exclusividad{

    public void aplicar(Puntajes puntajes){
        if(puntajes.haySoloUnaCorrecta()) {
            puntajes.duplicarPuntajes();
            return;
        }
        puntajes.anularPuntajes(); //Si dos o mas jugadores aciertan entonces no se otorgan puntos
    }
}
