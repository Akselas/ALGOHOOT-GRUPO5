package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.vista.recursos.Sonidos;
import javafx.stage.Stage;
import edu.fiuba.algo3.controlador.*;

import java.util.Iterator;

public class FaseIntermedia implements Fase {
    Stage fondo;
    FaseManejador manejador;
    Puntajes puntajesParciales;
    Sonidos sonidoFondo;

    public FaseIntermedia(Stage stage, FaseManejador manejador){
        this.fondo = stage;
        this.manejador = manejador;
        this.puntajesParciales = new Puntajes();
        this.sonidoFondo = new Sonidos("musicaFondo.mp3");
    }
    @Override
    public void iniciar(){
        int contador = 1;
        Jugadores jugadores = manejador.obtenerAtributos().getJugadores();
        procesarJuego(contador, jugadores);
        }

    private boolean terminoJuego(int i) {
        int limitePreguntas = manejador.obtenerAtributos().getNumPreguntas();
        boolean hayGanador = manejador.obtenerAtributos().hayGanador();
        return (i > limitePreguntas || hayGanador);
    }

    private void procesarJuego(int contador, Jugadores jugadores){
        sonidoFondo.sonar();
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
            sonidoFondo.parar();
            VistaRonda rondaTerminada = new VistaRonda(fondo, jugadores, poderesUsados, pregunta.obtenerTextoRespuesta());
            rondaTerminada.mostrar();

            rondaTerminada.getBotonSiguiente().setOnAction(event -> {
                rondaTerminada.getSonido().parar();
                procesarJuego(contador + 1, jugadores);}
            );//aca prepara para la siguiente ronda, sumando uno al contador(esto seria necesario para la condicion de corte del juego, contador = la cantidad de rondas o preguntas que pasaron(aplicar refactor))
            //en el refactor podriamos iterarlas preguntas.
        } else {
            Jugador jugador = iteradorJugadores.next();
            ControladorFactory controladorFactory = new ControladorFactory();
            ControladorPregunta controlador = controladorFactory.crearControlador(pregunta, jugador);

            controlador.mostrarVentanaPregunta(fondo);
            controlador.setOnResponder(() -> {
                puntajesParciales.agregarPuntaje(jugador.getPuntajeParcial());
                poderesUsados.agregarPoder(controlador.poderUsado());
                //sigue con el siguiente jugador después de que se procese la respuesta
                procesarRonda(iteradorJugadores, pregunta, poderesUsados, contador, jugadores);
            });

        }
    }
    @Override
    public void fasePromover() {
        this.sonidoFondo.parar();
        manejador.cambiarFase(new FaseFinal(this.fondo, this.manejador));
        manejador.iniciarFase();
    }
}