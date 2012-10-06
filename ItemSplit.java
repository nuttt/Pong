
public class ItemSplit extends Item {

	public final static String name = "Split";
	public ItemSplit() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Item clone() {
		// TODO Auto-generated method stub
		return new ItemSplit();
	}
	
	public String getName() {
		return name;
	}

}
