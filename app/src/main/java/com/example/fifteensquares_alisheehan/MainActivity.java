package com.example.fifteensquares_alisheehan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.GridView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Can get screen height and width here? I'm not sure it makes much of a difference or how to use it
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        GridController controller = new GridController((PlayGridView) findViewById(R.id.playGridView));

        SeekBar seekGridSize = (SeekBar) findViewById(R.id.seekGridSize);
        seekGridSize.setOnSeekBarChangeListener(controller);



    }
}