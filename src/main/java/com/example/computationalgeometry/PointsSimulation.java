package com.example.computationalgeometry;

import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PointsSimulation {
    private BorderPane root;
    public Pane graphics;
    private HBox buttons;
    public Slider slider;

    public Group visualPoints;
    public ArrayList<Point> points;

    Timeline timeline;

    public PointsSimulation(Scene home, Stage stage, String custom1, String custom2) {
        points = new ArrayList<>();
        root = new BorderPane();

        graphics = new Pane();
        graphics.setBackground(Constants.BLACK_BACK);
        visualPoints = new Group();
        graphics.getChildren().add(visualPoints);

        buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(Constants.BUTTON_HORIZONTAL_SPACE);
        buttons.setBackground(Constants.HONEYDEW_BACK);

        slider = new Slider(0, 100, 50);
        slider.setPrefSize(Constants.PAGE_BUTTON_WIDTH, Constants.MAIN_BUTTON_HEIGHT);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(1);
        slider.valueProperty().addListener((oV, oldVal, newVal) -> {
            reset();
            createPoints((int) (double) newVal);
        });

        Button returnToHome = new Button("Home");
        returnToHome.setPrefSize(Constants.PAGE_BUTTON_WIDTH, Constants.MAIN_BUTTON_HEIGHT);
        returnToHome.setOnAction(e -> {
            reset();
            stage.setScene(home);
        });

        Button execute1 = new Button(custom1);
        execute1.setPrefSize(Constants.PAGE_BUTTON_WIDTH, Constants.MAIN_BUTTON_HEIGHT);
        execute1.setOnAction(e -> {
            disableButtons();
            run1();
            updateTimeline1();
            timeline.play();
        });

        Button execute2 = new Button(custom2);
        execute2.setPrefSize(Constants.PAGE_BUTTON_WIDTH, Constants.MAIN_BUTTON_HEIGHT);
        execute2.setOnAction(e -> {
            disableButtons();
            run2();
            updateTimeline2();
            timeline.play();
        });

        graphics.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            Point created = new Point(e.getX(), e.getY(), points.size(), true);
            reset();
            points.add(created);
            visualPoints.getChildren().add(created.getShape());
            slider.adjustValue(points.size());
        });

        buttons.getChildren().addAll(returnToHome, execute1, execute2, slider);
        root.setCenter(graphics);
        root.setTop(buttons);

        timeline = new Timeline();
        timeline.setOnFinished(e -> enableButtons());
    }


    public void disableButtons() {
        for (Node node: buttons.getChildren()) {
            node.setDisable(true);
        }
        graphics.setDisable(true);

    }

    public void enableButtons() {
        for (Node node: buttons.getChildren()) {
            node.setDisable(false);
        }
        graphics.setDisable(false);
    }

    public void updateTimeline1() {}

    public void updateTimeline2() {}

    public void reset() {
        timeline.getKeyFrames().clear();
    }

    public void initialize() {
        slider.adjustValue(50);
        createPoints(50);
    }

    public void run1() {}

    public void run2() {}

    public void createPoints(int target) {
        createPoints(target, 0);
    }

    public void createPoints(int target, int boundarySize) {

        while (points.size() > target) {
            points.remove(points.size() - 1);
        }

        int iterations = 0;
        while (points.size() < target && iterations < 10000) {
            Point p = new Point(points.size(), boundarySize, true);
            if (isValid(p)) {
                points.add(p);
            }
            iterations++;
        }

        visualPoints.getChildren().clear();
        for (Point p: points) {
            System.out.println(p.getId());
            visualPoints.getChildren().add(p.getShape());
        }
    }

    private boolean isValid(Point p) {
        for (Point other: points) {
            if (p.tooClose(other)) return false;
        }
        return true;
    }

    public Pane getRoot() {
        return root;
    }
}
