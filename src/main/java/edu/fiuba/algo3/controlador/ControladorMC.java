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
    private Runnable onResponder;

    public ControladorMC(Pregunta pregunta, Jugador jugador) {
        this.vista = new VistaMC();
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.poderesBox = new PoderesVista(jugador, pregunta);
        initialize();
    }
    @Override
    public void mostrarVentanaPregunta(Stage fondo) {
        Scene escena = vista.proyectar(poderesBox);
        fondo.setScene(escena);
        fondo.setTitle(pregunta.obtenerTipo());
        fondo.show();
    }
    @Override
    public void initialize() {
        vista.mostrarPregunta(pregunta, jugador);
        vista.mostrarOpciones(pregunta.obtenerOpciones());
        establecerManejoDeEventos();
    }

    @Override
    public void establecerManejoDeEventos() {
        this.vista.obtenerBotonResponder().setOnAction(event -> {
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

            if (onResponder != null) {
                onResponder.run();
            }
        });
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
