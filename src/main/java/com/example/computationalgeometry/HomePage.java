package com.example.computationalgeometry;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePage {

    Scene root, triangulation, convexHull, voronoi, pi,
            dijkstra, bipartite, minSpanningTree, travellingSalesman;
    Stage stage;

    TriangulationSim tri;
    VoronoiSim voroi;
    MSTSim mst;
    ConvexHullSim convHull;


    public HomePage(Stage s) {
        stage = s;

        BorderPane homeLayout = new BorderPane();
        root = new Scene(homeLayout, Constants.WIDTH, Constants.HEIGHT);

        tri = new TriangulationSim(root, stage);
        triangulation = new Scene(tri.getRoot(), Constants.WIDTH, Constants.HEIGHT);

        voroi = new VoronoiSim(root, stage);
        voronoi = new Scene(voroi.getRoot(), Constants.WIDTH, Constants.HEIGHT);

        mst = new MSTSim(root, stage);
        minSpanningTree = new Scene(mst.getRoot(), Constants.WIDTH, Constants.HEIGHT);

        convHull = new ConvexHullSim(root, stage);
        convexHull = new Scene(convHull.getRoot(), Constants.WIDTH, Constants.HEIGHT);

        VBox left = createLeftPanel();
        homeLayout.setLeft(left);

        VBox right = createRightPanel();
        homeLayout.setRight(right);

        homeLayout.setBackground(Constants.NAVY_BACK);
    }

    private VBox createLeftPanel() {
        VBox leftButtons = new VBox();
        leftButtons.setSpacing(Constants.BUTTON_VERTICAL_SPACE);
        leftButtons.setPadding(new Insets(Constants.MAIN_PADDING));

        Button goToTriangulation = new Button("Triangulation");
        goToTriangulation.setPrefSize(Constants.MAIN_BUTTON_WIDTH, Constants.MAIN_BUTTON_HEIGHT);
        goToTriangulation.setOnAction(e -> {
            stage.setScene(triangulation);
            tri.initialize();
        });

        Button goToConvex = new Button("Convex Hull");
        goToConvex.setPrefSize(Constants.MAIN_BUTTON_WIDTH, Constants.MAIN_BUTTON_HEIGHT);
        goToConvex.setOnAction(e -> {
            stage.setScene(convexHull);
            convHull.initialize();
        });

        Button goToVoronoi = new Button("Voronoi Diagram");
        goToVoronoi.setPrefSize(Constants.MAIN_BUTTON_WIDTH, Constants.MAIN_BUTTON_HEIGHT);
        goToVoronoi.setOnAction(e -> {
            stage.setScene(voronoi);
            voroi.initialize();
        });

        Button goToPi = new Button("Pi Approximation");
        goToPi.setPrefSize(Constants.MAIN_BUTTON_WIDTH, Constants.MAIN_BUTTON_HEIGHT);
        goToPi.setOnAction(e -> stage.setScene(pi));

        leftButtons.getChildren().addAll(goToConvex, goToTriangulation, goToVoronoi, goToPi);

        return leftButtons;
    }

    private VBox createRightPanel() {
        VBox rightButtons = new VBox();
        rightButtons.setSpacing(Constants.BUTTON_VERTICAL_SPACE);
        rightButtons.setPadding(new Insets(Constants.MAIN_PADDING));

        Button goToDijkstra = new Button("Dijkstra Visualization");
        goToDijkstra.setPrefSize(Constants.MAIN_BUTTON_WIDTH, Constants.MAIN_BUTTON_HEIGHT);
        goToDijkstra.setOnAction(e -> stage.setScene(dijkstra));

        Button goToBipartite = new Button("Is Graph Bipartite");
        goToBipartite.setPrefSize(Constants.MAIN_BUTTON_WIDTH, Constants.MAIN_BUTTON_HEIGHT);
        goToBipartite.setOnAction(e -> stage.setScene(bipartite));

        Button goToClosestPoints = new Button("Minimum Spanning Tree");
        goToClosestPoints.setPrefSize(Constants.MAIN_BUTTON_WIDTH, Constants.MAIN_BUTTON_HEIGHT);
        goToClosestPoints.setOnAction(e -> {
            stage.setScene(minSpanningTree);
            mst.initialize();
        });

        Button goToTravellingSalesman = new Button("Travelling Salesman");
        goToTravellingSalesman.setPrefSize(Constants.MAIN_BUTTON_WIDTH, Constants.MAIN_BUTTON_HEIGHT);
        goToTravellingSalesman.setOnAction(e -> stage.setScene(travellingSalesman));

        rightButtons.getChildren().addAll(
                goToDijkstra, goToBipartite, goToClosestPoints, goToTravellingSalesman);

        return rightButtons;
    }

    public Scene getRoot() {
        return root;
    }


}
