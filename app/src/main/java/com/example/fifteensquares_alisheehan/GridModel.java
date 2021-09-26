package com.example.fifteensquares_alisheehan;

import java.util.Random;

public class GridModel {

    public int numRows = 4;
    public int gridSize;
    public int[] gridValues;
    public int[] locations;
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
        locations = randomizeLocation();


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


    /**
     * Randomize the >.>
     *
     * Credit to solution found on Stack Overflow:
     *  //https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
     *
     * @return
     */
    public int[] randomizeLocation() {
        int[] ret;

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

    public boolean isOnGrid(int x, int y) {
        boolean isValid = false;
        if ( PlayGridView.gridLeft + PlayGridView.borderWidth < x
                && x < PlayGridView.gridWidth + PlayGridView.gridLeft + PlayGridView.borderWidth) {
            if (PlayGridView.gridTop + PlayGridView.borderWidth < y
                    && y < PlayGridView.gridWidth + PlayGridView.gridTop + PlayGridView.borderWidth) {
                isValid = true;
            }
        }
        return isValid;
    }

    public int whichSquare(int x, int y) {

        // Increment through gridRects for a square containing clicked point
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                if(gridRects[i][j].square.left < x && gridRects[i][j].square.right > x) {
                    if (gridRects[i][j].square.top < y && gridRects[i][j].square.bottom > y) {

                    // return the position of the gridRect object as found in the int array position
                        return (i * numRows) + (j+1);
                    }
                }
            }
        }

        // Return -1 if clicked on a border
        return -1;
    }

    public int validMove(int location) {
        //CHECK IF NEXT TO NULL SQUARE

        return -1;
    }
}
