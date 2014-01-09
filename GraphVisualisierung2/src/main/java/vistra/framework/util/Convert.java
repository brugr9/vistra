package vistra.framework.util;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * A utility class serving with static methods only.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class Convert {

	/**
	 * A main (no-)constructor.
	 */
	private Convert() {
	}

	/**
	 * Tries to convert a string to an integer.
	 * 
	 * @param value
	 *            the value to convert
	 * @return the value as {@code Integer} if successful
	 */
	public static Integer toInteger(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Tries to read two strings as coordinates and to convert them to a point.
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @return the point
	 */
	public static Point2D toPoint2D(String x, String y) {
		int xInt, yInt;
		Point2D p;
		try {
			xInt = Integer.parseInt(x);
		} catch (Exception e) {
			throw new UnsupportedOperationException("x: " + x, e);
		}
		try {
			yInt = Integer.parseInt(y);
		} catch (Exception e) {
			throw new UnsupportedOperationException("y: " + y, e);
		}
		try {
			p = new Point(xInt, yInt);
		} catch (Exception e) {
			throw new UnsupportedOperationException("point", e);
		}
		return p;
	}

}
