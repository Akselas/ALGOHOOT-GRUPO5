package edu.fiuba.algo3.vista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PreguntaOCVista {
    private Label enunciadoLabel;
    //private VBox poderesBox;
    private VBox layout;
    private Button responder;
    //private ToggleButton duplicador;
    //private Button triplicador;


    public PreguntaOCVista(Button responder) {
        enunciadoLabel = new Label();
        this.responder = responder;
//        duplicador = new ToggleButton("Duplicador (2)");
//        duplicador.setUserData(new Duplicador());
//        duplicador.setMaxWidth(Double.MAX_VALUE);
//        ToggleGroup grupoPoderes = new ToggleGroup();
//        duplicador.setToggleGroup(grupoPoderes);

        //triplicador = new Button();

//        this.poderesBox = new VBox(50, duplicador);
//        poderesBox.setSpacing(10);

        this.layout = new VBox(20, enunciadoLabel);
        this.layout.setSpacing(10);
        this.layout.setPadding(new Insets(20, 20, 20, 20));
        this.layout.setAlignment(Pos.CENTER);

        layout.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");

    }
    public void mostrarPregunta(PreguntaOC pregunta, ListView<Opcion> opcionesListView) {
        enunciadoLabel.setText(pregunta.obtenerTexto());
        layout.getChildren().add(opcionesListView);
    }

    public Button obtenerBotonResponder() {
        return this.responder;
    }

//    public ToggleButton obtenerBotonDuplicador() {
//        return duplicador;
//    }
    public VBox getLayout(){
        return this.layout;
    }
    /*public Button obtenerBotonTriplicador() {
        return triplicador;
    }*/


   /* public void actualizarPoderes(int cantDuplicador) {
        duplicador.setText("Duplicador (" + cantDuplicador + ")");
        //triplicador.setText("Triplicador: " + cantTriplicador);
    }*/
}


