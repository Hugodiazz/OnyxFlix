package Control;

import Datos.Datos;
import ReproductorMP4.ReproductorMP4;
import View.Escena1;
import View.Escena2;
import View.Vista;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ReproductorMP4.Escena3;
import javafx.util.Duration;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Controlador {
    private Stage stage;
    private ReproductorMP4 reproductorMP4;
    private Escena3 escena3;
    private Datos datos;
    private Vista vista;
    public Controlador(Vista vista, ReproductorMP4 reproductorMP4, Stage stage, Datos datos) throws MalformedURLException, URISyntaxException {
        this.vista = vista;
        this.stage = stage;
        this.reproductorMP4= reproductorMP4;
        this.datos = datos;


        Escena1 escena1= new Escena1(stage, datos.getPeliculas());
        Escena2 escena2= new Escena2(stage);
        Escena3 escena3 = new Escena3(stage);
        
        stage.setScene(escena1.getScene());
        stage.show();

        if (escena1.getScrollPadre() != null){
            escena1.getScrollPadre().setOnMouseClicked(e->{
                escena2.iniciarDatos(escena1.getPeliculaSeleccionada());
                cambiarEscena(escena2.getScene());
            });
        }

        escena2.getBotonAtras().setOnMouseClicked(e ->{
            cambiarEscena(escena1.getScene());
        });

        escena2.getBtnPlay().setOnMouseClicked(e ->{
            System.out.println("Reproduciendo pelicula chi cheñor.");
            try {
                reproductorMP4.reproducirPelicula(escena2.getPelicula());
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
            escena3.getMediaView().setMediaPlayer(reproductorMP4.getPeliculaReproduciendo());
            cambiarEscena(escena3.getScene());

            //actualizarSlider();
        });
        escena3.getMediaView().setOnMouseClicked(e ->{
            reproductorMP4.playPause();
        });

        escena3.getBtPlayPause().setOnMouseClicked(e ->{
            reproductorMP4.playPause();
        });
        escena3.getSlVolumen().valueProperty().addListener((observable, oldValue, newValue) -> {
            reproductorMP4.setVolumen(newValue.doubleValue() / 100.0);
        });
        escena3.getSlTiempoDeReproduccion().setOnMousePressed(e ->{
            if (reproductorMP4.getPeliculaReproduciendo() != null){
                reproductorMP4.getPeliculaReproduciendo().pause();
            }
        });
        escena3.getSlTiempoDeReproduccion().setOnMouseReleased(e -> {
            if(reproductorMP4.getPeliculaReproduciendo() != null){
                double duration = reproductorMP4.getPeliculaReproduciendo().getTotalDuration().toSeconds();
                double seekTime = escena3.getSlTiempoDeReproduccion().getValue() / 100 * duration;
                reproductorMP4.getPeliculaReproduciendo().seek(Duration.seconds(seekTime));
                reproductorMP4.getPeliculaReproduciendo().play();
                actualizarSlider();
            }
        });
        escena3.getBtAtras().setOnMouseClicked(e->{
            reproductorMP4.getPeliculaReproduciendo().dispose();
            cambiarEscena(escena2.getScene());
        });


    }

    public void cambiarEscena(Scene scene){
        vista.setScene(scene);
    }

    public void actualizarSlider(){
        reproductorMP4.getPeliculaReproduciendo().currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            if (!escena3.getSlTiempoDeReproduccion().isPressed()) {
                double duration = reproductorMP4.getPeliculaReproduciendo().getTotalDuration().toSeconds();
                double currentTime = newValue.toSeconds();
                if (duration > 0) {
                    escena3.getSlTiempoDeReproduccion().setValue(currentTime / duration * 100);
                }
            }
        });
    }
}
