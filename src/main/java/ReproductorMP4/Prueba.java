package ReproductorMP4;

import Control.Controlador;
import Modelo.Pelicula;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;

public class Prueba extends Application{
    private Controlador controlador;
    private ReproductorMP4 reproductorMP4;
    @Override
    public void start(Stage stage) throws Exception {
        reproductorMP4 = new ReproductorMP4();
        controlador = new Controlador(reproductorMP4, stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
