package cschacks.frontend;

import java.awt.Polygon;

public class Polygons {

    public static Polygon createRegularPolygon(int x, int y, int rad, int sides) {
        if (sides < 3) {
            System.out.println("Polygon unable to be drawn");
            return new Polygon();
        }
        double angle = (2*Math.PI)/sides;
        int[] xValues = new int[sides];
        int[] yValues = new int[sides];
        for (int i = 0; i < sides; i++) {
            xValues[i] = x + (int) (rad * Math.cos(angle*i));
            yValues[i] = y + (int) (rad * Math.sin(angle*i));
            // System.out.println("The x value for point " + i + " is " + xValues[i] + " and the y value is " + yValues[i]);
        }
        return new Polygon(xValues, yValues, sides);
    }

    public static Polygon rotatePolygon(Polygon input, double angle) {
    //     int sides = input.npoints;
    //     int[] xValues = new int[sides];
    //     int[] yValues = new int[sides];
    //     double angleDiff = (2*Math.PI)/sides;
    //     for (int i = 0; i < sides; i++) {
    //         xValues[i] = input.xpoints[i] + (int) Math.cos((angleDiff*i) + angle);
    //         yValues[i] = input.ypoints[i] + (int) Math.sin((angleDiff*i) + angle);
    //         System.out.println("The x value for point " + i + " is " + xValues[i] + " and the y value is " + yValues[i]);
    //     }
        
    //     return new Polygon(xValues, yValues, sides);
    return new Polygon();

     }
        
}