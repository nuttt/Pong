
public class ItemShock extends Item {

	public final static String name = "Shock";
	public final static int SHOCK_INTERVAL = 400;
	public ItemShock() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Item clone() {
		// TODO Auto-generated method stub
		return new ItemShock();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		// TODO Auto-generated method stub
		if(b.owner == 1)
			gui.getPaddle1().setShcokInterval(ItemShock.SHOCK_INTERVAL);
		else
			gui.getPaddle2().setShcokInterval(ItemShock.SHOCK_INTERVAL);
	}

}
