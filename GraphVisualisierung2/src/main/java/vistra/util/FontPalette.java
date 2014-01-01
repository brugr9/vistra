package vistra.util;

import java.awt.Font;

/**
 * A palette defining some customised fonts.
 * <p>
 * Use the lower-case constants for getting directly a {@code Font}.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see StrokePalette
 * @see ColorPalette
 * 
 */
public enum FontPalette {

	/**
	 * Font 'normal'.
	 * <ul>
	 * <li>Style: normal
	 * <li>Size: normal
	 * 
	 * @see ItemLayoutConstant
	 */
	NORMAL("normal", ItemLayoutConstant.FONT_STYLE_NORMAL,
			ItemLayoutConstant.FONT_SIZE_NORMAL),
	/**
	 * Font 'emphasised'.
	 * <ul>
	 * <li>Style: emphasised
	 * <li>Size: emphasised
	 * 
	 * @see ItemLayoutConstant
	 */
	EMPHASISED("emphasised", ItemLayoutConstant.FONT_STYLE_EMPHASISED,
			ItemLayoutConstant.FONT_SIZE_EMPHASISED),

	;

	/**
	 * A field for the name.
	 */
	private final String name;
	/**
	 * A field for the style.
	 */
	private final int style;
	/**
	 * A field for the size.
	 */
	private final int size;

	/**
	 * Main constructor.
	 * 
	 * @param name
	 *            the font name
	 * @param style
	 *            the font style
	 * @param size
	 *            the font size
	 */
	FontPalette(String name, int style, int size) {
		this.name = name;
		this.style = style;
		this.size = size;
	}

	/**
	 * Returns the font.
	 * 
	 * @return the font
	 */
	public Font getFont() {
		return new Font(this.name, this.style, this.size);
	}

	/**
	 * Font 'normal'.
	 * <ul>
	 * <li>Size: normal
	 * <li>Style: normal
	 * 
	 * @see ItemLayoutConstant
	 */
	public final static Font normal = NORMAL.getFont();

	/**
	 * Font 'emphasised'.
	 * <ul>
	 * <li>Size: emphasised
	 * <li>Style: emphasised
	 * 
	 * @see ItemLayoutConstant
	 */
	public final static Font emphasised = EMPHASISED.getFont();

}
