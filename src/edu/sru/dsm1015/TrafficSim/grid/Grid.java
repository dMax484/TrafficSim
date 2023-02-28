package edu.sru.dsm1015.TrafficSim.grid;

//import java.awt.*;

public class Grid {
    private int width;
    private int height;
    private Cell[][] cells; 

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void initialize() {
        // Initialize each cell with a default value
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Coordinate tempCoordinate = new Coordinate(i, j);
                cells[i][j] = new Cell(tempCoordinate);
                
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setCell(int x, int y, Cell cell) {
        cells[x][y] = cell;
    }
}
