package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
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
        btPlayPause = new Button("Play/Pause");
        slVolumen = new Slider(0, 100, 50);
        slTiempoDeReproduccion = new Slider();
        mediaView = new MediaView();

        HBox contenedorArriba = new HBox();
        btAtras = new Button();
        ImageView ivAtras = new ImageView(new Image("btVolverAtrasE3.png"));
        btAtras.setGraphic(ivAtras);
        contenedorArriba.getChildren().add(btAtras);


        HBox contenedorSlider = new HBox();
        VBox.setVgrow(contenedorSlider, Priority.ALWAYS);
        contenedorSlider.setPadding(new Insets(0,46,0,46));
        HBox.setHgrow(slTiempoDeReproduccion, Priority.ALWAYS);
        contenedorSlider.setStyle("-fx-border-color: blue");
        contenedorSlider.setAlignment(Pos.BOTTOM_CENTER);
        contenedorSlider.getChildren().add(slTiempoDeReproduccion);

        HBox controles = new HBox(btPlayPause, slVolumen);
        controles.setAlignment(Pos.CENTER);

        VBox contenedorMultimedia = new VBox(10);
        contenedorMultimedia.getChildren().addAll(contenedorArriba, contenedorSlider, controles);
        contenedorMultimedia.setStyle("-fx-border-color: red");

        StackPane contenedor = new StackPane(mediaView,contenedorMultimedia);
        contenedor.setStyle("-fx-background-color: #000");
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
