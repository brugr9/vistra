package travis.util.transformer;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.List;

import travis.core.graph.item.IRestrictedGraphItem;
import travis.core.util.GraphPropertyConstants;
import travis.util.TravisColor;


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
			return TravisColor.LIGHT_GREEN;
		case GraphPropertyConstants.YELLOW:
			return TravisColor.LIGHT_YELLOW;
		case GraphPropertyConstants.BLUE:
			return TravisColor.LIGHT_BLUE;
		case GraphPropertyConstants.GRAY:
			return TravisColor.LIGHT_GRAY;
		case GraphPropertyConstants.ORANGE:
			return TravisColor.LIGHT_ORANGE;
		case GraphPropertyConstants.BLACK:
			return TravisColor.BLACK;
		case GraphPropertyConstants.WHITE:
			return TravisColor.WHITE;
		case GraphPropertyConstants.ANTIQUE:
			return TravisColor.ANTIQUE;
		default:
			return TravisColor.RED;
		}
	}

	/**
	 * @param color
	 * @return String
	 */
	public static String transformColorToString(Color color) {
		if (color.equals(TravisColor.LIGHT_GREEN)) {
			return GraphPropertyConstants.GREEN;
		} else if (color.equals(TravisColor.LIGHT_YELLOW)) {
			return GraphPropertyConstants.YELLOW;
		} else if (color.equals(TravisColor.LIGHT_BLUE)) {
			return GraphPropertyConstants.BLUE;
		} else if (color.equals(TravisColor.LIGHT_GRAY)) {
			return GraphPropertyConstants.GRAY;
		} else if (color.equals(TravisColor.LIGHT_ORANGE)) {
			return GraphPropertyConstants.ORANGE;
		} else if (color.equals(TravisColor.BLACK)) {
			return GraphPropertyConstants.BLACK;
		} else if (color.equals(TravisColor.WHITE)) {
			return GraphPropertyConstants.WHITE;
		} else if (color.equals(TravisColor.ANTIQUE)) {
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
