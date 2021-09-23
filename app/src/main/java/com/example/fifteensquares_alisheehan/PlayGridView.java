package com.example.fifteensquares_alisheehan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

    public PlayGridView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setWillNotDraw(false);

        background.setColor(Color.LTGRAY);
        background.setStyle(Paint.Style.FILL);
        borders.setColor(Color.DKGRAY);
        borders.setStyle(Paint.Style.FILL);



        setBackgroundColor(0xFFE1C699);

        gridModel = new GridModel();

        squareWidth = (gridWidth - ((gridModel.numRows + 1) * borderWidth)) / gridModel.numRows;

    }

    public GridModel getGridModel() {
        return gridModel;
    }

    @Override
    public void onDraw(Canvas canvas) {

        //Update squareWidth with SeekBar changes
        squareWidth = (gridWidth - ((gridModel.numRows + 1) * borderWidth)) / gridModel.numRows;

        //
        float top = gridTop;
        float left = gridLeft;

        canvas.drawRect(gridLeft, gridTop, gridWidth + gridLeft,
                gridWidth + gridTop, background);

        for (int i = 0; i < gridModel.numRows + 1; i++ ) {
            canvas.drawRect(left, gridTop, left + borderWidth,  gridTop + gridWidth, borders);
            left = left + borderWidth + squareWidth;
        }
        for (int i = 0; i < gridModel.numRows + 1; i++ ) {
            canvas.drawRect(gridLeft, top, gridLeft + gridWidth,  top + borderWidth, borders);
            top = top + borderWidth + squareWidth;
        }

    }
}//onDraw

//class CakeView

