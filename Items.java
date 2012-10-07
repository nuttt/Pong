import java.util.ArrayList;

public class Items implements Runnable {

	private ArrayList<Item> itemList = new ArrayList<Item>();
	public static ArrayList<Item> ITEM_POOL = new ArrayList<Item>();
	public static int MAXIMUM_ITEM = 10;
	public static int ITEM_INTERVAL = 4000;
	public static boolean itemArea[][] = new boolean[5][4];

	public Items() {
		Items.ITEM_POOL.add(new ItemSplit());
		Items.ITEM_POOL.add(new ItemDash());
		Items.ITEM_POOL.add(new ItemBetray());
		Items.ITEM_POOL.add(new ItemRandom());
		Items.ITEM_POOL.add(new ItemFast());
		Items.ITEM_POOL.add(new ItemBigPad());
		Items.ITEM_POOL.add(new ItemSmallPad());
		Items.ITEM_POOL.add(new ItemGhost());
		Items.ITEM_POOL.add(new ItemMagnet());
		Items.ITEM_POOL.add(new ItemShock());
		Items.ITEM_POOL.add(new ItemRandom());
	}

	@Override
	public void run() {
		while (true) {
			// Check if Paused
			try {
				Thread.sleep(ITEM_INTERVAL);
				ITEM_INTERVAL = (int)(Math.random()*5000+1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (Game.lockPause) {
				if(Game.isPaused() || !Game.isStarted() || Game.isHasWinner())
					try {
						Game.lockPause.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			if (itemList.size() < MAXIMUM_ITEM) {
					int i = (int) (Math.random() * ITEM_POOL.size());
					Item t = ITEM_POOL.get(i).clone();
					int x,y;
					while(true)
					{
						x = (int)(Math.random()*5);
						y = (int)(Math.random()*4);
						System.out.println("x"+x+" y"+y);
						if(itemArea[x][y] == false)
						{
							System.out.println("empty!");
							t.setX(200+150*x);
							t.setY(120+150*y);
							itemArea[x][y] = true;
							break;
						}
					}
					System.out.println("place "+t.getName()+" at "+t.getX()+" "+t.getY());
					for(int ii = 0;ii < 4 ; ii++)
					{
						for(int jj = 0 ; jj < 5 ; jj++)
						{
							System.out.print(itemArea[jj][ii]+"\t");
						}
						System.out.println("");
					}
					itemList.add(t);
					Sound.playItem(11);
			}
			
		}
	}
	
	public ArrayList<Item> getItemList()
	{
		return itemList;
	}
}
