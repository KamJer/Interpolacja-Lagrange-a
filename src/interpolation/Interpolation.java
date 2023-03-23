package interpolation;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Interpolation {

	/**
	 * 
	 * Interpoluje wartoœci metod¹ lagrage'a
	 * 
	 * @param points - punkty stanowi¹ce podstawê do interpolacji
	 * @param x      - x dla ktorego wyinterpolowywana jest wartoœæ
	 * @return - wyinterpolowana wartoœæ
	 */
	public static double lagrangeInterpolation(Point2D.Double[] points, double x) {
		double l = 1;
		double p = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (i != j) {
					l *= (x - points[j].getX()) / (points[i].getX() - points[j].getX());
				}
			}
			p += (points[i].getY() * l);
			l = 1;
		}
		return p;
	}

	public static Point2D.Double linearInterpolation(Point2D.Double[] points, double x) {
		if (points.length == 2 || x < points[0].x) {
			return calculateValue(points[0], points[1], x);
		} else {
			if (x > points[points.length - 1].x) {
				return calculateValue(points[points.length - 2], points[points.length - 1], x);
			}else {
				for (int i = 0; i < points.length; i++) {
					if (points[i].x <= x && points[i + 1].x >= x) {
						return calculateValue(points[i], points[i + 1], x);
					}
				}
			}
		}
		return null;
	}

	private static Point2D.Double calculateValue(Point2D.Double point1, Point2D.Double point2, double x) {
		double y = (point1.y - point2.y) / (point1.x - point2.x) * x
				+ (point1.y - (point1.y - point2.y) / (point1.x - point2.x) * point1.x);
		return new Point2D.Double(x, y);
	}
	
	public static Point2D.Double logarytmicInterpolation (Point2D.Double[] points, double x) {
		double a = Math.pow(points[0].x, 1/points[0].y);
		return new Point2D.Double(x, Math.log(x) / Math.log(a));
	}
	
	public static Point2D.Double sqrtInterpolation(double x) {
		return new Point2D.Double(x, Math.sqrt(x));
	}
}
