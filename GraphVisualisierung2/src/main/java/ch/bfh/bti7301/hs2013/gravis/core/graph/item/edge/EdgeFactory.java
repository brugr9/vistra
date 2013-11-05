package ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;

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
	public static IEdge createRestrictedGravisEdge(IEdge edge) {
		return new RestrictedGravisEdge(edge);
	}

}
