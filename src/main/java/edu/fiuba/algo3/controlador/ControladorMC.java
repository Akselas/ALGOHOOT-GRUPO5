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
            showScoreAlert(puntajeRonda.obtenerPuntuacion());
        });
    }

    private void showScoreAlert(int puntaje ) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Puntaje del Jugador");
        alert.setHeaderText(null);
        alert.setContentText("El puntaje del jugador " + jugador.getNombre() + " es: " + jugador.getPuntaje());

        alert.showAndWait();
    }
}