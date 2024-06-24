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
import javafx.scene.control.ToggleButton;


public class PreguntaVFVista extends Application {




    @Override
    public void start(Stage stage) {


        String textoPregunta = "El tomate es una fruta?";
        RespuestaVF correcta = new RespuestaVF();
        correcta.agregarOpcion(new Opcion("V"));
        PreguntaVF preguntaVF = new PreguntaVF(textoPregunta, new Opciones(), correcta);
        Jugador j1 = new Jugador("Axel");
        VistaVF vista = new VistaVF(preguntaVF);
        //BOTONES
        Label enunciadoLabel = new Label("¿El tomate es una fruta?");

        Button BotonResponder = new Button("Responder");

        ToggleGroup grupoOpciones = new ToggleGroup();
        ToggleGroup grupoPoderes = new ToggleGroup();

        //botones de opciones
        RadioButton opcion1 = new RadioButton("verdadero");
        opcion1.setUserData(new Opcion("V"));
        opcion1.setToggleGroup(grupoOpciones);

        RadioButton opcion2 = new RadioButton("falso");
        opcion2.setUserData(new Opcion("F"));
        opcion2.setToggleGroup(grupoOpciones);


        //BOTONES DE PODERES
        ToggleButton botonDuplicador = new ToggleButton("Duplicador");
        botonDuplicador.setMaxWidth(Double.MAX_VALUE);
        botonDuplicador.setToggleGroup(grupoPoderes);

        ToggleButton botonTriplicador = new ToggleButton("Triplicador");
        botonTriplicador.setMaxWidth(Double.MAX_VALUE);
        botonTriplicador.setToggleGroup(grupoPoderes);

        ToggleButton botonExclusividad = new ToggleButton("Exclusividad");
        botonExclusividad.setMaxWidth(Double.MAX_VALUE);
        botonExclusividad.setToggleGroup(grupoPoderes);

        ToggleButton botonAnulador = new ToggleButton("Anulador");
        botonAnulador.setMaxWidth(Double.MAX_VALUE);
        botonAnulador.setToggleGroup(grupoPoderes);


        Label cantidadDuplicadores = new Label("1");
        Label cantidadTriplicadores = new Label("1");
        Label cantidadExclusividad = new Label("2");
        Label cantidadAnulador = new Label("1");

        //CONTROLADOR

        ControladorVF controlador = new ControladorVF(new VistaVF(preguntaVF), j1, preguntaVF, new VistaPrincipal() );
        BotonResponder.setOnAction(controlador::handleAcceptButtonAction);

        //CONTENEDORES
        HBox opciones = new HBox(20, opcion1, opcion2);

        VBox layout = new VBox(20, enunciadoLabel, opciones);//tiene las opciones y la pregunta
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(5, 5 , 5 , 5));
        layout.setMinWidth(150);

        VBox poderes = new VBox(20, botonDuplicador, botonTriplicador, botonExclusividad, botonAnulador);
        poderes.setPadding(new Insets(5, 5 , 5 , 5));

        VBox cantidadPoderes = new VBox(20, cantidadDuplicadores, cantidadTriplicadores, cantidadExclusividad, cantidadAnulador);
        cantidadPoderes.setPadding(new Insets(10, 15 , 0 , 0));
        cantidadPoderes.setSpacing(29);

        HBox sublayout = new HBox(20, layout, poderes, cantidadPoderes);//tiene la pregunta y los poderes.
        sublayout.setMaxWidth(Double.MAX_VALUE);
        sublayout.setPadding(new Insets(10, 10 , 10 , 10));

        //ESTILOS
        poderes.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        sublayout.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        opciones.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        layout.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");


        VBox principal = new VBox(sublayout, BotonResponder);
        principal.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        principal.setSpacing(10);
        principal.setPadding(new Insets(10));
        principal.setAlignment(Pos.CENTER);

        Scene scene = new Scene(principal); //350, 400);

        stage.setTitle("Verdadero o Falso");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


/*
        Button botonDuplicador = new Button("Duplicador");
        botonDuplicador.setMaxWidth(Double.MAX_VALUE);
        Button botonTriplicador = new Button("Triplicador");
        botonTriplicador.setMaxWidth(Double.MAX_VALUE);
        Button boton3 = new Button("Exclusividad");
        botonExclusividad.setMaxWidth(Double.MAX_VALUE);
        Button botonAnulador = new Button("Anulador");
        botonAnulador.setMaxWidth(Double.MAX_VALUE);*/


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