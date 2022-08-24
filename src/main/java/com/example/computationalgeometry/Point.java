package com.example.computationalgeometry;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Point {

    int id;

    double x, y;
    boolean explored;

    Ellipse p;
    Color color;

    public Point(double a, double b, int i, boolean rainbow) {
        x = a;
        y = b;
        id = i;

        if (rainbow) {
            int red = (int) (256 * Math.random());
            int green = (int) (256 * Math.random());
            int blue = (int) (256 * Math.random());
            color = Color.rgb(red, green, blue);
        } else {
            color = Color.WHITE;
        }

        explored = false;

        p = new Ellipse(Constants.POINT_SIZE, Constants.POINT_SIZE);
        p.setFill(color);
        p.setCenterX(x);
        p.setCenterY(y);
    }

    public Point(int i, int boundary, boolean rainbow) {
        this(Math.random() * (Constants.WIDTH - 4 * boundary) + 2 * boundary,
                Math.random() * (Constants.HEIGHT - 50 - 2 * boundary) + boundary,
                i, rainbow);
    }


    public void setExplored(boolean e) {
        explored = e;
    }

    public boolean isExplored() {
        return explored;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Ellipse getShape() {
        return p;
    }

    public void clearColor() {
        p.setFill(Color.WHITE);
    }

    boolean tooClose(Point other) {
        double distance = Math.pow(x - other.getX(), 2) + Math.pow(y - other.getY(), 2);
        return distance < Constants.MIN_POINT_DIST;
    }

    public int getId() {
        return id;
    }


}
