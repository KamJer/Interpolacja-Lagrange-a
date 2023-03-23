package interpolation;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;

class Test {

	@org.junit.jupiter.api.Test
	void beetwinsegments1Linear() {
		Point2D.Double[] points = new Point2D.Double[3];
		points[0] = new Point2D.Double(0, 0);
		points[1] = new Point2D.Double(1, 1);
		points[2] = new Point2D.Double(2, 1);
		Point2D.Double point = Interpolation.linearInterpolation(points, 0.7);
		assertTrue(point.y == 0.7);
	}
	
	@org.junit.jupiter.api.Test
	void beetwinsegments2Linear() {
		Point2D.Double[] points = new Point2D.Double[3];
		points[0] = new Point2D.Double(0, 0);
		points[1] = new Point2D.Double(1, 1);
		points[2] = new Point2D.Double(2, 1);
		Point2D.Double point = Interpolation.linearInterpolation(points, 1.2);
		assertTrue(point.y == 1);
	}
	
	@org.junit.jupiter.api.Test
	void lowerThenMinLinear() {
		Point2D.Double[] points = new Point2D.Double[3];
		points[0] = new Point2D.Double(0, 0);
		points[1] = new Point2D.Double(1, 1);
		points[2] = new Point2D.Double(2, 1);
		Point2D.Double point = Interpolation.linearInterpolation(points, -1);
		assertTrue(point.y == -1);
	}
	
	@org.junit.jupiter.api.Test
	void higherThenMaxLinear() {
		Point2D.Double[] points = new Point2D.Double[3];
		points[0] = new Point2D.Double(0, 0);
		points[1] = new Point2D.Double(1, 1);
		points[2] = new Point2D.Double(2, 1);
		Point2D.Double point = Interpolation.linearInterpolation(points, 3);
		assertTrue(point.y == 1);
	}
	
	@org.junit.jupiter.api.Test
	void logarytmicInterpolation() {
		Point2D.Double[] points = new Point2D.Double[1];
		points[0] = new Point2D.Double(3, 2);
		Point2D.Double point = Interpolation.logarytmicInterpolation(points, 1.5);
		double roundY = point.y * 100;
		roundY = Math.round(roundY);
		roundY = roundY / 100;
		assertTrue(roundY == 0.74);
	}

}
