
public class ItemSmallPad extends Item {

	public final static String name = "SmallPad";
	public ItemSmallPad() {
		super();
	}

	@Override
	public Item clone() {
		return new ItemSmallPad();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		if(b.owner == 1)
		{
			gui.getPaddle1().DecreseLength();
		}
		else
		{
			gui.getPaddle2().DecreseLength();
		}
		Sound.playItem(7);
	}

}
