package com.example.fifteensquares_alisheehan;

import android.app.Activity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

public class GridController implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, View.OnTouchListener {

    private PlayGridView gridView;
    private GridModel gridModel;

    public GridController(PlayGridView gridViewInstance) {
        gridView = gridViewInstance;
        gridModel = gridView.getGridModel();


    }


    /**
     * Resizes the grid based on the current value of seekBar.
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //
        gridModel.numRows = i;
        // Adjust size and number of squares
        gridModel.initializeRects();
        gridView.invalidate();
        Log.i("i", "" +gridView.squareWidth);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.exitButton:



            /*
             * RESTART BUTTON FUNCTIONALITY
             * Randomly scrambles the squares to start a new game. Does not change grid size.
             */
            case R.id.restartButton:
                gridModel.initializeRects();
                gridView.invalidate();
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (gridModel.isOnGrid(x,y)) {
            int currentLocation = gridModel.whichSquare(x,y);
            gridView.whichSquare = currentLocation;
        } else {
            gridView.whichSquare = -1;
        }
        view.invalidate();
        return false;
    }
}
