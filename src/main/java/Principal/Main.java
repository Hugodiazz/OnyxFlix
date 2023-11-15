package Principal;

import Control.Controlador;
import Datos.Datos;
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
    private Datos datos;

    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        stage.setWidth(950);
        stage.setHeight(700);
        stage.setMinWidth(950);
        stage.setMinHeight(700);
        stage.setTitle("OnyxFlix");
        datos = new Datos();
        reproductorMP4 = new ReproductorMP4();
        vista = new Vista(stage);
        controlador= new Controlador(reproductorMP4,stage,datos);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
