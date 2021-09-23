package com.example.fifteensquares_alisheehan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class PlayGridView extends SurfaceView {

    public static final float gridWidth = 1000f;
    public static final float gridTop = 100f;
    public static final float gridLeft = 100f;
    public static final float borderWidth = 10f;
    public static final float squareWidth = 237.5f;

    Paint background = new Paint();
    Paint borders = new Paint();

    public PlayGridView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setWillNotDraw(false);

        background.setColor(Color.LTGRAY);
        background.setStyle(Paint.Style.FILL);
        borders.setColor(Color.DKGRAY);
        borders.setStyle(Paint.Style.FILL);
    }


    @Override
    public void onDraw(Canvas canvas) {
        float top = gridTop;
        float left = gridLeft;

        canvas.drawRect(gridLeft, gridTop, gridWidth + gridLeft,
                gridWidth + gridTop, background);

        for (int i = 0; i < 5; i++ ) {
            canvas.drawRect(left, gridTop, left + borderWidth,  gridTop + gridWidth, borders);
            left = left + borderWidth + squareWidth;
        }
        for (int i = 0; i < 5; i++ ) {
            canvas.drawRect(gridLeft, top, gridLeft + gridWidth,  top + borderWidth, borders);
            top = top + borderWidth + squareWidth;
        }

    }
}//onDraw

//class CakeView

