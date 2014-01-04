package vistra.util;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * A shape palette.
 * <p>
 * Use the lower-case constants for getting directly a {@code Shape}.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see FontPalette
 * @see StrokePalette
 * @see ColorPalette
 */
public enum ShapePalette {

	/**
	 * Shape 'default'.
	 * <ul>
	 * <li>Width: 45.0
	 * <li>Height: 40.0
	 */
	DEFAULT(ShapeWidth.widthDefault, ShapeHeight.heightDefault),

	;

	/**
	 * A field for the width.
	 */
	private double width;
	/**
	 * A field for the height.
	 */
	private double height;

	/**
	 * Main constructor.
	 * 
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	private ShapePalette(double width, double height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * Returns the width.
	 * 
	 * @return the width
	 */
	public double getWidth() {
		return this.width;
	}

	/**
	 * Returns the height.
	 * 
	 * @return the height
	 */
	public double getHeight() {
		return this.height;
	}

	/**
	 * Returns the shape.
	 * 
	 * @return the shape
	 */
	public Shape getShape() {
		return new Ellipse2D.Double(-this.width / 2.0, -this.width / 2.0,
				this.width, this.height);
	}

	/**
	 * Default shape.
	 */
	public final static Shape shapeDefault = DEFAULT.getShape();

	/**
	 * Shape widths.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum ShapeWidth {

		/**
		 * Width 'default'.
		 * <ul>
		 * <li>Width: 45.0
		 */
		DEFAULT(45.0),

		;

		/**
		 * A field for the width.
		 */
		private double width;

		/**
		 * Main constructor.
		 * 
		 * @param width
		 *            the width
		 */
		private ShapeWidth(double width) {
			this.width = width;
		}

		/**
		 * Returns the width.
		 * 
		 * @return the width
		 */
		public double getWidth() {
			return this.width;
		}

		/**
		 * Width 'default'.
		 * <ul>
		 * <li>Width: 45.0
		 */
		public final static double widthDefault = DEFAULT.getWidth();

	}

	/**
	 * Shape heights.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum ShapeHeight {

		/**
		 * Height 'default'.
		 * <ul>
		 * <li>Height: 40.0
		 */
		DEFAULT(40.0),

		;

		/**
		 * A field for the height.
		 */
		private double height;

		/**
		 * Main constructor.
		 * 
		 * @param height
		 *            the height
		 */
		private ShapeHeight(double height) {
			this.height = height;
		}

		/**
		 * Returns the height.
		 * 
		 * @return the height
		 */
		public double getHeight() {
			return this.height;
		}

		/**
		 * Height 'default'.
		 * <ul>
		 * <li>Height: 40.0
		 */
		public final static double heightDefault = DEFAULT.getHeight();

	}

}
