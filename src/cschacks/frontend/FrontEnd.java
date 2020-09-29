package cschacks.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
		int[][] homePlate = {{0, 170, 170, 85, 0}, {0, 0, 85, 200, 85}};
		// int[] xCoords = {0, 170, 170, 85, 0};
		// int[] yCoords = {0, 0, 85, 200, 85};
		graphics = getGraphics();
		Polygon p = new Polygon(homePlate[0], homePlate[1], 5);
		graphics.drawPolygon(p);
		graphics.setColor(Color.GRAY);
		graphics.fillPolygon(p);
	}
	
	public void hideField () {
		fieldFrame.setVisible(false);
	}
	
    @Override
    public void actionPerformed(ActionEvent e) {
        

    }
    
}
