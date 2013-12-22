package vistra.util;

import java.awt.Color;

import vistra.core.graph.GraphMLMeta;

/**
 * A tool class built like {@link Color} defining some customised colours.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see Color
 * 
 */
public abstract class ColorPalette {

	/**
	 * A field for the colour antique.
	 */
	public final static Color antique = new Color(235, 215, 200);
	/**
	 * A field for the colour antique.
	 */
	public final static Color ANTIQUE = antique;
	/**
	 * A field for the colour red in the RGB space.
	 */
	public final static Color red = new Color(190, 45, 0);
	/**
	 * A field for the colour red in the RGB space.
	 */
	public final static Color RED = red;
	/**
	 * A field for the colour green in the RGB space.
	 */
	public final static Color green = new Color(155, 205, 50);
	/**
	 * A field for the colour green in the RGB space.
	 */
	public final static Color GREEN = green;
	/**
	 * A field for the colour darkgreen in the RGB space.
	 */
	public final static Color darkgreen = new Color(90, 110, 80);
	/**
	 * A field for the colour darkgreen in the RGB space.
	 */
	public final static Color DARKGREEN = darkgreen;
	/**
	 * A field for the colour orange in the RGB space.
	 */
	public final static Color orange = new Color(235, 215, 130);
	/**
	 * A field for the colour orange in the RGB space.
	 */
	public final static Color ORANGE = orange;
	/**
	 * A field for the colour blue in the RGB space.
	 */
	public final static Color blue = new Color(210, 220, 250);
	/**
	 * A field for the colour blue in the RGB space.
	 */
	public final static Color BLUE = blue;
	/**
	 * A field for the colour darkblue in the RGB space.
	 */
	public final static Color darkblue = new Color(65, 70, 140);
	/**
	 * A field for the colour darkblue in the RGB space.
	 */
	public final static Color DARKBLUE = darkblue;
	/**
	 * A field for the colour citron.
	 */
	public final static Color citron = new Color(250, 250, 120);
	/**
	 * A field for the colour citron.
	 */
	public final static Color CITRON = citron;
	/**
	 * A field for the colour yellow.
	 */
	public final static Color yellow = new Color(250, 250, 160);
	/**
	 * A field for the colour yellow.
	 */
	public final static Color YELLOW = yellow;
	/**
	 * A field for the colour gray.
	 */
	public final static Color gray = new Color(210, 210, 210);
	/**
	 * A field for the colour gray.
	 */
	public final static Color GRAY = gray;
	/**
	 * A field for the colour darkgrey.
	 */
	public final static Color darkgrey = new Color(140, 135, 130);
	/**
	 * A field for the colour darkgrey.
	 */
	public final static Color DARKGRAY = darkgrey;
	/**
	 * A field for the colour white.
	 */
	public final static Color white = Color.WHITE;
	/**
	 * A field for the colour white.
	 */
	public final static Color WHITE = white;
	/**
	 * A field for the colour black.
	 */
	public final static Color black = Color.BLACK;
	/**
	 * A field for the colour black.
	 */
	public final static Color BLACK = black;

	/**
	 * A main (no-)constructor.
	 */
	private ColorPalette() {
	}

	/**
	 * Converts a color name as found in {@link ColorPalette} to a lower case
	 * string (e.g. used as metadata property in a GraphML element).
	 * <p>
	 * If the color as given is not defined in {@link ColorPalette}, the method
	 * returns the RGB value as string.
	 * 
	 * @param color
	 *            the colour
	 * @return the string if successful
	 * @see GraphMLMeta
	 */
	public static String toString(Color color) {

		if (color.equals(antique)) {
			return "antique";
		} else if (color.equals(ANTIQUE)) {
			return "antique";
		} else if (color.equals(red)) {
			return "red";
		} else if (color.equals(RED)) {
			return "red";
		} else if (color.equals(green)) {
			return "green";
		} else if (color.equals(GREEN)) {
			return "green";
		} else if (color.equals(darkgreen)) {
			return "darkgreen";
		} else if (color.equals(DARKGREEN)) {
			return "darkgreen";
		} else if (color.equals(orange)) {
			return "orange";
		} else if (color.equals(ORANGE)) {
			return "orange";
		} else if (color.equals(blue)) {
			return "blue";
		} else if (color.equals(BLUE)) {
			return "blue";
		} else if (color.equals(darkblue)) {
			return "darkblue";
		} else if (color.equals(DARKBLUE)) {
			return "darkblue";
		} else if (color.equals(citron)) {
			return "citron";
		} else if (color.equals(CITRON)) {
			return "citron";
		} else if (color.equals(yellow)) {
			return "yellow";
		} else if (color.equals(YELLOW)) {
			return "yellow";
		} else if (color.equals(gray)) {
			return "gray";
		} else if (color.equals(GRAY)) {
			return "gray";
		} else if (color.equals(darkgrey)) {
			return "darkgray";
		} else if (color.equals(DARKGRAY)) {
			return "darkgray";
		} else if (color.equals(white)) {
			return "white";
		} else if (color.equals(WHITE)) {
			return "white";
		} else if (color.equals(black)) {
			return "black";
		} else if (color.equals(BLACK)) {
			return "black";
		} else
			return Integer.toString(color.getRGB());
	}

	/**
	 * Tries to convert a {@link ColorPalette} color name (e.g. used as metadata
	 * property in a GraphML element) into a {@link ColorPalette} color.
	 * 
	 * @param name
	 *            a {@link ColorPalette} color name
	 * @return the {@link ColorPalette} if successful (else: black)
	 * @see GraphMLMeta
	 */
	public static Color toColor(String name) {

		switch (name) {

		case "antique":
			return antique;
		case "red":
			return red;
		case "green":
			return green;
		case "darkgreen":
			return darkgreen;
		case "orange":
			return orange;
		case "blue":
			return blue;
		case "darkblue":
			return darkblue;
		case "citron":
			return citron;
		case "yellow":
			return yellow;
		case "gray":
			return gray;
		case "darkgray":
			return darkgrey;
		case "white":
			return white;
		case "black":
			return black;
		default:
			return black;
		}

	}

}
