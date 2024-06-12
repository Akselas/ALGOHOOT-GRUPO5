package edu.fiuba.algo3.modelo;

public class Puntaje {
    private int punto;

    public Puntaje(){
        this.punto = 0;
    }
    public Puntaje(int valor){
        this.punto = valor;
    }

    public int obtenerPuntuacion(){
        return this.punto;
    }


    public void sumar(){
        this.punto += 1;
    }

    public void sumar(int suma){
        this.punto += suma;
    }
    public void sumar(Puntaje puntaje){
        this.punto += puntaje.obtenerPuntuacion();
    }

    public void restar(int resta){
        this.punto -= resta;
    }



}