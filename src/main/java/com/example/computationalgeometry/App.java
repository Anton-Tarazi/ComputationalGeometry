package com.example.computationalgeometry;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Computational Geometry Simulation");

        HomePage homePage = new HomePage(stage);

        stage.setScene(homePage.getRoot());
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}