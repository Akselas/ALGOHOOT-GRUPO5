package edu.fiuba.algo3.controlador;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.PoderesVista;
import edu.fiuba.algo3.vista.VistaMC;
import javafx.scene.control.*;




public class ControladorMC implements ControladorPregunta{

    private Jugador jugador;
    private Pregunta pregunta;
    private VistaMC vista;
    private PoderesVista poderesBox;
    private Poder poderSeleccionado;
    private Button responder;

    public ControladorMC(Jugador jugador, Pregunta pregunta, VistaMC vistaMC, PoderesVista poderesBox, Button responder) {
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.vista = vistaMC;
        this.poderesBox = poderesBox;
        this.responder = responder;
        initialize();
    }

    @Override
    public void initialize() {
        vista.mostrarPregunta(pregunta);
        vista.mostrarOpciones(pregunta.obtenerOpciones());
        establecerManejoDeEventos();
    }

    @Override
    public void establecerManejoDeEventos() {
        responder.setOnAction(event-> {
            RespuestaMC respuestaJugador = new RespuestaMC();

            for(CheckBox checkBox : vista.obtenerBotones()){
                if (checkBox.isSelected()) {
                    respuestaJugador.agregarOpcionSeleccionada((Opcion) checkBox.getUserData());
                } else {
                    respuestaJugador.agregarOpcionNoSeleccionada((Opcion) checkBox.getUserData());
                }
            }

            Puntaje puntaje = pregunta.calcularPuntaje((Respuesta) respuestaJugador);

            if (poderSeleccionado != null) {
                poderSeleccionado.aplicar(puntaje);
                poderesBox.cantDuplicador--;
                poderesBox.actualizarPoderes();
                poderSeleccionado = null;
            }

            jugador.sumarPuntaje(puntaje);
            showScoreAlert(puntaje.obtenerPuntuacion());
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

    private void showScoreAlert(int puntaje ) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Puntaje del Jugador");
        alert.setHeaderText(null);
        alert.setContentText("El puntaje del jugador " + jugador.obtenerNombre() + " es: " + jugador.obtenerPuntaje());

        alert.showAndWait();
    }
}