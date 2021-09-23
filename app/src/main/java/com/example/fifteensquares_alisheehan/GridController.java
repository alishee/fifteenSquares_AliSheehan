package com.example.fifteensquares_alisheehan;

import android.util.Log;
import android.widget.SeekBar;

public class GridController implements SeekBar.OnSeekBarChangeListener {

    private PlayGridView gridView;
    private GridModel gridModel;

    public GridController(PlayGridView gridViewInstance) {
        gridView = gridViewInstance;
        gridModel = gridView.getGridModel();


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        gridModel.numRows = i;
        gridView.invalidate();
        Log.i("i", "" +gridView.squareWidth);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
