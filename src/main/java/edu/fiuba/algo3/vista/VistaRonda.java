package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class VistaRonda extends VBox {

    public VistaRonda(List<Jugador> jugadores) {
        Label titulo = new Label("Resultados de la Ronda");
        Button boton = new Button("Siguiente");
        TableView<Jugador> tablaPuntajes = this.agregarTablaPuntaje(jugadores);
        HBox contenedor = new HBox(tablaPuntajes);
        this.getChildren().addAll(titulo, contenedor, boton);
        this.setAlignment(Pos.CENTER);
    }

    private TableView<Jugador> agregarTablaPuntaje(List<Jugador> jugadores){
        TableView<Jugador> tablaPuntajes = new TableView<>();
        TableColumn<Jugador, String> nombreColumn = new TableColumn<>("Nombre");
        nombreColumn.setCellValueFactory(new PropertyValueFactory<Jugador, String>("nombre"));

        TableColumn<Jugador, Integer> puntajeColumn = new TableColumn<>("Puntaje");
        puntajeColumn.setCellValueFactory(new PropertyValueFactory<Jugador, Integer>("puntaje"));



        tablaPuntajes.getColumns().addAll(nombreColumn, puntajeColumn);
        tablaPuntajes.getItems().addAll(jugadores);
        return tablaPuntajes;
    }
}




