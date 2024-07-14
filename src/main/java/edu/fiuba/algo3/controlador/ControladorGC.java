package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.PoderesVista;
import edu.fiuba.algo3.vista.VistaGC;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.stage.Stage;

public class ControladorGC implements ControladorPregunta{
    private VistaGC vista;
    private Jugador jugador;
    private Pregunta pregunta;
    private VistaPrincipal vistaPrincipal;
    private PoderesVista poderesBox;
    private Button responder;
    private Runnable onResponder;

    public ControladorGC(Pregunta pregunta, Jugador jugador) {
        this.vista = new VistaGC();
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.poderesBox = new PoderesVista(jugador, pregunta);
        this.responder = new Button("Responder"); //por ahora lo dejamos adentro
        initialize();
    }

    @Override
    public void mostrarVentanaPregunta(Stage fondo){
        Scene escena = vista.proyectar(poderesBox, responder);
        fondo.setScene(escena);
        fondo.setTitle("AlgoHoot");
        fondo.show();
    }

    @Override
    public void initialize() {
        this.vista.mostrarOpciones(this.pregunta.obtenerOpciones()); //esto setea opcionesListView
        this.vista.mostrarPregunta(this.pregunta);
        this.vista.mostrarNombresDeGrupos(this.pregunta);
        establecerManejoDeEventos();
    }


    @Override
    public void establecerManejoDeEventos() {
        this.responder.setOnAction(event -> {
            //Cuando se presiona el boton responder entonces:

            // reviso si todas las opciones fueron asignadas
            VBox opcionesGrupoDefault = this.vista.obtenerGrupoDefault();

            if (!opcionesGrupoDefault.getChildren().isEmpty()) {
                System.out.println("Por favor agrupe todas las opciones");
                return;
            }

            // Obtengo los grupos
            VBox grupo1 = this.vista.obtenerGrupo1Opciones();
            VBox grupo2 = this.vista.obtenerGrupo2Opciones();

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
            jugador.cargarPuntajeRonda(pregunta.calcularPuntaje(respuestaJugador));
            Poder poderSeleccionado = poderesBox.obtenerPoderSeleccionado();//este if esta expuesto logica de negocios
            Poderes.verificarPoder(poderSeleccionado, jugador.getPuntajeParcial());
            poderesBox.actualizarPoderes();
            showScoreAlert();

            if (onResponder != null) {
                onResponder.run();
            }

        });
    }

    private void showScoreAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Puntaje del Jugador");
        alert.setHeaderText(null);
        alert.setContentText("El puntaje del jugador " + jugador.getNombre() + " es: " + jugador.getPuntajeParcial().obtenerPuntuacion());
        alert.showAndWait();
    }

    @Override
    public Poder poderUsado(){
        return poderesBox.obtenerPoderSeleccionado();
    }

    @Override
    public void setOnResponder(Runnable onResponder) {
        this.onResponder = onResponder;
    }

}
