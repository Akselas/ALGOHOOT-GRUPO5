package edu.fiuba.algo3.controlador;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.PoderesVista;
import edu.fiuba.algo3.vista.VistaVF;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class ControladorVF implements ControladorPregunta{

    private VistaVF vista;
    private Jugador jugador;
    private Pregunta pregunta;
    private PoderesVista poderesBox;
    private Runnable onResponder;

    public ControladorVF(Pregunta pregunta, Jugador jugador){
        this.vista = new VistaVF();
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.poderesBox = new PoderesVista(jugador, pregunta); //por ahora lo dejamos adentro

        initialize();
    }
    @Override
    public void mostrarVentanaPregunta(Stage fondo){
        Scene escena = vista.proyectar(poderesBox);
        fondo.setScene(escena);
        fondo.setTitle(pregunta.obtenerTipo());
        fondo.show();
    }
    @Override
    public void initialize(){//no me deja ponerlo en privado
        this.vista.mostrarPregunta(this.pregunta, this.jugador);
        this.vista.mostrarOpciones(pregunta.obtenerOpciones());
        establecerManejoDeEventos();
    }

    @Override
    public void establecerManejoDeEventos() {
        this.vista.obtenerBotonResponder().setOnAction(event -> {
            //Cuando se presiona el boton responder entonces:
            //Creo la respuesta del jugador
            RespuestaVF respuestaJugador = new RespuestaVF();

            // Obtengo el botón seleccionado
            RadioButton botonSeleccionado = (RadioButton) this.vista.obtenerGrupoOpciones().getSelectedToggle();
            // Si se presionó el boton Responder pero no se presiono ninguna opcion entonces pregunto
            if (botonSeleccionado != null) {
                //Obtengo el valor del boton seleccionado, que es de la clase Opcion
                respuestaJugador.agregarOpcion((Opcion) botonSeleccionado.getUserData());
                jugador.cargarPuntajeRonda(pregunta.calcularPuntaje(respuestaJugador));
                Poder poderSeleccionado = poderesBox.obtenerPoderSeleccionado();//este if esta expuesto logica de negocios
                Poderes.verificarPoder(poderSeleccionado, jugador.getPuntajeParcial());
                poderesBox.actualizarPoderes();

                System.out.println("Puntaje de " + jugador.getNombre() + " : " + jugador.getPuntaje());

            }else {
                System.out.println("Por favor selecciona una opción.");
            }

            if (onResponder != null) {
                onResponder.run();
            }

            });
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
