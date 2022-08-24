package com.example.computationalgeometry;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Constants {

    public static final double MAIN_BUTTON_WIDTH = 350.0;
    public static final double PAGE_BUTTON_WIDTH = 150.0;
    public static final double SMALL_BUTTON_WIDTH = 50.0;
    public static final double MAIN_BUTTON_HEIGHT = 50.0;
    public static final double MAIN_PADDING = 75.0;

    public static final double BUTTON_VERTICAL_SPACE = 60.0;
    public static final double BUTTON_HORIZONTAL_SPACE = 40.0;

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;

    public static final int POINT_SIZE = 5;
    public static final int MIN_POINT_DIST = 2000;
    public static final int LINE_WIDTH = 3;

    private static final BackgroundFill navy = new BackgroundFill(Color.NAVY,
            CornerRadii.EMPTY, Insets.EMPTY);
    public static final Background NAVY_BACK = new Background(navy);

    private static final BackgroundFill black = new BackgroundFill(Color.BLACK,
            CornerRadii.EMPTY, Insets.EMPTY);
    public static final Background BLACK_BACK = new Background(black);

    private static final BackgroundFill honeydew = new BackgroundFill(Color.HONEYDEW,
            CornerRadii.EMPTY, Insets.EMPTY);
    public static final Background HONEYDEW_BACK = new Background(honeydew);
}
