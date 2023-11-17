package View;

import Modelo.Pelicula;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
    private HBox contenedorSubtitulo;
    private Label subtitulo;
    private HBox contenedorDivisior;
    private HBox contenedorBoton;
    private Button botonAtras;
    private StackPane contenedorBannerPelicula;
    private Image botonAtrasImagen;
    private Image imageBannerPelicula;
    private HBox contenedorStackPane;
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


    public void iniciarDatos(Pelicula pelicula){
        this.pelicula = pelicula;
        tituloPelicula.setText(pelicula.getNombre());
        getPaisPelicula.setText(pelicula.getPais());
        getProductoraPelicula.setText(pelicula.getProductora());
        getAnoPelicula.setText(pelicula.getAnio());
        getDescripcion.setText(pelicula.getDescripcion());
        String actores= "";
        for (int i = 0; i<pelicula.getActores().size(); i++){
            actores = actores + pelicula.getActores().get(i) + ", ";
        }
        actores = actores.substring(0, actores.length() - 2);
        getElenco.setText(actores);
        getGenero.setText(pelicula.getGenero());
        imageviewBannerPelicula.setImage(new Image(pelicula.getBanner()));
    }


    public Escena2(Stage stage){
        this.stage=stage;
        contenedorPrincipal = new VBox();
        contenedorPrincipal = getContenedorPrincipal();
        contenedorSubtitulo = new HBox();
        contenedorSubtitulo= getContenedorSubtitulo();
        contenedorDivisior = new HBox();
        contenedorDivisior = getContenedorDivisior();
        //VBox.setVgrow(contenedorDivisior, Priority.ALWAYS);
        contenedorDivisior.setPadding(new Insets(0,40,0,0));
        ScrollPane VboxScroll = new ScrollPane();
        VboxScroll.setFitToWidth(true);
        //VboxScroll.setFitToHeight(true);
        contenedorInformacion = new VBox(10);
        contenedorInformacion.setPadding(new Insets(0,0,0,57));
        contenedorInformacion = getContenedorInformacion();



        contenedorPrincipal.getChildren().addAll(contenedorTitulo,contenedorSubtitulo,contenedorDivisior,contenedorInformacion);
        VboxScroll.setContent(contenedorPrincipal);

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
        botonAtrasImagen = new Image("btnAtras.png", 40, 40, false, true);
        ImageView botonAtrasImageView = new ImageView(botonAtrasImagen);
        botonAtras.setGraphic(botonAtrasImageView);
        botonAtras.setStyle("-fx-background-color: transparent; -fx-border-color: transparent");
        contenedorBoton.getChildren().add(botonAtras);

        contenedorStackPane = new HBox();
        HBox.setHgrow(contenedorStackPane, Priority.ALWAYS);

        contenedorBannerPelicula = new StackPane();
        HBox.setHgrow(contenedorBannerPelicula, Priority.ALWAYS);
        contenedorBannerPelicula.prefWidth(200);

        paneImagen = new Pane();  // Nuevo Pane para contener la imagen
        imageviewBannerPelicula = new ImageView(imageBannerPelicula);
        //imageviewBannerPelicula.setPreserveRatio(true);
        imageviewBannerPelicula.setFitWidth(872);
        paneImagen.getChildren().add(imageviewBannerPelicula);

        contenedorBannerPelicula.widthProperty().addListener((observable, oldValue, newValue) -> {
            imageviewBannerPelicula.setFitWidth(newValue.doubleValue());
        });

        contenedorBannerPelicula.heightProperty().addListener((observable, oldValue, newValue) -> {
            imageviewBannerPelicula.setFitHeight(newValue.doubleValue());
        });

        divisorStackPane = new HBox();
        datosPelicula = new HBox();
        infoPelicula = new VBox(10);
        infoPelicula.setId("FondoBlanco");
        infoPelicula.setPadding(new Insets(0,10,0,10));
        HBox.setHgrow(datosPelicula, Priority.ALWAYS);
        datosPelicula.setPadding(new Insets(100,0,100,47));

        btnPlay = new Button();
        btnPlay.setPadding(new Insets(0,60,53,0));
        HBox contenedorBtnPlay = new HBox();
        imageBtnPlay = new Image("btnPlayEscena2.png",100,100,false,false);
        btnPlayImageView = new ImageView(imageBtnPlay);
        btnPlay.setGraphic(btnPlayImageView);
        btnPlay.setStyle("-fx-background-color: transparent; -fx-border-color: transparent");
        contenedorBtnPlay.getChildren().add(btnPlay);
        contenedorBtnPlay.setAlignment(Pos.BOTTOM_CENTER);

        tituloPelicula = new Label();
        tituloPelicula.setId("EstiloDatosPeliculaEscena2");
        tituloPelicula.setWrapText(true);
        HBox contenedorTituloPelicula = new HBox();
        contenedorTituloPelicula.setAlignment(Pos.CENTER);
        contenedorTituloPelicula.getChildren().add(tituloPelicula);

        HBox infoDirectorPais = new HBox(10);
        Label directorPelicula = new Label("");
        Label getDirectorPelicula = new Label("Nombre del director");
        getDirectorPelicula.setWrapText(true);
        getDirectorPelicula.setId("EstiloTextoTituloPeliculaEscena2");
        directorPelicula.setId("EstiloTextoTituloPeliculaEscena2");
        Label paisPelicula = new Label("País: ");
        getPaisPelicula = new Label();
        getPaisPelicula.setWrapText(true);
        getPaisPelicula.setId("EstiloTextoTituloPeliculaEscena2");
        paisPelicula.setId("EstiloTextoTituloPeliculaEscena2");
        HBox director = new HBox();
        HBox pais = new HBox();
        director.getChildren().addAll(directorPelicula,getDirectorPelicula);
        pais.getChildren().addAll(paisPelicula,getPaisPelicula);
        infoDirectorPais.getChildren().addAll(director,pais);


        HBox infoProductoraAno = new HBox(10);
        Label productoraPelicula = new Label("Productora: ");
        getProductoraPelicula = new Label();
        getProductoraPelicula.setWrapText(true);
        getProductoraPelicula.setId("EstiloTextoTituloPeliculaEscena2");
        productoraPelicula.setId("EstiloTextoTituloPeliculaEscena2");
        Label anoPelicula = new Label("Año: ");
        getAnoPelicula = new Label();
        getAnoPelicula.setWrapText(true);
        getAnoPelicula.setId("EstiloTextoTituloPeliculaEscena2");
        anoPelicula.setId("EstiloTextoTituloPeliculaEscena2");
        HBox productora = new HBox();
        HBox ano = new HBox();
        productora.getChildren().addAll(productoraPelicula,getProductoraPelicula);
        ano.getChildren().addAll(anoPelicula,getAnoPelicula);
        infoProductoraAno.getChildren().addAll(productora,ano);

        infoPelicula.getChildren().addAll(contenedorTituloPelicula,infoDirectorPais,infoProductoraAno);

        datosPelicula.getChildren().add(infoPelicula);

        divisorStackPane.getChildren().addAll(datosPelicula,contenedorBtnPlay);

        contenedorBannerPelicula.getChildren().addAll(paneImagen,divisorStackPane);  // Añadir el Pane a StackPane

        contenedorStackPane.getChildren().add(contenedorBannerPelicula);

        contenedorDivisior.getChildren().addAll(contenedorBoton, contenedorStackPane);

        return contenedorDivisior;
    }

    public VBox getContenedorInformacion() {
        HBox contElenco = new HBox();
        Label elenco = new Label("Elenco: ");
        elenco.setId("EstiloInformacionEscena2");
        getElenco = new Label();
        getElenco.setId("EstiloInformacionEscena2");
        getElenco.setWrapText(true);
        contElenco.getChildren().addAll(elenco,getElenco);

        HBox contgenero = new HBox();
        Label genero = new Label("Género: ");
        genero.setId("EstiloInformacionEscena2");
        getGenero = new Label();
        getGenero.setId("EstiloInformacionEscena2");
        getGenero.setWrapText(true);
        contgenero.getChildren().addAll(genero,getGenero);

        HBox contDescripcion = new HBox();
        Label descripcion = new Label("Descripción: ");
        descripcion.setId("EstiloInformacionEscena2");
        getDescripcion = new Label();
        getDescripcion.setId("EstiloInformacionEscena2");
        getDescripcion.setWrapText(true);
        contDescripcion.getChildren().addAll(descripcion,getDescripcion);


        contenedorInformacion.getChildren().addAll(contElenco,contgenero,contDescripcion);
        return contenedorInformacion;
    }

    public Scene getScene() {
        return scene;
    }

    public Label getSubtitulo() {
        return subtitulo;
    }

    public Button getBotonAtras() {
        return botonAtras;
    }
}
