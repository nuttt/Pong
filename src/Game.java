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
	private boolean AIMode;
	private boolean WiiMote;
	private Coordinate Player1Coordinate, Player2Coordinate;
	private Paddle paddle1, paddle2;
	private int GUIWidth;
	private int GUIHeight;

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
		return AIMode;
	}

	public void setAIMode(boolean aIMode) {
		AIMode = aIMode;
	}

	public Coordinate getPlayer1Coordinate() {
		return Player1Coordinate;
	}

	public void setPlayer1Coordinate(Coordinate player1Coordinate) {
		Player1Coordinate = player1Coordinate;
	}

	public Coordinate getPlayer2Coordinate() {
		return Player2Coordinate;
	}

	public void setPlayer2Coordinate(Coordinate player2Coordinate) {
		Player2Coordinate = player2Coordinate;
	}

	public int getGUIWidth() {
		return GUIWidth;
	}

	public void setGUIWidth(int width) {
		this.GUIWidth = width;
	}

	public int getGUIHeight() {
		return GUIHeight;
	}

	public void setGUIHeight(int height) {
		this.GUIHeight = height;
	}
	
	public boolean isWiiMote() {
		return WiiMote;
	}

	public void setWiiMote(boolean wiiMote) {
		WiiMote = wiiMote;
	}
	
	public Paddle getPaddle1() {
		return paddle1;
	}

	public Paddle getPaddle2() {
		return paddle2;
	}
	
	/*
	 * Constructor & Thread
	 */
	

	public Game() {
		// TODO Game Constructor
		drawPanel = new DrawPanel(this);
		this.setGUIWidth(1024);
		this.setGUIHeight(768);
		this.setAIMode(false);
		this.setWiiMote(false);
	}

	public void run() {
		// TODO Game Thread
		while(true)
		{
			drawPanel.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void createGUI() {
		//TODO GUI
		JFrame.setDefaultLookAndFeelDecorated(false);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(drawPanel);
		drawPanel.setPreferredSize(new Dimension(GUIWidth,GUIHeight));
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Main
		Game game = new Game();
		game.createGUI();
		Thread gameThread = new Thread(game);
		gameThread.start();
	}
}