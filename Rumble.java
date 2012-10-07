
public class Rumble implements Runnable{

	Paddle paddle;
	Game gui;
	int player;
	public Rumble(Game gui,int player) {
		this.gui = gui;
		if(player == 1)
			paddle = gui.getPaddle1();
		else if(player == 2)
			paddle = gui.getPaddle2();
		this.player = player;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// TODO Auto-generated method stub
		Object hit = paddle.getHit();
		while(true)
		{
			synchronized (hit) {
				try {
					hit.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//			System.out.println("hit1:"+paddle1.isHit());
			Game.wiimotes[player-1].activateRumble();
			try {
				Thread.sleep(75);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Game.wiimotes[player-1].deactivateRumble();
			
		}
	}

}
