package vistra.framework.util.palette;

import java.awt.Color;

/**
 * A palette defining some customized colors.
 * 
 * Use the lower-case constants for getting directly a {@code Color}.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see FontPalette
 * @see StrokePalette
 * @see ShapePalette
 */
public enum ColorPalette {

	/**
	 * The color antique in the sRGB space.
	 */
	ANTIQUE(235, 215, 200),
	/**
	 * The color red in the sRGB space.
	 */
	RED(190, 45, 0),
	/**
	 * The color green in the sRGB space.
	 */
	GREEN(155, 205, 50),
	/**
	 * The color darkgreen in the sRGB space.
	 */
	DARKGREEN(90, 110, 80),
	/**
	 * The color orange in the sRGB space.
	 */
	ORANGE(235, 215, 130),
	/**
	 * The color blue in the sRGB space.
	 */
	BLUE(210, 220, 250),
	/**
	 * The color darkblue in the sRGB space.
	 */
	DARKBLUE(65, 70, 140),
	/**
	 * The color citron in the sRGB space.
	 */
	CITRON(250, 250, 120),
	/**
	 * The color yellow in the sRGB space.
	 */
	YELLOW(250, 250, 160),
	/**
	 * The color grey in the sRGB space.
	 */
	GREY(210, 210, 210),
	/**
	 * The color darkgrey in the sRGB space.
	 */
	DARKGREY(140, 135, 130),
	/**
	 * The color white in the sRGB space.
	 */
	WHITE(254, 255, 255),
	/**
	 * The color black in the sRGB space.
	 */
	BLACK(50, 40, 40),

	;

	/**
	 * The RGB-value red.
	 */
	private int r;
	/**
	 * The RGB-value green.
	 */
	private int g;
	/**
	 * The RGB-value blue.
	 */
	private int b;

	/**
	 * Main constructor.
	 * 
	 * @param r
	 *            RGB-value red
	 * @param g
	 *            RGB-value green
	 * @param b
	 *            RGB-value blue
	 */
	private ColorPalette(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	/**
	 * Returns the color.
	 * 
	 * @return the color
	 */
	public Color getColor() {
		return new Color(this.r, this.g, this.b);
	}

	/**
	 * The color antique.
	 */
	public final static Color antique = ANTIQUE.getColor();
	/**
	 * The color red in the sRGB space.
	 */
	public final static Color red = RED.getColor();
	/**
	 * The color green in the sRGB space.
	 */
	public final static Color green = GREEN.getColor();
	/**
	 * The color darkgreen in the sRGB space.
	 */
	public final static Color darkgreen = DARKGREEN.getColor();
	/**
	 * The color orange in the sRGB space.
	 */
	public final static Color orange = ORANGE.getColor();
	/**
	 * The color blue in the sRGB space.
	 */
	public final static Color blue = BLUE.getColor();
	/**
	 * The color darkblue in the sRGB space.
	 */
	public final static Color darkblue = DARKBLUE.getColor();
	/**
	 * The color citron in the sRGB space.
	 */
	public final static Color citron = CITRON.getColor();
	/**
	 * The color yellow in the sRGB space.
	 */
	public final static Color yellow = YELLOW.getColor();
	/**
	 * The color grey in the sRGB space.
	 */
	public final static Color grey = GREY.getColor();
	/**
	 * The color darkgrey in the sRGB space.
	 */
	public final static Color darkgrey = DARKGREY.getColor();
	/**
	 * The color white in the sRGB space.
	 */
	public final static Color white = WHITE.getColor();
	/**
	 * The color black in the sRGB space.
	 */
	public final static Color black = BLACK.getColor();

}
