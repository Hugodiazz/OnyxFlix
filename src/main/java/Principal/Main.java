package Principal;

import Control.Controlador;
import Modelo.Pelicula;
import ReproductorMP4.ReproductorMP4;
import View.Vista;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private Stage stage;
    private Controlador controlador;
    private ReproductorMP4 reproductorMP4;
    private Vista vista;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        stage.setWidth(950);
        stage.setHeight(700);
        stage.setTitle("OnyxFlix");
        reproductorMP4 = new ReproductorMP4();
        vista = new Vista(stage);
        controlador= new Controlador(reproductorMP4,stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
