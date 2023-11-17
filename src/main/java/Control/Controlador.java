package Control;

import Datos.Datos;
import Modelo.Pelicula;
import ReproductorMP4.ReproductorMP4;
import View.Escena1;
import View.Escena2;
import View.Vista;
import javafx.beans.property.ReadOnlyProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ReproductorMP4.EscenaPrueba;
import javafx.util.Duration;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controlador {
    private Stage stage;
    private ReproductorMP4 reproductorMP4;
    private EscenaPrueba escenaPrueba;
    private Datos datos;
    private Vista vista;
    public Controlador(Vista vista, ReproductorMP4 reproductorMP4, Stage stage, Datos datos) throws MalformedURLException, URISyntaxException {
        this.vista = vista;
        this.stage = stage;
        this.reproductorMP4= reproductorMP4;
        this.datos = datos;

        //reproductorMP4.reproducirPelicula(datos.getPeliculas().getFirst());
        //escenaPrueba = new EscenaPrueba(stage);

        Escena1 escena1= new Escena1(stage, datos.getPeliculas());
        Escena2 escena2= new Escena2(stage);

        stage.setScene(escena1.getScene());
        stage.show();
        //escena1.createScrollPane(datos.getPeliculas());

        if (escena1.getScrollPadre() != null){
            escena1.getScrollPadre().setOnMouseClicked(e->{
                cambiarEscena(escena2.getScene());
                escena2.iniciarDatos(escena1.getPeliculaSeleccionada());
            });
        }

        escena2.getBotonAtras().setOnMouseClicked(e ->{
            cambiarEscena(escena1.getScene());
        });


        /*
        escenaPrueba.getMediaView().setMediaPlayer(reproductorMP4.getPeliculaReproduciendo());
        actualizarSlider();
        escenaPrueba.getMediaView().setOnMouseClicked(e ->{
            reproductorMP4.playPause();
        });

        escenaPrueba.getBtPlayPause().setOnMouseClicked(e ->{
            reproductorMP4.playPause();
        });
        escenaPrueba.getSlVolumen().valueProperty().addListener((observable, oldValue, newValue) -> {
            reproductorMP4.setVolumen(newValue.doubleValue() / 100.0);
        });
        escenaPrueba.getSlTiempoDeReproduccion().setOnMousePressed(e ->{
            if (reproductorMP4.getPeliculaReproduciendo() != null){
                reproductorMP4.getPeliculaReproduciendo().pause();
            }
        });
        escenaPrueba.getSlTiempoDeReproduccion().setOnMouseReleased(e -> {
            if(reproductorMP4.getPeliculaReproduciendo() != null){
                double duration = reproductorMP4.getPeliculaReproduciendo().getTotalDuration().toSeconds();
                double seekTime = escenaPrueba.getSlTiempoDeReproduccion().getValue() / 100 * duration;
                reproductorMP4.getPeliculaReproduciendo().seek(Duration.seconds(seekTime));
                reproductorMP4.getPeliculaReproduciendo().play();
                actualizarSlider();
            }
        });

         */


    }

    public void cambiarEscena(Scene scene){
        vista.setScene(scene);
    }

    public void actualizarSlider(){
        reproductorMP4.getPeliculaReproduciendo().currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            if (!escenaPrueba.getSlTiempoDeReproduccion().isPressed()) {
                double duration = reproductorMP4.getPeliculaReproduciendo().getTotalDuration().toSeconds();
                double currentTime = newValue.toSeconds();
                if (duration > 0) {
                    escenaPrueba.getSlTiempoDeReproduccion().setValue(currentTime / duration * 100);
                }
            }
        });
    }
}
