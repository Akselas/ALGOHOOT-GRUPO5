package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Poder;
import javafx.stage.Stage;

public interface ControladorPregunta {
   void initialize();
   void establecerManejoDeEventos();
   void mostrarVentanaPregunta(Stage stage);
   Poder poderUsado();
   void setOnResponder(Runnable onResponder);
}
