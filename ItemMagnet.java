
public class ItemMagnet extends Item {

	public final static String name = "Magnet";
	public final static int MAGNET_THRESHOLD = 3;
	public ItemMagnet() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Item clone() {
		// TODO Auto-generated method stub
		return new ItemMagnet();
	}
	
	public String getName() {
		return name;
	}

}
