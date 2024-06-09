package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Puntaje {
    private int punto;

    public Puntaje(){
        this.punto = 0;
    }
    public void comparar(Respuesta unaResp, Respuesta otraResp){
        this.punto = unaResp.esIgual(otraResp) ? 1:0;
    }
    public int devolverPunto(){
        return this.punto;
    }
    public void modificar(int modificador){
        this.punto = this.punto * modificador;
    }
}
