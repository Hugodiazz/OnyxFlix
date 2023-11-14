package Control;

import Modelo.Pelicula;
import ReproductorMP4.ReproductorMP4;
import View.Escena1;
import javafx.beans.property.ReadOnlyProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ReproductorMP4.EscenaPrueba;
import javafx.util.Duration;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private Stage stage;
    private ReproductorMP4 reproductorMP4;
    private EscenaPrueba escenaPrueba;
    public Controlador(ReproductorMP4 reproductorMP4, Stage stage) throws MalformedURLException, URISyntaxException {
        this.stage = stage;
        this.reproductorMP4= reproductorMP4;

        List<String> actores = new ArrayList<>();
        Pelicula pelicula = new Pelicula("/SPIDER-MAN.mp4", "", "SpiderMan", "us", "1234", "", actores, "", "");
        reproductorMP4.reproducirPelicula(pelicula);
        //escenaPrueba = new EscenaPrueba(stage);
        Escena1 escena1= new Escena1(stage);


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
