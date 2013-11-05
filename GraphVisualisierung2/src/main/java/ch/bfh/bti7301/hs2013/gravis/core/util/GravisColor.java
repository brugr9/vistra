package ch.bfh.bti7301.hs2013.gravis.core.util;

import java.awt.Color;

/**
 * The colours of GRAVIS.
 * <p>
 * Some colours in a tool class though serving with <i>static elements only</i>.
 * <p>
 * The class is built like {@link Color}.
 * 
 * @license GNU_GPL_v3
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see Color
 * 
 */
public abstract class GravisColor {

	/**
	 * A field for the colour red in the RGB space.
	 */
	public final static Color red = new Color(255, 0, 0);
	/**
	 * A field for the colour red in the RGB space.
	 */
	public final static Color RED = red;
	/**
	 * A field for the colour green in the RGB space.
	 */
	public final static Color green = new Color(100, 200, 100);
	/**
	 * A field for the colour green in the RGB space.
	 */
	public final static Color GREEN = green;
	/**
	 * A field for the colour orange in the RGB space.
	 */
	public final static Color orange = new Color(240, 190, 70);
	/**
	 * A field for the colour orange in the RGB space.
	 */
	public final static Color ORANGE = orange;
	/**
	 * A field for the colour blue in the RGB space.
	 */
	public final static Color blue = new Color(150, 220, 240);
	/**
	 * A field for the colour blue in the RGB space.
	 */
	public final static Color BLUE = blue;
	/**
	 * A field for the colour yellow.
	 */
	public final static Color yellow = Color.YELLOW;
	/**
	 * A field for the colour yellow.
	 */
	public final static Color YELLOW = yellow;
	/**
	 * A field for the colour gray.
	 */
	public final static Color gray = Color.LIGHT_GRAY;
	/**
	 * A field for the colour gray.
	 */
	public final static Color GRAY = gray;
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
	private GravisColor() {
	}

}
