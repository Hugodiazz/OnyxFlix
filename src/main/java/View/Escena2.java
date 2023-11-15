package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Escena2 {
    private Stage stage;
    private VBox contenedorPrincipal;
    private HBox contenedorTitulo;
    private Label titulo;
    private HBox contenedorSubtitulo;
    private Label subtitulo;
    private HBox contenedorDivisior;
    private HBox contenedorBoton;
    private Button botonAtras;
    private HBox contenedorBannerPelicula;

    public Escena2(Stage stage){
        this.stage=stage;
        contenedorPrincipal = new VBox();
        contenedorPrincipal = getContenedorPrincipal();
        contenedorSubtitulo = new HBox();
        contenedorSubtitulo= getContenedorSubtitulo();
        contenedorDivisior = new HBox();
        contenedorDivisior = getContenedorDivisior();




        contenedorPrincipal.getChildren().addAll(contenedorTitulo,contenedorSubtitulo,contenedorDivisior);

        Scene scene = new Scene(contenedorPrincipal);
        stage.setScene(scene);

        String cssPath = "/Estilos.css"; // Reemplaza con la ruta correcta
        scene.getStylesheets().add(cssPath);
    }

    public VBox getContenedorPrincipal() {
        contenedorPrincipal.setId("ColorFondoNegro");
        titulo = new Label("OnyxTube");
        titulo.setId("EstiloTituloEscena1");
        contenedorTitulo = new HBox(10);
        contenedorTitulo.setPadding(new Insets(10));
        contenedorTitulo.getChildren().add(titulo);
        return contenedorPrincipal;
    }

    public HBox getContenedorSubtitulo() {
        contenedorSubtitulo.setAlignment(Pos.TOP_RIGHT);
        contenedorSubtitulo.setPadding(new Insets(0,40,0,0));
        subtitulo = new Label("Añadir a mi lista");
        subtitulo.setId("EstiloSubtituloEscena2");
        contenedorSubtitulo.getChildren().add(subtitulo);
        return contenedorSubtitulo;
    }

    public HBox getContenedorDivisior() {
        contenedorBoton = new HBox();
        botonAtras = new Button();
        Image botonAtrasImagen = new Image("btnAtras.png", 40, 40, false, true);
        ImageView botonAtrasImageView = new ImageView(botonAtrasImagen);
        botonAtras.setGraphic(botonAtrasImageView);
        botonAtras.setStyle("-fx-background-color: transparent; -fx-border-color: transparent");
        contenedorBoton.getChildren().add(botonAtras);
        contenedorBannerPelicula = new HBox();

        BackgroundSize backgroundSize = new BackgroundSize(100,
                100,
                true,
                true,
                true,
                true);

        // Crear un fondo con la imagen
        BackgroundImage image = new BackgroundImage(new Image("xd.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);

        contenedorBannerPelicula.setBackground(new Background(image));
        contenedorBannerPelicula.setStyle("-fx-border-color: red");
        contenedorBannerPelicula.getChildren().add(contenedorBoton);



        contenedorDivisior.getChildren().addAll(contenedorBoton,contenedorBannerPelicula);
        return contenedorDivisior;
    }


    public Label getSubtitulo() {
        return subtitulo;
    }
}
