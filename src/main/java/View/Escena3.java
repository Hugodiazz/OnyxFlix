package View;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.MalformedURLException;

public class Escena3 {
    private HBox contenedorVolumen;
    private HBox controles;
    private VBox contenedorMultimedia;
    private HBox contenedorSlider;
    private HBox contenedorArriba;
    private Label tituloPelicula;
    private Stage stage;
    private Slider slVolumen;
    private Button btPlayPause;
    private Slider slTiempoDeReproduccion;
    private MediaView mediaView;
    private Scene scene;
    private String titulo;
    private Button btAtras;
    private Button btAdelantar;
    private Button btAtrasar;

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
        slTiempoDeReproduccion = new Slider();
        mediaView = new MediaView();

        contenedorArriba = new HBox(20);
        contenedorArriba.setAlignment(Pos.CENTER_LEFT);
        contenedorArriba = getContenedorArriba();

        contenedorSlider = new HBox();
        contenedorSlider = getContenedorSlider();

        contenedorVolumen = new HBox();


        controles = getControles();

        contenedorMultimedia = new VBox();
        contenedorMultimedia = getContenedorMultimedia();

        StackPane contenedor = new StackPane(mediaView,contenedorMultimedia);
        contenedor.setStyle("-fx-background-color: #000");

        // Agregar manejadores de eventos al StackPane
        contenedor.setOnMouseEntered(this::mouseEntered);
        contenedor.setOnMouseExited(this::mouseExited);

        scene = new Scene(contenedor, 800, 600);
        String cssPath = "/Estilos.css"; // Reemplaza con la ruta correcta
        scene.getStylesheets().add(cssPath);
        stage.setScene(scene);
    }

    public HBox getContenedorArriba() {
        ImageView ivAtras = new ImageView(new Image("btVolverAtrasE3.png"));
        btAtras = new Button();
        btAtras.setPadding(new Insets(0,0,0,40));
        btAtras.setStyle("-fx-background-color: transparent; -fx-border-color: transparent");
        btAtras.setGraphic(ivAtras);
        tituloPelicula = new Label("Titulo de la pelicula");
        tituloPelicula.setId("EstiloTituloPeliculaEscena3");
        contenedorArriba.getChildren().addAll(btAtras,tituloPelicula);
        return contenedorArriba;
    }

    public HBox getContenedorSlider() {
        VBox.setVgrow(contenedorSlider, Priority.ALWAYS);
        contenedorSlider.setPadding(new Insets(0,46,0,46));
        HBox.setHgrow(slTiempoDeReproduccion, Priority.ALWAYS);
        //contenedorSlider.setStyle("-fx-border-color: blue");
        contenedorSlider.setAlignment(Pos.BOTTOM_CENTER);
        contenedorSlider.getChildren().add(slTiempoDeReproduccion);
        return contenedorSlider;
    }

    public HBox getControles() {
        controles = new HBox(0);
        //controles.setStyle("-fx-border-color: green");

        HBox controlesBox = new HBox(15);
        controlesBox.setPadding(new Insets(0, 0, 0, 150));
        controlesBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(controlesBox, Priority.ALWAYS);

        btPlayPause = new Button();
        btPlayPause.setGraphic(new ImageView(new Image("btPauseE3.png")));
        btPlayPause.setStyle("-fx-background-color: transparent; -fx-border-color: transparent");

        btAdelantar = new Button();
        btAdelantar.setGraphic(new ImageView(new Image("btAdelantarE3.png")));
        btAdelantar.setStyle("-fx-background-color: transparent; -fx-border-color: transparent");

        btAtrasar = new Button();
        btAtrasar.setGraphic(new ImageView(new Image("btAtrasarE3.png")));
        btAtrasar.setStyle("-fx-background-color: transparent; -fx-border-color: transparent");

        controlesBox.getChildren().addAll(btAtrasar, btPlayPause, btAdelantar);

        HBox contenedorSlVolumen = new HBox(5);  // VBox para el Slider
        //contenedorSlVolumen.setStyle("-fx-border-color: yellow");
        contenedorSlVolumen.setAlignment(Pos.CENTER);
        HBox.setHgrow(contenedorSlVolumen, Priority.ALWAYS);
        ImageView ivVolumen = new ImageView(new Image("iconoVolumenE3.png"));

        slVolumen = new Slider(0, 100, 50);
        contenedorSlVolumen.getChildren().addAll(ivVolumen,slVolumen);

        controles.getChildren().addAll(controlesBox, contenedorSlVolumen);

        return controles;
    }

    public VBox getContenedorMultimedia() {
        contenedorMultimedia.getChildren().addAll(contenedorArriba, contenedorSlider, controles);
       // contenedorMultimedia.setStyle("-fx-border-color: red");
        return contenedorMultimedia;
    }

    private void mouseEntered(MouseEvent event) {
        // Detener cualquier animación en progreso
        contenedorMultimedia.setVisible(true);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.2), contenedorMultimedia);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    private void mouseExited(MouseEvent event) {
        // Crear y configurar la transición de desvanecimiento para ocultar contenedorMultimedia
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.2), contenedorMultimedia);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                contenedorMultimedia.setVisible(false);
            }
        });
        fadeTransition.play();
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula.setText(tituloPelicula);
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
