package cschacks.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cschacks.frontend.Polygons;

public class FrontEnd extends JPanel implements ActionListener {

    private JFrame fieldFrame;
    private Graphics graphics;
    
    public FrontEnd () {
		fieldFrame = new JFrame("Baseball Field");
		fieldFrame.getContentPane().add(this, BorderLayout.CENTER);
		fieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fieldFrame.setSize(1000, 1000);
        
    }

    public void showField () {
		fieldFrame.setVisible(true);
		//int[][] homeCoords = {{0, 170, 170, 85, 0}, {0, 0, 85, 200, 85}};
		// int[][] homeCoords = {{415, 585, 585, 500, 415}, {700, 700, 785, 900, 785}};
		// int[][] firstCoords = {{200, 350, 350, 200}, {0, 0, 150, 150}};
		// int[][] secondBase = {{}, {}};
		// int[][] thirdBase = {{}, {}};
		// int[] xCoords = {0, 170, 170, 85, 0};
		// int[] yCoords = {0, 0, 85, 200, 85};
		graphics = getGraphics();
		// Polygon homePlate = new Polygon(homeCoords[0], homeCoords[1], 5);
		Polygon homePlate = Polygons.createRegularPolygon(100, 100, 100, 4, (Math.PI/4));
		// Polygon rotated = Polygons.rotatePolygon(homePlate, Math.PI/4);
		// Polygon firstBase = new Polygon(firstCoords[0], firstCoords[1], 4);
		graphics.drawPolygon(homePlate);
		graphics.setColor(Color.GRAY);
		graphics.fillPolygon(homePlate);
		// graphics.drawPolygon(rotated);
		// graphics.setColor(Color.GRAY);
		// graphics.fillPolygon(rotated);
		// graphics.drawPolygon(firstBase);
		// graphics.setColor(Color.WHITE);
		// graphics.fillPolygon(firstBase);
	}
	
	public void hideField () {
		fieldFrame.setVisible(false);
	}
	
    @Override
    public void actionPerformed(ActionEvent e) {
        

    }
    
}
