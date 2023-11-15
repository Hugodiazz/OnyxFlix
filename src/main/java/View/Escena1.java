package View;

import Modelo.Pelicula;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Escena1 {
    private String[] lista = {"Video 1", "Video 2","Video 3","Video 4","Video 5"};
    private VBox scrollPane;
    private Label titulo;
    private VBox contenedorPrincipal;
    private Stage stage;
    private HBox contenedorTitulo;
    private double xOffset = 0.0;
    private double scrollSpeed = 1.5;
    private HBox labelsContainer;

    public Escena1(Stage stage) {
        this.stage = stage;
        contenedorPrincipal = getContenedorPrincipal();

        scrollPane = createScrollPane(lista);
        contenedorPrincipal.getChildren().addAll(contenedorTitulo, scrollPane);

        Scene scene = new Scene(contenedorPrincipal, 800, 600);
        stage.setScene(scene);

        String cssPath = "/Estilos.css"; // Reemplaza con la ruta correcta
        scene.getStylesheets().add(cssPath);
    }

    public VBox createScrollPane(String[] content) {
        VBox container = new VBox(10);
        container.setPadding(new Insets(0,40,0,40));
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setId("scrollPane");
        labelsContainer = new HBox(12);
        labelsContainer.setId("ColorFondoNegro");

        Label tituloV = new Label("Acción");
        tituloV.setId("EstiloGeneroEscena1");

        for (String s : content) {
            ImageView imageView = new ImageView(new Image("prueba.jpg",275,174,false,true));
            labelsContainer.getChildren().add(imageView);
            labelsContainer.setStyle("-fx-border-color: black; ");
        }

        labelsContainer.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            xOffset = event.getSceneX();
        });

        labelsContainer.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            double deltaX = event.getSceneX() - xOffset;
            xOffset = event.getSceneX();
            scrollPane.setHvalue(scrollPane.getHvalue() - deltaX * scrollSpeed / labelsContainer.getWidth());
        });

        labelsContainer.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            labelsContainer.setStyle("-fx-cursor: hand;");
        });

        labelsContainer.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
            labelsContainer.setStyle("-fx-cursor: default;");
        });

        scrollPane.setContent(labelsContainer);
        container.getChildren().addAll(tituloV,scrollPane);
        return container;
    }

    public VBox getContenedorPrincipal() {
        contenedorPrincipal = new VBox();
        contenedorPrincipal.setId("ColorFondoNegro");
        contenedorTitulo = new HBox();
        titulo = new Label("OnyxTube");
        titulo.setId("EstiloTituloEscena1");
        contenedorTitulo.getChildren().add(titulo);
        contenedorTitulo.setPadding(new Insets(15));
        return contenedorPrincipal;
    }


}
