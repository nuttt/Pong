
public class ItemMagnet extends Item {

	public final static String name = "Magnet";
	public final static int MAGNET_THRESHOLD = 3;
	public ItemMagnet() {
		super();
	}

	@Override
	public Item clone() {
		return new ItemMagnet();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		if(b.owner == 1)
			gui.getPaddle1().setMagnetCount(ItemMagnet.MAGNET_THRESHOLD);
		else
			gui.getPaddle2().setMagnetCount(ItemMagnet.MAGNET_THRESHOLD);
	}

}
