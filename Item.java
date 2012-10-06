import java.awt.Image;


public abstract class Item {
	private double x,y;
	private double radius;
	public final static double DEFAULT_ITEM_REDIUS = 10;
	public final static double ITEM_BOUND_X = 150;
	public final static double ITEM_BOUND_Y = 50;
	Image icon;
	public Item(Image icon) {
		// TODO Auto-generated constructor stub
		x = (Math.random()*(Game.GUI_WIDTH-2*ITEM_BOUND_X))+ITEM_BOUND_X;
		y = (Math.random()*(Game.GUI_HEIGHT-2*ITEM_BOUND_Y))+ITEM_BOUND_Y;
		radius = DEFAULT_ITEM_REDIUS;
		this.icon = icon;
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
	public synchronized Image getIcon() {
		return icon;
	}
	public synchronized void setIcon(Image icon) {
		this.icon = icon;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public abstract Item clone();
	
	public abstract String getName();
}
