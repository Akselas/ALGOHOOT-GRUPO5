package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.vista.recursos.Sonidos;
import javafx.stage.Stage;
import edu.fiuba.algo3.controlador.*;

import java.util.ArrayList;
import java.util.Iterator;

public class FaseIntermedia implements Fase {
    Stage fondo;
    FaseManejador manejador;
    Puntajes puntajesParciales;
    Puntajes puntajesGenerales;
    Sonidos sonidoFondo;

    public FaseIntermedia(Stage stage, FaseManejador manejador){
        this.fondo = stage;
        this.manejador = manejador;
        this.puntajesParciales = new Puntajes();
        this.sonidoFondo = new Sonidos("musicaFondo.mp3");
    }

    public void iniciar(){
        // Crear la tabla general de puntajes y asociarla a los jugadores, no se si crear un objeto tabla
        // Crear tabla parcial de puntajes y asignarselos a los jugadores
        // Esto lo vamos a mandar a fase inicial y acá directamente arrancamos el juego.
        sonidoFondo.sonar();
        int contador = 0;
        Jugadores jugadores = manejador.obtenerAtributos().getJugadores();
        procesarJuego(contador, jugadores);
        }

    private boolean terminoJuego(int i) {
        int limitePreguntas = manejador.obtenerAtributos().getNumPreguntas();
        boolean hayGanador = manejador.obtenerAtributos().hayGanador();
        return (i > limitePreguntas || hayGanador);
    }

    private void procesarJuego(int contador, Jugadores jugadores){
        if (!terminoJuego(contador)) {//aca es la condicion de corte para que termine el juego
            Iterator<Jugador> iteradorJugadores = jugadores.iterador();//si no termina prepara los parametros para iniciar una ronda
            Pregunta pregunta = manejador.obtenerAtributos().getPreguntaAleatoria();

            Poderes poderesUsados = new Poderes();
            procesarRonda(iteradorJugadores, pregunta, poderesUsados, contador, jugadores);
        }else{
            fasePromover();
        }

    }

    private void procesarRonda(Iterator<Jugador> iteradorJugadores, Pregunta pregunta, Poderes poderesUsados, int contador, Jugadores jugadores) {
        //termina la ronda cuando termine la iteracion a cada jugador de jugadores

        if (!iteradorJugadores.hasNext()) {//si ya no hay mas jugadores aplicar poderes grupales y actualizar puntajes
            poderesUsados.aplicarPoderesGrupales(puntajesParciales);
            jugadores.actualizarPuntajes();
            VistaRonda rondaTerminada = new VistaRonda(fondo, jugadores, poderesUsados, pregunta.textoRespuesta);
            rondaTerminada.mostrar();

            rondaTerminada.getBotonSiguiente().setOnAction(event -> procesarJuego(contador + 1, jugadores));//aca prepara para la siguiente ronda, sumando uno al contador(esto seria necesario para la condicion de corte del juego, contador = la cantidad de rondas o preguntas que pasaron(aplicar refactor))
            //en el refactor podriamos iterarlas preguntas.
        } else {
            Jugador jugador = iteradorJugadores.next();
            ControladorFactory controladorFactory = new ControladorFactory();
            ControladorPregunta controlador = controladorFactory.crearControlador(pregunta, jugador);

            controlador.mostrarVentanaPregunta(fondo);
            controlador.setOnResponder(() -> {
                puntajesParciales.agregarPuntaje(jugador.getPuntajeParcial());
                poderesUsados.agregarPoder(controlador.poderUsado());
                for(Poder p: poderesUsados.devolverPoderes()){
                    System.out.println(p.obtenerNombre()+ "\n");
                }


                // Continuar con el siguiente jugador después de que se procese la respuesta
                procesarRonda(iteradorJugadores, pregunta, poderesUsados, contador, jugadores);
            });

        }
    }
    @Override
    public void fasePromover(){
        manejador.cambiarFase(new FaseFinal(this.fondo, this.manejador));
        manejador.iniciarFase();
        System.out.println("Ganador: " + manejador.obtenerAtributos().obtenerGanador());
        this.sonidoFondo.parar();

}