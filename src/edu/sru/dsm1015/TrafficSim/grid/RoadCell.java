package edu.sru.dsm1015.TrafficSim.grid;

import java.awt.Color;

import edu.sru.dsm1015.TrafficSim.datastructures.Node;

public class RoadCell extends Cell {

    private Node[][] nodes;
    

    public RoadCell(Coordinate coordinates) {
        super(coordinates);
        this.nodes = new Node[3][1]; //4 sets of 2 nodes; NESW
        this.setColor(Color.DARK_GRAY);
        
        // set up nodes
        Coordinate tempCoordinates = new Coordinate(coordinates.getX(), coordinates.getY()+1);
        this.nodes[0][0] = new Node(tempCoordinates, 0, false);
      
    }
    
}
