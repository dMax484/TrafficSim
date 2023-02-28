package edu.sru.dsm1015.TrafficSim.gui;

import javax.swing.*;
import java.awt.*;

import edu.sru.dsm1015.TrafficSim.grid.Cell;
import edu.sru.dsm1015.TrafficSim.grid.Grid;
import edu.sru.dsm1015.TrafficSim.grid.RoadCell;
import edu.sru.dsm1015.TrafficSim.grid.ZoneCell;

public class Gui extends JFrame {

    private Grid grid;
    private JPanel panel;
    // menu 
    JMenu menu, zoneSubMenu;
    JMenuItem roadMenuItem, zoneItem1, zoneItem2, zoneItem3, clearItem;

    String currentSelection;

    public Gui(Grid grid) {
        this.grid = grid;
        // Set up the main window
        setTitle("CitySim");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));

        // Create a panel to hold the grid display
        this.panel = new JPanel();
        panel.setLayout(new GridLayout(grid.getWidth(), grid.getHeight(), 0, 0));
        add(panel, BorderLayout.CENTER);

        // initialize current selection
        this.currentSelection = "none";

        // add menu
        menu = new JMenu("Add");
        zoneSubMenu = new JMenu("Zone");
        JMenuBar menuBar = new JMenuBar();
        roadMenuItem = new JMenuItem("Road");
        roadMenuItem.addActionListener(e -> {
            this.currentSelection = "road";
        });
        zoneItem1 = new JMenuItem("Commercial");
        zoneItem1.addActionListener(e -> {
            this.currentSelection = "commercial";
        });
        zoneItem2 = new JMenuItem("Residential");
        zoneItem2.addActionListener(e -> {
            this.currentSelection = "residential";
        });
        zoneItem3 = new JMenuItem("Offices");
        zoneItem3.addActionListener(e -> {
            this.currentSelection = "offices";
        });
        zoneSubMenu.add(zoneItem1);
        zoneSubMenu.add(zoneItem2);
        zoneSubMenu.add(zoneItem3);
        clearItem = new JMenuItem("Remove");
        clearItem.addActionListener(e -> {
            this.currentSelection = "none";
        });
        menu.add(roadMenuItem);
        menu.add(zoneSubMenu);
        menu.add(clearItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Add each cell to the panel
        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                Cell cell = grid.getCell(i, j);
                JButton button = new JButton();
                button.setBackground(cell.getColor());
                //add listener for upgrading the cell on click
                button.addActionListener(e -> {
                    changeCell(cell);
                });
                panel.add(button);
            }
        }

        // Pack the window and display it
        pack();
        setVisible(true);     
    }

    public void upgradeCellToRoad(Cell cell){

        if (cell instanceof RoadCell){
            return;
        }
        // Create a new RoadCell with the same coordinates as the current cell
        RoadCell roadCell = new RoadCell(cell.getCoordinates());

        // Replace the current cell with the RoadCell in the Grid
        grid.setCell(cell.getCoordinates().getX(), cell.getCoordinates().getY(), roadCell);

        // Update the button background color to reflect the new cell type
        JButton button = (JButton) panel.getComponent(cell.getCoordinates().getX() * grid.getHeight() + cell.getCoordinates().getY());
        button.setBackground(roadCell.getColor());
    }

    public void upgradeCellToZone(Cell cell, String zoneType){

        // Create a new RoadCell with the same coordinates as the current cell
        ZoneCell zoneCell = new ZoneCell(cell.getCoordinates(), zoneType);
 
        // Replace the current cell with the RoadCell in the Grid
        grid.setCell(cell.getCoordinates().getX(), cell.getCoordinates().getY(), zoneCell);

        // Update the button background color to reflect the new cell type
        JButton button = (JButton) panel.getComponent(cell.getCoordinates().getX() * grid.getHeight() + cell.getCoordinates().getY());
        button.setBackground(zoneCell.getColor());
    }

    public void clearCell(Cell cell){

        // Create a new RoadCell with the same coordinates as the current cell
        Cell newCell = new Cell(cell.getCoordinates());

        // Replace the current cell with the RoadCell in the Grid
        grid.setCell(cell.getCoordinates().getX(), cell.getCoordinates().getY(), newCell);

        // Update the button background color to reflect the new cell type
        JButton button = (JButton) panel.getComponent(cell.getCoordinates().getX() * grid.getHeight() + cell.getCoordinates().getY());
        button.setBackground(newCell.getColor());
    }

    public void changeCell(Cell cell){
        switch (this.currentSelection){
            case "none":
                System.out.println("clearing cell");
                clearCell(cell);
                break;
            case "road":
                System.out.println("adding road cell");
                upgradeCellToRoad(cell);
                break;
            case "residential":
                System.out.println("adding residential zone");
                upgradeCellToZone(cell, "residential");
                break;
            case "commercial":
                System.out.println("adding commercial zone");
                upgradeCellToZone(cell, "commercial");
                break;
            case "offices":
                System.out.println("adding offices zone");
                upgradeCellToZone(cell, "offices");
                break;
        }
    }

    public static void main(String args[]){
        // Create a sample grid
        Grid grid = new Grid(10, 10);
        grid.initialize();

        // Create the GUI and display the grid
        Gui gui = new Gui(grid);
     }

     
}
