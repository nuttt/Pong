import java.util.ArrayList;

public class ItemRandomItem extends Item {

	public final static String name = "RandomItem";
	public ItemRandomItem() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Item clone() {
		// TODO Auto-generated method stub
		return new ItemRandomItem();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		// TODO Auto-generated method stub
		int n = (int)(Math.random()*Items.ITEM_POOL.size());
		Item t = Items.ITEM_POOL.get(n).clone();
		t.setX(super.getX());
		t.setY(super.getY());
		t.makeEffect(gui, b);
	}

}
