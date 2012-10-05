import javax.swing.*;
import java.awt.*;

import javax.imageio.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class DrawPanel extends JPanel {
	Game gui;
	File bgFile = new File("img/background.jpg");
	File ballMediumFile = new File("img/ball.png");
	File padMediumFile = new File("img/pad.png");
	File padBlueMediumFile = new File("img/padb.png");
	Image background, ballMedium, padMedium, padBlueMedium;
	boolean paddle1Blue;

	public DrawPanel(Game gui) {
		this.gui = gui;
        try {
    		background = ImageIO.read(bgFile);
    		ballMedium = ImageIO.read(ballMediumFile);
    		padMedium = ImageIO.read(padMediumFile);
    		padBlueMedium = ImageIO.read(padBlueMediumFile);
        } catch (IOException e) {
        }
	}

	public void paintComponent(Graphics g) {
		// TODO Paint Graphics
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, gui.getGUIWidth(), gui.getGUIHeight());
		g.drawImage(background, 0, 0, null);
        
		g.setColor(Color.BLACK);
		Paddle paddle1 = gui.getPaddle1();
		Paddle paddle2 = gui.getPaddle2();
		ArrayList<Ball> a = gui.getBalls().getList();
		Balls balls = gui.getBalls();
		Ball b;
		paddle1Blue = true;
		
		/*
		 * Paddle
		 */
		if(balls.isHitsPaddle1()) g.drawImage(padBlueMedium, paddle1.getX()-9, paddle1.getY()-75, null);
		else g.drawImage(padMedium, paddle1.getX()-9, paddle1.getY()-75, null);

		if(!balls.isHitsPaddle1()) g.drawImage(padBlueMedium, paddle2.getX()-9, paddle2.getY()-75, null);
		else g.drawImage(padMedium, paddle2.getX()-9, paddle2.getY()-75, null);
		
		//g.fillRect(paddle1.getX()-paddle1.getThick(), paddle1.getY() - paddle1.getLength()/2, 2*paddle1.getThick()+1, paddle1.getLength());
		//g.fillRect(paddle2.getX()-paddle2.getThick(), paddle2.getY() - paddle2.getLength()/2, 2*paddle2.getThick()+1, paddle2.getLength());
		/*
		 * Ball
		 */
		
		for(int i = 0 ; i < a.size(); i++)
		{
			b = a.get(i);
			//g.fillOval((int)(b.getX() - b.getRadius()), (int)(b.getY() - b.getRadius()), (int)(b.getRadius() * 2), (int)(b.getRadius() * 2));
			g.drawImage(ballMedium, (int)(b.getX() - b.getRadius())-3, (int)(b.getY() - b.getRadius())-3, null);
			
		}
		/*
		 * SnapBall
		 */
		ArrayList<SnapBall> snap1 = paddle1.getSnapBall();
		SnapBall s;
		for(int i = 0 ; i < snap1.size(); i++)
		{
			s = snap1.get(i);
			//g.fillOval((int)(paddle1.getX()+paddle1.getThick()), (int)(paddle1.getY()-s.getRadius()), (int)(2*s.getRadius()), (int)(2*s.getRadius()));
			g.drawImage(ballMedium, (int)(paddle1.getX()+paddle1.getThick())-3, (int)(int)(paddle1.getY()-s.getRadius())-3, null);
			balls.setHitsPaddle1(true);
		}
	}
}
