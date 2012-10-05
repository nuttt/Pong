import java.util.ArrayList;

public class Paddle implements Runnable {

	int x;
	int y;
	int length;
	int player;
	int thick;
	ArrayList<SnapBall> snapBall;
	final static int DEFAULT_LENGTH = 100;
	final static int DEFAULT_THICK = 5;
	Game gui;

	public Paddle(Game game, int player) {
		gui = game;
		this.player = player;
		this.setDefaultLength();
		this.setDefaultThick();
		snapBall = new ArrayList<SnapBall>();
		if (player == 1)
			x = 50;
		else if (player == 2)
			x = gui.getGUIWidth() - 50;
	}

	@Override
	public void run() {
		// TODO Paddle Thread
		//shadow mode
		Coordinate p;
			p = gui.getPlayerCoordinate(player);
		while (true) {
			synchronized (p) {
				try {
					p.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			setY(gui.getPlayerCoordinate(player).getY());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
		this.y = y;
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
	
	public synchronized boolean isRangeY(double y) {
		if( y > this.y - this.length/2 && y < this.y + this.length/2)
			return true;
		return false;
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
			if(Math.abs(theta) < Math.toRadians(30))
				theta = Math.toRadians(Math.random()*60-30);
			System.out.println(theta);
			double v = Math.sqrt(Math.pow(b.getDX(), 2)+Math.pow(b.getDY(), 2));
			double dx = Math.cos(theta)*v;
			double dy = Math.sin(theta)*v;
			System.out.println((x+thick+b.getRadius())+" "+(y+s.getDiffY()));
			Ball ball = new Ball(this.x+this.thick+b.getRadius(), this.y+s.getDiffY(), dx, dy, b.getRadius());
			balls.add(ball);
			snapBall.remove(snapBall.size()-1);
		}
	}
}
