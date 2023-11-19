package Control;

import Datos.Datos;
import Modelo.Pelicula;
import ReproductorMP4.ReproductorMP4;
import View.Escena1;
import View.Escena2;
import View.Vista;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import View.Escena3;
import javafx.util.Duration;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

public class Controlador {
    private Stage stage;
    private ReproductorMP4 reproductorMP4;
    private Datos datos;
    private Vista vista;
    private Escena3 escena3;
    private Escena1 escena1;
    private Escena2 escena2;
    public Controlador(Vista vista, ReproductorMP4 reproductorMP4, Stage stage, Datos datos) throws MalformedURLException, URISyntaxException {
        this.vista = vista;
        this.stage = stage;
        this.reproductorMP4= reproductorMP4;
        this.datos = datos;

        escena1= new Escena1(stage, datos.getPeliculas());
        escena2= new Escena2(stage);
        escena3 = new Escena3(stage);
        
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
                escena3.getMediaView().setMediaPlayer(reproductorMP4.getPeliculaReproduciendo());
                escena3.setTituloPelicula(escena2.getPelicula().getNombre());
                actualizarSlider();
                cambiarEscena(escena3.getScene());
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        });

        escena2.getBtnAnadirMas().setOnMouseClicked(e->{
            List<Pelicula> peliculas = reproductorMP4.getMiListaDeReproduccion();
            if (!peliculas.contains(escena2.getPelicula())) {
                reproductorMP4.setMiListaDeReproduccion(escena2.getPelicula());
                escena1.createScrollPaneMiLista(reproductorMP4.getMiListaDeReproduccion());
            }

            System.out.println("Peliculas en Lista");
            for (Pelicula pelicula: reproductorMP4.getMiListaDeReproduccion()){
                System.out.println(pelicula.getNombre());
            }

        });
        escena3.getMediaView().setOnMouseClicked(e ->{
            reproductorMP4.playPause();
        });

        escena3.getBtPlayPause().setOnMouseClicked(e ->{
            reproductorMP4.playPause();
            if (reproductorMP4.getPeliculaReproduciendo().getStatus() == javafx.scene.media.MediaPlayer.Status.PLAYING){
                escena3.getBtPlayPause().setGraphic(new ImageView(new Image("btPlayE3.png")));
            }else {
                escena3.getBtPlayPause().setGraphic(new ImageView(new Image("btPauseE3.png")));
            }
        });
        escena3.getSlVolumen().valueProperty().addListener((observable, oldValue, newValue) -> {
            reproductorMP4.setVolumen(newValue.doubleValue() / 100.0);
        });
        escena3.getSlTiempoDeReproduccion().setOnMousePressed(e ->{
            reproductorMP4.getPeliculaReproduciendo().pause();
        });
        escena3.getSlTiempoDeReproduccion().setOnMouseReleased(e -> {
            double duration = reproductorMP4.getPeliculaReproduciendo().getTotalDuration().toSeconds();
            double seekTime = escena3.getSlTiempoDeReproduccion().getValue() / 100 * duration;
            reproductorMP4.getPeliculaReproduciendo().seek(Duration.seconds(seekTime));
            reproductorMP4.getPeliculaReproduciendo().play();
            actualizarSlider();
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
        if (escena3 != null){
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
}
