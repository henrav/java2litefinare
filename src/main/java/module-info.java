module com.example.testafinarejava2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    //opens com.example.testafinarejava2 to javafx.fxml;
    //exports com.example.testafinarejava2;

    exports com.example.testafinarejava2.Controllers;
    opens com.example.testafinarejava2.Controllers to javafx.fxml;
    exports com.example.testafinarejava2.Entities;
    opens com.example.testafinarejava2.Entities to javafx.fxml;
    exports com.example.testafinarejava2.Driver;
    opens com.example.testafinarejava2.Driver to javafx.fxml;

}