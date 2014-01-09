package vistra.framework.util.palette;

import java.awt.Font;

/**
 * A palette defining some customized fonts.
 * <p>
 * Use the lower-case constants for getting directly a {@code Font}.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see StrokePalette
 * @see ColorPalette
 * @see ShapePalette
 * 
 */
public enum FontPalette {

	/**
	 * Font 'normal'.
	 * <ul>
	 * <li>Style: normal
	 * <li>Size: normal
	 */
	NORMAL("normal", FontStyle.normal, FontSize.normal),
	/**
	 * Font 'emphasized'.
	 * <ul>
	 * <li>Style: emphasized
	 * <li>Size: emphasized
	 */
	EMPHASIZED("emphasized", FontStyle.emphasized, FontSize.emphasized),

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
	 */
	public final static Font normal = NORMAL.getFont();

	/**
	 * Font 'emphasized'.
	 * <ul>
	 * <li>Size: emphasized
	 * <li>Style: emphasized
	 * 
	 */
	public final static Font emphasised = EMPHASIZED.getFont();

	/**
	 * Font sizes.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum FontSize {

		/**
		 * Font size: normal.
		 */
		FONT_SIZE_NORMAL(18),
		/**
		 * Font size: emphasized.
		 */
		FONT_SIZE_EMPHASIZED(20),

		;

		/**
		 * A field for the size.
		 */
		private int size;

		/**
		 * Main constructor.
		 * 
		 * @param size
		 *            the size
		 */
		FontSize(int size) {
			this.size = size;
		}

		/**
		 * Returns the size.
		 * 
		 * @return the size
		 */
		public int getSize() {
			return this.size;
		}

		/**
		 * Font size: normal.
		 */
		public final static int normal = FONT_SIZE_NORMAL.getSize();
		/**
		 * Font size: emphasized.
		 */
		public final static int emphasized = FONT_SIZE_EMPHASIZED.getSize();
	}

	/**
	 * Font styles.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum FontStyle {

		/**
		 * Font style: normal.
		 */
		FONT_STYLE_NORMAL(Font.PLAIN),
		/**
		 * Font style: emphasized.
		 */
		FONT_STYLE_EMPHASIZED(Font.BOLD),

		;

		/**
		 * A field for the style.
		 */
		private int style;

		/**
		 * Main constructor.
		 * 
		 * @param style
		 *            the style
		 */
		FontStyle(int style) {
			this.style = style;
		}

		/**
		 * Returns the style.
		 * 
		 * @return the style
		 */
		public int getStyle() {
			return this.style;
		}

		/**
		 * Font style: normal.
		 */
		public final static int normal = FONT_STYLE_NORMAL.getStyle();
		/**
		 * Font style: emphasized.
		 */
		public final static int emphasized = FONT_STYLE_EMPHASIZED.getStyle();
	}
}
