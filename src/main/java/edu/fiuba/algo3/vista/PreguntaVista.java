package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class PreguntaVista extends Application {
    @Override
    public void start(Stage stage) {
        Label enunciadoLabel = new Label();
        enunciadoLabel.setText("¿El tomate es una fruta?");
        Button BotonResponder = new Button("Responder");

        GridPane layout = new GridPane();
        //layout.getChildren().addAll(enunciadoLabel, BotonResponder);
        layout.add(enunciadoLabel, 7, 5);
        layout.add(BotonResponder, 7, 15);


        ToggleGroup group = new ToggleGroup();

        RadioButton opcion1 = new RadioButton("verdadero");
        opcion1.setToggleGroup(group);
        layout.add(opcion1, 5, 10); // Col: 5, Fila:10


        RadioButton opcion2 = new RadioButton("falso");
        opcion2.setToggleGroup(group);
        layout.add(opcion2, 10, 10); // Col 10, Fila 10


        layout.setHgap(7); // Espaciado horizontal entre nodos
        layout.setVgap(4); // Espaciado vertical entre nodos

        Scene scene = new Scene(layout, 370, 200);

        stage.setTitle("Verdadero o Falso");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


