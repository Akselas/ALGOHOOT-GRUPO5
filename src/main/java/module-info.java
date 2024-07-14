module edu.fiuba.algo3 {
    requires javafx.controls;
    requires java.desktop;
    requires org.json;
    requires com.google.gson;
    requires javafx.media;
    //requires javafx.fxml;
    exports edu.fiuba.algo3.vista;
    exports edu.fiuba.algo3.controlador;

    opens edu.fiuba.algo3.modelo to javafx.base;
}