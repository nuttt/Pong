
public class ItemSplit extends Item {

	public final static String name = "Split";
	public ItemSplit() {
		// TODO Auto-generated constructor stub
		super(ImagePool.IMAGE_SPLIT);
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
