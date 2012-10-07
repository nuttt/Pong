<<<<<<< HEAD

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
		if(b.owner == 1)
			gui.getPaddle1().setShockInterval(ItemShock.SHOCK_INTERVAL);
		else
			gui.getPaddle2().setShockInterval(ItemShock.SHOCK_INTERVAL);
	}

}
=======

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
>>>>>>> 01b57a2feb0e0a6b5b6b562adfcc7df0d502829c
