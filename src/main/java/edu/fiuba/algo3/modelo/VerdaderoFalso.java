package edu.fiuba.algo3.modelo;

public class VerdaderoFalso {
    private String texto;
    private Respuesta correcta;

    public VerdaderoFalso(String texto, Respuesta correcta){
        this.texto = texto;
        this.correcta = correcta;
    }
    public Puntajes calcularPuntaje(Jugadores jugadores){
        Puntajes puntajes = new Puntajes();

        for(Jugador jugador : jugadores.devolverJugadores()){

            Puntaje p = new Puntaje(); //Puntaje lo creo aca asi cada clase de pregunta crea su propio tipo de puntaje.
            p.comparar(jugador.responder(),this.correcta);
            puntajes.agregar(jugador, p);

        }
        return puntajes;
    }
}
