
public class ItemDash extends Item {

	public final static String name = "Dash";
	public final static double DASH_FACTOR = 1.8;
	public ItemDash() {
		super();
	}

	@Override
	public Item clone() {
		return new ItemDash();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		if(b.getDX() < 0)
			b.setDX(-b.getVelocity());
		else
			b.setDX(+b.getVelocity());
		b.setDY(0);
		b.setDash(true);
		Sound.playItem(2);
	}

}
