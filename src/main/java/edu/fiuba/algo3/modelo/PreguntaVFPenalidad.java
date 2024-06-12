package edu.fiuba.algo3.modelo;

public class PreguntaVFPenalidad {
    private String texto;
    private RespuestaVF correcta;

    public PreguntaVFPenalidad(String texto, RespuestaVF correcta){
        this.texto = texto;
        this.correcta = correcta;
    }

    public Puntaje calcularPuntajeDe(RespuestaVF otra){//Recibe jugador para no tener que castear el tipo de respuesta
        Puntaje p = new Puntaje();
        if(this.correcta.esIgual(otra)){
            p.sumar();//return new Puntaje(1);
        } else{
            p.restar(); //return new Puntaje(-1);
        }
        return p;
    }
}
