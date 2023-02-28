package edu.sru.dsm1015.TrafficSim.grid;

import java.awt.Color;

public class ZoneCell extends Cell {

    private String zoneType;


    public ZoneCell(Coordinate coordinates, String zoneType) {
        super(coordinates);
        switch(zoneType){
            case "residential":
                this.zoneType = "residential";
                this.setColor(Color.GREEN);
                break;
            case "commercial":
                this.zoneType = "commercial";
                this.setColor(Color.BLUE);
                break;
            case "offices":
                this.zoneType = "offices";
                this.setColor(Color.YELLOW);
                break;
        }
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }

    public String getZoneType() {
        return this.zoneType;
    }
}
