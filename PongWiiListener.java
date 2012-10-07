import wiiusej.wiiusejevents.physicalevents.ExpansionEvent;
import wiiusej.wiiusejevents.physicalevents.IREvent;
import wiiusej.wiiusejevents.physicalevents.MotionSensingEvent;
import wiiusej.wiiusejevents.physicalevents.WiimoteButtonsEvent;
import wiiusej.wiiusejevents.utils.WiimoteListener;
import wiiusej.wiiusejevents.wiiuseapievents.ClassicControllerInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.ClassicControllerRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.DisconnectionEvent;
import wiiusej.wiiusejevents.wiiuseapievents.GuitarHeroInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.GuitarHeroRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.NunchukInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.NunchukRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.StatusEvent;


public class PongWiiListener implements WiimoteListener {

	Game gui;
	int player;
	public PongWiiListener(Game gui, int player) {
		// TODO Auto-generated constructor stub
		this.gui = gui;
	}

	@Override
	public void onButtonsEvent(WiimoteButtonsEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.isButtonBJustPressed())
		{
			if(!Game.isPaused()) Game.setPaused(true);
			else if(Game.isPaused()) {
				Game.setPaused(false);
				//Resume
				synchronized (Game.lockPause) {
					Game.lockPause.notifyAll();
				}
			}
		}
	}

	@Override
	public void onClassicControllerInsertedEvent(
			ClassicControllerInsertedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClassicControllerRemovedEvent(
			ClassicControllerRemovedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDisconnectionEvent(DisconnectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExpansionEvent(ExpansionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGuitarHeroInsertedEvent(GuitarHeroInsertedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGuitarHeroRemovedEvent(GuitarHeroRemovedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onIrEvent(IREvent arg0) {
		// TODO Auto-generated method stub
		Coordinate p1 = gui.getPlayerCoordinate(1);
		Coordinate p2 = gui.getPlayerCoordinate(2);
		//System.out.println(arg0.getX() +" "+ arg0.getAy());
		p1.setX(arg0.getX());
		p1.setY(arg0.getAy());
		synchronized (p1) {
			p1.notifyAll();
		}
		p2.setX(arg0.getX());
		p2.setY(arg0.getAy());
		synchronized (p2) {
			p2.notifyAll();
		}
		
	}

	@Override
	public void onMotionSensingEvent(MotionSensingEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println(arg0.getRawAcceleration().getX());
		if(arg0.getRawAcceleration().getX() < 50)
		{
			gui.getPaddle1().fireSnapBall();
		}
		if(arg0.getRawAcceleration().getX() < 50)
		{
			gui.getPaddle2().fireSnapBall();
		}
		
	}

	@Override
	public void onNunchukInsertedEvent(NunchukInsertedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNunchukRemovedEvent(NunchukRemovedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusEvent(StatusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
