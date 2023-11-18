package ReproductorMP4;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.net.MalformedURLException;

public class Escena3 {
    private Stage stage;
    private Slider slVolumen;
    private Button btPlayPause;
    private Slider slTiempoDeReproduccion;
    private MediaView mediaView;
    private Scene scene;
    private String titulo;
    private Button btAtras;

    public MediaView getMediaView() {
        return mediaView;
    }

    public void setMediaView(MediaPlayer pelicula) {
        this.mediaView.setMediaPlayer(pelicula);
    }

    public Escena3(Stage stage) throws MalformedURLException {
        this.stage= stage;
        String titulo = new String();
        this.stage.setTitle(titulo);
        btAtras = new Button("Regresar");
        btPlayPause = new Button("Play/Pause");
        slVolumen = new Slider(0, 100, 50);
        slTiempoDeReproduccion = new Slider();
        mediaView = new MediaView();

        HBox controles = new HBox(btAtras, btPlayPause, slVolumen);
        controles.setAlignment(Pos.CENTER);
        VBox contenedor = new VBox(mediaView, slTiempoDeReproduccion, controles);
        contenedor.setAlignment(Pos.CENTER);
        scene = new Scene(contenedor, 800, 600);
        stage.setScene(scene);
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

    public Scene getScene() {
        return scene;
    }

    public Button getBtAtras() {
        return btAtras;
    }
}
