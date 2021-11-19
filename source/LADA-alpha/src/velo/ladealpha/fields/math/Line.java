package velo.ladealpha.fields.math;

public class Line {
	private double x1, x2, y1, y2;
	LinearFunction f;
	public Line(Point a, Point b) {
		x1 = a.getX();
		x2 = b.getX();
		y1 = a.getY();
		y2 = b.getY();
		computeFunction();
	}
	
	private double lerp(double t,double a, double b) {
		return (1-t) * a + t * b;
	}
	
	public Point lerp(double t) {
		double x = lerp(t, x1, x2),y = lerp(t, y1, y2);
		return new Point(x,y);
	}
	
	private void computeFunction() {
		double m = (y2 - y1) / (x2 - x1);
		double b = y1 - (m * x1);
		f = new LinearFunction(m, b);
	}
	
	public double compute(double x) {
		return f.compute(x);
	}
	
	public Line(double x1, double x2, double y1, double y2) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		computeFunction();
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}
	
}
