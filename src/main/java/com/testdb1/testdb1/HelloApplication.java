package com.testdb1.testdb1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tw_new2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1032);
        stage.setTitle("Dental");
        stage.setScene(scene);
        stage.show();
    }
}