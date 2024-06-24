package edu.fiuba.algo3.vista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.*;


public class VistaPrincipal extends Application {
    private Stage ventanaPrincipal;

    @Override
    public void start(Stage stage) {
        this.ventanaPrincipal = stage;
        ventanaPrincipal.setWidth(400);
        ventanaPrincipal.setHeight(400);
        mostrarVistaVF();
        //mostrarVistaOC();
        //mostrarVistaMC();
        //mostrarVistaGC();
    }

    public void mostrarVistaVF() { //debería ser mostrarVistaPregunta para encapsular
        RespuestaVF correcta = new RespuestaVF();
        correcta.agregarOpcion(new Opcion("V"));
        PreguntaVF preguntaVF = new PreguntaVF("El tomate es una fruta?", new Opciones(), correcta);
        Jugador jugador = new Jugador("Axel");

        VistaVF vistaVF = new VistaVF(preguntaVF);

        //Controlador debe llamar una funcion mostrarPregunta para setear las caracteristicas
        //ControladorVF controladorVF = new ControladorVF(vistaVF, jugador, preguntaVF, this);

        Scene scene = new Scene(vistaVF.getLayout());
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("AlgoHoot");
        ventanaPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
