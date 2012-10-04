/*
 * Coordinate: Use to Keep X,Y Position of Player
 */

public class Coordinate {
	int x,y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Coordinate(){
		this(0, 0);
	}

	public int getX() {
		return x;
	}

	public synchronized void setX(int x) {
		this.x = x;
	}
	
	public void setCoordinate(Coordinate p){
		this.x = p.getX();
		this.y = p.getY();
	}
	
	public Coordinate getCoordinate(){
		return new Coordinate(this.getX(),this.getY());
	}

	public int getY() {
		return y;
	}

	public synchronized void setY(int y) {
		this.y = y;
	}
}
