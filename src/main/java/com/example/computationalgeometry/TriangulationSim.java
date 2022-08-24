package com.example.computationalgeometry;

import javafx.scene.Scene;
import javafx.stage.Stage;


public class TriangulationSim extends PointsSimulation {
    public TriangulationSim(Scene home, Stage stage) {
        super(home, stage, "Quick", "Full Process");
    }

    public void run1() {
        System.out.println("Triangulation");
        Triangle x = new Triangle(points.get(0), points.get(1), points.get(2));
        graphics.getChildren().add(x.getShape());
    }
}
