import java.util.ArrayList;

public class Paddle implements Runnable {

	int x;
	int y;
	int length;
	int player;
	int score;
	int magnetCount;

	int shockInterval;
	int ghostInterval;
	Object hit = new Object();
<<<<<<< HEAD
	
	public synchronized int getGhostInterval() {
		return ghostInterval;
	}
	public synchronized void setGhostInterval(int ghostInterval) {
		this.ghostInterval = ghostInterval;
	}
	
=======
	private boolean onMagnet = false;
	private boolean shocked = false;
	
	
	public boolean isShocked() {
		return shocked;
	}
	public void setShocked(boolean shock) {
		this.shocked = shock;
	}
	public boolean isOnMagnet() {
		return onMagnet;
	}
	public void setOnMagnet(boolean isOnMagnet) {
		this.onMagnet = isOnMagnet;
	}
>>>>>>> Sound for each effect added
	public Object getHit() {
		return hit;
	}
	public void increaseScore(){
		this.score++;
		if(this.score < Game.WIN_POINT){
			Sound.playWin();
		}
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	int thick;
	ArrayList<SnapBall> snapBall;
	//151 for normal, 261 for long, 103 for short
	final static int DEFAULT_LENGTH = 151;
	final static int DEFAULT_THICK = 10;
	Game gui;

	public Paddle(Game game, int player) {
		gui = game;
		this.player = player;
		this.score = 0;
		this.setDefaultLength();
		this.setDefaultThick();
		snapBall = new ArrayList<SnapBall>();
		if (player == 1)
			x = 50;
		else if (player == 2)
			x = gui.getGUIWidth() - 50;
		ghostInterval = 0;
		magnetCount = 0;
	}

	@Override
	public void run() {
		// TODO Paddle Thread
		//shadow mode
		Coordinate p;
			p = gui.getPlayerCoordinate(player);
		while (true) {
			// Check if Paused
			synchronized (Game.lockPause) {
				if(Game.isPaused() || Game.isHasWinner())
					try {
						Game.lockPause.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			synchronized (p) {
				try {
					p.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
<<<<<<< HEAD
			if(ghostInterval > 0)
			{
				ghostInterval -= 10;
			}
			if(shockInterval > 0)
			{
=======
			if(shockInterval > 0){
>>>>>>> Sound for each effect added
				shockInterval -= 10;
				if(shockInterval == 0){
					setShocked(false);
				}
			}
			else
			{
				if(ghostInterval > 0)
					setY(gui.getGUIHeight()-gui.getPlayerCoordinate(player).getY());
				else
					setY(gui.getPlayerCoordinate(player).getY());
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public synchronized int getX() {
		return x;
	}

	public synchronized int getY() {
		return y;
	}

	public synchronized void setY(int y) {
		if(y < length/2) this.y = length/2;
		else if(y > 700 - length/2) this.y = 700 - length/2; 
		else this.y = y;
	}

	public synchronized int getLength() {
		return length;
	}

	public synchronized void setLength(int length) {
		this.length = length;
	}

	public synchronized void setDefaultLength() {
		this.length = DEFAULT_LENGTH;
	}
	
	public synchronized void setDefaultThick() {
		this.thick = DEFAULT_THICK;
	}
	
	public synchronized void setThick(int thick) {
		this.thick = thick;
	}

	public synchronized int getThick() {
		return thick;
	}
	
	public synchronized boolean isRangeY(double y, double radius) {
		if( y > this.y - this.length/2 - radius/2 && y < this.y + this.length/2 + radius/2)
			return true;
		return false;
	}
	
	public void addSnapBall(double diffY)
	{
		snapBall.add(new SnapBall(x,y,Ball.DEFAULT_DX,Ball.DEFAULT_DY,Ball.DEFAULT_RADIUS,diffY));
	}
	public void addDefaultSnapBall()
	{
		snapBall.add(new SnapBall(x,y,Ball.DEFAULT_DX,Ball.DEFAULT_DY,Ball.DEFAULT_RADIUS,0));
	}

	public synchronized ArrayList<SnapBall> getSnapBall() {
		return snapBall;
	}
	
	public synchronized void fireSnapBall()
	{
		Balls balls = gui.getBalls();
		while(!snapBall.isEmpty())
		{
			SnapBall s = snapBall.get(snapBall.size()-1);
			Ball b = (Ball)s;
			double x = getLength() / Math.tan(Math.toRadians(Balls.MAXIMUM_ANGLE)) / 2;
			double theta = Math.atan((s.getDiffY()) / x);
//			if(Math.abs(theta) < Math.toRadians(10))
//				theta = Math.toRadians(Math.random()*20-10);
			System.out.println(theta);
			double v = Math.sqrt(Math.pow(b.getDX(), 2)+Math.pow(b.getDY(), 2));
			double dx = Math.cos(theta)*v;
			double dy = Math.sin(theta)*v;
			if(s.x > gui.getGUIWidth()/2)
				dx = -dx;
			System.out.println((x+thick+b.getRadius())+" "+(y+s.getDiffY()));
			Ball ball;
			if(s.x > gui.getGUIWidth()/2)
				ball = new Ball(this.x-this.thick-b.getRadius(), this.y+s.getDiffY(), dx, dy, b.getRadius());
			else
				ball = new Ball(this.x+this.thick+b.getRadius(), this.y+s.getDiffY(), dx, dy, b.getRadius());
			ball.setOwner(player);
			balls.add(ball);
			snapBall.remove(snapBall.size()-1);
		}
	}
	
	public synchronized int getMagnetCount() {
		return magnetCount;
	}
	public synchronized void setMagnetCount(int magnetCount) {
		this.magnetCount = magnetCount;
		System.out.println("paddle" + player + "set magnet to" + this.magnetCount);
	}
	
	public synchronized void decreaseMagnetCount()
	{
		if(magnetCount > 0){
			magnetCount --;
			if(magnetCount == 0){
				setOnMagnet(false);
			}
		}
	}
	
	public synchronized void IncreaseLength()
	{
		if(length == 103)
			length = 151;
		else if(length == 151)
			length = 261;
	}
	
	public synchronized void DecreseLength()
	{
		if(length == 151)
			length = 103;
		else if(length == 261)
			length = 151;
	}
	public void setShcokInterval(int shockInterval) {
		this.shockInterval = shockInterval;
		
	}
<<<<<<< HEAD

=======
	public void ToggleGhost() {
		this.ghost = !this.ghost;
	}
>>>>>>> Sound for each effect added
}
