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
	UNEXPLORED(ItemLayoutConstant.STROKE_WIDTH_DEFAULT,
			ItemLayoutConstant.STROKE_PATTERN_SOLID),
	/**
	 * Stroke style 'back'.
	 * <ul>
	 * <li>Width: default
	 * <li>Stroke: dashed
	 * 
	 * @see ItemLayoutConstant
	 */
	BACK(ItemLayoutConstant.STROKE_WIDTH_DEFAULT,
			ItemLayoutConstant.STROKE_DASHED),
	/**
	 * Stroke style 'forward'.
	 * <ul>
	 * <li>Width: default
	 * <li>Stroke: short dashed
	 * 
	 * @see ItemLayoutConstant
	 */
	FORWARD(ItemLayoutConstant.STROKE_WIDTH_DEFAULT,
			ItemLayoutConstant.STROKE_DASHED_SHORT),
	/**
	 * Stroke style 'cross'.
	 * <ul>
	 * <li>Width: default
	 * <li>Stroke: dash-point
	 * 
	 * @see ItemLayoutConstant
	 */
	CROSS(ItemLayoutConstant.STROKE_WIDTH_DEFAULT,
			ItemLayoutConstant.STROKE_DASH_POINT),
	/**
	 * Stroke style 'visited'.
	 * <ul>
	 * <li>Width: bold
	 * <li>Stroke: solid
	 * 
	 * @see ItemLayoutConstant
	 */
	VISITED(ItemLayoutConstant.STROKE_WIDTH_BOLD,
			ItemLayoutConstant.STROKE_PATTERN_SOLID),
	/**
	 * Stroke style 'discarded'.
	 * <ul>
	 * <li>Width: bold
	 * <li>Stroke: dashed
	 * 
	 * @see ItemLayoutConstant
	 */
	DISCARDED(ItemLayoutConstant.STROKE_WIDTH_BOLD,
			ItemLayoutConstant.STROKE_DASHED),

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
					ItemLayoutConstant.STROKE_DASH_PHASE);
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
	 * <li>Width: default
	 * <li>Stroke: dashed
	 * 
	 * @see ItemLayoutConstant
	 */
	public final static BasicStroke back = BACK.getStorke();

	/**
	 * Stroke style 'forward'.
	 * <ul>
	 * <li>Width: default
	 * <li>Stroke: short dashed
	 * 
	 * @see ItemLayoutConstant
	 */
	public final static BasicStroke forward = FORWARD.getStorke();

	/**
	 * Stroke style 'cross'.
	 * <ul>
	 * <li>Width: default
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

}
