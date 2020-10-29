package cschacks.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Polygon;
import java.awt.Button;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cschacks.frontend.Polygons;
import cschacks.backend.BackEnd;

public class FrontEnd extends JPanel implements ActionListener
{
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
	menuFrame.setSize(1000, 1000);

	backend = new BackEnd();

    }

    public void showMenu () {
	Button tutorial = new Button();
	Button ties = new Button();
	Button innings = new Button();
	Button start = new Button("Start Game");
	Button quit = new Button("Quit Game");

	start.setBounds(100, 100, 100, 50);
	start.setVisible(true);

	quit.setBounds(100, 200, 100, 20);
	quit.setVisible(true);

	start.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!tutorialOption)
				backend = generateBackEnd();
			hideMenu();
		}
		});

	quit.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			hideMenu();
			System.exit(0);
		}
		});

	menuFrame.add(start);
	menuFrame.add(quit);

	menuFrame.setVisible(true);

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

    @Override
    public void actionPerformed(ActionEvent e) {


    }

}
