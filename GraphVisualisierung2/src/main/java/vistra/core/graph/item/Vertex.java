package vistra.core.graph.item;

import java.util.Observable;

import vistra.core.graph.ml.ExtendedGraphMLWriter;

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
	 * A field for a value.
	 */
	int value;

	/**
	 * Main constructor.
	 */
	Vertex() {
		super();
		this.start = ExtendedGraphMLWriter.V_START_DEFAULT;
		this.end = ExtendedGraphMLWriter.V_END_DEFAULT;
		this.value = ExtendedGraphMLWriter.V_VALUE_DEFAULT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isStart() {
		return start;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnd() {
		return end;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getValue() {
		return value;
	}

}
