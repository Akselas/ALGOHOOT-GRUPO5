package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PreguntaVFVista extends Application {

   // public void posicionarNodo( )



    @Override
    public void start(Stage stage) {
        Label enunciadoLabel = new Label("¿El tomate es una fruta?");
        //enunciadoLabel.setText("¿El tomate es una fruta?");

        Button BotonResponder = new Button("Responder");

        ToggleGroup group = new ToggleGroup();

        RadioButton opcion1 = new RadioButton("verdadero");
        opcion1.setToggleGroup(group);

        RadioButton opcion2 = new RadioButton("falso");
        opcion2.setToggleGroup(group);

        GridPane layout = new GridPane();

        layout.setConstraints(enunciadoLabel, 6, 5, 25, 2 );




        /*layout.add(enunciadoLabel, 6, 5, 25, 2);
        layout.add(BotonResponder, 9, 20, 4, 1);

        layout.add(opcion1, 6, 15); // Col: 5, Fila:10
        layout.add(opcion2, 10, 15); // Col 10, Fila 10*/


        //layout.setAlignment(Pos.CENTER);//posicionar lodo en el centro
        layout.setHgap(10); // Espaciado horizontal entre nodos
        layout.setVgap(10); // Espaciado vertical entre nodos

        StackPane.setMargin(layout, new Insets(5));

        //////////////////////////////////////////////

       /* // Crear VBox para los botones de poderes
        VBox poderesBox = new VBox(10); // Espaciado vertical entre los botones
        poderesBox.setTranslateX(200); // Ajustar la posición horizontal de VBox
        poderesBox.setTranslateY(50);  // Ajustar la posición vertical de VBox

        // Botón y etiqueta para el multiplicador
        Button botonMultiplicador = new Button("Multiplicador");
        Label labelMultiplicador = new Label("3"); // Número de multiplicadores disponibles
        HBox multiplicadorBox = new HBox(5, botonMultiplicador, labelMultiplicador);

        // Botón y etiqueta para el anulador
        Button botonAnulador = new Button("Anulador");
        Label labelAnulador = new Label("2"); // Número de anuladores disponibles
        HBox anuladorBox = new HBox(5, botonAnulador, labelAnulador);

        // Agregar HBox al VBox
        poderesBox.getChildren().addAll(multiplicadorBox, anuladorBox);

        // Agregar VBox al GridPane
        layout.add(poderesBox, 9, 5); // Colocar VBox en la columna 15 y fila 5
        //////////////////

*/

        layout.setGridLinesVisible(true);//para poder ver las celdas
        Scene scene = new Scene(layout, 600, 200);

        stage.setTitle("Verdadero o Falso");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


