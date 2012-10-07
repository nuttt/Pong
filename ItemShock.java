
public class ItemShock extends Item {

	public final static String name = "Shock";
	public final static int SHOCK_INTERVAL = 400;
	public ItemShock() {
		super();
	}

	@Override
	public Item clone() {
		return new ItemShock();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		if(b.owner == 1){
			gui.getPaddle1().setShcokInterval(ItemShock.SHOCK_INTERVAL);
			gui.getPaddle1().setShocked(true);
		}
		else{
			gui.getPaddle2().setShcokInterval(ItemShock.SHOCK_INTERVAL);
			gui.getPaddle2().setShocked(true);
		}
		Sound.playItem(10);
	}

}
