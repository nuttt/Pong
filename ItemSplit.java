import java.util.ArrayList;


public class ItemSplit extends Item {

	public final static String name = "Split";
	public ItemSplit() {
		super();
	}

	@Override
	public Item clone() {
		return new ItemSplit();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		ArrayList<Ball> ballList = gui.getBalls().getList();
		double v = b.getVelocity();
		double theta2;
		while (true) {
			theta2 = Math.random() * 360 - 180;
			if (Math.abs(theta2) < Balls.MAXIMUM_ANGLE
					|| Math.abs(theta2) > 180 - Balls.MAXIMUM_ANGLE)
				break;
		}
		theta2 = Math.toRadians(theta2);
		Ball b2 = new Ball(b.getX(), b.getY(), v
				* Math.cos(theta2), v
				* Math.sin(theta2), b.getRadius());
		b2.setOwner(b.getOwner());
		ballList.add(b2);
		Sound.playItem(1);
	}

}
