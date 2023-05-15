
package com.example.testafinarejava2;


import java.util.Objects;

import com.sun.javafx.tk.TKStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {


    public void start(Stage stage) throws Exception{
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("startsidan.fxml")));
        stage.setScene(new Scene(parent));
        stage.show();
    }
    public static void main(String[]args){
        launch(args);
    }



}