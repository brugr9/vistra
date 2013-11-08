package ch.bfh.bti7301.hs2013.gravis.core.util;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * A utility class, therefore serving with static method only.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class ValueTransformer {

	/**
	 * A main (no-)constructor.
	 */
	private ValueTransformer() {
	}

	/**
	 * @param stringValue
	 * @return a transformed double value
	 */
	public static double transformWeight(String stringValue) {
		try {
			return Double.parseDouble(stringValue);
		} catch (Exception e) {
			return Double.NaN;
		}
	}

	/**
	 * @param stringValue
	 * @return boolean
	 */
	public static boolean transformBoolean(String stringValue) {
		try {
			return Boolean.parseBoolean(stringValue);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param stringValue
	 * @return Color
	 */
	public static Color transformColor(String stringValue) {
		// TODO replace string literals
		switch (stringValue) {
		case "green":
			return GravisColor.green;
		case "yellow":
			return GravisColor.yellow;
		case "blue":
			return GravisColor.blue;
		case "gray":
			return GravisColor.gray;
		default:
			return GravisColor.red;
		}
	}

	/**
	 * @param xValue
	 * @param yValue
	 * @return
	 */
	public static Point2D transformLocation(String xValue, String yValue) {
		try {
			return new Point(Integer.parseInt(xValue), Integer.parseInt(yValue));
		} catch (Exception e) {
			return new Point();
		}
	}

}
