
public class Tools {
	public static double distance2D(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
	}
	
	public static double velocity(double dx,double dy)
	{
		return Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
	}
}
