package edu.sru.dsm1015.TrafficSim.grid;

import java.awt.Color;

import edu.sru.dsm1015.TrafficSim.datastructures.Edge;
import edu.sru.dsm1015.TrafficSim.datastructures.Node;

public class RoadCell extends Cell {

    private Node[][] nodes;
    private Edge[] edges;
    

    public RoadCell(Coordinate coordinates) {
        super(coordinates);
        this.nodes = new Node[4][2]; //4 sets of 2 nodes; NESW
        this.setColor(Color.DARK_GRAY);
        
        // set up nodes
        Coordinate tempCoordinates = new Coordinate(coordinates.getX(), coordinates.getY());
        
        // Simple Horizontal Road W -> E
        this.nodes[1][0] = new Node(tempCoordinates, 1, false); //E L
        this.nodes[1][1] = new Node(tempCoordinates, 1, true); //E R
        this.nodes[3][0] = new Node(tempCoordinates, 3, false); //W L
        this.nodes[3][1] = new Node(tempCoordinates, 3, true); //W R

        Edge leftEdge = new Edge(nodes[3][0], nodes[1][1], 1); // W L to E R
        Edge rightEdge = new Edge(nodes[1][0], nodes[3][1], 1);// E L to W R
        Edge newEdges[] = {leftEdge, rightEdge};
        this.edges = newEdges;


        /* for (int i = 0; i <= 3; i++){
            //left node
            this.nodes[i][0] = new Node(tempCoordinates, i, false);
            //right node
            this.nodes[i][1] = new Node(tempCoordinates, i, true);
        } */
      
    }
    
}
