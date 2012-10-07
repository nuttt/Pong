
public class ItemBetray extends Item {

	public final static String name = "Betray";
	public final static double BETRAY_FACTOR = 1.8;
	public ItemBetray() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Item clone() {
		// TODO Auto-generated method stub
		return new ItemBetray();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		// TODO Auto-generated method stub
		if(b.getDX() < 0)
			b.setDX(b.getVelocity());
		else
			b.setDX(-b.getVelocity());
		b.setDY(0);
		b.setBetray(true);
	}

}
