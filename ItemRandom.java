
public class ItemRandom extends Item {

	public final static String name = "Random";
	public ItemRandom() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Item clone() {
		// TODO Auto-generated method stub
		return new ItemRandom();
	}
	
	public String getName() {
		return name;
	}

}
