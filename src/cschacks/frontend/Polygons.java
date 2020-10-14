package cschacks.frontend;

import java.awt.Polygon;
import cschacks.frontend.Line;
import java.util.ArrayList;


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
            System.out.println("The x value for point " + i + " is " + xValues[i] + " and the y value is " + yValues[i]);
        }
        return new Polygon(xValues, yValues, sides);
    }

    public static Polygon createRegularPolygon(int x, int y, int rad, int sides, double angle) {
        if (sides < 3) {
            System.out.println("Polygon unable to be drawn");
            return new Polygon();
        }
        double angleDiff = (2*Math.PI)/sides;
        int[] xValues = new int[sides];
        int[] yValues = new int[sides];
        for (int i = 0; i < sides; i++) {
            xValues[i] = x + (int) (rad * (Math.cos((angleDiff * i) + angle)));
            yValues[i] = y + (int) (rad * (Math.sin((angleDiff * i) + angle)));
            System.out.println("The x value for point " + i + " is " + xValues[i] + " and the y value is " + yValues[i]);
        }
    return new Polygon(xValues, yValues, sides);

     }
    
    public static ArrayList<Line> createCurve(int startX, int startY, int vertexX, int vertexY, int finishX, int finishY, int lines) {
    	ArrayList<Line> curve = new ArrayList<Line>();
    	double a = ((double) startY - (double) vertexY)/Math.pow(((double) startX - (double) vertexX), 2);
    	//y = a(x-vertexX)^2 + vertexY
    	double y1 = startY;
    	for (double i = startX; i < finishX; i+=((finishX-startX)/lines)) {
            double x2 = i+((finishX-startX)/lines);
    		double y2 = a*Math.pow((x2-vertexX), 2) + vertexY;
            curve.add(new Line((int) i, (int) x2, (int) y1, (int) y2));
            // System.out.println("Line goes from (" + i + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
            y1 = y2;
    	}
    	return curve;
    }
        
}