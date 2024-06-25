package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.controlador.ControladorMC;
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
        mostrarVistaMC();
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

    public void mostrarVistaMC() {
        RespuestaMC correcta = new RespuestaMC();

        Opcion opcion1 = new Opcion("4");
        Opcion opcion2 = new Opcion("Un numero par");
        Opcion opcion3 = new Opcion("2");
        Opcion opcion4 = new Opcion("Un numero impar");

        correcta.agregarOpcionSeleccionada(opcion1);
        correcta.agregarOpcionSeleccionada(opcion2);
        correcta.agregarOpcionNoSeleccionada(opcion3);
        correcta.agregarOpcionNoSeleccionada(opcion4);

        Opciones opciones = new Opciones();
        opciones.agregarOpcion(opcion1);
        opciones.agregarOpcion(opcion2);
        opciones.agregarOpcion(opcion3);
        opciones.agregarOpcion(opcion4);

        PreguntaMC preguntaMC = new PreguntaMC("Cuanto es 2+2?", opciones, correcta);
        Jugador jugador = new Jugador("Axel");

        VistaMC vistaMC = new VistaMC(preguntaMC);
        ControladorMC controlador = new ControladorMC(jugador, preguntaMC, vistaMC);

        Scene scene = new Scene(vistaMC.getLayout());
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("AlgoHoot");
        ventanaPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
