package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.PoderesVista;
import edu.fiuba.algo3.vista.VistaGC;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.Node;

public class ControladorGC {
    private VBox grupo1;
    private VBox grupo2;

    private Opciones opciones;
    private VBox opcionesView;
    private VistaGC vistaGC;
    private Jugador jugador;
    private Pregunta pregunta;
    private VistaPrincipal vistaPrincipal;
    private PoderesVista poderesBox;
    private  Poder poderSeleccionado;

    public ControladorGC(VistaGC vistaGC, Jugador jugador, Pregunta pregunta, PoderesVista poderesBox) {
        this.vistaGC = vistaGC;
        this.opciones = pregunta.obtenerOpciones();
        this.opcionesView = new VBox();//Considerar si la clase opciones puede hacerse cargo de esto
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.poderesBox = poderesBox;
        initialize();
    }

    private void initialize() {
        this.vistaGC.mostrarOpciones(this.pregunta); //esto setea opcionesListView
        this.vistaGC.mostrarPregunta(this.pregunta, opcionesView);
        establecerManejoDeEventos();
    }

    private void crearYConfigurarOpciones() {

        VBox optionsBox = new VBox(10);
        for (Opcion o : this.opciones) {
            Text option = new Text(o.obtenerTexto());
            enableDrag(option);
            optionsBox.getChildren().add(option);
        }

        PreguntaGC preguntaGC = (PreguntaGC) this.pregunta;

        VBox grupo1 = new VBox(10);
        grupo1.setStyle("-fx-border-color: black; -fx-padding: 10;");
        grupo1.setPrefSize(150, 200);
        Label nombreGrupo1 = new Label(preguntaGC.obtenerNombreGrupo1());
        VBox grupo1Box = new VBox(5, nombreGrupo1, grupo1);

        VBox grupo2 = new VBox(10);
        grupo2.setStyle("-fx-border-color: black; -fx-padding: 10;");
        grupo2.setPrefSize(150, 200);
        Label nombreGrupo2 = new Label(preguntaGC.obtenerNombreGrupo1());
        VBox grupo2Box = new VBox(5, nombreGrupo2, grupo2);

        enableDrop(grupo1, grupo2, optionsBox);
        enableDrop(grupo2, grupo1, optionsBox);

        this.opcionesView.getChildren().add(new HBox(20, grupo1Box, grupo2Box));
    }

    private void establecerManejoDeEventos() {
        this.vistaGC.obtenerBotonResponder().setOnAction(event -> {
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

    public void handleAcceptButtonAction(ActionEvent event) {
        Grupo respuestaGrupo1 = new Grupo();
        for (Node node : this.grupo1.getChildren()) {
            if (node instanceof Text) {
                Text label = (Text) node;
                Opcion opcion = new Opcion(label.getText());
                respuestaGrupo1.agregar(opcion);
            }
        }

        Grupo respuestaGrupo2 = new Grupo();
        for (Node node : this.grupo2.getChildren()) {
            if (node instanceof Text) {
                Text label = (Text) node;
                Opcion opcion = new Opcion(label.getText());
                respuestaGrupo2.agregar(opcion);
            }
        }

        RespuestaGC respuestaGC = new RespuestaGC(respuestaGrupo1, respuestaGrupo2);
    }

    private void enableDrag(Text text) {
        text.setOnDragDetected(event -> {
            Dragboard db = text.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(text.getText());
            db.setContent(content);
            event.consume();
        });
    }

    private void enableDrop(Pane targetPane, Pane otherPane1, Pane otherPane2) {
        targetPane.setOnDragOver(event -> {
            if (event.getGestureSource() != targetPane && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        targetPane.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                String draggedText = db.getString();

                otherPane1.getChildren().removeIf(node -> {
                    if (node instanceof Text) {
                        Text text = (Text) node;
                        return text.getText().equals(draggedText);
                    }
                    return false;
                });

                otherPane2.getChildren().removeIf(node -> {
                    if (node instanceof Text) {
                        Text text = (Text) node;
                        return text.getText().equals(draggedText);
                    }
                    return false;
                });

                Text text = new Text(draggedText);
                enableDrag(text);
                targetPane.getChildren().add(text);
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
        });
    }

    private void showScoreAlert(int puntaje ) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Puntaje del Jugador");
        alert.setHeaderText(null);
        alert.setContentText("El puntaje del jugador " + jugador.obtenerNombre() + " es: " + puntaje);

        alert.showAndWait();
    }
}
