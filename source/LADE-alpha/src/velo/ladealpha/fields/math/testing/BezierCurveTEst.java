package velo.ladealpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.math.AlgorithmicBezierCurve;
import velo.ladealpha.fields.math.Point;

class BezierCurveTEst {

	@Test
	void test() {
		
		ArrayList<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 1));
		points.add(new Point(1, 2));
		points.add(new Point(2, 2));
		points.add(new Point(2, 1));
		
		AlgorithmicBezierCurve bc = new AlgorithmicBezierCurve(points);
		Point leprt = bc.compute(0.3);
		System.out.println(leprt);
	}

}
