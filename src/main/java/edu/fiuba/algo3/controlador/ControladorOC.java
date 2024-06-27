package edu.fiuba.algo3.controlador;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.PoderesVista;
import edu.fiuba.algo3.vista.VistaOC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.input.DragEvent;



public class ControladorOC implements ControladorPregunta{
    private PreguntaOC pregunta;
    private Jugador jugador;
    private VistaOC vista;
    private PoderesVista poderesBox;
    private Poder poderSeleccionado;
    private Button responder;


    public ControladorOC(Jugador jugador, PreguntaOC pregunta, VistaOC vista, PoderesVista poderesVista, Button responder) {
        this.poderesBox = poderesVista; //Falta relacionar la cantidad de poderes disponibles con el jugador.
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.vista = vista;
        this.responder = responder;
        initialize();
    }

    @Override
    public void initialize() {
        crearYConfigurarCeldas();
        vista.mostrarPregunta(pregunta);
        vista.mostrarOpciones(pregunta.obtenerOpciones());
        establecerManejoDeEventos();
    }

    @Override
    public void establecerManejoDeEventos() {
        poderesBox.obtenerBotonDuplicador().setOnAction(event -> {
            if(poderesBox.obtenerBotonDuplicador().isSelected()){
                poderSeleccionado = (Duplicador) poderesBox.obtenerBotonDuplicador().getUserData();
                System.out.println("Poder seleccionado: Duplicador");
            }else{
                poderSeleccionado = null;
                System.out.println("Poder deseleccionado: Duplicador");
            }
        });

        responder.setOnAction(event -> {
            RespuestaOC respuestaJugador = new RespuestaOC();//creo la respuesta del jugador
            ObservableList<Opcion> items = vista.obtenerOpcionesListView().getItems();//cambio li ListView en una ObservableList porque sino no me deja hacer el ciclo for
            for(Opcion opcionDeRespuesta : items){
                respuestaJugador.agregar(opcionDeRespuesta);//agrego la opcion a la respuesta
            }
            Puntaje puntaje = pregunta.calcularPuntaje(respuestaJugador);

            if (poderSeleccionado != null) {
                poderSeleccionado.aplicar(puntaje);
                poderesBox.cantDuplicador--;
                poderesBox.actualizarPoderes();
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

                ObservableList<Opcion> items = vista.obtenerOpcionesListView().getItems();
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
        vista.obtenerOpcionesListView().setItems(opcionesObservable);
        vista.obtenerOpcionesListView().setCellFactory(lv -> {
            ListCell<Opcion> cell = crearCeldas();
            configurarArrastreYSoltar(cell);
            return cell;
        });
    }

}



