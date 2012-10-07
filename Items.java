import java.util.ArrayList;

public class Items implements Runnable {

	private ArrayList<Item> itemList = new ArrayList<Item>();
	public static ArrayList<Item> ITEM_POOL = new ArrayList<Item>();
	public static int MAXIMUM_ITEM = 3;
	public static int ITEM_INTERVAL = 10;

	public Items() {
		// TODO Auto-generated constructor stub
		Items.ITEM_POOL.add(new ItemSplit());
		Items.ITEM_POOL.add(new ItemDash());
		Items.ITEM_POOL.add(new ItemBetray());
		Items.ITEM_POOL.add(new ItemRandom());
		Items.ITEM_POOL.add(new ItemGhost());
	}

	@Override
	public void run() {
		while (true) {
			// Check if Paused
			synchronized (Game.lockPause) {
				if(Game.isPaused())
					try {
						Game.lockPause.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			if (itemList.size() < MAXIMUM_ITEM) {
					int i = (int) (Math.random() * ITEM_POOL.size());
					Item t = ITEM_POOL.get(i).clone();
					System.out.println("Place " + t.getName() + " at "
							+ t.getX() + "," + t.getY());
					itemList.add(t);
			}
			try {
				Thread.sleep(ITEM_INTERVAL);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Item> getItemList()
	{
		return itemList;
	}
}
