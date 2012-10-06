import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

/*
 * Main Class for Game GUI
 */

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
	public static boolean isPaused = false;
	public static Object lockPause = new Object();

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

	public void run() {
		// TODO Game Thread
		/*
		 * Select Input
		 */
		if (isAIMode()) {
			if (isWiiMote()) {

			} else {

			}
		} else {
			if (isWiiMote()) {

			} else {
				drawPanel.addMouseMotionListener(new PongMouseListener(
						getPlayerCoordinate(1)));
				drawPanel.addMouseMotionListener(new PongMouseListener(
						getPlayerCoordinate(2)));
				drawPanel.addMouseListener(new MouseListener() {
					public void mouseClicked(MouseEvent arg0) {
						System.out.println("Mouse clicked");
						if(!Game.isPaused) Game.isPaused = true;
						else if(Game.isPaused) {
							Game.isPaused = false;
							//Resume
							synchronized (Game.lockPause) {
								Game.lockPause.notifyAll();
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
			synchronized (Game.lockPause) {
				if(Game.isPaused)
					try {
						Game.lockPause.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			if(balls.isEmpty() && paddle1.getSnapBall().isEmpty() && paddle2.getSnapBall().isEmpty())
			{
				paddle1.setGhost(false);
				paddle2.setGhost(false);
				//TODO Rule for snapball
				paddle1.addDefaultSnapBall();
			}
			if(Math.random() > 0.9888)
				paddle1.fireSnapBall();
			drawPanel.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	

	public void createGUI() {
		// TODO GUI
		JFrame.setDefaultLookAndFeelDecorated(false);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(drawPanel);
		drawPanel.setPreferredSize(new Dimension(GUI_WIDTH, GUI_HEIGHT));
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		//TODO ImagePool
		//TODO change test image
		//TODO ItemList

		// TODO Main
		Game game = new Game();
		game.setShadowMode(true);
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
	}
}