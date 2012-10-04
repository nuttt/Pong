import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
	Game gui;

	public DrawPanel(Game gui) {
		this.gui = gui;
	}

	public void paintComponent(Graphics g) {
		// TODO Paint Graphics
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, gui.getGUIWidth(), gui.getGUIHeight());
		g.setColor(Color.BLACK);
		Paddle paddle1 = gui.getPaddle1();
		Paddle paddle2 = gui.getPaddle2();
		/*
		 * Paddle
		 */
		g.fillRect(paddle1.getX()-paddle1.getThick(), paddle1.getY() - paddle1.getLength()/2, 2*paddle1.getThick()+1, paddle1.getLength());
		g.fillRect(paddle2.getX()-paddle2.getThick(), paddle2.getY() - paddle2.getLength()/2, 2*paddle2.getThick()+1, paddle2.getLength());
		/*
		 * Ball
		 */
		ArrayList<Ball> a = gui.getBalls().getList();
		Ball b;
		for(int i = 0 ; i < a.size(); i++)
		{
			b = a.get(i);
			g.fillOval((int)(b.getX() - b.getRadius()), (int)(b.getY() - b.getRadius()), (int)(b.getRadius() * 2), (int)(b.getRadius() * 2));
		}
	}
}
