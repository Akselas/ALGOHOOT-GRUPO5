package edu.fiuba.algo3.controlador;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.PoderesVista;
import edu.fiuba.algo3.vista.VistaVF;
import javafx.scene.control.*;


public class ControladorVF implements ControladorPregunta{

    private VistaVF vistaVF;
    private Jugador jugador;
    private Pregunta pregunta;
    private PoderesVista poderesBox;
    private Button responder;

    public ControladorVF(VistaVF vistaVF, Jugador jugador, Pregunta pregunta, PoderesVista poderesBox, Button responder){
        this.vistaVF = vistaVF;
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.poderesBox = poderesBox;
        this.responder = responder;
        initialize();

    }
    @Override
    public void initialize(){//no me deja ponerlo en privado
        this.vistaVF.mostrarPregunta(this.pregunta);
        this.vistaVF.mostrarOpciones(pregunta.obtenerOpciones());
        establecerManejoDeEventos();
    }

    @Override
    public void establecerManejoDeEventos() {
        this.responder.setOnAction(event -> {
            //Cuando se presiona el boton responder entonces:
            //Creo la respuesta del jugador
            RespuestaVF respuestaJugador = new RespuestaVF();

            // Obtengo el botón seleccionado
            RadioButton botonSeleccionado = (RadioButton) this.vistaVF.obtenerGrupoOpciones().getSelectedToggle();
            // Si se presionó el boton Responder pero no se presiono ninguna opcion entonces pregunto
            if (botonSeleccionado != null) {
                //Obtengo el valor del boton seleccionado, que es de la clase Opcion
                respuestaJugador.agregarOpcion((Opcion) botonSeleccionado.getUserData());

                Puntaje puntajeRonda = pregunta.calcularPuntaje(respuestaJugador);
                jugador.cargarPuntajeRonda(puntajeRonda);

                Poder poderSeleccionado = poderesBox.obtenerPoderSeleccionado();//este if esta expuesto logica de negocios
                if(poderSeleccionado instanceof PoderIndividual){
                    PoderIndividual poder = (PoderIndividual) poderSeleccionado;
                    poder.aplicarUnico(puntajeRonda);
                    poderesBox.actualizarPoderes();
                }else{
                    PoderGrupal poder = (PoderGrupal) poderSeleccionado;
                    //listaPoderesGrupales.agregar(poder);

                }

                jugador.sumarPuntaje(puntajeRonda);
                System.out.println("Puntaje de " + jugador.obtenerNombre() + " : " + jugador.obtenerPuntaje());

            }else {
                System.out.println("Por favor selecciona una opción.");
            }
            });
    }

}
