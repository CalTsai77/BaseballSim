package cschacks.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Polygon;
import java.awt.Rectangle;

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
		graphics = getGraphics();
		Polygon homePlate = Polygons.createRegularPolygon(500, 800, 10, 5, (13*Math.PI)/10);
		Polygon firstBase = Polygons.createRegularPolygon(620, 680, 10, 4);
		Polygon secondBase = Polygons.createRegularPolygon(500, 560, 10, 4);
		Polygon thirdBase = Polygons.createRegularPolygon(380, 680, 10, 4);
		graphics.drawLine(505, 792, 620, 690);
		graphics.drawLine(495, 792, 380, 690);
		graphics.drawLine(620, 690, 860, 470);
		graphics.drawLine(380, 690, 140, 470);
		graphics.setColor(Color.YELLOW);
		graphics.drawLine(140, 470, 140, 420);
		graphics.drawLine(860, 470, 860, 420);
		graphics.drawPolygon(homePlate);
		graphics.setColor(Color.GRAY);
		graphics.fillPolygon(homePlate);
		graphics.drawPolygon(firstBase);
		graphics.setColor(Color.WHITE);
		graphics.fillPolygon(firstBase);
		graphics.drawPolygon(secondBase);
		graphics.setColor(Color.WHITE);
		graphics.fillPolygon(secondBase);
		graphics.drawPolygon(thirdBase);
		graphics.setColor(Color.WHITE);
		graphics.fillPolygon(thirdBase);
	}
	
	public void hideField () {
		fieldFrame.setVisible(false);
	}
	
    @Override
    public void actionPerformed(ActionEvent e) {
        

    }
    
}
