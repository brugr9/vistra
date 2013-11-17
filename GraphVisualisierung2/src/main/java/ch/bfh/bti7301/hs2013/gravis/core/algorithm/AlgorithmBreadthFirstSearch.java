package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.util.LinkedList;
import java.util.Queue;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class AlgorithmBreadthFirstSearch extends AbstractAlgorithm {

	private int counter = 0;
	
	public AlgorithmBreadthFirstSearch() {
		super();
		super.setName("Breadth-first search (BFS)");
		super.setDescription("Breadth-first search (BFS) for DIRECTED and UNDIRECTED edges.");
		// TODO annotations
		super.setGraphTypes(new GraphType[] {});
		// TODO init id
		super.setId(4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.AbstractAlgorithm#execute
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph)
	 */
	@Override
	public void execute(IRestrictedGraph graph) throws Exception {
		// TODO bitte an dieser Methode nichts ändern (pk)

		// TODO BFS with forest
		
		this.counter = 0;
		Queue<IRestrictedVertex> vertexQueue = new LinkedList<>();
		IRestrictedVertex startVertex = graph.getStartVertex();
		
		startVertex.setDone(true);
		vertexQueue.offer(startVertex);
		
		while (!vertexQueue.isEmpty()) {
			IRestrictedVertex selectedVertex = vertexQueue.poll();
			
			graph.updateState(selectedVertex, State.ACTIVATION);
			
			selectedVertex.setResult(++this.counter);
			graph.updateState(selectedVertex, State.SOLUTION);
			
			for (IRestrictedVertex successor : graph.getSuccessors(selectedVertex)) {
				if (!successor.isDone()) {
					graph.updateState(successor, State.ACTIVATION);
					
					successor.setDone(true);
					graph.updateState(successor, State.VISIT);
					
					vertexQueue.offer(successor);
				}
			}
		}
	}

}
