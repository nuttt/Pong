
public class ItemBigPad extends Item {

	public final static String name = "BigPad";
	public ItemBigPad() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Item clone() {
		// TODO Auto-generated method stub
		return new ItemBigPad();
	}
	
	public String getName() {
		return name;
	}

}
