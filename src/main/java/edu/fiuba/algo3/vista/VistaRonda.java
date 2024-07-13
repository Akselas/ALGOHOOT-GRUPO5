package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import edu.fiuba.algo3.modelo.*;
import javafx.stage.Stage;

import java.util.List;

public class VistaRonda {
    Stage ventanaPrincipal;
    Jugadores jugadores;
    Poderes poderes;//Estos los poderes usados en la ronda
    private Button botonSiguiente;

    public VistaRonda(Stage ventanaPrincipal, Jugadores jugadores, Poderes poderes) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.jugadores = jugadores;
        this.poderes = poderes;
        iniciar();
    }

    private void iniciar(){
        Label titulo = new Label("Resultados de la Ronda");
        botonSiguiente = new Button("Siguiente");

        TableView<Jugador> tablaPuntajes = this.crearTablaPuntaje();
        Text textoExtra = this.crearTextoPoderes();

        HBox contenedor = new HBox(tablaPuntajes, textoExtra);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPadding(new Insets(10)); // Añade padding si deseas más espacio alrededor de los nodos

        VBox.setMargin(titulo, new Insets(10, 0, 40, 0)); // Espacio alrededor del título
        VBox.setMargin(contenedor, new Insets(0, 0, 20, 0)); // Espacio alrededor del contenedor
        VBox.setMargin(botonSiguiente, new Insets(40, 0, 0, 0));
        HBox.setMargin(tablaPuntajes, new Insets(0, 20, 0, 0));

        VBox vistaRonda = new VBox(titulo, contenedor, botonSiguiente);
        vistaRonda.setId("VistaRonda");
        vistaRonda.setAlignment(Pos.CENTER);
        vistaRonda.setSpacing(10);
        vistaRonda.setPadding(new Insets(20));
        Scene scene = new Scene(vistaRonda);
        scene.getStylesheets().add(getClass().getResource("/FaseIntermedia.css").toExternalForm());
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("AlgoHoot");
    }

    private TableView<Jugador> crearTablaPuntaje(){
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
        Text textoExtra = new Text("En esta ronda se utilizó al menos una vez los siguientes poderes:\n");
        for(Poder poder : poderes.devolverPoderes()){//aca considero que solo hay una sola instancia por cada tipo de poder.
            if(!(poder instanceof Basico)){
                textoExtra.setText(textoExtra.getText() + "• " + poder.obtenerNombre() + " de puntaje\n");
            }
            textoExtra.setText(textoExtra.getText() + "• " + poder.obtenerNombre() + " de puntaje\n");
        }
        textoExtra.setWrappingWidth(150);
        return textoExtra;
    }

    public void mostrar(){
        ventanaPrincipal.show();
    }

    public Button getBotonSiguiente() {
        return botonSiguiente;
    }
}




