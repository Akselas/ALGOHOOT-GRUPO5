package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.controlador.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.*;


public class VistaPrincipal extends Application {
    private Stage ventanaPrincipal;
    private Button responder;
    private VBox vistaPrincipal;
    private PoderesVista poderesBox;
    private Parser creador;

    @Override
    public void start(Stage stage) {
        this.ventanaPrincipal = stage;
        responder = new Button("Responder");
        ventanaPrincipal.setWidth(500);
        ventanaPrincipal.setHeight(500);
        this.vistaPrincipal = establecerVistaPrincipal();
        this.poderesBox = new PoderesVista();
        this.creador = new Parser();

        //mostrarVistaVF();
        //mostrarVistaOC();
        //mostrarVistaMC();
        mostrarVistaGC();

    }


    public void mostrarVistaGC() { //debería ser mostrarVistaPregunta para encapsular
        PreguntaGC preguntaGC = creador.devolverPreguntaGC();
        Jugador jugador = new Jugador("Axel");
        VistaGC vistaGC = new VistaGC();

        //Controlador llama una funcion mostrarPregunta para setear la vista
        ControladorGC controladorGC = new ControladorGC(vistaGC, jugador, preguntaGC, poderesBox, responder);
        proyectarVista(vistaGC);
    }

    public void mostrarVistaVF() { //debería ser mostrarVistaPregunta para encapsular
        PreguntaVF preguntaVF = creador.devolverPreguntaVF();
        Jugador jugador = new Jugador("Axel");
        VistaVF vistaVF = new VistaVF();

        //Controlador llama una funcion mostrarPregunta para setear la vista
        ControladorVF controladorVF = new ControladorVF(vistaVF, jugador, preguntaVF, poderesBox, responder);
        proyectarVista(vistaVF);
    }

    public void mostrarVistaMC() {

        PreguntaMC preguntaMC = creador.devolverPreguntaMC();
        Jugador jugador = new Jugador("Axel");

        VistaMC vistaMC = new VistaMC();
        ControladorMC controlador = new ControladorMC(jugador, preguntaMC, vistaMC, poderesBox, responder);
        proyectarVista(vistaMC);
    }

    public void mostrarVistaOC(){
        //return new VistaX().show()
        PreguntaOC preguntaOC = creador.devolverPreguntaOC();
        Jugador j1 = new Jugador("Pepe");
        VistaOC vistaOC = new VistaOC();
        ControladorOC controlador = new ControladorOC(j1,preguntaOC, vistaOC, poderesBox, responder);
        proyectarVista(vistaOC);
    }

    private void proyectarVista(VistaPregunta vistaPregunta) {
        HBox ventanaPregunta = new HBox(20, vistaPregunta, poderesBox.obtenerLayout());
        ventanaPregunta.setMaxWidth(Double.MAX_VALUE);
        ventanaPregunta.setPadding(new Insets(10, 10, 10, 10));
        ventanaPregunta.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");

        vistaPrincipal.getChildren().clear();
        vistaPrincipal.getChildren().addAll(ventanaPregunta, responder);

        Scene scene = new Scene(vistaPrincipal);
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
