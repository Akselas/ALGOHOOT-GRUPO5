package edu.fiuba.algo3.controlador;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.PreguntaOCVista;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.input.DragEvent;
import java.util.ArrayList;


public class ControladorOC {
    private ArrayList<Opcion> opciones;//despues modificar
    private PreguntaOC pregunta;
    private Jugador jugador;
    private PreguntaOCVista vista;
    private ListView<Opcion> opcionesListView;
    private Poder poderSeleccionado;
    private int cantDuplicador = 2;
    //private int cantTriplicador;


    public ControladorOC(ArrayList<Opcion> opciones, Jugador jugador, PreguntaOC pregunta, PreguntaOCVista vista) {//Pregunta preguntaOC
        this.opciones = opciones;
        this.opcionesListView = new ListView<>();
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.vista = vista;
        initialize();
    }

    private void initialize() {
        crearYConfigurarCeldas();
        vista.mostrarPregunta(pregunta, opcionesListView);
        addEventHandlers();
    }


    private void addEventHandlers() {
        vista.obtenerBotonResponder().setOnAction(event -> {
            RespuestaOC respuestaJugador = new RespuestaOC();//creo la respuesta del jugador
            ObservableList<Opcion> items = opcionesListView.getItems();//cambio li ListView en una ObservableList porque sino no me deja hacer el ciclo for
            for(Opcion opcionDeRespuesta : items){
                respuestaJugador.agregar(opcionDeRespuesta);//agrego la opcion a la respuesta
            }
            Puntaje puntaje = pregunta.calcularPuntaje(respuestaJugador);
            conPoder(puntaje);

            jugador.sumarPuntaje(puntaje);
            System.out.println("Puntaje de " + jugador.obtenerNombre()+ " : " + jugador.obtenerPuntaje());
        });

        vista.obtenerBotonDuplicador().setOnAction(event -> {
            poderSeleccionado = (Duplicador) vista.obtenerBotonDuplicador().getUserData();
            System.out.println("Poder seleccionado: Multiplicador");
        });
    }

    private void conPoder(Puntaje puntaje){
        if (poderSeleccionado != null) {
            if (poderSeleccionado.equals(new Duplicador())) {
                Duplicador duplicador = new Duplicador();
                duplicador.aplicar(puntaje);
                cantDuplicador--;
            }
            vista.actualizarPoderes(cantDuplicador);//aca seria algo de jugador
        }

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

    private void configurarArrastreYSoltar(ListCell<Opcion> cell){//Aca se hace el metodo de arrastre, soltar, y se reemplaza
        cell.setOnDragDetected(event -> {
            if(cell.getItem() == null){
                return;
            }
            Dragboard db = cell.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(Integer.toString(cell.getIndex())); // Transferimos el índice del item
            db.setContent(content);
            event.consume();
        });

        cell.setOnDragOver(event -> {
            if(event.getGestureSource() != cell && event.getDragboard().hasString()){
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        cell.setOnDragDropped(event -> {
            if(cell.getItem() == null){
                return;
            }

            Dragboard db = event.getDragboard();
            boolean success = false;

            if(db.hasString()){
                int draggedIdx = Integer.parseInt(db.getString());
                int thisIdx = cell.getIndex();

                ObservableList<Opcion> items = opcionesListView.getItems();
                Opcion temp = items.get(draggedIdx);
                items.set(draggedIdx, items.get(thisIdx));
                items.set(thisIdx, temp);

                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
        });

        cell.setOnDragDone(DragEvent::consume);
    }

    private void crearYConfigurarCeldas() {
        ObservableList<Opcion> opcionesObservable = FXCollections.observableArrayList(this.opciones);
        opcionesListView.setItems(opcionesObservable);
        opcionesListView.setCellFactory(lv -> {
            ListCell<Opcion> cell = crearCeldas();
            configurarArrastreYSoltar(cell);
            return cell;
        });
    }

}



