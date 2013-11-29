package ch.bfh.bti7301.hs2013.gravis.core.graph.item;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.core.util.GravisConstants;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public abstract class AbstractGraphItem implements IGraphItem {

	private static int counter = 0;

	private String id;
	private String info;
	private String comment;
	private double result;
	private double paintedResult;
	private float strokeWidth;
	private boolean done;
	private boolean tagged;
	private boolean visible;
	private State state;
	private State traversalState = null;
	private Color color;
	private Object value = null;

	/**
	 * Main constructor.
	 */
	protected AbstractGraphItem() {
		this.id = String.valueOf(++counter);
		this.info = this.comment = "";
		this.paintedResult = this.result = Double.NaN;
		this.strokeWidth = GravisConstants.STROKE_WIDTH_DEFAULT;
		this.done = this.tagged = false;
		this.visible = true;
		this.state = State.INITIAL;
		this.color = GravisConstants.V_COLOR_DEFAULT;
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
	public String getInfo() {
		return this.info;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void setId(String id) {
		this.id = id.trim();
	}

	@Override
	public void setInfo(String info) {
		this.info = info.trim();
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String getComment() {
		return this.comment;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment.trim();
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
	public void setTraversalState(State traversalState) {
		this.traversalState = traversalState;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#
	 * getTraversalState()
	 */
	@Override
	public State getTraversalState() {
		return this.traversalState;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem#setState(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State)
	 */
	@Override
	public void setState(State state) {
		this.state = state;
	}

	@Override
	public State getState() {
		return this.state;
	}

	@Override
	public double getResult() {
		return this.result;
	}

	@Override
	public void setResult(double value) {
		this.result = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.common.IGraphItem#getPaintedResult()
	 */
	@Override
	public double getPaintedResult() {
		return this.paintedResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.common.IGraphItem#setPaintedResult(double)
	 */
	@Override
	public void setPaintedResult(double result) {
		this.paintedResult = result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem#
	 * resetVisualizationValues()
	 */
	@Override
	public void resetVisualizationValues() {
		this.comment = "";
		this.result = Double.NaN;
		this.traversalState = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem#hasNoResult()
	 */
	@Override
	public boolean hasNoResult() {
		return Double.isNaN(this.result);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#
	 * appendComment(java.lang.String)
	 */
	@Override
	public void appendComment(String comment) {
		this.comment += System.getProperty("line.separator") + comment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem#getStrokeWidth()
	 */
	@Override
	public float getStrokeWidth() {
		return this.strokeWidth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem#setStrokeWidth
	 * (float)
	 */
	@Override
	public void setStrokeWidth(float strokeWidth) {
		this.strokeWidth = strokeWidth;
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

}