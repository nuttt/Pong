
public class ItemBetray extends Item {

	public final static String name = "Betray";
	public final static double BETRAY_FACTOR = 1.6;
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

}
