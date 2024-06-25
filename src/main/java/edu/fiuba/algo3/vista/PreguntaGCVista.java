package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PreguntaGCVista extends Application {

    @Override
    public void start(Stage stage) {
        Label enunciadoLabel = new Label("Asignar Frutas y Verduras"); //pregunta.obtenertexto()
        Button BotonResponder = new Button("Responder");

        ToggleGroup grupoPoderes = new ToggleGroup();

        ToggleButton Boton1 = new ToggleButton("Duplicador");
        Boton1.setMaxWidth(Double.MAX_VALUE);
        Boton1.setToggleGroup(grupoPoderes);

        ToggleButton Boton2 = new ToggleButton("Triplicador");
        Boton2.setMaxWidth(Double.MAX_VALUE);
        Boton2.setToggleGroup(grupoPoderes);

        ToggleButton Boton3 = new ToggleButton("Exclusividad");
        Boton3.setMaxWidth(Double.MAX_VALUE);
        Boton3.setToggleGroup(grupoPoderes);

        ToggleButton Boton4 = new ToggleButton("Anulador");
        Boton4.setMaxWidth(Double.MAX_VALUE);
        Boton4.setToggleGroup(grupoPoderes);

        Label cantidadDuplicadores = new Label("1"); //jugador.getCantDuplicador()
        Label cantidadTriplicadores = new Label("1");
        Label cantidadExclusividad = new Label("2");
        Label cantidadAnulador = new Label("1");

        Text option1 = new Text("Tomate");
        Text option2 = new Text("Mandarina");
        Text option3 = new Text("Cebolla");
        Text option4 = new Text("Lechuga");

        VBox optionsBox = new VBox(10, option1, option2, option3, option4);

        VBox enunciado = new VBox(10, enunciadoLabel, optionsBox);

        enableDrag(option1);
        enableDrag(option2);
        enableDrag(option3);
        enableDrag(option4);

        VBox grupo1 = new VBox(10);
        grupo1.setStyle("-fx-border-color: black; -fx-padding: 10;");
        grupo1.setPrefSize(150, 200);
        Label nombreGrupo1 = new Label("Frutas");
        VBox grupo1Box = new VBox(5, nombreGrupo1, grupo1);

        VBox grupo2 = new VBox(10);
        grupo2.setStyle("-fx-border-color: black; -fx-padding: 10;");
        grupo2.setPrefSize(150, 200);
        Label nombreGrupo2 = new Label("Verduras");
        VBox grupo2Box = new VBox(5, nombreGrupo2, grupo2);

        enableDrop(grupo1, grupo2, optionsBox);
        enableDrop(grupo2, grupo1, optionsBox);

        HBox groupsBox = new HBox(20, grupo1Box, grupo2Box);

        VBox layout = new VBox(15, enunciado, groupsBox);
        layout.setAlignment(Pos.CENTER);
        layout.setMinWidth(260);
        layout.setPadding(new Insets(5, 5 , 5 , 5));

        VBox poderes = new VBox(20, Boton1, Boton2, Boton3, Boton4);
        poderes.setPadding(new Insets(5, 5 , 5 , 5));

        VBox cantidadPoderes = new VBox(20, cantidadDuplicadores, cantidadTriplicadores, cantidadExclusividad, cantidadAnulador);
        cantidadPoderes.setPadding(new Insets(10, 15 , 0 , 0));
        cantidadPoderes.setSpacing(29);

        // ControladorGC controlador = new ControladorGC(grupo1, grupo2, new Jugador("Axel"));
        // BotonResponder.setOnAction(controlador::handleAcceptButtonAction);

        HBox sublayout = new HBox(20, layout, poderes, cantidadPoderes);//tiene la pregunta y los poderes.
        sublayout.setMaxWidth(Double.MAX_VALUE);
        sublayout.setPadding(new Insets(10, 10 , 10 , 10));

        poderes.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        sublayout.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        layout.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");

        VBox principal = new VBox(sublayout, BotonResponder);
        principal.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        principal.setSpacing(10);
        principal.setPadding(new Insets(10));
        principal.setAlignment(Pos.CENTER);

        Scene scene = new Scene(principal, 600, 300);

        stage.setTitle("Multiple Choice");
        stage.setScene(scene);
        stage.show();
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

    public static void main(String[] args) {
        launch(args);
    }
}
