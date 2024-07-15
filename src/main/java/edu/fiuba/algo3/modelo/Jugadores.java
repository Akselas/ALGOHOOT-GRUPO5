package edu.fiuba.algo3.modelo;
import java.util.*;


public class Jugadores {
    private ArrayList<Jugador> jugadores;

    public Jugadores(){
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador){
        this.jugadores.add(jugador);
    }

    public List<String> obtenerPodio() {
        List<String> podio = new ArrayList<>();

        for (int i = 0; i < Math.min(3, jugadores.size()); i++) {
            podio.add(jugadores.get(i).getNombre());
        }

        return podio;
    }

    public boolean algunoSuperaPuntaje(int numero){
        for (Jugador j : jugadores){
            if(j.getPuntaje() >= numero){
                return true;
            }
        }
        return false;
    }

    public void actualizarPuntajes(){
        for(Jugador jugador: jugadores){
            jugador.actualizarPuntaje();
        }
    }
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }

    public Iterator<Jugador> iterador() {
        return jugadores.iterator();
    }

    public String obtenerJugadorConMayorPuntaje(){
        int maximo = 0;
        String nombreDelMayor = "";
        for (Jugador j : jugadores){
            if(j.getPuntaje() >= maximo){
                maximo = j.getPuntaje();
                nombreDelMayor = j.getNombre();
            }
        }
        return nombreDelMayor;
    }

    public void ordenarPorPuntaje() {
        Collections.sort(jugadores, new Comparator<>() {
            @Override
            public int compare(Jugador j1, Jugador j2) {
                return Integer.compare(j2.getPuntaje(), j1.getPuntaje()); // Orden descendente
            }
        });
    }
}
