package com.example.fifteensquares_alisheehan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GridController controller = new GridController( findViewById(R.id.playGridView));

        // Set Seek Bar functionality
        SeekBar seekGridSize = findViewById(R.id.seekGridSize);
        seekGridSize.setOnSeekBarChangeListener(controller);

        // Set restart button functionality
        Button restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(controller);

        PlayGridView gridView = findViewById(R.id.playGridView);
        gridView.setOnTouchListener(controller);



    }
}