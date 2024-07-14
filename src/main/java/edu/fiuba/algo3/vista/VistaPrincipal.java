package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.vista.recursos.Sonidos;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class VistaPrincipal extends Application {
    private Stage ventanaPrincipal;
    private String ruta;

//    public VistaPrincipal(String ruta){
//        this.ruta = ruta;
//    }
    @Override
    public void start(Stage stage) {
        this.ventanaPrincipal = stage;
        String ruta = "src/main/resources/JsonFiles/preguntasSource.json";

        try {
            FaseManejador manejadorDeFases = new FaseManejador(ventanaPrincipal, ruta);
            manejadorDeFases.iniciarFase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void iniciarJuego(){
        start(new Stage());

    }
    public static void main(String[] args) {
        launch(args);
    }
}
