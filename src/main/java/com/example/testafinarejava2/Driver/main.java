
package com.example.testafinarejava2.Driver;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.events.Event;

import java.util.EventListener;
import java.util.Objects;

public class main extends Application {


    public void start(Stage stage) throws Exception{
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/testafinarejava2/Controllers/Startsidan.fxml")));
        stage.setScene(new Scene(parent));
        stage.show();
    }
    public static void main(String[]args){
        launch(args);
    }



}