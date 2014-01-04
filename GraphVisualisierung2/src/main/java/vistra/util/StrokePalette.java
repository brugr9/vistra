package vistra.util;

import java.awt.BasicStroke;

/**
 * A palette defining some customised strokes.
 * <p>
 * Use the lower-case constants for getting directly a {@code BasicStroke}.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see FontPalette
 * @see ColorPalette
 */
public enum StrokePalette {

	/**
	 * Stroke style 'unexplored'.
	 * <ul>
	 * <li>Width: default
	 * <li>Stroke: solid
	 * 
	 * @see ItemLayoutConstant
	 */
	UNEXPLORED(StrokeWidth.widthDefault, StrokePattern.solid),
	/**
	 * Stroke style 'back'.
	 * <ul>
	 * <li>Width: bold
	 * <li>Stroke: dashed
	 * 
	 * @see ItemLayoutConstant
	 */
	BACK(StrokeWidth.widthBold, StrokePattern.dashed),
	/**
	 * Stroke style 'forward'.
	 * <ul>
	 * <li>Width: bold
	 * <li>Stroke: short dashed
	 * 
	 * @see ItemLayoutConstant
	 */
	FORWARD(StrokeWidth.widthBold, StrokePattern.shortDashed),
	/**
	 * Stroke style 'cross'.
	 * <ul>
	 * <li>Width: bold
	 * <li>Stroke: dash-point
	 * 
	 * @see ItemLayoutConstant
	 */
	CROSS(StrokeWidth.widthBold, StrokePattern.dashPoint),
	/**
	 * Stroke style 'visited'.
	 * <ul>
	 * <li>Width: bold
	 * <li>Stroke: solid
	 * 
	 * @see ItemLayoutConstant
	 */
	VISITED(StrokeWidth.widthBold, StrokePattern.solid),
	/**
	 * Stroke style 'discarded'.
	 * <ul>
	 * <li>Width: bold
	 * <li>Stroke: dashed
	 * 
	 * @see ItemLayoutConstant
	 */
	DISCARDED(StrokeWidth.widthBold, StrokePattern.dashed),

	;

	/**
	 * A field for the width.
	 */
	private final float width;
	/**
	 * A field for the pattern.
	 */
	private final float[] pattern;

	/**
	 * Main constructor.
	 * 
	 * @param width
	 *            the stroke width
	 * @param pattern
	 *            the stroke pattern
	 */
	StrokePalette(float width, float[] pattern) {
		this.width = width;
		this.pattern = pattern;
	}

	/**
	 * Returns the stroke.
	 * 
	 * @return the stroke
	 */
	public BasicStroke getStorke() {
		if (this.pattern == null)
			return new BasicStroke(width);
		else
			return new BasicStroke(width, BasicStroke.CAP_SQUARE,
					BasicStroke.JOIN_MITER, 10.0f, pattern,
					StrokePhase.strokeDashPhase);
	}

	/**
	 * Stroke style 'unexplored'.
	 * <ul>
	 * <li>Width: default
	 * <li>Stroke: solid
	 * 
	 * @see ItemLayoutConstant
	 */
	public final static BasicStroke unexplored = UNEXPLORED.getStorke();

	/**
	 * Stroke style 'back'.
	 * <ul>
	 * <li>Width: bold
	 * <li>Stroke: dashed
	 * 
	 * @see ItemLayoutConstant
	 */
	public final static BasicStroke back = BACK.getStorke();

	/**
	 * Stroke style 'forward'.
	 * <ul>
	 * <li>Width: bold
	 * <li>Stroke: short dashed
	 * 
	 * @see ItemLayoutConstant
	 */
	public final static BasicStroke forward = FORWARD.getStorke();

	/**
	 * Stroke style 'cross'.
	 * <ul>
	 * <li>Width: bold
	 * <li>Stroke: dash-point
	 * 
	 * @see ItemLayoutConstant
	 */
	public final static BasicStroke cross = CROSS.getStorke();

	/**
	 * Stroke style 'visited'.
	 * <ul>
	 * <li>Width: bold
	 * <li>Stroke: solid
	 * 
	 * @see ItemLayoutConstant
	 */
	public final static BasicStroke visited = VISITED.getStorke();

	/**
	 * Stroke style 'discarded'.
	 * <ul>
	 * <li>Width: bold
	 * <li>Stroke: dashed
	 * 
	 * @see ItemLayoutConstant
	 */
	public final static BasicStroke discarded = DISCARDED.getStorke();

	/**
	 * Some stroke widths.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum StrokeWidth {

		/**
		 * Stroke width default.
		 */
		STROKE_WIDTH_DEFAULT(1.5f),
		/**
		 * Stroke width bold.
		 */
		STROKE_WIDTH_BOLD(3.0f),

		;

		/**
		 * A field for the width.
		 */
		private float width;

		/**
		 * Main constructor.
		 * 
		 * @param width
		 *            the width
		 */
		StrokeWidth(float width) {
			this.width = width;
		}

		/**
		 * Returns the width.
		 * 
		 * @return the width
		 */
		public float getWidth() {
			return this.width;
		}

		/**
		 * Stroke width default.
		 */
		public final static float widthDefault = STROKE_WIDTH_DEFAULT
				.getWidth();
		/**
		 * Stroke width bold.
		 */
		public final static float widthBold = STROKE_WIDTH_BOLD.getWidth();

	}

	/**
	 * Some stroke pattern.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum StrokePattern {

		/**
		 * Stroke pattern solid.
		 */
		STROKE_PATTERN_SOLID(null),
		/**
		 * Stroke pattern dashed.
		 */
		STROKE_DASHED(new float[] { 12.0f, 10.0f }),
		/**
		 * Stroke pattern short dashed.
		 */
		STROKE_DASHED_SHORT(new float[] { 1.0f, 8.0f }),
		/**
		 * Stroke pattern dash point.
		 */
		STROKE_DASH_POINT(new float[] { 10.0f, 10.0f, 1.0f, 10.0f }),

		;

		/**
		 * A field for the pattern.
		 */
		private float[] pattern;

		/**
		 * Main constructor.
		 * 
		 * @param pattern
		 *            the pattern
		 */
		StrokePattern(float[] pattern) {
			this.pattern = pattern;
		}

		/**
		 * Return the pattern.
		 * 
		 * @return the pattern
		 */
		public float[] getPattern() {
			return this.pattern;
		}

		/**
		 * Stroke pattern solid.
		 */
		public final static float[] solid = STROKE_PATTERN_SOLID.getPattern();
		/**
		 * Stroke pattern dashed.
		 */
		public final static float[] dashed = STROKE_DASHED.getPattern();
		/**
		 * Stroke pattern short dashed.
		 */
		public final static float[] shortDashed = STROKE_DASHED_SHORT
				.getPattern();
		/**
		 * Stroke pattern dash-point.
		 */
		public final static float[] dashPoint = STROKE_DASH_POINT.getPattern();

	}

	/**
	 * Some stroke phase.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum StrokePhase {

		/**
		 * Stroke dash phase default.
		 */
		STROKE_DASH_PHASE(1.0f),

		;

		/**
		 * A field for the phase.
		 */
		private float phase;

		/**
		 * Main constructor.
		 * 
		 * @param phase
		 *            the phase
		 */
		StrokePhase(float phase) {
			this.phase = phase;
		}

		/**
		 * Returns the phase.
		 * 
		 * @return the phase
		 */
		public float getPhase() {
			return this.phase;
		}

		/**
		 * Stroke dash phase.
		 */
		public final static float strokeDashPhase = STROKE_DASH_PHASE
				.getPhase();

	}
}
