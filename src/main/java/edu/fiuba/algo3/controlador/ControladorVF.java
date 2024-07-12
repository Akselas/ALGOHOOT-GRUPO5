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
    private Button responder;

    public ControladorVF(Pregunta pregunta, Jugador jugador){
        this.vista = new VistaVF();
        this.jugador = jugador;
        this.poderesBox = new PoderesVista(jugador); //por ahora lo dejamos adentro
        this.pregunta = pregunta;
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
    public void initialize(){//no me deja ponerlo en privado
        this.vista.mostrarPregunta(this.pregunta);
        this.vista.mostrarOpciones(pregunta.obtenerOpciones());
        establecerManejoDeEventos();
    }

    @Override
    public void establecerManejoDeEventos() {
        this.responder.setOnAction(event -> {
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
            });
    }
    @Override
    public Poder poderUsado(){
        return poderesBox.obtenerPoderSeleccionado();
    }
}
