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

    Paint background = new Paint();

    public PlayGridView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setWillNotDraw(false);

        background.setColor(Color.RED);
        background.setStyle(Paint.Style.FILL);
    }


    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRect(gridTop, gridLeft, gridWidth + gridTop, gridWidth + gridLeft, background);
    }
}//onDraw

//class CakeView

