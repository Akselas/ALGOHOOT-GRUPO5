package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class PoderesVista {
    private VBox poderesVista;
    private ToggleGroup grupoPoderes;
    private ToggleButton duplicador;
    private ToggleButton triplicador;
    private ToggleButton exclusividad;
    private ToggleButton anulador;
    public int cantDuplicador; //esto va a cambiar
    public int cantTriplicador;
    public int cantidadExclusividad;
    public int cantAnulador;

    public PoderesVista() {

        cantDuplicador = 2;
        cantTriplicador = 2;
        cantidadExclusividad = 1;
        cantAnulador = 1;

        grupoPoderes = new ToggleGroup();

        duplicador = new ToggleButton("Duplicador (" + cantDuplicador + ")");
        duplicador.setMaxWidth(Double.MAX_VALUE);
        duplicador.setToggleGroup(grupoPoderes);
        duplicador.setUserData(new Duplicador());


        triplicador = new ToggleButton("Triplicador (" + cantTriplicador + ")");
        triplicador.setMaxWidth(Double.MAX_VALUE);
        triplicador.setToggleGroup(grupoPoderes);


        exclusividad = new ToggleButton("Exclusividad (" + cantidadExclusividad + ")");
        exclusividad.setMaxWidth(Double.MAX_VALUE);
        exclusividad.setToggleGroup(grupoPoderes);


        anulador = new ToggleButton("Anulador (" + cantAnulador + ")");
        anulador.setMaxWidth(Double.MAX_VALUE);
        anulador.setToggleGroup(grupoPoderes);


        poderesVista = new VBox(20, duplicador, triplicador, exclusividad, anulador);
        poderesVista.setSpacing(40);
        poderesVista.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-style: solid;");
        poderesVista.setPadding(new Insets(10, 10, 10, 10));
        poderesVista.setAlignment(Pos.CENTER);
    }

    public VBox obtenerLayout() {
        return poderesVista;
    }

    public ToggleButton obtenerBotonDuplicador() {
        return duplicador;
    }

    public ToggleButton obtenerBotonTriplicador() {
        return triplicador;
    }

    public ToggleButton obtenerBotonExclusividad() {
        return exclusividad;
    }

    public ToggleButton obtenerBotonAnulador() {
        return anulador;
    }
    public void actualizarPoderes() {
        duplicador.setText("Duplicador (" + cantDuplicador + ")");
        triplicador.setText("Triplicador: (" + cantTriplicador + ")");
        exclusividad.setText("Exclusividad (" + cantidadExclusividad + ")");
        anulador.setText("Anulador (" + cantAnulador + ")");
    }

}
