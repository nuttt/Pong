import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
/*
 * Main Class for Game GUI
 */

import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;

public class Game implements Runnable {
	/*
	 * AI Mode: 1 Player, Player 2 is AI isWiiMote: set using WiiMote or Mouse
	 * if AI Mode is on, 2 WiiMote is required
	 */
	private boolean aiMode;
	private boolean shadowMode;
	private boolean wiiMote;
	private Coordinate[] playerCoordinate;
	private Paddle paddle1, paddle2;
	public final static int GUI_WIDTH = 1000;
	public final static int GUI_HEIGHT = 700;
	public final static int WIN_POINT = 2;
	private static boolean paused = false;
	private static boolean started = false;
	private static boolean hasWinner = false;
	private static int winner = 0;
	public static Object lockPause = new Object();
	public static Wiimote[] wiimotes;

	private Balls balls;
	private Items items;
	
	/*
	 * Drawing Tools
	 */
	DrawPanel drawPanel;

	/*
	 * Getters & Setters
	 */	
	public DrawPanel getDrawPanel() {
		return drawPanel;
	}

	public static int getWinner() {
		return winner;
	}

	public static void setWinner(int winner) {
		Game.winner = winner;
	}

	public static boolean isHasWinner() {
		return hasWinner;
	}

	public static void setHasWinner(boolean hasWinner) {
		Game.hasWinner = hasWinner;
	}

	public static boolean isStarted() {
		return started;
	}

	public static void setStarted(boolean started) {
		Game.started = started;
	}

	public static boolean isPaused() {
		return paused;
	}

	public static void setPaused(boolean paused) {
		Game.paused = paused;
	}

	public boolean isAIMode() {
		return aiMode;
	}

	public void setAIMode(boolean aiMode) {
		this.aiMode = aiMode;
	}

	public boolean isShadowMode() {
		return shadowMode;
	}

	public void setShadowMode(boolean shadowMode) {
		this.shadowMode = shadowMode;
	}

	public Coordinate getPlayerCoordinate(int player) {
		return playerCoordinate[player - 1];
	}

	public void setPlayerCoordinate(Coordinate playerCoordinate, int player) {
		this.playerCoordinate[player - 1] = playerCoordinate;
	}

	public int getGUIWidth() {
		return GUI_WIDTH;
	}

	/*
	public void setGUIWidth(int width) {
		this.guiWidth = width;
	}
	*/

	public int getGUIHeight() {
		return GUI_HEIGHT;
	}

	/*
	public void setGUIHeight(int height) {
		this.guiHeight = height;
	}
	*/

	public boolean isWiiMote() {
		return wiiMote;
	}

	public void setWiiMote(boolean wiiMote) {
		this.wiiMote = wiiMote;
	}

	public Paddle getPaddle1() {
		return paddle1;
	}

	public Paddle getPaddle2() {
		return paddle2;
	}
	
	public Balls getBalls() {
		return balls;
	}
	
	/*
	 * Constructor & Thread
	 */

	public synchronized Items getItems() {
		return items;
	}

	public synchronized Wiimote[] getWiimotes() {
		return wiimotes;
	}

	public Game() {
		drawPanel = new DrawPanel(this);
		/*
		this.setGUIWidth(1000);
		this.setGUIHeight(700);
		*/
		this.setAIMode(false);
		this.setWiiMote(false);
		this.setShadowMode(false);
		playerCoordinate = new Coordinate[2];
		playerCoordinate[0] = new Coordinate();
		playerCoordinate[1] = new Coordinate();
		paddle1 = new Paddle(this, 1);
		paddle2 = new Paddle(this, 2);
		balls = new Balls(this);
		items = new Items();
	}
	
	public void resetPaddleEffect()
	{
		paddle1.setGhostInterval(0);
		paddle2.setGhostInterval(0);
		paddle1.setMagnetCount(0);
		paddle2.setMagnetCount(0);
		paddle1.setShockInterval(0);
		paddle1.setShockInterval(0);
		paddle1.setDefaultLength();
		paddle2.setDefaultLength();
	}

