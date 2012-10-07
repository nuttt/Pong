
public class ItemSmallPad extends Item {

	public final static String name = "SmallPad";
	public ItemSmallPad() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Item clone() {
		// TODO Auto-generated method stub
		return new ItemSmallPad();
	}
	
	public String getName() {
		return name;
	}

}
