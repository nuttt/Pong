
public class ItemFast extends Item {

	public final static String name = "Dash";
	public final static double FAST_FACTOR = 1.3;
	public ItemFast() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Item clone() {
		// TODO Auto-generated method stub
		return new ItemFast();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		// TODO Auto-generated method stub
		b.setDX(b.getDX()*ItemFast.FAST_FACTOR);
		b.setDY(b.getDY()*ItemFast.FAST_FACTOR);
	}

}
