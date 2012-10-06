import java.util.ArrayList;

public class Items implements Runnable {

	private ArrayList<Item> itemList = new ArrayList<Item>();
	public static ArrayList<Item> ITEM_POOL = new ArrayList<Item>();
	public static int MAXIMUM_ITEM = 3;

	public Items() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (itemList.size() < MAXIMUM_ITEM) {
					int i = (int) (Math.random() * ITEM_POOL.size());
					Item t = ITEM_POOL.get(i).clone();
					System.out.println("Place " + t.getName() + " at "
							+ t.getX() + "," + t.getY());
					itemList.add(t);
			}
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Item> getItemList()
	{
		return itemList;
	}
}
