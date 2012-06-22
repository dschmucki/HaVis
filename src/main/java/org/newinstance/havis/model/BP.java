package org.newinstance.havis.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * User: u207365
 * Date: 19.06.12
 * Time: 14:49
 */
public class BP extends Line {

    private double x = 0;
    private double y = 0;
    private int z = 0;

    private String uic;
    private String name;

    public BP(String uic, String name) {
        this.uic = uic;
        this.name = name;
        setStroke(Color.BLUE);
        setStrokeWidth(1.0);
    }

    public String toString() {
        return uic + " " + name + "\t\t x: " + x + " y: " + y + " z: " + z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        this.setStartX((x-7)*800);
        this.setEndX((x-7)*800+1);
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        this.setStartY((y-47)*500);
        this.setEndY((y-47)*500+1);
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUic() {
        return uic;
    }

    public void setUic(String uic) {
        this.uic = uic;
    }
}
