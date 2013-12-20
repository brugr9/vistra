package vistra.gui.view.component.vizualization.transformer;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.List;

import vistra.core.graph.item.IGraphItem;
import vistra.core.graph.GraphPropertyConstants;
import vistra.util.VistraColor;

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
			return VistraColor.LIGHT_GREEN;
		case GraphPropertyConstants.YELLOW:
			return VistraColor.LIGHT_YELLOW;
		case GraphPropertyConstants.BLUE:
			return VistraColor.LIGHT_BLUE;
		case GraphPropertyConstants.GRAY:
			return VistraColor.LIGHT_GRAY;
		case GraphPropertyConstants.ORANGE:
			return VistraColor.LIGHT_ORANGE;
		case GraphPropertyConstants.BLACK:
			return VistraColor.BLACK;
		case GraphPropertyConstants.WHITE:
			return VistraColor.WHITE;
		case GraphPropertyConstants.ANTIQUE:
			return VistraColor.ANTIQUE;
		default:
			return VistraColor.RED;
		}
	}

	/**
	 * @param color
	 * @return String
	 */
	public static String transformColorToString(Color color) {
		if (color.equals(VistraColor.LIGHT_GREEN)) {
			return GraphPropertyConstants.GREEN;
		} else if (color.equals(VistraColor.LIGHT_YELLOW)) {
			return GraphPropertyConstants.YELLOW;
		} else if (color.equals(VistraColor.LIGHT_BLUE)) {
			return GraphPropertyConstants.BLUE;
		} else if (color.equals(VistraColor.LIGHT_GRAY)) {
			return GraphPropertyConstants.GRAY;
		} else if (color.equals(VistraColor.LIGHT_ORANGE)) {
			return GraphPropertyConstants.ORANGE;
		} else if (color.equals(VistraColor.BLACK)) {
			return GraphPropertyConstants.BLACK;
		} else if (color.equals(VistraColor.WHITE)) {
			return GraphPropertyConstants.WHITE;
		} else if (color.equals(VistraColor.ANTIQUE)) {
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
	public static IGraphItem[] toArray(List<IGraphItem> itemList) {
		return itemList.toArray(new IGraphItem[itemList.size()]);
	}
}
