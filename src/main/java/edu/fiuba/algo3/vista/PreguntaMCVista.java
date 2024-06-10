package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class PreguntaMCVista extends Application {
    @Override
    public void start(Stage stage) {
        Label enunciadoLabel = new Label();
        enunciadoLabel.setText("¿Cuanto es 2+2?");
        Button BotonResponder = new Button("Responder");

        GridPane layout = new GridPane();
        layout.add(enunciadoLabel, 7, 5);
        layout.add(BotonResponder, 7, 20);

        RadioButton opcion1 = new RadioButton("un numero par");
        layout.add(opcion1, 5, 10); // Col: 5, Fila:10


        RadioButton opcion2 = new RadioButton("un numero impar");
        layout.add(opcion2, 10, 10); // Col 10, Fila 10

        RadioButton opcion3 = new RadioButton("2");
        layout.add(opcion3, 5, 15); // Col 10, Fila 10

        RadioButton opcion4 = new RadioButton("todas las anteriores");
        layout.add(opcion4, 10, 15); // Col 10, Fila 10


        layout.setHgap(7); // Espaciado horizontal entre nodos
        layout.setVgap(4); // Espaciado vertical entre nodos

        Scene scene = new Scene(layout, 450, 200);

        stage.setTitle("Multiple Choice");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
