<<<<<<< HEAD

public class ItemSmallPad extends Item {

	public final static String name = "SmallPad";
	public ItemSmallPad() {
		super();
	}

	@Override
	public Item clone() {
		return new ItemSmallPad();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		if(b.owner == 1)
		{
			gui.getPaddle1().DecreseLength();
		}
		else
		{
			gui.getPaddle2().DecreseLength();
		}
	}

}
=======

public class ItemSmallPad extends Item {

	public final static String name = "SmallPad";
	public ItemSmallPad() {
		super();
	}

	@Override
	public Item clone() {
		return new ItemSmallPad();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		if(b.owner == 1)
		{
			gui.getPaddle1().DecreseLength();
		}
		else
		{
			gui.getPaddle2().DecreseLength();
		}
		Sound.playItem(7);
	}

}
>>>>>>> 01b57a2feb0e0a6b5b6b562adfcc7df0d502829c
