package velo.ladealpha.fields.math;

import java.util.ArrayList;
import java.util.Arrays;



/*
 * DOESNT WORK
 */
public class AlgorithmicBezierCurve {
	private ArrayList<Point> points;

	public AlgorithmicBezierCurve(ArrayList<Point> points) {
		super();
		this.points = points;
	}
	
	private ArrayList<Line> linesFromPoints(ArrayList<Point> points) {
		ArrayList<Line> coreLines = new ArrayList<Line>();
		for(int i = 0; i < points.size()-1; i += 1) {
			Point p = points.get(i), p1 = points.get(i+1);
			Line l = new Line(p, p1);			
			coreLines.add(l);
		}
		return coreLines;
	}
	
	private ArrayList<Point> lerpLines(ArrayList<Line> lines, double t) {
		ArrayList<Point> points = new ArrayList<Point>();
		for(Line l : lines) {
			points.add(l.lerp(t));
		}
		return points;
	}
	
	public Point compute(double t) {				
		ArrayList<Line> linesO = linesFromPoints(points);
		ArrayList<Point> pointsO = new ArrayList<Point>();
		while(linesO.size() > 1) {
			pointsO = lerpLines(linesO, t);
			linesO = linesFromPoints(pointsO);
			System.out.println(Arrays.toString(pointsO.toArray()));
		}
		return pointsO.get(0);
	}
}
