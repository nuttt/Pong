<<<<<<< HEAD

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
=======

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
		if(b.owner == 1){
			gui.getPaddle1().setMagnetCount(ItemMagnet.MAGNET_THRESHOLD);
			gui.getPaddle1().setOnMagnet(true);
		}
		else{
			gui.getPaddle2().setMagnetCount(ItemMagnet.MAGNET_THRESHOLD);
			gui.getPaddle2().setOnMagnet(true);
		}
		Sound.playItem(9);
	}

}
>>>>>>> 01b57a2feb0e0a6b5b6b562adfcc7df0d502829c
