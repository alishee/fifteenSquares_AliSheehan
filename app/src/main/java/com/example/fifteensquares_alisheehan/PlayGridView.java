package com.example.fifteensquares_alisheehan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceView;

public class PlayGridView extends SurfaceView {


    public static final float gridWidth = 1500f;
    public static final float gridTop = 100f;
    public static final float gridLeft = 100f;
    public static final float borderWidth = 10f;

    public float squareWidth;

    Paint background = new Paint();
    Paint borders = new Paint();

    GridModel gridModel;

    /**
     * Constructor for PlayGridView class
     */
    public PlayGridView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setWillNotDraw(false);

        //Set Paint settings for background and borders
        background.setColor(Color.LTGRAY);
        background.setStyle(Paint.Style.FILL);
        borders.setColor(Color.DKGRAY);
        borders.setStyle(Paint.Style.FILL);


        setBackgroundColor(0xFFE1C699);

        // Create gridModel and calculate square width based on gridModel variables
        gridModel = new GridModel();
        squareWidth = (gridWidth - ((gridModel.numRows + 1) * borderWidth)) / gridModel.numRows;


    }

    /**
     * Returns the gridModel associated with this PlayGridView object.
     *
     * @return GridModel object for use with PlayGridView
     */
    public GridModel getGridModel() {
        return gridModel;
    }

    /**
     * onDraw method for PlayGridView object.
     *
     *
     * @param canvas
     */
    @Override
    public void onDraw(Canvas canvas) {

        //Update squareWidth with SeekBar changes
        squareWidth = (gridWidth - ((gridModel.numRows + 1) * borderWidth)) / gridModel.numRows;

        //set top and left values to use while drawing
        float top = gridTop;
        float left = gridLeft;

        // Draw the base for the grid
        canvas.drawRect(gridLeft, gridTop, gridWidth + gridLeft,
                gridWidth + gridTop, background);

        //Draw the borders for the grid
        for (int i = 0; i < gridModel.numRows + 1; i++ ) {
            canvas.drawRect(left, gridTop, left + borderWidth,  gridTop + gridWidth, borders);
            left = left + borderWidth + squareWidth;
        }
        for (int i = 0; i < gridModel.numRows + 1; i++ ) {
            canvas.drawRect(gridLeft, top, gridLeft + gridWidth,  top + borderWidth, borders);
            top = top + borderWidth + squareWidth;
        }

        //Draw rectangles from values in GridRect[][]
        for (int i = 0; i < gridModel.numRows; i++){
            for (int j = 0; j < gridModel.numRows; j++) {
                if (gridModel.gridRects[i][j].value != -1) {
                    canvas.drawRect(gridModel.gridRects[i][j].square, gridModel.gridRects[i][j].squarePaint);
                    canvas.drawText(gridModel.gridRects[i][j].value + "", gridModel.gridRects[i][j].square.centerX(), gridModel.gridRects[i][j].square.centerY(), gridModel.gridRects[i][j].textPaint);
                }
            }
        }



    }
}//onDraw

//class CakeView

