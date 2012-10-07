import java.util.ArrayList;

public class ItemRandomItem extends Item {

	public final static String name = "RandomItem";
	public ItemRandomItem() {
		super();
	}

	@Override
	public Item clone() {
		return new ItemRandomItem();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		int n = (int)(Math.random()*Items.ITEM_POOL.size());
		Item t = Items.ITEM_POOL.get(n).clone();
		t.setX(super.getX());
		t.setY(super.getY());
		t.makeEffect(gui, b);
		Sound.playItem(0);
	}

}
