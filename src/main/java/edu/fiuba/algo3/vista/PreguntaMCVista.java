package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PreguntaMCVista extends Application {
    @Override
    public void start(Stage stage) {



        Label enunciadoLabel = new Label("¿Cuanto es 2+2?"); //pregunta.obtenertexto()

        Button BotonResponder = new Button("Responder");


        CheckBox opcion1 = new CheckBox("un numero par"); //pregunta.obtenerOpciones()
        opcion1.setUserData(new Opcion("un numero par"));

        CheckBox opcion2 = new CheckBox("un numero impar");
        opcion2.setUserData(new Opcion("un numero impar"));

        CheckBox opcion3 = new CheckBox("4");
        opcion3.setUserData(new Opcion("4"));

        CheckBox opcion4 = new CheckBox("todas las anteriores");
        opcion4.setUserData(new Opcion("todas las anteriores"));


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

        //
        Label cantidadDuplicadores = new Label("1"); //jugador.getCantDuplicador()
        Label cantidadTriplicadores = new Label("1");
        Label cantidadExclusividad = new Label("2");
        Label cantidadAnulador = new Label("1");


        ControladorMC controlador = new ControladorMC(opcion1, opcion2, opcion3, opcion4, new Jugador("Axel"));
        BotonResponder.setOnAction(controlador::handleAcceptButtonAction);

        HBox opciones1 = new HBox(20, opcion1, opcion2);//parte de arriba
        HBox opciones2 = new HBox(20, opcion3, opcion4);//parte de abajo


        VBox layout = new VBox(15, enunciadoLabel, opciones1, opciones2);//tiene las opciones y la pregunta
        layout.setAlignment(Pos.CENTER);
        layout.setMinWidth(260);
        layout.setPadding(new Insets(5, 5 , 5 , 5));

        VBox poderes = new VBox(20, Boton1, Boton2, Boton3, Boton4);
        poderes.setPadding(new Insets(5, 5 , 5 , 5));

        VBox cantidadPoderes = new VBox(20, cantidadDuplicadores, cantidadTriplicadores, cantidadExclusividad, cantidadAnulador);
        cantidadPoderes.setPadding(new Insets(10, 15 , 0 , 0));
        cantidadPoderes.setSpacing(29);

        HBox sublayout = new HBox(20, layout, poderes, cantidadPoderes);//tiene la pregunta y los poderes.
        sublayout.setMaxWidth(Double.MAX_VALUE);
        sublayout.setPadding(new Insets(10, 10 , 10 , 10));

        poderes.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        sublayout.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        opciones1.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        opciones2.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        layout.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");


        VBox principal = new VBox(sublayout, BotonResponder);
        principal.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        principal.setSpacing(10);
        principal.setPadding(new Insets(10));
        principal.setAlignment(Pos.CENTER);

        Scene scene = new Scene(principal);

        stage.setTitle("Multiple Choice");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
