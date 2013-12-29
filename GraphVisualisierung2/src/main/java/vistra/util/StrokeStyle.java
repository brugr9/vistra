package vistra.util;

import java.awt.BasicStroke;
import java.awt.Stroke;

import vistra.core.graph.item.ItemLayoutConstant;

/**
 * An enumeration of stroke styles.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see BasicStroke
 */
public enum StrokeStyle {

	/**
	 * Stroke style 'unexplored'.
	 * <ul>
	 * <li>Width: default
	 * <li>Stroke: solid
	 * 
	 * @see ItemLayoutConstant
	 */
	UNEXPLORED(ItemLayoutConstant.STROKE_WIDTH_DEFAULT,
			ItemLayoutConstant.STROKE_SOLID),
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
			ItemLayoutConstant.STROKE_SOLID),
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
	 *            the width
	 * @param pattern
	 *            the pattern
	 */
	StrokeStyle(float width, float[] pattern) {
		this.width = width;
		this.pattern = pattern;
	}

	/**
	 * Returns a stroke.
	 * 
	 * @return the stroke
	 */
	public Stroke getStorke() {
		if (this.pattern == null)
			return new BasicStroke(width);
		else
			return new BasicStroke(width, BasicStroke.CAP_SQUARE,
					BasicStroke.JOIN_MITER, 10.0f, pattern,
					ItemLayoutConstant.STROKE_DASH_PHASE);
	}

}
