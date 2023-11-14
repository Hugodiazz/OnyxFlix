package ReproductorMP4;

import Control.Controlador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class EscenaPrueba {
    private Stage stage;
    private Slider slVolumen;
    private Button btPlayPause;
    private Slider slTiempoDeReproduccion;
    private MediaView mediaView;

    public MediaView getMediaView() {
        return mediaView;
    }

    public void setMediaView(MediaPlayer pelicula) {
        this.mediaView.setMediaPlayer(pelicula);
    }

    public EscenaPrueba(Stage stage) throws MalformedURLException {
        this.stage= stage;
        this.stage.setTitle("Prueba");/*
        File mediaFile = new File("src/SPIDER-MAN.mp4");
        Media media= new Media(mediaFile.toURI().toURL().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        */
        btPlayPause = new Button("Play/Pause");
        slVolumen = new Slider(0, 100, 50);
        slTiempoDeReproduccion = new Slider();
        mediaView = new MediaView();

        HBox controles = new HBox(btPlayPause, slVolumen);
        controles.setAlignment(Pos.CENTER);
        VBox contenedor = new VBox(mediaView, slTiempoDeReproduccion, controles);
        contenedor.setAlignment(Pos.CENTER);
        Scene scene = new Scene(contenedor, 800, 400);
        this.stage.setScene(scene);
    }

    public Button getBtPlayPause() {
        return btPlayPause;
    }

    public Slider getSlTiempoDeReproduccion() {
        return slTiempoDeReproduccion;
    }

    public Slider getSlVolumen() {
        return slVolumen;
    }
}
