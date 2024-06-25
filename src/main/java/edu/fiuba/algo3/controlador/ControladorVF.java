package edu.fiuba.algo3.controlador;
import edu.fiuba.algo3.modelo.*;
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

    public ControladorVF(VistaVF vistaVF, Jugador jugador, Pregunta pregunta, Opciones options) {
        this.vistaVF = vistaVF;
        this.opciones = options;
        this.opcionesVisibles = new ListView<>();//Considerar si la clase opciones puede hacerse cargo de esto
        this.jugador = jugador;
        this.pregunta = pregunta;
        initialize();

    }
    private void initialize() {
        crearYConfigurarCeldas(); //esto setea opcionesListView
        this.vistaVF.mostrarPregunta(this.pregunta, opcionesVisibles);
        establecerManejoDeEventos();
    }
    private void crearYConfigurarCeldas() { //Refactor: deberia ser una clase aparte

        ObservableList<Opcion> opcionesObservable = FXCollections.observableArrayList(this.opciones.devolverOpciones());
        opcionesVisibles.setItems(opcionesObservable);
        opcionesVisibles.setCellFactory(lv -> {
            ListCell<Opcion> cell = crearCeldas();
            return cell;

        });
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
                jugador.sumarPuntaje(puntaje);
                System.out.println("Puntaje de " + jugador.obtenerNombre() + " : " + jugador.obtenerPuntaje());

            }else {
                System.out.println("Por favor selecciona una opción.");
            }
            });
    }

    public void handleAcceptButtonAction(ActionEvent event) {


        //pregunta.calcularPuntaje(respuesta);
        //aca no sé si usar puntaje y asignarselo al jugador o esperar despues y usar el multiplicador

        /* Logica de pregunta vf
        if (boton1.isSelected() && opcion.esIgual(new Opcion("V"))) {
            showScoreAlert(1);
        }
        else if(boton2.isSelected() && opcion2.esIgual(new Opcion("F"))){
            showScoreAlert(0);
        }
        */
    }
    private void showScoreAlert(int puntaje ) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Puntaje del Jugador");
        alert.setHeaderText(null);
        alert.setContentText("El puntaje del jugador " + jugador.obtenerNombre() + " es: " + puntaje);

        alert.showAndWait();
    }

    private ListCell<Opcion> crearCeldas(){//Aca modificamos las celdas para que se vean las opciones de forma string
        return new ListCell<Opcion>() {
            @Override
            protected void updateItem(Opcion item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                    setGraphic(null);
                }else{
                    setText(item.obtenerTexto());
                }
            }
        };
    }
}
