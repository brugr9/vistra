package vistra.framework.graph.item;

import java.util.Observable;

import vistra.framework.graph.ml.GraphWriter;
import vistra.framework.util.palette.SigmaPalette;

/**
 * A vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class Vertex extends Observable implements IVertex {

	/**
	 * A field for a start.
	 */
	boolean start;

	/**
	 * A field for an end.
	 */
	boolean end;

	/**
	 * A field for a visited value.
	 */
	boolean visited;

	/**
	 * A field for a value.
	 */
	String value;

	/**
	 * Main constructor.
	 */
	Vertex() {
		super();
		this.start = GraphWriter.V_START_DEFAULT;
		this.end = GraphWriter.V_END_DEFAULT;
		this.visited = false;
		this.value = GraphWriter.V_VALUE_DEFAULT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isStart() {
		return this.start;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnd() {
		return this.end;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isInitialized() {
		return this.value == SigmaPalette.infinity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isVisited() {
		return this.visited;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getDistance() {
		if (this.value == SigmaPalette.infinity)
			return Integer.MAX_VALUE;
		else if (this.value == "")
			return null;
		else
			return Integer.parseInt(this.value);
	}

}
