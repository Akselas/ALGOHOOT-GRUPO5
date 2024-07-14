package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.controlador.*;
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
    private Button responder;
    private VBox vistaPrincipal;
    private PoderesVista poderesBox;
    private Parser creador;

    @Override
    public void start(Stage stage) {
        this.ventanaPrincipal = stage;
        String ruta = "src/main/resources/preguntasSource.json";

        try {
            FaseManejador manejadorDeFases = new FaseManejador(ventanaPrincipal,ruta );
            manejadorDeFases.iniciarFase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        FaseInicial faseInicial = new FaseInicial(stage);
//        faseInicial.mostrarFase();



//        Poderes poderes = new Poderes();
//        List<Jugador> jugadores= new ArrayList<>();
//        jugadores.add(new Jugador("Denu"));
//        jugadores.add(new Jugador("Juani"));
//        jugadores.add(new Jugador("Axel"));
//        VistaRonda vistaRonda = new VistaRonda(stage,jugadores, poderes);;
//        vistaRonda.mostrarVistaRonda();



//        responder = new Button("Responder");
//        this.responder.getStyleClass().add("answer-button");
//        ventanaPrincipal.setWidth(500);
//        ventanaPrincipal.setHeight(500);
//        this.vistaPrincipal = establecerVistaPrincipal();
         //Jugador jugador = new Jugador("Axel");
         //mostrarVistaGC(jugador);
        //mostrarVistaMC();
//        this.poderesBox = new PoderesVista(jugador);
//        //creador.devolverPrimeraPregunta();

    }


    public void mostrarVistaGC(Jugador jugador) { //debería ser mostrarVistaPregunta para encapsular


       /* Grupo frutas = new Grupo();
        frutas.agregar(new Opcion("tomate"));
        frutas.agregar(new Opcion("mandarina"));
        frutas.agregar(new Opcion("manzana"));

        Grupo verduras = new Grupo();
        verduras.agregar(new Opcion("cebolla"));
        verduras.agregar(new Opcion("lechuga"));
        verduras.agregar(new Opcion("zanahoria"));

        Opciones opciones = new Opciones();
        opciones.agregarOpcion(new Opcion("tomate"));
        opciones.agregarOpcion(new Opcion("mandarina"));
        opciones.agregarOpcion(new Opcion("manzana"));
        opciones.agregarOpcion(new Opcion("cebolla"));
        opciones.agregarOpcion(new Opcion("lechuga"));
        opciones.agregarOpcion(new Opcion("zanahoria"));

        RespuestaGC correcta = new RespuestaGC(frutas, verduras);



        PreguntaGC preguntaGC = new PreguntaGC("ordenar Frutas y Verduras", opciones, "Frutas", "Verduras", correcta);
        ControladorFactory controladorFactory = new ControladorFactory();
        ControladorPregunta controlador = controladorFactory.crearControlador(preguntaGC, jugador);

        controlador.mostrarVentanaPregunta(ventanaPrincipal);*/
    }

    public void mostrarVistaVF(Jugador jugador) { //debería ser mostrarVistaPregunta para encapsular
        /*PreguntaVF preguntaVF = creador.devolverPreguntaVF();
        //poderesBox.agregarBotones(preguntaVF);
        VistaVF vistaVF = new VistaVF();

        //Controlador llama una funcion mostrarPregunta para setear la vista
        ControladorVF controladorVF = new ControladorVF(preguntaVF, jugador);
        proyectarVista(vistaVF);*/
       // Jugador jugador = new Jugador("Axel");
        /*Opcion opc1 = new Opcion("Verdadero");
        Opcion opc2 = new Opcion("Falso");
        Opciones opciones = new Opciones();
        opciones.agregarOpcion(opc1);
        opciones.agregarOpcion(opc2);
        RespuestaVF correcta = new RespuestaVF();//Estado inconsistente no debería haber una respuesta sin opcion
        correcta.agregarOpcion(opc1);
        PreguntaVF pregunta = new PreguntaVF("El tomate es una fruta?", opciones, correcta);
        ControladorFactory controladorFactory = new ControladorFactory();
        ControladorPregunta controlador = controladorFactory.crearControlador(pregunta, jugador);

        controlador.mostrarVentanaPregunta(ventanaPrincipal);*/
    }

    public void mostrarVistaMC() {

        /*Jugador jugador = new Jugador("Axel");

        Opciones opciones = new Opciones();
        Opcion opcion1 = new Opcion("Elefante");
        Opcion opcion2 = new Opcion("Mono");
        Opcion opcion3 = new Opcion("Pato");
        Opcion opcion4 = new Opcion("Ave");

        opciones.agregarOpcion(opcion1);
        opciones.agregarOpcion(opcion2);
        opciones.agregarOpcion(opcion3);
        opciones.agregarOpcion(opcion4);

        RespuestaMC correcta = new RespuestaMC();
        correcta.agregarOpcionSeleccionada(opcion1);
        correcta.agregarOpcionSeleccionada(opcion2);
        correcta.agregarOpcionNoSeleccionada(opcion3);
        correcta.agregarOpcionNoSeleccionada(opcion4);


        PreguntaMC pregunta = new PreguntaMC("Que animal es mamifero?", opciones, correcta);

        ControladorFactory controladorFactory = new ControladorFactory();
        ControladorPregunta controlador = controladorFactory.crearControlador(pregunta, jugador);

        controlador.mostrarVentanaPregunta(ventanaPrincipal);*/

        /*Jugador jugador = new Jugador("Axel");

        Opciones opciones = new Opciones();
        Opcion opcion1 = new Opcion("Elefante");
        Opcion opcion2 = new Opcion("Tiburon");
        Opcion opcion3 = new Opcion("Pato");

        opciones.agregarOpcion(opcion1);
        opciones.agregarOpcion(opcion2);
        opciones.agregarOpcion(opcion3);

        RespuestaMC correcta = new RespuestaMC();
        correcta.agregarOpcionSeleccionada(opcion1);
        correcta.agregarOpcionSeleccionada(opcion2);
        correcta.agregarOpcionNoSeleccionada(opcion3);

        PreguntaMC pregunta = new PreguntaMC("Que animal es mamifero?", opciones, correcta);

        RespuestaMC respuestaJugador = new RespuestaMC();
        respuestaJugador.agregarOpcionSeleccionada(opcion1);
        respuestaJugador.agregarOpcionSeleccionada(opcion2);
        respuestaJugador.agregarOpcionNoSeleccionada(opcion3);

        jugador.cargarPuntajeRonda(pregunta.calcularPuntaje(respuestaJugador));
        System.out.println(jugador.getPuntajeParcial().obtenerPuntuacion());*/

    }

    public void mostrarVistaOC(Jugador jugador){
        //return new VistaX().show()
        //PreguntaOC preguntaOC = creador.devolverPreguntaOC();
      //poderesBox.agregarBotones(preguntaOC);
        VistaOC vistaOC = new VistaOC();
       // ControladorOC controlador = new ControladorOC(preguntaOC, jugador);
        //proyectarVista(vistaOC);
    }

    private void proyectarVista(VistaPregunta vistaPregunta) {
        HBox ventanaPregunta = new HBox(20, vistaPregunta, poderesBox);
        ventanaPregunta.setMaxWidth(Double.MAX_VALUE);
        ventanaPregunta.setPadding(new Insets(10, 10, 10, 10));
        ventanaPregunta.getStyleClass().add("pregunta");

        vistaPrincipal.getChildren().clear();
        vistaPrincipal.getChildren().addAll(ventanaPregunta, responder);

        Scene scene = new Scene(vistaPrincipal);
        scene.getStylesheets().add(getClass().getResource("/FaseJuego.css").toExternalForm());
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("AlgoHoot");
        ventanaPrincipal.show();
    }

    public VBox establecerVistaPrincipal(){
        VBox vista = new VBox();
        vista.setId("VistaPrincipal");
        vista.setSpacing(10);
        vista.setPadding(new Insets(10));
        vista.setAlignment(Pos.CENTER);
        return vista;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
