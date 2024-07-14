package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;

import javafx.stage.Stage;
import edu.fiuba.algo3.controlador.*;

import java.util.ArrayList;
import java.util.Iterator;

public class FaseIntermedia implements Fase {
    Parser lector;
    Stage fondo;
    FaseManejador manejador;
    Puntajes puntajesParciales;
    Puntajes puntajesGenerales;

    public FaseIntermedia(Stage stage, FaseManejador manejador){
        this.fondo = stage;
        this.manejador = manejador;
        this.puntajesParciales = new Puntajes();
        this.puntajesGenerales = new Puntajes();
    }

    public void iniciar(){
        // Crear la tabla general de puntajes y asociarla a los jugadores, no se si crear un objeto tabla
        // Crear tabla parcial de puntajes y asignarselos a los jugadores
        // Esto lo vamos a mandar a fase inicial y acá directamente arrancamos el juego.
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


/*                  PARA MC
            System.out.println("Todas las opciones\n");
            ArrayList<Opcion> opciones = pregunta.obtenerOpciones().devolverOpciones();
            for (Opcion op: opciones){
                System.out.println(op.obtenerTexto()+ "\n");
            }
            System.out.println();
            Respuesta respuesta = pregunta.obtenerRespuesta();
            if(respuesta instanceof RespuestaMC){
                System.out.println("Todas las opciones Correctas\n");
                ArrayList<Opcion> opcionesCorrectas = ((RespuestaMC) respuesta).obtenerCorrectas();
                for (Opcion op: opcionesCorrectas){
                    System.out.println(op.obtenerTexto()+ "\n");
                }

                System.out.println("Todas las opciones Incorrectas\n");
                ArrayList<Opcion> opcionesIncorrectas = ((RespuestaMC) respuesta).obtenerIncorrectas();
                for (Opcion op: opcionesIncorrectas){
                    System.out.println(op.obtenerTexto()+ "\n");
                }
            }*/


            //                PARA GC
       /*     System.out.println("Todas las opciones\n");
            ArrayList<Opcion> opciones = pregunta.obtenerOpciones().devolverOpciones();
            for (Opcion op: opciones){
                System.out.println(op.obtenerTexto()+ "\n");
            }
            System.out.println();
            Respuesta respuesta = pregunta.obtenerRespuesta();
            if(respuesta instanceof RespuestaGC){
                System.out.println("GrupoA\n");
                ArrayList<Opcion> opcionesA = ((RespuestaGC) respuesta).obtenerGrupo1().getOpciones();
                for (Opcion op: opcionesA){
                    System.out.println(op.obtenerTexto()+ "\n");
                }

                System.out.println("GrupoB\n");
                ArrayList<Opcion> opcionesB = ((RespuestaGC) respuesta).obtenerGrupo2().getOpciones();
                for (Opcion op: opcionesB){
                    System.out.println(op.obtenerTexto()+ "\n");
                }
            }*/


            Poderes poderesUsados = new Poderes();
            procesarRonda(iteradorJugadores, pregunta, poderesUsados, contador, jugadores);
        }else{
            finJuego();
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

    private void finJuego(){
    }

}