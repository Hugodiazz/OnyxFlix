package View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Escena1 {
    private String[] lista = {"Video 1", "Video 2"};
    private VBox scrollPane;
    private Label titulo;
    private VBox contenedorPrincipal;
    private Stage stage;
    private HBox contenedorTitulo;

    public Escena1(Stage stage) {
        this.stage = stage;
        contenedorPrincipal = new VBox();
        contenedorPrincipal.setId("ColorFondoNegro");
        contenedorTitulo = new HBox();
        titulo = new Label("OnyxTube");
        titulo.setId("EstiloTituloEscena1");
        contenedorTitulo.getChildren().add(titulo);
        contenedorTitulo.setPadding(new Insets(15));
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
        scrollPane.setId("scroll-pane");
        HBox labelsContainer = new HBox(12);

        Label tituloV = new Label("Acción");
        tituloV.setId("EstiloGeneroEscena1");

        for (String s : content) {
            Label text = new Label(s);
            labelsContainer.getChildren().add(text);
            labelsContainer.setStyle("-fx-border-color: black; ");
        }
        scrollPane.setContent(labelsContainer);
        container.getChildren().addAll(tituloV,scrollPane);
        return container;
    }
}
