package ch.bfh.bti7301.hs2013.gravis.core.util.transformer;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

import ch.bfh.bti7301.hs2013.gravis.core.util.GravisConstants;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisColor;

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
	public static double transformDouble(String stringValue) {
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
	public static Color transformStringToColor(String stringValue) {
		switch (stringValue) {
		case GravisConstants.GREEN:
			return GravisColor.LIGHT_GREEN;
		case GravisConstants.YELLOW:
			return GravisColor.LIGHT_YELLOW;
		case GravisConstants.BLUE:
			return GravisColor.LIGHT_BLUE;
		case GravisConstants.GRAY:
			return GravisColor.LIGHT_GRAY;
		case GravisConstants.ORANGE:
			return GravisColor.LIGHT_ORANGE;
		case GravisConstants.BLACK:
			return GravisColor.BLACK;
		case GravisConstants.WHITE:
			return GravisColor.WHITE;
		case GravisConstants.ANTIQUE:
			return GravisColor.ANTIQUE;
		default:
			return GravisColor.RED;
		}
	}
	
	/**
	 * @param stringValue
	 * @return Color
	 */
	public static String transformColorToString(Color color) {
		if (color.equals(GravisColor.LIGHT_GREEN)) {
			return GravisConstants.GREEN;
		} else if (color.equals(GravisColor.LIGHT_YELLOW)) {
			return GravisConstants.YELLOW;
		} else if (color.equals(GravisColor.LIGHT_BLUE)) {
			return GravisConstants.BLUE;
		} else if (color.equals(GravisColor.LIGHT_GRAY)) {
			return GravisConstants.GRAY;
		} else if (color.equals(GravisColor.LIGHT_ORANGE)) {
			return GravisConstants.ORANGE;
		} else if (color.equals(GravisColor.BLACK)) {
			return GravisConstants.BLACK;
		} else if (color.equals(GravisColor.WHITE)) {
			return GravisConstants.WHITE;
		} else if (color.equals(GravisColor.ANTIQUE)) {
			return GravisConstants.ANTIQUE;
		} else {
			return GravisConstants.RED;
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

	/**
	 * @param value
	 * @return
	 */
	public static double round2Decimals(double value) {
		return Math.rint(value * 100.0) / 100.0;
	}

}
