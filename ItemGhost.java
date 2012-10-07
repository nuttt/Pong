public class ItemGhost extends Item {

	public final static String name = "Ghost";
	public final static int GHOST_INTERVAL = 5000;
	public ItemGhost() {
		super();
	}

	@Override
	public Item clone() {
		return new ItemGhost();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		
		if(b.owner == 1)
			gui.getPaddle1().setGhostInterval(GHOST_INTERVAL);
		else
			gui.getPaddle1().setGhostInterval(GHOST_INTERVAL);
		Sound.playItem(8);
	}

}
