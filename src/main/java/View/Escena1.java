package View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Escena1 extends Application {
    private String[] lista = {"Video 1", "Video 2"};
    private VBox scrollPane;
    private Label titulo;
    private VBox contenedorPrincipal;

    @Override
    public void start(Stage stage) {
        contenedorPrincipal = new VBox();
        titulo = new Label("OnyxTube");
        titulo.setAlignment(Pos.CENTER);
        scrollPane = createScrollPane(lista);
        contenedorPrincipal.getChildren().addAll(titulo, scrollPane);

        Scene scene = new Scene(contenedorPrincipal, 800, 600);
        stage.setTitle("Escena 1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public VBox createScrollPane(String[] content) {
        VBox container = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        HBox labelsContainer = new HBox(12);

        Label tituloV = new Label("Acción");

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
