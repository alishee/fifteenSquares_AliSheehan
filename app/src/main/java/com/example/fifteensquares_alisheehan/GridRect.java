package com.example.fifteensquares_alisheehan;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class GridRect {

    // Rectangle object to draw
    public Rect square;

    // Paint variables
    Paint squarePaint = new Paint();
    Paint textPaint = new Paint();

    // Value and Position variables
    public int value;
    public int position;  // position to update


    /**
     * Constructor for GridRect.
     * Initializes a Rectangle object based on position arguments given to the constructor.
     * Assigns value and position based on arguments given to the constructor.
     *
     * @param left integer value for left bound of rectangle
     * @param top integer value for top bound of the rectangle
     * @param right integer value for right bound of the rectangle
     * @param bottom integer value for bottom bound of the rectangle
     * @param pos  integer value for the current position of the rectangle
     * @param val integer value for the intended position of the rectangle
     */
    public GridRect(int left, int top, int right, int bottom, int pos, int val) {

        square = new Rect(left, top, right, bottom);

        value = val;
        position = pos;

        // Sets paint color for a square based on whether or not position matches value.
        squarePaint.setStyle(Paint.Style.FILL);
        if (value == position) {
            squarePaint.setColor(0xFF5da3d9);
        } else {
            squarePaint.setColor(0xFFa3a3a3);
        }

        // Sets text to be black, centered, size 36
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(64);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }



}
