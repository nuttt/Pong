
public class ItemDash extends Item {

	public final static String name = "Dash";
	public final static double DASH_FACTOR = 1.6;
	public ItemDash() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Item clone() {
		// TODO Auto-generated method stub
		return new ItemDash();
	}
	
	public String getName() {
		return name;
	}

}
