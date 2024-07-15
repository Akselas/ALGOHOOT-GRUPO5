package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import edu.fiuba.algo3.vista.recursos.Sonidos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.List;

public class FaseFinal implements Fase {
    Stage fondo;
    FaseManejador manejador;
    Sonidos sonidoFinal;

    public FaseFinal(Stage stage, FaseManejador manejador){
        this.fondo = stage;
        this.manejador = manejador;
        this.sonidoFinal = new Sonidos("musicaFinal.mp3");
    }
    @Override
    public void iniciar(){
        this.sonidoFinal.sonar();
        String ganador = manejador.obtenerAtributos().obtenerGanador();
        Label mensajeGanador = new Label("¡Felicidades " + ganador + " sos el ganador!");
        Button botonTerminado = new Button("Terminar juego");

        botonTerminado.setOnAction(event -> {
            this.sonidoFinal.parar();
            fondo.close();
        });

        TableView<Jugador> tablaPuntajes = this.crearTablaPuntaje();
        Text textoExtra = this.crearTextoPoderes();

        HBox contenedor = new HBox(tablaPuntajes, textoExtra);
        contenedor.setSpacing(20);
        contenedor.setMinHeight(200);
        contenedor.setMaxWidth(700);

        HBox.setHgrow(tablaPuntajes, Priority.ALWAYS);
        HBox.setHgrow(textoExtra, Priority.NEVER);

        VBox.setMargin(mensajeGanador, new Insets(10, 0, 40, 0)); // Espacio alrededor del título
        VBox.setMargin(botonTerminado, new Insets(40, 0, 0, 0));


        VBox layout = new VBox(mensajeGanador, contenedor, botonTerminado);
        layout.setId("VistaFinal");
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);
        layout.setMinHeight(500);
        layout.setMaxWidth(800);
        layout.setPadding(new Insets(20));
        Scene scene = new Scene(layout, 800, 500);
        scene.getStylesheets().add(getClass().getResource("/FaseFinal.css").toExternalForm());
        fondo.setScene(scene);
        fondo.setTitle("AlgoHoot");
        fondo.show();
    }

    private TableView<Jugador> crearTablaPuntaje(){
        Jugadores jugadores = manejador.obtenerAtributos().getJugadores();
        jugadores.ordenarPorPuntaje();
        TableView<Jugador> tablaPuntajes = new TableView<>();
        tablaPuntajes.setFixedCellSize(25); // Tamaño fijo de las celdas
        tablaPuntajes.prefHeightProperty().bind(tablaPuntajes.fixedCellSizeProperty().multiply(jugadores.getJugadores().size()));

        TableColumn<Jugador, String> nombreColumn = new TableColumn<>("Nombre");
        nombreColumn.setCellValueFactory(new PropertyValueFactory<Jugador, String>("nombre"));
        nombreColumn.setMaxWidth(150);

        TableColumn<Jugador, Integer> puntajeColumn = new TableColumn<>("Puntaje");
        puntajeColumn.setCellValueFactory(new PropertyValueFactory<Jugador, Integer>("puntaje"));
        puntajeColumn.setMaxWidth(150);

        //Agrega los puntajes a la tabla
        tablaPuntajes.getColumns().addAll(nombreColumn, puntajeColumn);
        tablaPuntajes.getItems().addAll(jugadores.getJugadores());

        tablaPuntajes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//esto es para que solo esten las columnas necesarias, y no las vacias

        return tablaPuntajes;
    }

    private Text crearTextoPoderes(){
        Jugadores jugadores = manejador.obtenerAtributos().getJugadores();
        jugadores.ordenarPorPuntaje();
        Text textoExtra = new Text();
        textoExtra.setWrappingWidth(250);
        textoExtra.setTextAlignment(TextAlignment.JUSTIFY);
        List<String> podio = jugadores.obtenerPodio();
        textoExtra.setText("PUESTOS\n");
        int puesto = 1;
        for(String nombre: podio){
            textoExtra.setText(textoExtra.getText() + puesto + "° puesto es de: " + nombre + "\n");
            puesto++;
        }


        return textoExtra;
    }
    @Override
    public void fasePromover(){

    }



}
