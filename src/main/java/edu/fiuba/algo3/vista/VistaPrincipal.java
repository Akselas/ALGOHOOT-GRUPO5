package edu.fiuba.algo3.vista;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;



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
