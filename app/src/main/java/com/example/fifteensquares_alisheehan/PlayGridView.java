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

    public int whichSquare = -1;

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

        //Draw rectangles from GridRect[][]
        for (int i = 0; i < gridModel.numRows; i++){
            for (int j = 0; j < gridModel.numRows; j++) {
                if (gridModel.gridRects[i][j].value != -1) {
                    canvas.drawRect(gridModel.gridRects[i][j].square, gridModel.gridRects[i][j].squarePaint);
                    canvas.drawText(gridModel.gridRects[i][j].value + "", gridModel.gridRects[i][j].square.centerX(), gridModel.gridRects[i][j].square.centerY(), gridModel.gridRects[i][j].textPaint);
                }
            }
        }

        if (whichSquare != -1){
            Paint temp = new Paint();
            temp.setStyle(Paint.Style.FILL);
            temp.setColor(Color.BLACK);
            temp.setTextSize(36);
            canvas.drawText(whichSquare + "", 100f, 1700f, temp);
        }
    }
}//onDraw

//class CakeView

