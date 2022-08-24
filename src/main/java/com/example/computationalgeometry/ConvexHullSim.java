package com.example.computationalgeometry;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConvexHullSim extends PointsSimulation {

    public static final int BOUNDARY_SIZE = 100;


    public ConvexHullSim(Scene home, Stage stage) {
        super(home, stage, "Gift Wrapping", "Graham Scan");
    }

    public void createPoints(int target) {
        createPoints(target, BOUNDARY_SIZE);
    }
}
