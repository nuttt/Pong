<<<<<<< HEAD

public class ItemBigPad extends Item {

	public final static String name = "BigPad";
	public ItemBigPad() {
		super();
	}

	@Override
	public Item clone() {
		return new ItemBigPad();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		if(b.owner == 1)
		{
			gui.getPaddle1().IncreseLength();
		}
		else
		{
			gui.getPaddle2().IncreseLength();
		}
	}

}
=======

public class ItemBigPad extends Item {

	public final static String name = "BigPad";
	public ItemBigPad() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Item clone() {
		// TODO Auto-generated method stub
		return new ItemBigPad();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void makeEffect(Game gui, Ball b) {
		if(b.owner == 1)
		{
			gui.getPaddle1().IncreaseLength();
		}
		else
		{
			gui.getPaddle2().IncreaseLength();
		}
		Sound.playItem(6);
	}

}
>>>>>>> 01b57a2feb0e0a6b5b6b562adfcc7df0d502829c
