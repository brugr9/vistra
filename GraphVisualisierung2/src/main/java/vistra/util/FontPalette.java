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
	 * <li>Size: normal
	 * <li>Style: normal
	 * 
	 * @see ItemLayoutConstant
	 */
	NORMAL("normal", ItemLayoutConstant.FONT_SIZE_NORMAL,
			ItemLayoutConstant.FONT_STYLE_NORMAL),
	/**
	 * Font 'hyphen'.
	 * <ul>
	 * <li>Size: hyphen
	 * <li>Style: hyphen
	 * 
	 * @see ItemLayoutConstant
	 */
	HYPHEN("hyphen", ItemLayoutConstant.FONT_SIZE_HYPHEN,
			ItemLayoutConstant.FONT_STYLE_HYPHEN),

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
	 * Font 'hyphen'.
	 * <ul>
	 * <li>Size: hyphen
	 * <li>Style: hyphen
	 * 
	 * @see ItemLayoutConstant
	 */
	public final static Font hyphen = HYPHEN.getFont();

}
