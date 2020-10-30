package cschacks.frontend;

import java.awt.BorderLayout;
import java.awt.Button;
//import java.awt.CheckBox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Polygon;
import java.awt.Button;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import cschacks.frontend.Polygons;
import cschacks.backend.BackEnd;

public class FrontEnd extends JPanel implements ActionListener {

    private JFrame fieldFrame;
    private JFrame menuFrame;

    private boolean tutorialOption;
    private boolean tiesOption;
    private int inningsOption;
    private boolean homeOption;
	private boolean awayOption;

    public BackEnd backend;

    public FrontEnd () {
	fieldFrame = new JFrame("Baseball Field");
	fieldFrame.getContentPane().add(this, BorderLayout.CENTER);
	fieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	fieldFrame.setSize(1000, 1000);

	menuFrame = new JFrame("Game Menu");
	menuFrame.getContentPane().add(this, BorderLayout.CENTER);
	menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	menuFrame.setSize(500, 500);

	backend = new BackEnd();

	}

	public void showMenu () {
		menuFrame.setVisible(true);
		Graphics graphics = getGraphics();
		graphics.setColor(Color.BLACK);

		JButton start = new JButton("Start");
		JButton quit = new JButton("Quit");

		JPanel startPanel = new JPanel();
		startPanel.setSize(new Dimension(50,50));
		start.addActionListener(this);
		start.setSize(50,20);
		Border border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
		start.setBorder(border);
		startPanel.add(start);
		menuFrame.add(startPanel);

		JPanel quitPanel = new JPanel();
		quitPanel.setSize(new Dimension(50,50));
		quit.addActionListener(new QuitGame());
		quit.setSize(50,20);
		quit.setBorder(border);
		quitPanel.add(quit);
		menuFrame.add(quitPanel);
	}

    public void hideMenu() {
		menuFrame.setVisible(false);
    }

    public void showField () {
    fieldFrame.setVisible(true);
    Graphics graphics = fieldFrame.getGraphics();


	Polygon homePlate = Polygons.createRegularPolygon(500, 800, 10, 5, (13*Math.PI)/10);
	Polygon firstBase = Polygons.createRegularPolygon(620, 680, 10, 4);
	Polygon secondBase = Polygons.createRegularPolygon(500, 560, 10, 4);
	Polygon thirdBase = Polygons.createRegularPolygon(380, 680, 10, 4);

	graphics.drawOval(475, 665, 50, 50);

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

	graphics.drawLine(505, 792, 620, 690);
	graphics.drawLine(495, 792, 380, 690);
	graphics.drawLine(620, 690, 860, 470);
	graphics.drawLine(380, 690, 140, 470);
	graphics.drawLine(140, 470, 140, 420);
	graphics.drawLine(860, 470, 860, 420);

	ArrayList<Line> ofFence = Polygons.createCurve(140, 470, 500, 270, 860, 470, 100);
	ArrayList<Line> ifBorder = Polygons.createCurve(350, 660, 500, 540, 650, 660, 100);
	// ArrayList<Line> bottomIfBorder = Polygons.createCurve(/*find variables */);

	graphics.setColor(Color.BLACK);
	for (int i = 0; i < ofFence.size(); i++) {
		Line l = ofFence.get(i);
		graphics.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
	}

	for (int i = 0; i < ifBorder.size(); i++) {
		Line l = ifBorder.get(i);
		graphics.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
	}

	// for(int i = 0; i < bottomIfBorder.size(); i++) {
	// 	Line l = bottomIfBorder.get(i);
	// 	graphics.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
	// }
    }

    public void hideField () {
	fieldFrame.setVisible(false);
    }

    public boolean getTiesOption() {
	return tiesOption;
    }

    public int getInningsOption() {
	return inningsOption;
    }

    public boolean homeOption() {
	return homeOption;
    }

    public boolean awayOption() {
	return awayOption;
    }

    public BackEnd generateBackEnd() {
	return new BackEnd(getTiesOption(), getInningsOption(), awayOption(), homeOption());
	}
	
	static class StartGame implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			 
		}
	}

	static class QuitGame implements ActionListener {
		@Override
    	public void actionPerformed(ActionEvent e) {
        	System.exit(0);
    	}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		hideMenu();
	}

}
