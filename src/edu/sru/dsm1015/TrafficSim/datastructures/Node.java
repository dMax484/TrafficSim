package edu.sru.dsm1015.TrafficSim.datastructures;

import edu.sru.dsm1015.TrafficSim.grid.Coordinate;

public class Node {
    private Coordinate coordinates;
    private int cardinalDirection; //0-N, 1-E, 2-S, 3-W
    private boolean isRight;

    public Node(Coordinate coordinate, int cardinalDirection, boolean isRight) {
        this.coordinates = coordinate;
        this.cardinalDirection = cardinalDirection;
        this.isRight = isRight;
    }
    
}
