package View;

import Modelo.Pelicula;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Escena2 {
    private VBox contenedorInformacion;
    private Stage stage;
    private VBox contenedorPrincipal;
    private HBox contenedorTitulo;
    private Label titulo;
    private HBox contenedorDivisior;
    private HBox contenedorBoton;
    private Button botonAtras;
    private StackPane contenedorBannerPelicula;
    private Image botonAtrasImagen;
    private Image imageBannerPelicula;
    private ImageView imageviewBannerPelicula;
    private Pane paneImagen;
    private HBox divisorStackPane;
    private HBox datosPelicula;
    private Button btnPlay;
    private Image imageBtnPlay;
    private ImageView btnPlayImageView;
    private VBox infoPelicula;
    private Scene scene;
    private Pelicula pelicula;
    private Label tituloPelicula;
    private Label getPaisPelicula;
    private Label getProductoraPelicula;
    private Label getAnoPelicula;
    private Label getDescripcion;
    private Label getElenco;
    private Label getGenero;
    private Button btnAnadirMas;


    public void iniciarDatos(Pelicula pelicula){
        this.pelicula = pelicula;
        tituloPelicula.setText(pelicula.getNombre());
        getPaisPelicula.setText(pelicula.getPais());
        getProductoraPelicula.setText(pelicula.getProductora());
        getAnoPelicula.setText(pelicula.getAnio());
        getDescripcion.setText("Descripción: " + pelicula.getDescripcion());
        String actores= "";
        for (int i = 0; i<pelicula.getActores().size(); i++){
            actores = actores + pelicula.getActores().get(i) + ", ";
        }
        actores = actores.substring(0, actores.length() - 2);
        getElenco.setText("Elenco: " + actores);
        getGenero.setText("Género: " + pelicula.getGenero());
        imageviewBannerPelicula.setImage(new Image(pelicula.getBanner()));
        // Aplicar el filtro de brillo
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.3); // Ajustar este valor según sea necesario
        imageviewBannerPelicula.setEffect(colorAdjust);
    }


    public Escena2(Stage stage){
        this.stage=stage;
        contenedorPrincipal = new VBox(10);
        contenedorPrincipal = getContenedorPrincipal();
        contenedorDivisior = new HBox();
        contenedorDivisior = getContenedorDivisior();
        //VBox.setVgrow(contenedorDivisior, Priority.ALWAYS);
        //contenedorDivisior.setPadding(new Insets(0,40,0,0));
        ScrollPane VboxScroll = new ScrollPane();
        VboxScroll.setFitToWidth(true);
        //VboxScroll.setFitToHeight(true);
        contenedorInformacion = new VBox(10);
        contenedorInformacion.setPadding(new Insets(0,40,0,50));
        contenedorInformacion = getContenedorInformacion();

        contenedorPrincipal.getChildren().addAll(contenedorTitulo,contenedorDivisior,contenedorInformacion);
        VboxScroll.setContent(contenedorPrincipal);
        VboxScroll.setId("scrollPadre");

        scene = new Scene(VboxScroll);
        stage.setScene(scene);

        String cssPath = "/Estilos.css"; // Reemplaza con la ruta correcta
        scene.getStylesheets().add(cssPath);
    }

    public VBox getContenedorPrincipal() {
        contenedorPrincipal.setId("ColorFondoNegro");
        titulo = new Label("OnyxFlix");
        titulo.setId("EstiloTituloEscena1");
        contenedorTitulo = new HBox(10);
        contenedorTitulo.setPadding(new Insets(10));
        contenedorTitulo.getChildren().add(titulo);
        return contenedorPrincipal;
    }

    public HBox getContenedorDivisior() {
        contenedorBoton = new HBox();
        botonAtras = new Button();
        botonAtrasImagen = new Image("btnAtras.png", 40, 40, false, true);
        ImageView botonAtrasImageView = new ImageView(botonAtrasImagen);
        botonAtras.setGraphic(botonAtrasImageView);
        botonAtras.setStyle("-fx-background-color: transparent; -fx-border-color: transparent");
        contenedorBoton.getChildren().add(botonAtras);

        contenedorBannerPelicula = new StackPane();
        HBox.setHgrow(contenedorBannerPelicula, Priority.ALWAYS);

        paneImagen = new Pane();  // Nuevo Pane para contener la imagen
        imageviewBannerPelicula = new ImageView(imageBannerPelicula);
        //imageviewBannerPelicula.setPreserveRatio(true);
        paneImagen.getChildren().add(imageviewBannerPelicula);

        contenedorBannerPelicula.widthProperty().addListener((observable, oldValue, newValue) -> {
            imageviewBannerPelicula.setFitWidth(newValue.doubleValue());
        });

        contenedorBannerPelicula.heightProperty().addListener((observable, oldValue, newValue) -> {
            imageviewBannerPelicula.setFitHeight(newValue.doubleValue());
        });

        divisorStackPane = new HBox();
        datosPelicula = new HBox();
        infoPelicula = new VBox(20);
        infoPelicula.setPrefWidth(400);
        //infoPelicula.setStyle("-fx-border-color: blue");
        infoPelicula.setPadding(new Insets(0,10,0,10));
        HBox.setHgrow(datosPelicula, Priority.ALWAYS);
        datosPelicula.setPadding(new Insets(40,0,0,47));
        //datosPelicula.setStyle("-fx-border-color: green");

        btnPlay = new Button();
        //btnPlay.setPadding(new Insets(0,60,53,0));
        HBox contenedorBtnPlay = new HBox();
        contenedorBtnPlay.setPadding(new Insets(0,0,0,-10));
        contenedorBtnPlay.setAlignment(Pos.CENTER_LEFT);
        //contenedorBtnPlay.setStyle("-fx-border-color: red");
        imageBtnPlay = new Image("btnPlayEscena2.png");
        btnPlayImageView = new ImageView(imageBtnPlay);
        btnPlay.setGraphic(btnPlayImageView);
        btnPlay.setStyle("-fx-background-color: transparent; -fx-border-color: transparent");
        contenedorBtnPlay.getChildren().add(btnPlay);

        btnAnadirMas = new Button();
        Image imgBtnAnadirMas = new Image("btnAnadir.png");
        ImageView imgViewBtnAnadirMas = new ImageView(imgBtnAnadirMas);
        btnAnadirMas.setGraphic(imgViewBtnAnadirMas);
        btnAnadirMas.setStyle("-fx-background-color: transparent; -fx-border-color: transparent");
        contenedorBtnPlay.getChildren().add(btnAnadirMas);

        tituloPelicula = new Label();
        tituloPelicula.setId("EstiloDatosPeliculaEscena2");
        tituloPelicula.setWrapText(true);
        HBox contenedorTituloPelicula = new HBox();
        contenedorTituloPelicula.setAlignment(Pos.CENTER);
        contenedorTituloPelicula.getChildren().add(tituloPelicula);

        HBox infoDirectorPais = new HBox();
        //infoDirectorPais.setStyle("-fx-border-color: yellow");
        Label getDirectorPelicula = new Label("Nombre del director");
        getDirectorPelicula.setWrapText(true);
        getDirectorPelicula.setId("EstiloTextoTituloPeliculaEscena2");
        getPaisPelicula = new Label();
        getPaisPelicula.setWrapText(true);
        getPaisPelicula.setId("EstiloTextoTituloPeliculaEscena2");
        HBox director = new HBox();
        HBox pais = new HBox();
        director.getChildren().addAll(getDirectorPelicula);
        pais.getChildren().addAll(getPaisPelicula);
        // Configurar alineación y expansión
        director.setAlignment(Pos.TOP_LEFT);
        pais.setAlignment(Pos.TOP_LEFT);

        // Configurar la expansión para que ocupen la mitad del infoDirectorPais
        HBox.setHgrow(director, Priority.ALWAYS);
        HBox.setHgrow(pais, Priority.ALWAYS);
        infoDirectorPais.getChildren().addAll(director,pais);

        HBox infoProductoraAno = new HBox();
        getProductoraPelicula = new Label();
        getProductoraPelicula.setWrapText(true);
        getProductoraPelicula.setId("EstiloTextoTituloPeliculaEscena2");
        getAnoPelicula = new Label();
        getAnoPelicula.setWrapText(true);
        getAnoPelicula.setId("EstiloTextoTituloPeliculaEscena2");
        HBox productora = new HBox();
        HBox ano = new HBox();
        productora.getChildren().addAll(getProductoraPelicula);
        ano.getChildren().addAll(getAnoPelicula);
        // Configurar alineación y expansión
        productora.setAlignment(Pos.TOP_LEFT);
        ano.setAlignment(Pos.TOP_LEFT);

        // Configurar la expansión para que ocupen la mitad del infoDirectorPais
        HBox.setHgrow(productora, Priority.ALWAYS);
        HBox.setHgrow(ano, Priority.ALWAYS);
        infoProductoraAno.getChildren().addAll(productora,ano);

        VBox contInformacion = new VBox(11);
        contInformacion.getChildren().addAll(infoDirectorPais,infoProductoraAno);

        infoPelicula.getChildren().addAll(contenedorTituloPelicula,contInformacion,contenedorBtnPlay);

        datosPelicula.getChildren().add(infoPelicula);

        divisorStackPane.getChildren().addAll(contenedorBoton, datosPelicula);

        contenedorBannerPelicula.getChildren().addAll(paneImagen,divisorStackPane);  // Añadir el Pane a StackPane

        contenedorDivisior.getChildren().addAll(contenedorBannerPelicula);

        return contenedorDivisior;
    }

    public VBox getContenedorInformacion() {
        getElenco = new Label();
        getElenco.setId("EstiloInformacionEscena2");
        getElenco.setWrapText(true);

        getGenero = new Label();
        getGenero.setId("EstiloInformacionEscena2");
        getGenero.setWrapText(true);

        getDescripcion = new Label();
        getDescripcion.setId("EstiloInformacionEscena2");
        getDescripcion.setWrapText(true);

        contenedorInformacion.getChildren().addAll(getElenco,getGenero,getDescripcion);
        return contenedorInformacion;
    }

    public Scene getScene() {
        return scene;
    }

    public Button getBotonAtras() {
        return botonAtras;
    }
}
