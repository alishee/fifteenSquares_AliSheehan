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
        initializeRects(true);

    }

    /**
     * A helper function to initialize the values of the GridRect array.
     * Initializes and sets the coordinates of the Rect objects in GridRect array.
     * If randomize is true, shuffles values of locations
     *
     * Used by the constructor as well as GridController to update the appearance of grid.
     *
     * @param randomize boolean whether or not to randomize locations
     */
    public void initializeRects(boolean randomize) {
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
        if (randomize) {
            locations = randomizeLocation();
        }

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
     * Copy the array gridValues to a new array and randomize the values to determine location on grid
     *
     * Credit to solution found on Stack Overflow:
     *  //https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
     *
     * @return array of values shuffled into positions indicated by index of array
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

    /**
     * Given two integer coordinates, returns whether or not a touch event was within the bounds of
     * the playable grid.
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return boolean value true if move was valid
     */
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

    /**
     * Given integer coordinates of a touch event, returns the position of the square touched.
     * Does not return position if touched gridlines.
     *
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return integer position (0-gridSize) of square touched
     */
    public int whichSquare(int x, int y) {

        // Increment through gridRects for a square containing clicked point
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                if(gridRects[i][j].square.left < x && gridRects[i][j].square.right > x) {
                    if (gridRects[i][j].square.top < y && gridRects[i][j].square.bottom > y) {

                    // return the position of the gridRect object as found in the int array position
                        return (i * numRows) + (j);
                    }
                }
            }
        }

        // Return -1 if clicked on a border
        return -1;
    }

    /**
     * given the location of a square, determines whether or not the NULL square was adjacent.
     * Returns 300 if not a valid move.
     *
     * @param loc index of selected square
     * @return integer value for location of null. Is valid index is move is valid. Is 300 if invalid.
     */
    public int validMove(int loc){
        boolean valid = false;
        int locNULL = 300;
        int locNULLTEMP = 300;

        // Locate locNULL in locations
        for (int i = 0; i < locations.length; i++) {
            if (locations[i] == -1) {
                locNULLTEMP = i;
            }
        }
            //Check left and right squares for NULL square
            if (loc - 1 == locNULLTEMP) {
                valid = true;
            } else if (loc + 1 == locNULLTEMP) {
                valid = true;
            }

            //Check above and below squares for NULL square
            if(loc - numRows == locNULLTEMP) {
                valid = true;
            } else if(loc + numRows == locNULLTEMP) {
                valid = true;
            }

        // If next to NULL square, update locNULL
        if(valid) {
            locNULL = locNULLTEMP;
        }
          return locNULL;
    }


    /**
     * Simple swap between two values of locations
     *
     */
    public void swapSquares(int loc, int locNULL) {
        int temp = locations[locNULL];
        locations[locNULL] = locations[loc];
        locations[loc] = -1;


    }
}
