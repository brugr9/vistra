package vistra.util;

import java.awt.Font;

/**
 * Constants for the item layout.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see FontPalette
 * @see StrokePalette
 * 
 */
public final class ItemLayoutConstant {

	/* vertex size */
	public final static double HEIGHT_DEFAULT = 40.0;
	public final static double WIDTH_DEFAULT = 45.0;

	/* font */
	public final static int FONT_SIZE_NORMAL = 18;
	public final static int FONT_SIZE_HYPHEN = 20;
	public final static int FONT_STYLE_NORMAL = Font.PLAIN;
	public final static int FONT_STYLE_HYPHEN = Font.BOLD;

	/* stroke */
	public final static float STROKE_DASH_PHASE = 1.0f;
	public final static float STROKE_WIDTH_DEFAULT = 1.5f;
	public final static float STROKE_WIDTH_BOLD = 3.0f;
	public final static float[] STROKE_PATTERN_SOLID = null;
	public final static float[] STROKE_DASHED = new float[] { 12.0f, 10.0f };
	public final static float[] STROKE_DASHED_SHORT = new float[] { 1.0f, 8.0f };
	public final static float[] STROKE_DASH_POINT = new float[] { 10.0f, 10.0f,
			1.0f, 10.0f };

	/**
	 * A main (no-)constructor.
	 */
	private ItemLayoutConstant() {
	}

}
