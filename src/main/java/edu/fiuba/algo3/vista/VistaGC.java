package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VistaGC extends VistaPregunta{
    private VBox grupo1;
    private VBox grupo2;
    private VBox grupo1Box;
    private VBox grupo2Box;
    private Label nombreGrupo1;
    private Label nombreGrupo2;
    private VBox grupoDefault;
    public static final int alturaMaxima = 50;

    public VistaGC(){
        this.grupoDefault = new VBox(10);
        this.grupo1 = new VBox(10);
        this.grupo2 = new VBox(10);
        this.grupo1Box = new VBox(5);
        grupo1Box.setMaxHeight(alturaMaxima);
        this.grupo2Box = new VBox(5);
        grupo2Box.setMaxHeight(alturaMaxima);
        this.nombreGrupo1 = new Label();
        this.nombreGrupo2 = new Label();

        setupLayout();
    }

    public void setupLayout(){
        this.grupo1.setStyle("-fx-border-color: black; -fx-padding: 10;");
        this.grupo1.setPrefSize(150, 200);
        this.grupo1Box.getChildren().addAll(nombreGrupo1, grupo1);


        this.grupo2.setStyle("-fx-border-color: black; -fx-padding: 10;");
        this.grupo2.setPrefSize(150, 200);
        this.grupo2Box.getChildren().addAll(nombreGrupo2,grupo2);

        HBox groupos = new HBox(20, this.grupo1Box, this.grupo2Box);

        this.getChildren().addAll(this.grupoDefault, groupos);
        this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER);
    }

    /*@Override
    public void mostrarPregunta(Pregunta pregunta, Jugador jugador) {
        this.turno.setText("Turno: " + jugador.getNombre());
        this.tema.setText("Tema: "+ pregunta.obtenerTema());
        this.enunciadoLabel.setText(pregunta.obtenerTexto());
    }*/

    public void mostrarNombresDeGrupos(Pregunta pregunta){
        PreguntaGC preguntaGC = (PreguntaGC) pregunta;
        this.nombreGrupo1.setText(preguntaGC.obtenerNombreGrupo1());
        this.nombreGrupo2.setText(preguntaGC.obtenerNombreGrupo2());
    }

    @Override
    public void mostrarOpciones(Opciones opciones) {

        for (Opcion o : opciones) {
            Text option = new Text(o.obtenerTexto());
            enableDrag(option);
            this.grupoDefault.getChildren().add(option);
        }

        enableDrop(this.grupo1, this.grupo2, this.grupoDefault);
        enableDrop(this.grupo2, this.grupo1, this.grupoDefault);
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
                boolean esta = false;
                for (Node node : targetPane.getChildren()) {
                    if (node instanceof Text) {
                        Text text = (Text) node;
                        if (text.getText().equals(draggedText)) {
                            esta = true;
                            break;
                        }
                    }
                }
                if (!esta) {//aca lo hace porque no esta
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
            }
            event.setDropCompleted(success);
            event.consume();
        });
    }
}
