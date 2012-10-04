import java.awt.*;
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
	private int guiWidth;
	private int guiHeight;
	private Balls balls;
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
		return guiWidth;
	}

	public void setGUIWidth(int width) {
		this.guiWidth = width;
	}

	public int getGUIHeight() {
		return guiHeight;
	}

	public void setGUIHeight(int height) {
		this.guiHeight = height;
	}

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

	public Game() {
		// TODO Game Constructor
		drawPanel = new DrawPanel(this);
		this.setGUIWidth(800);
		this.setGUIHeight(600);
		this.setAIMode(false);
		this.setWiiMote(false);
		this.setShadowMode(false);
		playerCoordinate = new Coordinate[2];
		playerCoordinate[0] = new Coordinate();
		playerCoordinate[1] = new Coordinate();
		paddle1 = new Paddle(this, 1);
		paddle2 = new Paddle(this, 2);
		balls = new Balls(this);
		balls.add(50, 500, 4, 3, 5);
		balls.add(50, 100, 4, 3, 10);
//		balls.add(150, 50, 3, 5, 20);
//		balls.add(400, 30, 10, 7, 10);
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
			}
		}

		/*
		 * Draw GUI
		 */
		while (true) {
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
		drawPanel.setPreferredSize(new Dimension(guiWidth, guiHeight));
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
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
	}
}