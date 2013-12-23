package vistra.util;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * A utility class, therefore serving with static method only.
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
	 * Tries to convert a string to a double.
	 * 
	 * @param value
	 *            the value to convert
	 * @return the value as double if successful, <code>Double.NaN</code>
	 *         otherwise
	 */
	public static double toDouble(String value) {
		try {
			return Double.parseDouble(value);
		} catch (Exception e) {
			return Double.NaN;
		}
	}

	/**
	 * Tries to convert a string to a boolean.
	 * 
	 * @param value
	 *            the value to convert
	 * @return the value as boolean if successful, <code>false</code> otherwise
	 */
	public static boolean toBoolean(String value) {
		try {
			return Boolean.parseBoolean(value);
		} catch (Exception e) {
			throw new UnsupportedOperationException("value: " + value, e);
		}
	}

	/**
	 * Tries to convert two string coordinates to a point.
	 * 
	 * @param xValue
	 *            the x coordinate
	 * @param yValue
	 *            the y coordinate
	 * @return the point
	 */
	public static Point2D toPoint2D(String xValue, String yValue) {
		int x, y;
		try {
			x = Integer.parseInt(xValue);
		} catch (Exception e) {
			throw new UnsupportedOperationException("xValue: " + xValue, e);
		}
		try {
			y = Integer.parseInt(yValue);
		} catch (Exception e) {
			throw new UnsupportedOperationException("yValue: " + yValue, e);
		}
		return new Point(x, y);
	}

	/**
	 * Rounds with two decimals.
	 * 
	 * @param value
	 *            the value to round
	 * @return the rounded value
	 */
	public static double toRounded2Decimals(double value) {
		return Math.rint(value * 100.0) / 100.0;
	}

}
