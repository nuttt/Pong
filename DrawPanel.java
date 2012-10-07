import java.awt.*;
import javax.imageio.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

public class DrawPanel extends JPanel {
	Game gui;
	File bgFile = new File("img/background.jpg");
	File ballMediumFile = new File("img/ball.png");
	File ballBlueMediumFile = new File("img/ballb.png");
	File ballYellowMediumFile = new File("img/bally.png");
	File padMediumFile = new File("img/pad.png");
	File padBlueMediumFile = new File("img/padb.png");
	File padShortFile = new File("img/pad-s.png");
	File padBlueShortFile = new File("img/padb-s.png");
	File padLongFile = new File("img/pad-l.png");
	File padBlueLongFile = new File("img/padb-l.png");
	File pauseFile = new File("img/pause.png");
	File[] itemsPicFile = new File[11];
	Image background, ballMedium, ballBlueMedium, ballYellowMedium;
	Image padMedium, padBlueMedium, padShort, padBlueShort, padLong, padBlueLong;
	Image pauseBg;
	Image[] itemsPic = new Image[11];
	boolean paddle1Blue;

	public DrawPanel(Game gui) {
		this.gui = gui;
		itemsPicFile[0] = new File("img/item-random2.png");
		itemsPicFile[1] = new File("img/item-ball.png");
		itemsPicFile[2] = new File("img/item-dash.png");
		itemsPicFile[3] = new File("img/item-betray.png");
		itemsPicFile[4] = new File("img/item-random.png");
		itemsPicFile[5] = new File("img/item-fast.png");
		itemsPicFile[6] = new File("img/item-wide.png");
		itemsPicFile[7] = new File("img/item-narrow.png");
		itemsPicFile[8] = new File("img/item-reverse.png");
		itemsPicFile[9] = new File("img/item-magnet.png");
		itemsPicFile[10] = new File("img/item-shock.png");
        try {
    		background = ImageIO.read(bgFile);
    		ballMedium = ImageIO.read(ballMediumFile);
    		ballBlueMedium = ImageIO.read(ballBlueMediumFile);
    		ballYellowMedium = ImageIO.read(ballYellowMediumFile);
    		padMedium = ImageIO.read(padMediumFile);
    		padBlueMedium = ImageIO.read(padBlueMediumFile);
    		padShort = ImageIO.read(padShortFile);
    		padBlueShort = ImageIO.read(padBlueShortFile);
    		padLong = ImageIO.read(padLongFile);
    		padBlueLong = ImageIO.read(padBlueLongFile);
    		pauseBg = ImageIO.read(pauseFile);
    		for (int i = 0; i < itemsPicFile.length; i++) {
    			itemsPic[i]	= ImageIO.read(itemsPicFile[i]);
    		}
        } catch (IOException e) {
        }
	}

	public void paintComponent(Graphics g) {
		// TODO Paint Graphics
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
		 * Score Point
		 */
		g.setColor(new Color(255, 255, 255, 155));
		g.setFont(new Font("Arial", Font.BOLD, 52));
		g.drawString(paddle1.getScore()+" : "+paddle2.getScore(), 470, 50);	
		

		/*
		 * Items
		 */
		g.setColor(Color.white);
		ArrayList<Item> itemList = gui.getItems().getItemList();
		synchronized (itemList) {
			int n = itemList.size();
			Item p;
			double r;
			for (int i = 0; i < n; i++) {
				try {
					p = itemList.get(i);
					r = p.getRadius();
					if (p instanceof ItemSplit) g.drawImage(itemsPic[1], (int) (p.getX() - r) - 4 , (int) (p.getY() - r) - 4, null);
					else if (p instanceof ItemDash) g.drawImage(itemsPic[2], (int) (p.getX() - r) - 4 , (int) (p.getY() - r) - 4, null);
					else if (p instanceof ItemBetray) g.drawImage(itemsPic[3], (int) (p.getX() - r) - 4 , (int) (p.getY() - r) - 4, null);
					else if (p instanceof ItemRandom) g.drawImage(itemsPic[4], (int) (p.getX() - r) - 4 , (int) (p.getY() - r) - 4, null);
					
					else if (p instanceof ItemGhost) g.drawImage(itemsPic[8], (int) (p.getX() - r) - 4 , (int) (p.getY() - r) - 4, null);
				} catch (NullPointerException e) {
					break;
				}
			}
		}
		
		/*
		 * Paddle
		 */
		if(paddle1.getLength() == 261){
			g.drawImage(padLong, paddle1.getX()-9, paddle1.getY()-paddle1.getLength()/2, null);
		}
		else if(paddle1.getLength() == 103){
			g.drawImage(padShort, paddle1.getX()-9, paddle1.getY()-paddle1.getLength()/2, null);
		}
		else{
			g.drawImage(padMedium, paddle1.getX()-9, paddle1.getY()-paddle1.getLength()/2, null);
		}
		if(paddle2.getLength() == 261){
			g.drawImage(padBlueLong, paddle2.getX()-9, paddle2.getY()-paddle2.getLength()/2, null);
		}
		else if(paddle2.getLength() == 103){
			g.drawImage(padBlueShort, paddle2.getX()-9, paddle2.getY()-paddle2.getLength()/2, null);
		}
		else{
			g.drawImage(padBlueMedium, paddle2.getX()-9, paddle2.getY()-paddle2.getLength()/2, null);
		}
		
		//g.fillRect(paddle1.getX()-paddle1.getThick(), paddle1.getY() - paddle1.getLength()/2, 2*paddle1.getThick()+1, paddle1.getLength());
		//g.fillRect(paddle2.getX()-paddle2.getThick(), paddle2.getY() - paddle2.getLength()/2, 2*paddle2.getThick()+1, paddle2.getLength());

		/*
		 * Ball
		 */

		for (int i = 0; i < a.size(); i++) {
			b = a.get(i);
			//g.fillOval((int)(b.getX() - b.getRadius()), (int)(b.getY() - b.getRadius()), (int)(b.getRadius() * 2), (int)(b.getRadius() * 2));
			
			if(b.getOwner() == 1){
				g.drawImage(ballYellowMedium, (int)(b.getX() - b.getRadius())-3, (int)(b.getY() - b.getRadius())-3, null);
			}
			else if(b.getOwner() == 2){
				g.drawImage(ballBlueMedium, (int)(b.getX() - b.getRadius())-3, (int)(b.getY() - b.getRadius())-3, null);
			}
			else{
				g.drawImage(ballMedium, (int)(b.getX() - b.getRadius())-3, (int)(b.getY() - b.getRadius())-3, null);
			}
		}
		/*
		 * SnapBall
		 */
		ArrayList<SnapBall> snap1 = paddle1.getSnapBall();
		SnapBall s;
		for (int i = 0; i < snap1.size(); i++) {
			s = snap1.get(i);
			//g.fillOval((int)(paddle1.getX()+paddle1.getThick()), (int)(paddle1.getY()-s.getRadius()), (int)(2*s.getRadius()), (int)(2*s.getRadius()));
			g.drawImage(ballYellowMedium, (int)(paddle1.getX()+paddle1.getThick())-3, (int)(int)(paddle1.getY()-s.getRadius())-3, null);
		}
		
		/*
		 * If Pause, show pause window
		 */
		if(Game.isPaused()){
			g.drawImage(pauseBg, 0, 0, null);
		}
		
	}
}
