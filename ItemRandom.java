
public class ItemRandom extends Item {

	public final static String name = "Random";
	public ItemRandom() {
		super();
	}

	@Override
	public Item clone() {
		return new ItemRandom();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		double theta3;
		while (true) {
			theta3 = Math.random() * 360 - 180;
			if (Math.abs(theta3) < Balls.MAXIMUM_ANGLE)
				break;
		}
		theta3 = Math.toRadians(theta3);
		double v = b.getVelocity();
		b.setDX(v*Math.cos(theta3));
		b.setDY(v*Math.sin(theta3));
	}

}
