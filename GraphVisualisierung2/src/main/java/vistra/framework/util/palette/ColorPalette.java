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
	 * The color apricot in the sRGB space.
	 */
	APRICOT(235, 215, 200),
	/**
	 * The color cherry in the sRGB space.
	 */
	CHERRY(190, 45, 0),
	/**
	 * The color apple in the sRGB space.
	 */
	APPLE(155, 205, 50),
	/**
	 * The color kiwi in the sRGB space.
	 */
	KIWI(90, 110, 80),
	/**
	 * The color orange in the sRGB space.
	 */
	ORANGE(235, 215, 130),
	/**
	 * The color citron in the sRGB space.
	 */
	CITRON(250, 250, 120),
	/**
	 * The color banana in the sRGB space.
	 */
	BANANA(250, 250, 160),
	/**
	 * The color blue in the sRGB space.
	 */
	BLUE(210, 220, 250),
	/**
	 * The color dark blue in the sRGB space.
	 */
	DARKBLUE(65, 70, 140),
	/**
	 * The color grey in the sRGB space.
	 */
	GREY(210, 210, 210),
	/**
	 * The color dark grey in the sRGB space.
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
	 * The color apricot in the sRGB space.
	 */
	public final static Color apricot = APRICOT.getColor();
	/**
	 * The color red in the sRGB space.
	 */
	public final static Color cherry = CHERRY.getColor();
	/**
	 * The color apple in the sRGB space.
	 */
	public final static Color apple = APPLE.getColor();
	/**
	 * The color kiwi in the sRGB space.
	 */
	public final static Color kiwi = KIWI.getColor();
	/**
	 * The color orange in the sRGB space.
	 */
	public final static Color orange = ORANGE.getColor();
	/**
	 * The color citron in the sRGB space.
	 */
	public final static Color citron = CITRON.getColor();
	/**
	 * The color banana in the sRGB space.
	 */
	public final static Color banana = BANANA.getColor();
	/**
	 * The color blue in the sRGB space.
	 */
	public final static Color blue = BLUE.getColor();
	/**
	 * The color dark blue in the sRGB space.
	 */
	public final static Color darkblue = DARKBLUE.getColor();
	/**
	 * The color grey in the sRGB space.
	 */
	public final static Color grey = GREY.getColor();
	/**
	 * The color dark grey in the sRGB space.
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
