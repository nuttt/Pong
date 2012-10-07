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
	
	File padLongMagnetFile = new File("img/pad-l-magnet.png");
	File padMagnetFile = new File("img/pad-magnet.png");
	File padShortMagnetFile = new File("img/pad-s-magnet.png");
	File padBlueLongMagnetFile = new File("img/padb-l-magnet.png");
	File padBlueMagnetFile = new File("img/padb-magnet.png");
	File padBlueShortMagnetFile = new File("img/padb-s-magnet.png");
	
	File padLongFreezeFile = new File("img/pad-l-freeze.png");
	File padFreezeFile = new File("img/pad-freeze.png");
	File padShortFreezeFile = new File("img/pad-s-freeze.png");	
	
	File padLongReverseFile = new File("img/pad-l-reverse.png");
	File padReverseFile = new File("img/pad-reverse.png");
	File padShortReverseFile = new File("img/pad-s-reverse.png");	
	
	File pauseFile = new File("img/pause.png");
	File startFile = new File("img/home.png");
	File win1File = new File("img/1win.png");
	File win2File = new File("img/2win.png");
	File[] itemsPicFile = new File[11];
	Image background, ballMedium, ballBlueMedium, ballYellowMedium;
	Image padMedium, padBlueMedium, padShort, padBlueShort, padLong, padBlueLong;
	Image pauseBg, startBg, win1, win2;
	Image padLongMagnet, padMagnet, padShortMagnet, padBlueLongMagnet, padBlueMagnet, padBlueShortMagnet;
	Image padLongFreeze, padFreeze, padShortFreeze;
	Image padLongReverse, padReverse, padShortReverse;
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
    		startBg = ImageIO.read(startFile);
    		win1 = ImageIO.read(win1File);
    		win2 = ImageIO.read(win2File);
    		padLongMagnet = ImageIO.read(padLongMagnetFile);
    		padMagnet = ImageIO.read(padMagnetFile);
    		padShortMagnet = ImageIO.read(padShortMagnetFile);
    		padBlueLongMagnet = ImageIO.read(padBlueLongMagnetFile);
    		padBlueMagnet = ImageIO.read(padBlueMagnetFile);
    		padBlueShortMagnet = ImageIO.read(padBlueShortMagnetFile);
    		padLongFreeze = ImageIO.read(padLongFreezeFile);
    		padFreeze = ImageIO.read(padFreezeFile);
    		padShortFreeze = ImageIO.read(padShortFreezeFile);
    		padLongReverse = ImageIO.read(padLongReverseFile);
    		padReverse = ImageIO.read(padReverseFile);
    		padShortReverse = ImageIO.read(padShortReverseFile);
    		for (int i = 0; i < itemsPicFile.length; i++) {
    			itemsPic[i]	= ImageIO.read(itemsPicFile[i]);
    		}
        } catch (IOException e) {
        }
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, gui.getGUIWidth(), gui.getGUIHeight());
		g.drawImage(background, 0, 0, null);
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
		g.drawString(paddle1.getScore()+" : "+paddle2.getScore(), 450, 50);	
		

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
					else if (p instanceof ItemFast) g.drawImage(itemsPic[5], (int) (p.getX() - r) - 4 , (int) (p.getY() - r) - 4, null);
					else if (p instanceof ItemBigPad) g.drawImage(itemsPic[6], (int) (p.getX() - r) - 4 , (int) (p.getY() - r) - 4, null);
					else if (p instanceof ItemSmallPad) g.drawImage(itemsPic[7], (int) (p.getX() - r) - 4 , (int) (p.getY() - r) - 4, null);
					else if (p instanceof ItemGhost) g.drawImage(itemsPic[8], (int) (p.getX() - r) - 4 , (int) (p.getY() - r) - 4, null);
					else if (p instanceof ItemMagnet) g.drawImage(itemsPic[9], (int) (p.getX() - r) - 4 , (int) (p.getY() - r) - 4, null);
					else if (p instanceof ItemShock) g.drawImage(itemsPic[10], (int) (p.getX() - r) - 4 , (int) (p.getY() - r) - 4, null);
					else if (p instanceof ItemRandom) g.drawImage(itemsPic[0], (int) (p.getX() - r) - 4 , (int) (p.getY() - r) - 4, null);
					
				} catch (Exception e) {
					break;
				}
			}
		}
		
		/*
		 * Paddle
		 */
		paintPaddle1(paddle1,g);
		paintPaddle2(paddle2,g);
		
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
		ArrayList<SnapBall> snap2 = paddle2.getSnapBall();
		SnapBall s;
		synchronized(this)
		{
			for (int i = 0; i < snap1.size(); i++) {
				s = snap1.get(i);
				g.drawImage(ballYellowMedium, (int)(paddle1.getX()+paddle1.getThick())-3, (int)(int)(paddle1.getY()-s.getRadius()+s.getDiffY())-3, null);
			}
			for (int i = 0; i < snap2.size(); i++) {
				s = snap2.get(i);
				g.drawImage(ballBlueMedium, (int)(paddle2.getX()-paddle2.getThick()-3-s.getRadius()*2), (int)(int)(paddle2.getY()-s.getRadius()+s.getDiffY())-3, null);
			}
		}
		
		/*
		 * If Pause, show pause window
		 */
		if(Game.isPaused()){
			g.drawImage(pauseBg, 0, 0, null);
		}
		
		/*
		 * Start Page
		 */
		if(!Game.isStarted()){
			g.drawImage(startBg, 0, 0, null);
		}
		
		/*
		 * Has Winner
		 */
		if(Game.isHasWinner()){
			if(Game.getWinner() == 1){
				g.drawImage(win1, 0, 0, null);
			}
			else
				g.drawImage(win2, 0, 0, null);
		}
		
	}
	public void paintPaddle1(Paddle paddle, Graphics g){
		if(paddle.getLength() == 261){
			if(paddle.isOnMagnet()){
				g.drawImage(padLongMagnet, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else if(paddle.isGhost()){
				g.drawImage(padLongReverse, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else if(paddle.isShocked()){
				g.drawImage(padLongFreeze, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else{
				g.drawImage(padLong, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);				
			}
		}
		else if(paddle.getLength() == 103){
			if(paddle.isOnMagnet()){
				g.drawImage(padShortMagnet, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else if(paddle.isGhost()){
				g.drawImage(padShortReverse, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else if(paddle.isShocked()){
				g.drawImage(padShortFreeze, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else{
				g.drawImage(padShort, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);				
			}
		}
		else{
			if(paddle.isOnMagnet()){
				g.drawImage(padMagnet, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else if(paddle.isGhost()){
				g.drawImage(padReverse, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else if(paddle.isShocked()){
				g.drawImage(padFreeze, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else{
				g.drawImage(padMedium, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);				
			}
		}
	}
	public void paintPaddle2(Paddle paddle, Graphics g){
		if(paddle.getLength() == 261){
			if(paddle.isOnMagnet()){
				g.drawImage(padBlueLongMagnet, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else if(paddle.isGhost()){
				g.drawImage(padLongReverse, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else if(paddle.isShocked()){
				g.drawImage(padLongFreeze, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else{
				g.drawImage(padBlueLong, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);				
			}
		}
		else if(paddle.getLength() == 103){
			if(paddle.isOnMagnet()){
				g.drawImage(padBlueShortMagnet, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else if(paddle.isGhost()){
				g.drawImage(padShortReverse, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else if(paddle.isShocked()){
				g.drawImage(padShortFreeze, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else{
				g.drawImage(padBlueShort, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);				
			}
		}
		else{
			if(paddle.isOnMagnet()){
				g.drawImage(padBlueMagnet, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else if(paddle.isGhost()){
				g.drawImage(padReverse, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else if(paddle.isShocked()){
				g.drawImage(padFreeze, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);
			}
			else{
				g.drawImage(padBlueMedium, paddle.getX()-9, paddle.getY()-paddle.getLength()/2, null);				
			}
		}
	}
}
