package com.example.computationalgeometry;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Edge {
    Point p1;
    Point p2;
    Line l;

    double length;

    public Edge(Point x, Point y) {
        p1 = x;
        p2 = y;

        l = new Line();
        l.setStrokeWidth(Constants.LINE_WIDTH);
        l.setStartX(p1.getX());
        l.setStartY(p1.getY());
        l.setEndX(p2.getX());
        l.setEndY(p2.getY());
        l.setStroke(Color.WHITE);

        length = Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2);

    }

    public double getLength() {
        return length;
    }

    public boolean onePointExplored() {
        return (p1.isExplored() && !p2.isExplored()) || (p2.isExplored() && !p1.isExplored());
    }

    public Line getShape() {
        return l;
    }

    public void markExplored() {
        p1.setExplored(true);
        p2.setExplored(true);
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }


}
