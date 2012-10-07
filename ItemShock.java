
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

}
