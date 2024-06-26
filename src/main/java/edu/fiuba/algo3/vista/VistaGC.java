package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Opciones;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.PreguntaGC;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VistaGC {
    private VBox layout;
    //private ToggleGroup grupoPoderes;
    private VBox grupo1;
    private VBox grupo2;
    private VBox grupo1Box;
    private VBox grupo2Box;
    private Label nombreGrupo1;
    private Label nombreGrupo2;
    private VBox grupoDefault;
    private Button botonResponder;
    private Label titulo;

    public VistaGC(){
        this.titulo = new Label();
        this.grupoDefault = new VBox(10);
        this.grupo1 = new VBox(10);
        this.grupo2 = new VBox(10);
        this.grupo1Box = new VBox(5);
        this.grupo2Box = new VBox(5);
        this.nombreGrupo1 = new Label();
        this.nombreGrupo2 = new Label();
        this.botonResponder = new Button("Responder");

        setupLayout();
    }

    public void setupLayout(){
        this.grupo1.setStyle("-fx-border-color: black; -fx-padding: 10;");
        this.grupo1.setPrefSize(150, 200);
        this.grupo1Box.getChildren().add(nombreGrupo1);
        this.grupo1Box.getChildren().add(grupo1);

        this.grupo2.setStyle("-fx-border-color: black; -fx-padding: 10;");
        this.grupo2.setPrefSize(150, 200);
        this.grupo2Box.getChildren().add(nombreGrupo2);
        this.grupo2Box.getChildren().add(grupo2);

        HBox groupos = new HBox(20, this.grupo1Box, this.grupo2Box);

        VBox layoutPregunta = new VBox(25, this.titulo, this.grupoDefault, groupos);
        layoutPregunta.setAlignment(Pos.CENTER);
        layoutPregunta.setPadding(new Insets(5));

        VBox principal = new VBox(layoutPregunta, this.botonResponder);
        principal.setSpacing(10);
        principal.setPadding(new Insets(10));
        principal.setAlignment(Pos.CENTER);

        this.layout = principal;
    }

    public VBox getLayout() {
        return this.layout;
    }

    public void mostrarPregunta(Pregunta pregunta, VBox opcionesView) {
        this.titulo.setText(pregunta.obtenerTexto());
        //enunciadoLabel.setText(pregunta.obtenerTexto());
        layout.getChildren().add(opcionesView);
    }

    public void mostrarOpciones(Pregunta pregunta) {
        Opciones opciones = pregunta.obtenerOpciones();

        for (Opcion o : opciones) {
            Text option = new Text(o.obtenerTexto());
            enableDrag(option);
            this.grupoDefault.getChildren().add(option);
        }

        PreguntaGC preguntaGC = (PreguntaGC) pregunta;

        this.nombreGrupo1.setText(preguntaGC.obtenerNombreGrupo1());
        this.nombreGrupo2.setText(preguntaGC.obtenerNombreGrupo2());

        enableDrop(this.grupo1, this.grupo2, this.grupoDefault);
        enableDrop(this.grupo2, this.grupo1, this.grupoDefault);
    }

    public Button obtenerBotonResponder(){
        return this.botonResponder;
    }

    public VBox obtenerGrupo1Opciones(){
        return this.grupo1;
    }

    public VBox obtenerGrupo2Opciones(){
        return this.grupo2;
    }

    public VBox obtenerGrupoDefault(){
        return this.grupoDefault;
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
}
