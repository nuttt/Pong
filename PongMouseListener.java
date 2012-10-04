import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class PongMouseListener implements MouseMotionListener {

	Coordinate p;
	public PongMouseListener(Coordinate p) {
		// TODO Auto-generated constructor stub
		this.p = p;
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		p.setX(arg0.getX());
		p.setY(arg0.getY());
		synchronized (p) {
			p.notifyAll();
		}
	}
}
