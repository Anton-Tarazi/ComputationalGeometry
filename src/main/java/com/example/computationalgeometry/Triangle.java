package com.example.computationalgeometry;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Triangle {

    Point p1;
    Point p2;
    Point p3;

    Polygon t;

    public Triangle(Point x, Point y, Point z) {
        p1 = x;
        p2 = y;
        p3 = z;

        t = new Polygon();
        t.getPoints().addAll(p1.getY(), p1.getY(),
                p2.getX(), p2.getY(),
                p3.getX(), p3.getY());

        t.setStrokeWidth(3);
        t.setStroke(Color.WHITE);
    }

    public Polygon getShape() {
        return t;
    }

}
