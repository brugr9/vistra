package ch.bfh.bti7301.hs2013.gravis.core;

import static ch.bfh.bti7301.hs2013.gravis.core.CoreFactory.createImmutListIterator;
import static ch.bfh.bti7301.hs2013.gravis.core.graph.GraphFactory.createGravisGraphEventListener;
import static ch.bfh.bti7301.hs2013.gravis.core.graph.GraphFactory.createRestrictedGraph;
import static ch.bfh.bti7301.hs2013.gravis.core.graph.GraphFactory.createObservableGraph;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ChangeListener;

import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.command.ICommand;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IObservableGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.graph.event.GraphEventListener;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class Traversal implements ITraversal {

	/**
	 * A field for a graph.
	 */
	private IGravisGraph graph;

	/**
	 * A field for an algorithm.
	 */
	private IAlgorithm algorithm;

	/**
	 * Main constructor.
	 * 
	 * @param gravisGraph
	 *            a graph for the traversal
	 * @param algorithm
	 *            an algorithm for the traversal
	 */
	protected Traversal(IGravisGraph gravisGraph, IAlgorithm algorithm) {
		this.graph = gravisGraph;
		this.algorithm = algorithm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ITraversal#setGraph(ch.bfh.bti7301
	 * .hs2013.gravis.core.graph.IGravisGraph)
	 */
	@Override
	public void setParameter(IGravisGraph gravisGraph) throws Exception {
		try {
			this.graph = gravisGraph;
		} catch (Exception e) {
			throw e;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ITraversal#setAlgorithm(ch.bfh.
	 * bti7301.hs2013.gravis.core.algorithm.IAlgorithm)
	 */
	@Override
	public void setParameter(IAlgorithm algorithm) throws Exception {
		try {
			this.algorithm = algorithm;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ITraversal#getTraversingGraph()
	 */
	@Override
	public IGravisGraph getGraph() {
		return this.graph;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ITraversal#getTraversingAlgorithm
	 * ()
	 */
	@Override
	public IAlgorithm getAlgorithm() {
		return this.algorithm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ITraversal#executeTraverser(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.IGraphItemStateChangeListener)
	 */
	@Override
	public IImmutListIterator<ICommand> execute(ChangeListener changeListener)
			throws Exception {
		try {
			// TODO bitte an dieser Methode nichts ändern (pk)

			// TODO GravisGraphEventListener and IteratorManager need an
			// Observer
			// for processing and traversing updates
			// TODO notify GuiControl.selectAlgorithm(index) for changes in item
			
			// TODO problem when this method is called twice
			// TODO add TraversalListener

			List<ICommand> commandList = new ArrayList<>();
			// TODO read enableEdges flag from algorithm
			GraphEventListener<IVertex, IEdge> graphEventListener = createGravisGraphEventListener(
					commandList, true);
			IObservableGravisGraph observableGraph = createObservableGraph(this.graph);

			observableGraph.addGraphEventListener(graphEventListener);
			IRestrictedGraph restrictedGraph = createRestrictedGraph(observableGraph);

			// TODO notify IGraphItemStateChangeListener
			this.algorithm.execute(restrictedGraph);

			for (int i = commandList.size() - 1; i >= 0; i--) {
				commandList.get(i).unExecute();
			}
			
			// TODO notify changeListener
			
			return createImmutListIterator(commandList);
		} catch (Exception e) {
			throw e;
		}

	}
}
