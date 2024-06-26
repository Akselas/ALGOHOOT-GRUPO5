package edu.fiuba.algo3.controlador;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.PoderesVista;
import edu.fiuba.algo3.vista.VistaPrincipal;
import edu.fiuba.algo3.vista.VistaVF;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.control.RadioButton;

public class ControladorVF {

    private Opciones opciones;
    private ListView<Opcion> opcionesVisibles;
    private VistaVF vistaVF;
    private Jugador jugador;
    private Pregunta pregunta;
    private VistaPrincipal vistaPrincipal;
    private PoderesVista poderesBox;
    private Poder poderSeleccionado;

    public ControladorVF(VistaVF vistaVF, Jugador jugador, Pregunta pregunta, PoderesVista poderesBox) {
        this.vistaVF = vistaVF;
        this.opciones = pregunta.obtenerOpciones();
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.poderesBox = poderesBox;
        initialize();

    }
    private void initialize() {
        this.vistaVF.mostrarPregunta(this.pregunta, this.opciones);
        establecerManejoDeEventos();
    }

    private void establecerManejoDeEventos() {
        this.vistaVF.obtenerBotonResponder().setOnAction(event -> {
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
