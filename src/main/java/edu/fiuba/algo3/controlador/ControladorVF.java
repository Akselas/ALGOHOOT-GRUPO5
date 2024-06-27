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
    private Poder poderSeleccionado;//esto se va en un refactor
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

                Puntaje puntaje = this.pregunta.calcularPuntaje(respuestaJugador);
                //EBERIA SER RESPOSABILIDAD DE JUGADOR
                if (poderSeleccionado != null) {
                    poderSeleccionado.aplicar(puntaje);
                    poderesBox.cantDuplicador--;
                    poderesBox.actualizarPoderes();
                    poderSeleccionado = null;
                }

                jugador.sumarPuntaje(puntaje);
                System.out.println("Puntaje de " + jugador.obtenerNombre() + " : " + jugador.obtenerPuntaje());

            }else {
                System.out.println("Por favor selecciona una opción.");
            }
            });

        poderesBox.obtenerBotonDuplicador().setOnAction(event -> {
            if(poderesBox.obtenerBotonDuplicador().isSelected()){
                poderSeleccionado = (Duplicador) poderesBox.obtenerBotonDuplicador().getUserData();
                System.out.println("Poder seleccionado: Duplicador");
            }else{
                poderSeleccionado = null;
                System.out.println("Poder deseleccionado: Duplicador");
            }
        });
    }

}
