
public class Ball{
	double x,y,dx,dy;
	int owner;
	boolean dead;
	double radius;
	final static double DEFAULT_RADIUS = 5;
	final static double DEFAULT_DX = 3;
	final static double DEFAULT_DY = 3;
	public Ball() {
		x = 500;
		y = 500;
		dx = DEFAULT_DX;
		dy = DEFAULT_DY;
		radius = DEFAULT_RADIUS;
		dead = false;
	}
	
	public Ball(double x,double y, double dx, double dy, double radius)
	{
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.radius = radius;
	}

	public synchronized boolean isDead() {
		return dead;
	}
	
	public synchronized void setDead(boolean dead){
		this.dead = dead;
	}
	
	public synchronized double getX() {
		return x;
	}

	public synchronized void setX(double x) {
		this.x = x;
	}

	public synchronized double getY() {
		return y;
	}

	public synchronized void setY(double y) {
		this.y = y;
	}

	public synchronized double getDX() {
		return dx;
	}

	public synchronized void setDX(double dx) {
		this.dx = dx;
	}

	public synchronized double getDY() {
		return dy;
	}

	public synchronized void setDY(double dy) {
		this.dy = dy;
	}

	public synchronized double getRadius() {
		return radius;
	}

	public synchronized void setRadius(double radius) {
		this.radius = radius;
	}
}
