package labs.lab20100222.layout;

public class Point2D implements Comparable<Point2D> {
	
	private int x, y;
	
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point2D p) {
		if(this.y > p.y)
			return 1;
		else if(this.y == p.y)
			return 0;
		
		return -1;
	}
	
	@Override
	public String toString() {
		return "("+x+", "+y+")";
	}
}
