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
    	int a = (startY - vertexY)/(startX - vertexX);
    	//y = a(x-vertexX) + vertexY
    	int y1 = startY;
    	for (int i = startX; i <= finishX; i+=((finishX-startX)/lines)) {
    		int x2 = i+((finishX-startX)/lines);
    		int y2 = a*(x2-vertexX) + vertexY;
    		curve.add(new Line(i, y1, x2, y2));
    	}
    	return curve;
    }
        
}