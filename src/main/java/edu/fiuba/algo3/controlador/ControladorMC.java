package edu.fiuba.algo3.controlador;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.PoderesVista;
import edu.fiuba.algo3.vista.VistaMC;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ControladorMC implements ControladorPregunta {
    private Jugador jugador;
    private Pregunta pregunta;
    private VistaMC vista;
    private PoderesVista poderesBox;
    private Button responder;
    private Runnable onResponder;

    public ControladorMC(Pregunta pregunta, Jugador jugador) {
        this.vista = new VistaMC();
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.poderesBox = new PoderesVista(jugador, pregunta);
        this.responder = new Button("Responder");
        initialize();
    }
    @Override
    public void mostrarVentanaPregunta(Stage fondo) {
        Scene escena = vista.proyectar(poderesBox, responder);
        fondo.setScene(escena);
        fondo.setTitle("AlgoHoot");
        fondo.show();
    }
    @Override
    public void initialize() {
        vista.mostrarPregunta(pregunta);
        vista.mostrarOpciones(pregunta.obtenerOpciones());
        establecerManejoDeEventos();
    }

    @Override
    public void establecerManejoDeEventos() {
        responder.setOnAction(event -> {
            RespuestaMC respuestaJugador = new RespuestaMC();

            for (CheckBox checkBox : vista.obtenerBotones()) {
                if (checkBox.isSelected()) {
                    respuestaJugador.agregarOpcionSeleccionada((Opcion) checkBox.getUserData());
                } else {
                    respuestaJugador.agregarOpcionNoSeleccionada((Opcion) checkBox.getUserData());
                }
            }

            jugador.cargarPuntajeRonda(pregunta.calcularPuntaje(respuestaJugador));
            Poder poderSeleccionado = poderesBox.obtenerPoderSeleccionado();
            Poderes.verificarPoder(poderSeleccionado, jugador.getPuntajeParcial());
            poderesBox.actualizarPoderes();
            showScoreAlert(jugador.getPuntajeParcial().obtenerPuntuacion());

            if (onResponder != null) {
                onResponder.run();
            }
        });
    }

    private void showScoreAlert(int puntaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Puntaje del Jugador");
        alert.setHeaderText(null);
        alert.setContentText("El puntaje del jugador " + jugador.getNombre() + " es: " + jugador.getPuntaje());
        alert.showAndWait();
    }

    @Override
    public Poder poderUsado() {
        return poderesBox.obtenerPoderSeleccionado();
    }

    @Override
    public void setOnResponder(Runnable onResponder) {
        this.onResponder = onResponder;
    }
}
