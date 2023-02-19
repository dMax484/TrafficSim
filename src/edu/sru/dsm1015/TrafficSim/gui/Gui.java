package edu.sru.dsm1015.TrafficSim.gui;

import javax.swing.*;
import java.awt.*;

import edu.sru.dsm1015.TrafficSim.grid.Cell;
import edu.sru.dsm1015.TrafficSim.grid.Grid;

public class Gui extends JFrame {

    private Grid grid;

    public Gui(Grid grid) {
        this.grid = grid;
        // Set up the main window
        setTitle("CitySim");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));

        // Create a panel to hold the grid display
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(grid.getWidth(), grid.getHeight(), 0, 0));
        add(panel, BorderLayout.CENTER);

        // Add each cell to the panel
        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                Cell cell = grid.getCell(i, j);
                JButton button = new JButton();
                //button.setBackground(cell.getColor());
                panel.add(button);
            }
        }

        // Pack the window and display it
        pack();
        setVisible(true);
    }

    public static void main(String args[]){
        // Create a sample grid
        Grid grid = new Grid(10, 10);
        grid.initialize();

        // Create the GUI and display the grid
        Gui gui = new Gui(grid);
     }

     
}
