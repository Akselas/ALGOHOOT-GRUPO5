package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.controlador.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;


public class VistaPrincipal extends Application {
    private Stage ventanaPrincipal;
    private Button responder;
    private VBox vistaPrincipal;
    @Override
    public void start(Stage stage) {
        this.ventanaPrincipal = stage;
        ventanaPrincipal.setWidth(400);
        ventanaPrincipal.setHeight(400);
        this.vistaPrincipal = establecerVistaPrincipal();
        mostrarVistaVF();
        //mostrarVistaOC();
        //mostrarVistaMC();
        //mostrarVistaGC();
    }

    public void mostrarVistaVF() { //debería ser mostrarVistaPregunta para encapsular
        Parser creador = new Parser();
        PreguntaVF preguntaVF = creador.devolverPreguntaVF();
        Jugador jugador = new Jugador("Axel");
        VistaVF vistaVF = new VistaVF();

        //Controlador llama una funcion mostrarPregunta para setear la vista
        ControladorVF controladorVF = new ControladorVF(vistaVF, jugador, preguntaVF, preguntaVF.obtenerOpciones());

        Scene scene = new Scene(vistaVF.getLayout());
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("AlgoHoot");
        ventanaPrincipal.show();
    }
    public VBox establecerVistaPrincipal(){
        VBox vista = new VBox();
        vista.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        vista.setSpacing(10);
        vista.setPadding(new Insets(10));
        vista.setAlignment(Pos.CENTER);
        return vista;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
