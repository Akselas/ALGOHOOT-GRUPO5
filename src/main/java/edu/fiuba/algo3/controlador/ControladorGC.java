package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.PoderesVista;
import edu.fiuba.algo3.vista.VistaGC;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.Node;

public class ControladorGC {
    private VistaGC vistaGC;
    private Jugador jugador;
    private Pregunta pregunta;
    private VistaPrincipal vistaPrincipal;
    private PoderesVista poderesBox;
    private  Poder poderSeleccionado;
    private Button responder;

    public ControladorGC(VistaGC vistaGC, Jugador jugador, Pregunta pregunta, PoderesVista poderesBox, Button responder) {
        this.vistaGC = vistaGC;
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.poderesBox = poderesBox;
        this.responder = responder;
        initialize();
    }

    private void initialize() {
        this.vistaGC.mostrarOpciones(this.pregunta.obtenerOpciones()); //esto setea opcionesListView
        this.vistaGC.mostrarPregunta(this.pregunta);
        this.vistaGC.mostrarNombresDeGrupos(this.pregunta);
        establecerManejoDeEventos();
    }


    private void establecerManejoDeEventos() {
        this.responder.setOnAction(event -> {
            //Cuando se presiona el boton responder entonces:

            // reviso si todas las opciones fueron asignadas
            VBox opcionesGrupoDefault = this.vistaGC.obtenerGrupoDefault();

            if (!opcionesGrupoDefault.getChildren().isEmpty()) {
                System.out.println("Por favor agrupe todas las opciones");
                return;
            }

            // Obtengo los grupos
            VBox grupo1 = this.vistaGC.obtenerGrupo1Opciones();
            VBox grupo2 = this.vistaGC.obtenerGrupo2Opciones();

            // armo la respuesta del jugador
            Grupo respuestaGrupo1 = new Grupo();
            for (Node node : grupo1.getChildren()) {
                if (node instanceof Text) {
                    Text label = (Text) node;
                    Opcion opcion = new Opcion(label.getText());
                    respuestaGrupo1.agregar(opcion);
                }
            }

            Grupo respuestaGrupo2 = new Grupo();
            for (Node node : grupo2.getChildren()) {
                if (node instanceof Text) {
                    Text label = (Text) node;
                    Opcion opcion = new Opcion(label.getText());
                    respuestaGrupo2.agregar(opcion);
                }
            }

            RespuestaGC respuestaJugador = new RespuestaGC(respuestaGrupo1, respuestaGrupo2);

            Puntaje puntaje = this.pregunta.calcularPuntaje(respuestaJugador);


            if (poderSeleccionado != null) {
                poderSeleccionado.aplicar(puntaje);
                poderesBox.cantDuplicador--;
                poderesBox.actualizarPoderes();
                poderSeleccionado = null;
            }


            jugador.sumarPuntaje(puntaje);
            System.out.println("Puntaje de " + jugador.obtenerNombre() + " : " + jugador.obtenerPuntaje());

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
