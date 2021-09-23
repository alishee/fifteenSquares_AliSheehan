package com.example.fifteensquares_alisheehan;

public class GridModel {

    public int numRows = 4;
    public int gridSize;
    public int[] gridValues;


    public GridModel() {
        gridSize = numRows * numRows;
        gridValues = new int[gridSize];

    }
}
