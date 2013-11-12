package ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge;

import org.apache.commons.collections15.Factory;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class EdgeFactory implements Factory<IEdge> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.collections15.Factory#create()
	 */
	@Override
	public IEdge create() {
		return new GravisEdge();
	}

	/**
	 * @param edge
	 * @return IEdge
	 */
	public static IRestrictedEdge createRestrictedEdge(IEdge edge) {
		return new RestrictedEdge(edge);
	}

}
