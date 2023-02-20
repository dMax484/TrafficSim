package edu.sru.dsm1015.TrafficSim.grid;

import java.awt.*;

public class Cell {

    private int cellSideLength;
    private Coordinate coordinates;
    private double trafficDensity;
    private Color color;

    public Cell(Coordinate coordinates){
        this.cellSideLength = 5;
        this.coordinates = coordinates;
        this.trafficDensity = 0;
        this.color = new Color(255, 255, 255); // white
    }

    public Cell(Coordinate coordinates, Color color){
        this.cellSideLength = 5;
        this.coordinates = coordinates;
        this.trafficDensity = 0;
        this.color = color; // passed color
    }

    // Getters and setters
    public int getCellSideLength() {
        return cellSideLength;
    }

    public void setCellSideLength(int cellSideLength) {
        this.cellSideLength = cellSideLength;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate coordinates) {
        this.coordinates = coordinates;
    }

    public double getTrafficDensity() {
        return trafficDensity;
    }

    public void setTrafficDensity(double trafficDensity) {
        this.trafficDensity = trafficDensity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    // toString method
    @Override
    public String toString() {
        return "Cell{" +
                "cellSideLength=" + cellSideLength +
                ", coordinates=" + coordinates +
                ", trafficDensity=" + trafficDensity +
                ", color=" + color +
                '}';
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return cellSideLength == cell.cellSideLength &&
                Double.compare(cell.trafficDensity, trafficDensity) == 0 &&
                coordinates.equals(cell.coordinates) &&
                color.equals(cell.color);
    }

    // paint method (to draw the cell on a graphics object)
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(coordinates.getX(), coordinates.getY(), cellSideLength, cellSideLength);
    }

    // computeTrafficFlow method (to compute the traffic flow based on the traffic density)
    public double computeTrafficFlow() {
        // Use a simple linear function to compute the traffic flow
        return 0.5 * trafficDensity;
    }


    
}
