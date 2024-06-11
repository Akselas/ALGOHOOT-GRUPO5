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


    public void sumar(){
        this.punto += 1;
    }

    public void sumar(int suma){
        this.punto += suma;
    }


    public void restar(){
        this.punto -= 1;
    }

    public void restar(int resta){
        this.punto -= resta;
    }



}