	public void run() {
		/*
		 * Select Input
		 */
		if (isAIMode()) {
			if (isWiiMote()) {

			} else {

			}
		} else {
			if (isWiiMote()) {
				//TODO 2 Player Wiimote
				wiimotes = WiiUseApiManager.getWiimotes(1, true);
				wiimotes[0].activateIRTRacking();
				//wiimotes[0].activateMotionSensing();
				wiimotes[0].addWiiMoteEventListeners(new PongWiiListener(this, 1));

			} else {
				drawPanel.addMouseMotionListener(new PongMouseListener(
						getPlayerCoordinate(1)));
				drawPanel.addMouseMotionListener(new PongMouseListener(
						getPlayerCoordinate(2)));
				drawPanel.addMouseListener(new MouseListener() {
					public void mouseClicked(MouseEvent arg0) {
						if(!arg0.isAltDown())
						{
							// Click to start the game
							if(!Game.isPaused() && !Game.isStarted()){
								Game.setStarted(true);
								//Resume
								synchronized (Game.lockPause) {
									Game.lockPause.notifyAll();
								}
							}
							
							// Get the winner, Click to start the game
							else if(Game.isHasWinner()){
								Game.setWinner(0);
								paddle1.setScore(0);
								paddle2.setScore(0);
								Game.setHasWinner(false);
								Game.setStarted(false);
							}
							
							// Click to resume the game
							else if(Game.isPaused() && Game.isStarted()) {
								Game.setPaused(false);
								//Resume
								synchronized (Game.lockPause) {
									Game.lockPause.notifyAll();
								}
							}
							
							// Click to pause the game
							else if(!Game.isPaused() && Game.isStarted()){
								Game.setPaused(true);
							}
						}
						else
						{
							if(Game.isStarted()){
								paddle1.fireSnapBall();
								paddle2.fireSnapBall();
							}
						}
					}

					public void mouseEntered(MouseEvent e) {
						
					}

					public void mouseExited(MouseEvent e) {
						
					}

					public void mousePressed(MouseEvent e) {
						
					}

					public void mouseReleased(MouseEvent e) {
						
					}
				});
			}
		}

		/*
		 * Draw GUI
		 */
		while (true) {
			
			// Check if hasWinner
			if(paddle1.getScore() == WIN_POINT){
				hasWinner = true;
				winner = 1;
				System.out.println("player1 wins");
				Sound.playLongFull();
			}
			else if(paddle2.getScore() == WIN_POINT){
				hasWinner = true;
				winner = 2;
				System.out.println("player2 wins");
				Sound.playLongFull();
			}
			
			// Check Pause game
			synchronized (Game.lockPause) {
				if(Game.isPaused())
					try {
						drawPanel.repaint();
						Game.lockPause.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			
			synchronized(paddle1)
			{
				synchronized(paddle2)
				{
					if(balls.isEmpty() && paddle1.getSnapBall().isEmpty() && paddle2.getSnapBall().isEmpty())
					{
							resetPaddleEffect();
							if(paddle1.score < paddle2.score || paddle1.score == paddle2.score && Math.random() < 0.5)
								paddle1.addDefaultSnapBall();
							else
								paddle2.addDefaultSnapBall();
					}
				}
			}
			drawPanel.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void createGUI() {
		JFrame.setDefaultLookAndFeelDecorated(false);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(drawPanel);
		drawPanel.setPreferredSize(new Dimension(GUI_WIDTH, GUI_HEIGHT));
		frame.pack();
		frame.setVisible(true);
		Sound.playSoundBg();
		
	}

	public static void main(String[] args) throws Exception{
		Game game = new Game();
		game.setWiiMote(true);
		game.createGUI();
		Thread gameThread = new Thread(game);
		gameThread.start();
		Thread paddle1Thread = new Thread(game.getPaddle1());
		paddle1Thread.start();
		Thread paddle2Thread = new Thread(game.getPaddle2());
		paddle2Thread.start();
		Thread ballsThread = new Thread(game.getBalls());
		ballsThread.start();
		Thread itemsThread = new Thread(game.getItems());
		itemsThread.start();
		//TODO 2 Player Wiimote
		if(game.isWiiMote())
		{
			Thread RumbleThread1 = new Thread(new Rumble(game,1));
			RumbleThread1.start();
		}
	}
}