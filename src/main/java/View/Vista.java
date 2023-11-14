package View;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Vista {
    private Stage stage;

    public Vista(Stage stage){
        this.stage = stage;
    }

    public void setScene(Scene scene){
        stage.setScene(scene);
    }
}
