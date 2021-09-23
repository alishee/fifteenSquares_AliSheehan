package com.example.fifteensquares_alisheehan;

public class GridModel {

    public int numRows;
    public int gridSize;
    public int[] gridValues;


    public GridModel(int gSize) {
        numRows = gSize;
        gridSize = numRows * numRows;
        gridValues = new int[gSize];

    }
}
