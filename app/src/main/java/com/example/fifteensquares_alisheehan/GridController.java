package com.example.fifteensquares_alisheehan;

import android.app.Activity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

public class GridController implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, View.OnTouchListener {

    private PlayGridView gridView;
    private GridModel gridModel;

    /**
     * Constructor for GridController object. Requires instance of PlayGridView object to make
     * associated gridModel object.
     *
     * @param gridViewInstance existing PlayGridView
     */
    public GridController(PlayGridView gridViewInstance) {
        gridView = gridViewInstance;
        gridModel = gridView.getGridModel();


    }


    /**
     * Resizes the grid based on the current value of seekBar.
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        // Update desired size of grid
        gridModel.numRows = i;
        // Adjust size and number of squares
        gridModel.initializeRects(true);
        gridView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    /**
     * Functional implementaion of restart button
     *
     */
    @Override
    public void onClick(View view) {

            gridModel.initializeRects(true);
            gridView.invalidate();

    }

    /**
     * Makes a valid move if:
     *   * touch was inside the grid
     *   * touch was not on grid line
     *   * square is next to null square
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (gridModel.isOnGrid(x,y)) {
            int currentLocation = gridModel.whichSquare(x,y);
            int locNULL = gridModel.validMove(currentLocation);
            if (locNULL != 300) {
                gridModel.swapSquares(currentLocation, locNULL);
                gridModel.initializeRects(false);
            }

        }
        view.invalidate();
        return false;
    }
}
