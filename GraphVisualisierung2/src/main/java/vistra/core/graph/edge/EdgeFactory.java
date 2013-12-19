package vistra.core.graph.edge;

import org.apache.commons.collections15.Factory;

/**
 * An edge factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFactory implements Factory<IEdge> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.collections15.Factory#create()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEdge create() {
		return new Edge();
	}

	/**
	 * Creates an immutable edge out of a edge as given.
	 * 
	 * @param edge
	 *            the edge
	 * @return an immutable edge
	 */
	public static IImmutableEdge createImmutableEdge(IEdge edge) {
		return new ImmutableEdge(edge);
	}
}
