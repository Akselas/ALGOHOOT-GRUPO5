package edu.fiuba.algo3.controlador;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.PoderesVista;
import edu.fiuba.algo3.vista.PreguntaOCVista;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.input.DragEvent;



public class ControladorOC {
    private PreguntaOC pregunta;
    private Jugador jugador;
    private PreguntaOCVista vista;
    private ListView<Opcion> opcionesListView;
    private PoderesVista poderesVista;
    private Poder poderSeleccionado;


    public ControladorOC(Jugador jugador, PreguntaOC pregunta, PreguntaOCVista vista, PoderesVista poderesVista) {//Pregunta preguntaOC

        this.poderesVista = poderesVista;
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

        poderesVista.obtenerBotonDuplicador().setOnAction(event -> {
            if(poderesVista.obtenerBotonDuplicador().isSelected()){
                poderSeleccionado = (Duplicador) poderesVista.obtenerBotonDuplicador().getUserData();
                System.out.println("Poder seleccionado: Multiplicador");
            }else{
                poderSeleccionado = null;
                System.out.println("Poder deseleccionado: Duplicador");
            }
        });

        vista.obtenerBotonResponder().setOnAction(event -> {
            RespuestaOC respuestaJugador = new RespuestaOC();//creo la respuesta del jugador
            ObservableList<Opcion> items = opcionesListView.getItems();//cambio li ListView en una ObservableList porque sino no me deja hacer el ciclo for
            for(Opcion opcionDeRespuesta : items){
                respuestaJugador.agregar(opcionDeRespuesta);//agrego la opcion a la respuesta
            }
            Puntaje puntaje = pregunta.calcularPuntaje(respuestaJugador);

            if (poderSeleccionado != null) {
                poderSeleccionado.aplicar(puntaje);
                poderesVista.cantDuplicador--;
                poderesVista.actualizarPoderes();
                poderSeleccionado = null;
            }

            jugador.sumarPuntaje(puntaje);
            System.out.println("Puntaje de " + jugador.obtenerNombre()+ " : " + jugador.obtenerPuntaje());
        });

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
        ObservableList<Opcion> opcionesObservable = FXCollections.observableArrayList(pregunta.obtenerOpciones().devolverOpciones());
        opcionesListView.setItems(opcionesObservable);
        opcionesListView.setCellFactory(lv -> {
            ListCell<Opcion> cell = crearCeldas();
            configurarArrastreYSoltar(cell);
            return cell;
        });
    }

}



