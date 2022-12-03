package com.mracover.javacalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("calculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("calculator-icon.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}