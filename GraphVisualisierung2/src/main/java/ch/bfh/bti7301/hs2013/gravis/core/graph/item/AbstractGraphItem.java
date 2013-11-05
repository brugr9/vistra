package ch.bfh.bti7301.hs2013.gravis.core.graph.item;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.common.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisColor;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public abstract class AbstractGraphItem implements IGraphItem {

	private String id;
	private String info;
	private String name;
	private String comment;
	private double result;
	private double paintedResult;
	private boolean visited;
	private State state;
	private Color color;

	/**
	 * Main constructor.
	 */
	protected AbstractGraphItem() {
		this.id = "";
		this.info = "";
		this.name = "";
		this.comment = "";
		this.paintedResult = this.result = Double.NaN;
		this.visited = false;
		this.state = State.INITIAL;
		this.color = GravisColor.red;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getName();
	}

	// TODO bitte an dieser Klasse nichts ändern (pk)
	// TODO problem in method VisualizationViewer.setLayout() with equals() and
	// hash code()

	// /* (non-Javadoc)
	// * @see java.lang.Object#hashCode()
	// */
	// @Override
	// public int hashCode() {
	// if (this.id == null || this.id.isEmpty()) {
	// return super.hashCode();
	// } else {
	// return this.id.hashCode();
	// }
	// }
	//
	// /* (non-Javadoc)
	// * @see java.lang.Object#equals(java.lang.Object)
	// */
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj) {
	// return true;
	// }
	//
	// if (obj == null) {
	// return false;
	// }
	//
	// if (this.getClass() != obj.getClass()) {
	// return false;
	// }
	//
	// AbstractGraphItem other = (AbstractGraphItem) obj;
	//
	// if (this.id == null || this.id.isEmpty()) {
	// return this == obj;
	// } else if (!this.id.equals(other.id)) {
	// return false;
	// }
	//
	// return true;
	// }

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
	public String getName() {
		return this.name.isEmpty() ? this.id : this.name;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getComment() {
		return this.comment;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public boolean isVisited() {
		return this.visited;
	}

	@Override
	public void setVisited(boolean value) {
		this.visited = value;
	}

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

}