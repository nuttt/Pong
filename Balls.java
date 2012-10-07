import java.util.ArrayList;

public class Balls implements Runnable {
	ArrayList<Ball> ballList;
	Game gui;
	final static int MAXIMUM_ANGLE = 60;

	public Balls(Game game) {
		ballList = new ArrayList<Ball>();
		gui = game;
	}

	public boolean isEmpty() {
		return ballList.isEmpty();
	}

	public ArrayList<Ball> getList() {
		return ballList;
	}

	public void add(double x, double y, double dx, double dy, double radius) {
		ballList.add(new Ball(x, y, dx, dy, radius));
	}

	public void add(Ball ball) {
		ballList.add(ball);
	}

	@Override
	public void run() {
		Ball b;
		Paddle paddle1 = gui.getPaddle1();
		Paddle paddle2 = gui.getPaddle2();
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
			for (int i = 0; i < ballList.size(); i++) {
				b = ballList.get(i);
				double factor  = 1;
				if(b.dash)
					factor *= ItemDash.DASH_FACTOR;
				if(b.betray)
					factor *= ItemBetray.BETRAY_FACTOR;
				b.setX(b.getX() + b.getDX() * factor);
				b.setY(b.getY() + b.getDY());
				// TODO Remove X Bounce
				/*
				 * X Bounce
				 */
				if (b.getX() - b.getRadius() < 0){
					if(ballList.size() == 1){
						paddle2.increaseScore();
						Sound.playWin();
					}
					b.setDead(true);
				}
				if(b.getX() + b.getRadius() > gui.getGUIWidth()) {
					if(ballList.size() == 1){
						paddle1.increaseScore();
						Sound.playWin();
					}
					b.setDead(true);
				}
				/*
				 * Y Bounce
				 */
				if (b.getY() - b.getRadius() < 0 && b.getDY() < 0
						|| b.getY() + b.getRadius() > gui.getGUIHeight()
						&& b.getDY() > 0) {
					b.setDY(-b.getDY());
					Sound.playHitY();
				}
				/*
				 * Paddle Bounce
				 */
				if (b.getX() - b.getRadius() <= paddle1.getX()
						+ paddle1.getThick()
						&& b.getX() - b.getRadius() > paddle1.getX()
								- paddle1.getThick()
						&& paddle1.isRangeY(b.getY(),b.getRadius()) && b.getDX() < 0) {
					System.out.println("Hit paddle1");
					Sound.playHitPaddle();
					b.setOwner(1);
					b.setDash(false);
					b.setBetray(false);
					System.out.println("Magnet: "+paddle1.getMagnetCount());
					if(paddle1.getMagnetCount() > 0)
					{
						paddle1.decreaseMagnetCount();
						paddle1.addSnapBall(b.getY()-paddle1.getY());
						ballList.remove(i--);
						continue;
					}
					else
					{
						double x = paddle1.getLength()
								/ Math.tan(Math.toRadians(MAXIMUM_ANGLE)) / 2;
						double theta = Math.atan((b.getY() - paddle1.getY()) / x);
						double phi = -Math.atan(b.getDY() / b.getDX());
						double phi2;
						// System.out.println("theta:"+Math.toDegrees(theta)+" phi:"+Math.toDegrees(phi));
						if (theta == 0)
							phi2 = phi;
						else if (theta > 0) {
							if (phi >= theta)
								phi2 = (Math.toRadians(90) + phi) / 2;
							else
								phi2 = (phi + theta) / 2;
						} else {
							if (phi <= theta)
								phi2 = (Math.toRadians(-90) + phi) / 2;
							else
								phi2 = (phi + theta) / 2;
						}
						if (phi > Math.toRadians(MAXIMUM_ANGLE))
							phi = Math.toRadians(MAXIMUM_ANGLE);
						if (phi < Math.toRadians(-MAXIMUM_ANGLE))
							phi = Math.toRadians(-MAXIMUM_ANGLE);
						/*
						 * if(Math.abs(phi) < Math.toRadians(5)) phi =
						 * Math.toRadians(Math.random()*10-5);
						 */
						// System.out.println("phi2: "+Math.toDegrees(phi2));
						double v = Math.sqrt(Math.pow(b.getDX(), 2)
								+ Math.pow(b.getDY(), 2));
						b.setDX(Math.cos(phi2) * v);
						b.setDY(Math.sin(phi2) * v);
					}
				}

				/*
				 * Paddle2 Bounce
				 */
				else if (b.getX() + b.getRadius() <= paddle2.getX()
						+ paddle2.getThick()
						&& b.getX() + b.getRadius() > paddle2.getX()
								- paddle2.getThick()
						&& paddle2.isRangeY(b.getY(),b.getRadius()) && b.getDX() > 0) {
					System.out.println("Hit paddle2");
					b.setDash(false);
					b.setBetray(false);
					Sound.playHitPaddle();
					b.setOwner(2);
					if(paddle2.getMagnetCount() > 0)
					{
						paddle2.decreaseMagnetCount();
						paddle2.addSnapBall(b.getY()-paddle2.getY());
						ballList.remove(i--);
						continue;
					}
					else
					{
						double x = paddle2.getLength()
								/ Math.tan(Math.toRadians(MAXIMUM_ANGLE)) / 2;
						double theta = Math.atan((b.getY() - paddle2.getY()) / x);
						double phi = -Math.atan(b.getDY() / b.getDX());
						double phi2;
						 System.out.println("theta:"+Math.toDegrees(theta)+" phi:"+Math.toDegrees(phi));
						if (theta == 0)
							phi2 = phi;
						else if (theta > 0) {
							if (phi >= theta)
								phi2 = phi;
							else
								phi2 = (phi + theta) / 2;
						} else {
							if (phi <= theta)
								phi2 = phi;
							else
								phi2 = (phi + theta) / 2;
						}
						if (phi > Math.toRadians(MAXIMUM_ANGLE))
							phi = Math.toRadians(MAXIMUM_ANGLE);
						if (phi < Math.toRadians(-MAXIMUM_ANGLE))
							phi = Math.toRadians(-MAXIMUM_ANGLE);
						if (Math.abs(phi) < Math.toRadians(5))
							phi = Math.toRadians(Math.random() * 10 - 5);
						// System.out.println("phi2: "+Math.toDegrees(phi2));
						double v = Math.sqrt(Math.pow(b.getDX(), 2)
								+ Math.pow(b.getDY(), 2));
						b.setDX(-Math.cos(phi2) * v);
						b.setDY(Math.sin(phi2) * v);
					}
				}

				/*
				 * Item
				 */
				ArrayList<Item> itemList = gui.getItems().getItemList();
				for (int j = 0; j < itemList.size(); j++) {
					try {
						Item p = itemList.get(j);
						if (Tools.distance2D(b.getX(), b.getY(), p.getX(),
								p.getY()) < p.getRadius() + b.getRadius()) {
							// Item Collision
							if (p instanceof ItemSplit) {
								double v = Tools.velocity(b.getDX(), b.getDY());
								double theta2;
								while (true) {
									theta2 = Math.random() * 360 - 180;
									if (Math.abs(theta2) < MAXIMUM_ANGLE
											|| Math.abs(theta2) > 180 - MAXIMUM_ANGLE)
										break;
								}
								theta2 = Math.toRadians(theta2);
								Ball b2 = new Ball(b.getX(), b.getY(), v
										* Math.cos(theta2), v
										* Math.sin(theta2), b.getRadius());
								b2.setOwner(b.getOwner());
								itemList.remove(j--);
								ballList.add(b2);
							}
							else if(p instanceof ItemDash)
							{
								itemList.remove(j--);
								if(b.getDX() < 0)
									b.setDX(-b.getVelocity());
								else
									b.setDX(+b.getVelocity());
								b.setDY(0);
								b.setDash(true);
							}
							else if(p instanceof ItemBetray)
							{
								itemList.remove(j--);
								if(b.getDX() < 0)
									b.setDX(b.getVelocity());
								else
									b.setDX(-b.getVelocity());
								b.setDY(0);
								b.setBetray(true);
							}
							else if(p instanceof ItemRandom)
							{
								itemList.remove(j--);
								double theta3;
								while (true) {
									theta3 = Math.random() * 360 - 180;
									if (Math.abs(theta3) < MAXIMUM_ANGLE)
										break;
								}
								theta3 = Math.toRadians(theta3);
								double v = b.getVelocity();
								b.setDX(v*Math.cos(theta3));
								b.setDY(v*Math.sin(theta3));
							}
							else if(p instanceof ItemFast)
							{
								itemList.remove(j--);
								b.setDX(b.getDX()*ItemFast.FAST_FACTOR);
								b.setDY(b.getDY()*ItemFast.FAST_FACTOR);
							}
							else if(p instanceof ItemBigPad)
							{
								itemList.remove(j--);
								if(b.owner == 1)
								{
									paddle1.IncreaseLength();
								}
								else
								{
									paddle2.IncreaseLength();
								}
							}
							else if(p instanceof ItemSmallPad)
							{
								itemList.remove(j--);
								if(b.owner == 1)
								{
									paddle1.DecreseLength();
								}
								else
								{
									paddle2.DecreseLength();
								}
							}
							else if(p instanceof ItemGhost)
							{
								itemList.remove(j--);
								if(b.owner == 1)
									paddle1.setGhost(true);
								else
									paddle2.setGhost(true);
							}
							else if(p instanceof ItemMagnet)
							{
								itemList.remove(j--);
								if(b.owner == 1)
									paddle1.setMagnetCount(ItemMagnet.MAGNET_THRESHOLD);
								else
									paddle2.setMagnetCount(ItemMagnet.MAGNET_THRESHOLD);
							}
							else if(p instanceof ItemShock)
							{
								itemList.remove(j--);
								if(b.owner == 1)
									paddle1.setShcokInterval(ItemShock.SHOCK_INTERVAL);
								else
									paddle2.setShcokInterval(ItemShock.SHOCK_INTERVAL);
							}
							
						}
					} catch (NullPointerException e) {
						break;
					}
				}
			}
			int i = 0;
			while (true) {
				if (i >= ballList.size())
					break;
				if (ballList.get(i).isDead())
					ballList.remove(i);
				else
					i++;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}