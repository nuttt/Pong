import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class PongMouseListener implements MouseMotionListener {

	Coordinate p;
	public PongMouseListener(Coordinate p) {
		this.p = p;
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		p.setX(arg0.getX());
		p.setY(arg0.getY());
		synchronized (p) {
			p.notifyAll();
		}
	}
}
