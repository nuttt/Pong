
public class SnapBall extends Ball{

	double diffY;
	public SnapBall(double x,double y,double dx,double dy,double radius,double diffY) {
		super(x, y, dx, dy, radius);
		this.diffY = diffY;
	}
	
	public SnapBall(Ball ball,double diffY)
	{
		this(ball.getX(),ball.getY(),ball.getDX(),ball.getDY(),ball.getRadius(),diffY);
	}

	public synchronized double getDiffY() {
		return diffY;
	}

	public synchronized void setDiffY(double diffY) {
		this.diffY = diffY;
	}
}
