package edu.fiuba.algo3.vista.recursos;


import java.io.File;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;


public class Sonidos {
    File fondo;
    String dir_fondo;
    MediaPlayer reproductor;

    public Sonidos(String nombreArchivo){
        this.fondo = new File(nombreArchivo);
        this.dir_fondo = "file:///" + fondo.getAbsolutePath();
    }

    public void sonar(){
        dir_fondo = dir_fondo.replace("\\", "/");
        Media musica = new Media(dir_fondo);
        reproductor = new MediaPlayer(musica);
        reproductor.play();
    }
    public void parar(){
        reproductor.stop();
    }
}
