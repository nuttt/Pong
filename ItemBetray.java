
public class ItemBetray extends Item {

	public final static String name = "Betray";
	public final static double BETRAY_FACTOR = 1.8;
	public ItemBetray() {
		super();
	}

	@Override
	public Item clone() {
		return new ItemBetray();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		if(b.getDX() < 0)
			b.setDX(b.getVelocity());
		else
			b.setDX(-b.getVelocity());
		b.setDY(0);
		b.setBetray(true);
	}

}
