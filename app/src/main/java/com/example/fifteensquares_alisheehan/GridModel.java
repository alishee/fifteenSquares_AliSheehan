package com.example.fifteensquares_alisheehan;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GridModel {

    public int numRows = 4;
    public int gridSize;
    public int[] gridValues;
    public GridRect[][] gridRects;

    private float squareWidth;


    public GridModel() {

        // Calls a helper function to set values of class variables
        initializeRects();

    }

    /**
     * A helper function to initialize the values of the GridRect array. Randomly generates
     */
    public void initializeRects() {
        float top;
        float left;
        float right;
        float bottom;

        int incrementVal = 0;

        gridSize = numRows * numRows;
        gridValues = new int[gridSize];
        gridRects = new GridRect[numRows][numRows];

        squareWidth = (PlayGridView.gridWidth - ((numRows + 1) * PlayGridView.borderWidth)) / numRows;

        // initialize the values in gridValues
        for (int i = 0; i < gridValues.length - 1; i++) {
            gridValues[i] = i + 1;
        }
        gridValues[gridValues.length-1] = -1;


        // Use a helper method to randomize
        int[] locations = randomizeLocation();


        int i, j;

            //initialize gridRects
        for (i = 0; i < numRows; i++) {
            for (j = 0; j < numRows; j++) {
                top = PlayGridView.gridTop + ((1 + i) * PlayGridView.borderWidth) +
                        (i * squareWidth);
                bottom = PlayGridView.gridTop + ((1 + i) * PlayGridView.borderWidth) + ((1+i) * squareWidth);
                left = PlayGridView.gridLeft + ((1 + j) * PlayGridView.borderWidth) + (j * squareWidth);
                right = PlayGridView.gridLeft + ((1 + j) * PlayGridView.borderWidth) + ((1 + j) * squareWidth);
                gridRects[i][j] = new GridRect((int) left, (int) top, (int) right, (int) bottom, gridValues[incrementVal], locations[incrementVal]);
                incrementVal++;
            }
        }
    }
    public int[] randomizeLocation() {
        int[] ret;                                                                                      //https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array


        ret = gridValues.clone();

        Random rnd = new Random(System.currentTimeMillis());
        for (int i = ret.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ret[index];
            ret[index] = ret[i];
            ret[i] = a;


        }
        return ret;
    }


}
