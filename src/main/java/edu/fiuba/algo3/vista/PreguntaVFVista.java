package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PreguntaVFVista extends Application {




    @Override
    public void start(Stage stage) {
        Label enunciadoLabel = new Label("¿El tomate es una fruta?");

        Button BotonResponder = new Button("Responder");

        ToggleGroup group = new ToggleGroup();

        RadioButton opcion1 = new RadioButton("verdadero");
        opcion1.setUserData(new Opcion("V"));
        opcion1.setToggleGroup(group);

        RadioButton opcion2 = new RadioButton("falso");
        opcion2.setUserData(new Opcion("F"));
        opcion2.setToggleGroup(group);

        Button Boton1 = new Button("Duplicador");
        Boton1.setMaxWidth(Double.MAX_VALUE);
        Button Boton2 = new Button("Triplicador");
        Boton2.setMaxWidth(Double.MAX_VALUE);
        Button Boton3 = new Button("Exclusividad");
        Boton3.setMaxWidth(Double.MAX_VALUE);
        Button Boton4 = new Button("Anulador");
        Boton4.setMaxWidth(Double.MAX_VALUE);

        ControladorVF controlador = new ControladorVF(opcion1, opcion2, new Jugador("Axel"));
        BotonResponder.setOnAction(controlador::handleAcceptButtonAction);

        HBox opciones = new HBox(20, opcion1, opcion2);

        VBox layout = new VBox(20, enunciadoLabel, opciones);//tiene las opciones y la pregunta
        layout.setAlignment(Pos.CENTER);

        VBox poderes = new VBox(20, Boton1, Boton2, Boton3, Boton4);
        poderes.setPadding(new Insets(5, 0 , 0 , 0));

        HBox sublayout = new HBox(20, layout, poderes);//tiene la pregunta y los poderes.
        sublayout.setMaxWidth(Double.MAX_VALUE);

        poderes.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        sublayout.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        opciones.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        layout.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");


        VBox principal = new VBox(sublayout, BotonResponder);
        principal.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        principal.setSpacing(10);
        principal.setPadding(new Insets(10));
        principal.setAlignment(Pos.CENTER);

        Scene scene = new Scene(principal, 350, 400);

        stage.setTitle("Verdadero o Falso");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


//layout.setAlignment(Pos.CENTER);//posicionar lodo en el centro
       /* layout.setHgap(10); // Espaciado horizontal entre nodos
        layout.setVgap(10); // Espaciado vertical entre nodos
*/
//StackPane.setMargin(layout, new Insets(5));





//layout.setGridLinesVisible(true);//para poder ver las celdas



//layout.add(enunciadoLabel, 6, 5, 25, 2);
//layout.add(BotonResponder, 9, 20, 4, 1);

//layout.add(opcion1, 6, 15); // Col: 5, Fila:10
//layout.add(opcion2, 10, 15); // Col 10, Fila 10
//layout.setAlignment(Pos.CENTER);