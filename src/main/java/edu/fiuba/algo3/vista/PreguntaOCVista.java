package edu.fiuba.algo3.vista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PreguntaOCVista extends VBox {
    private Label enunciadoLabel;
    private Button responder;
    private VBox poderesBox;
    private VBox layout;
    private ToggleButton duplicador;
    //private Button triplicador;


    public PreguntaOCVista() {
        enunciadoLabel = new Label();
        responder = new Button("Responder");
        duplicador = new ToggleButton("Duplicador (2)");
        duplicador.setUserData(new Duplicador());
        duplicador.setMaxWidth(Double.MAX_VALUE);
        ToggleGroup grupoPoderes = new ToggleGroup();
        duplicador.setToggleGroup(grupoPoderes);

        //triplicador = new Button();

        this.poderesBox = new VBox(50, duplicador);
        poderesBox.setSpacing(10);

        this.layout = new VBox(20, enunciadoLabel);
        this.setSpacing(10);
        this.setPadding(new Insets(20, 20, 20, 20));
        this.layout.setAlignment(Pos.CENTER);

        HBox sublayout = new HBox(20, layout, poderesBox);//tiene la pregunta y los poderes.
        sublayout.setMaxWidth(Double.MAX_VALUE);
        sublayout.setPadding(new Insets(10, 10 , 10 , 10));


        poderesBox.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        sublayout.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        layout.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");

        this.getChildren().addAll(sublayout, responder);
        this.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER);


    }
    public void mostrarPregunta(PreguntaOC pregunta, ListView<Opcion> opcionesListView) {
        enunciadoLabel.setText(pregunta.obtenerTexto());
        layout.getChildren().add(opcionesListView);
    }

    public Button obtenerBotonResponder() {
        return this.responder;
    }

    public ToggleButton obtenerBotonDuplicador() {
        return duplicador;
    }
    public VBox getLayout(){
        return this.layout;
    }
    /*public Button obtenerBotonTriplicador() {
        return triplicador;
    }*/


    public void actualizarPoderes(int cantDuplicador) {
        duplicador.setText("Duplicador (" + cantDuplicador + ")");
        //triplicador.setText("Triplicador: " + cantTriplicador);
    }
}


