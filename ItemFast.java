public class ItemFast extends Item {

	public final static String name = "Dash";
	public final static double FAST_FACTOR = 1.3;
	public ItemFast() {
		super();
	}

	@Override
	public Item clone() {
		return new ItemFast();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		b.setDX(b.getDX()*ItemFast.FAST_FACTOR);
		b.setDY(b.getDY()*ItemFast.FAST_FACTOR);
		Sound.playItem(5);
	}

}
