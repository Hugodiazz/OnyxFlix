module com.example.onyxtuve {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires com.fasterxml.jackson.databind;
    requires org.json;


    opens View to javafx.fxml;
    opens Datos to com.fasterxml.jackson.databind;
    exports Datos;
    exports View;
}