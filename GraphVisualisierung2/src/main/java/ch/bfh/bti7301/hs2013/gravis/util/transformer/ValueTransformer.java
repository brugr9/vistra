package ch.bfh.bti7301.hs2013.gravis.util.transformer;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.util.GraphPropertyConstants;
import ch.bfh.bti7301.hs2013.gravis.util.GravisColor;

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
		case GraphPropertyConstants.GREEN:
			return GravisColor.LIGHT_GREEN;
		case GraphPropertyConstants.YELLOW:
			return GravisColor.LIGHT_YELLOW;
		case GraphPropertyConstants.BLUE:
			return GravisColor.LIGHT_BLUE;
		case GraphPropertyConstants.GRAY:
			return GravisColor.LIGHT_GRAY;
		case GraphPropertyConstants.ORANGE:
			return GravisColor.LIGHT_ORANGE;
		case GraphPropertyConstants.BLACK:
			return GravisColor.BLACK;
		case GraphPropertyConstants.WHITE:
			return GravisColor.WHITE;
		case GraphPropertyConstants.ANTIQUE:
			return GravisColor.ANTIQUE;
		default:
			return GravisColor.RED;
		}
	}

	/**
	 * @param color
	 * @return String
	 */
	public static String transformColorToString(Color color) {
		if (color.equals(GravisColor.LIGHT_GREEN)) {
			return GraphPropertyConstants.GREEN;
		} else if (color.equals(GravisColor.LIGHT_YELLOW)) {
			return GraphPropertyConstants.YELLOW;
		} else if (color.equals(GravisColor.LIGHT_BLUE)) {
			return GraphPropertyConstants.BLUE;
		} else if (color.equals(GravisColor.LIGHT_GRAY)) {
			return GraphPropertyConstants.GRAY;
		} else if (color.equals(GravisColor.LIGHT_ORANGE)) {
			return GraphPropertyConstants.ORANGE;
		} else if (color.equals(GravisColor.BLACK)) {
			return GraphPropertyConstants.BLACK;
		} else if (color.equals(GravisColor.WHITE)) {
			return GraphPropertyConstants.WHITE;
		} else if (color.equals(GravisColor.ANTIQUE)) {
			return GraphPropertyConstants.ANTIQUE;
		} else {
			return GraphPropertyConstants.RED;
		}
	}

	/**
	 * @param xValue
	 * @param yValue
	 * @return Point2D
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
	 * @return double
	 */
	public static double round2Decimals(double value) {
		return Math.rint(value * 100.0) / 100.0;
	}

	/**
	 * @param itemList
	 * @return IRestrictedGraphItem[]
	 */
	public static IRestrictedGraphItem[] toArray(
			List<IRestrictedGraphItem> itemList) {
		return itemList.toArray(new IRestrictedGraphItem[itemList.size()]);
	}
}
