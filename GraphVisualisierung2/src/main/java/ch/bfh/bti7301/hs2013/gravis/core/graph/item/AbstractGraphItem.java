package ch.bfh.bti7301.hs2013.gravis.core.graph.item;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.core.util.GraphPropertyConstants;
import ch.bfh.bti7301.hs2013.gravis.util.GravisColor;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public abstract class AbstractGraphItem implements IGraphItem {

	private static int counter = 0;

	private String id, newComment;

	private double currentResult, newResult;

	private State currentState, newState = null;

	private Color currentColor, newColor, oldColor;

	private float currentStrokeWidth, newStrokeWidth, oldStrokeWidth;

	private boolean done, tagged, visible, stateCommentEnabled;

	private Object value = null;

	/**
	 * Main constructor.
	 */
	protected AbstractGraphItem() {
		this.id = String.valueOf(++counter);
		this.newComment = "";
		this.currentResult = this.newResult = Double.NaN;
		this.currentState = State.INITIAL;
		this.currentColor = this.oldColor = GraphPropertyConstants.V_COLOR_DEFAULT;
		this.currentStrokeWidth = this.oldStrokeWidth = GraphPropertyConstants.STROKE_WIDTH_DEFAULT;
		this.stateCommentEnabled = this.done = false;

		this.setNewColor(GraphPropertyConstants.V_COLOR_DEFAULT);
		this.setNewStrokeWidth(GraphPropertyConstants.STROKE_WIDTH_DEFAULT);
		this.setVisible(true);
		this.setTagged(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getId();
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Color getCurrentColor() {
		return this.currentColor;
	}

	@Override
	public void setId(String id) {
		this.id = id.trim();
	}

	@Override
	public void setCurrentColor(Color color) {
		this.currentColor = color;
		this.visible = color != GravisColor.WHITE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem#setNewColor(java
	 * .awt.Color)
	 */
	@Override
	public void setNewColor(Color newColor) {
		if (newColor != GravisColor.WHITE) {
			this.oldColor = newColor;
		}

		this.newColor = newColor;
		this.visible = newColor != GravisColor.WHITE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem#getNewColor()
	 */
	@Override
	public Color getNewColor() {
		return this.newColor;
	}

	@Override
	public String getNewComment() {
		return this.newComment;
	}

	@Override
	public void setNewComment(String comment) {
		this.newComment = comment.trim();
	}

	@Override
	public boolean isDone() {
		return this.done;
	}

	@Override
	public void setDone(boolean value) {
		this.done = value;
	}

	@Override
	public void setNewState(State traversalState) {
		this.newState = traversalState;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#
	 * getTraversalState()
	 */
	@Override
	public State getNewState() {
		return this.newState;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem#setState(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State)
	 */
	@Override
	public void setCurrentState(State state) {
		this.currentState = state;
	}

	@Override
	public State getCurrentState() {
		return this.currentState;
	}

	@Override
	public double getNewResult() {
		return this.currentResult;
	}

	@Override
	public void setNewResult(double value) {
		this.currentResult = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.common.IGraphItem#getPaintedResult()
	 */
	@Override
	public double getCurrentResult() {
		return this.newResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.common.IGraphItem#setPaintedResult(double)
	 */
	@Override
	public void setCurrentResult(double result) {
		this.newResult = result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem#
	 * resetVisualizationValues()
	 */
	@Override
	public void resetVisualizationValues() {
		this.newComment = "";
		this.currentResult = Double.NaN;
		this.newState = null;
		this.stateCommentEnabled = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem#hasNoResult()
	 */
	@Override
	public boolean hasNoResult() {
		return Double.isNaN(this.currentResult);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#
	 * appendComment(java.lang.String)
	 */
	@Override
	public void appendToNewComment(String comment) {
		this.newComment += System.getProperty("line.separator") + comment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem#getStrokeWidth()
	 */
	@Override
	public float getCurrentStrokeWidth() {
		return this.currentStrokeWidth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem#setStrokeWidth
	 * (float)
	 */
	@Override
	public void setCurrentStrokeWidth(float strokeWidth) {
		this.currentStrokeWidth = strokeWidth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem#getNewStrokeWidth
	 * ()
	 */
	@Override
	public float getNewStrokeWidth() {
		return this.newStrokeWidth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem#setNewStrokeWidth
	 * (float)
	 */
	@Override
	public void setNewStrokeWidth(float width) {
		if (width != this.getDefaultStrokeWidth()) {
			this.oldStrokeWidth = width;
		}

		this.newStrokeWidth = width;
		this.tagged = width == this.getDefaultStrokeWidth();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public AbstractGraphItem clone() throws CloneNotSupportedException {
		return (AbstractGraphItem) super.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#getValue
	 * ()
	 */
	@Override
	public Object getValue() {
		return this.value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#setValue
	 * (java.lang.Object)
	 */
	@Override
	public void setValue(Object value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#setVisible
	 * (boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
		this.newColor = visible ? this.oldColor : GravisColor.WHITE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#isVisible
	 * ()
	 */
	@Override
	public boolean isVisible() {
		return this.visible;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#setTagged
	 * (boolean)
	 */
	@Override
	public void setTagged(boolean tagged) {
		this.tagged = tagged;
		this.newStrokeWidth = tagged ? this.getDefaultStrokeWidth()
				: this.oldStrokeWidth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#isTagged
	 * ()
	 */
	@Override
	public boolean isTagged() {
		return this.tagged;
	}

	/**
	 * @return float
	 */
	protected abstract float getDefaultStrokeWidth();

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#
	 * setStateCommentEnabled(boolean)
	 */
	@Override
	public void setStateCommentEnabled(boolean value) {
		this.stateCommentEnabled = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#
	 * isStateCommentEnabled()
	 */
	@Override
	public boolean isStateCommentEnabled() {
		return this.stateCommentEnabled;
	}

}