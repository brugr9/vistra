package ch.bfh.bti7301.hs2013.gravis.core;

import java.util.List;
import java.util.Properties;

import javax.swing.event.ChangeEvent;

import ch.bfh.bti7301.hs2013.gravis.core.algorithm.AlgorithmFactory;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithmManager;
import ch.bfh.bti7301.hs2013.gravis.core.command.ICommand;
import ch.bfh.bti7301.hs2013.gravis.core.graph.GraphFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphManager;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.graph.Graph;

/**
 * This factory class creates and composes all necessary objects used in the
 * gravis core package. The construction of objects is centralized in this
 * class. All necessary dependencies are passed through the constructors and
 * methods to the objects (dependency injection). An object speaks only through
 * an interface to other dependant objects.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class CoreFactory {

	/**
	 * A main (no-)constructor.
	 */
	private CoreFactory() {
	}

	/**
	 * Creates instances of type ICore. ICore is the interface to all important
	 * core classes.
	 * 
	 * @return an instance of type ICore
	 * @param p
	 * @throws Exception
	 */
	public static ICore createCore(Properties p) throws Exception {
		try {
			// Graph
			IGravisGraph gravisGraph = GraphFactory.createIGravisGraph();
			IGraphManager graphManager = GraphFactory.createGraphManager(p);
			// Algorithm
			IAlgorithmManager algorithmManager = AlgorithmFactory
					.createAlgorithmManager(p);
			// Traversal
			ITraversal traversal = createTraveral(gravisGraph,
					algorithmManager.getDefaultAlgorithm());
			IGravisListIterator<ICommand> listIterator = createListIterator();
			IIteratorManager iteratorManager = createIteratorManager(listIterator);

			return createCore(graphManager, algorithmManager, traversal,
					iteratorManager);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @param graphManager
	 * @param algorithmManager
	 * @param traversal
	 * @param iteratorManager
	 * @return
	 * @throws Exception
	 */
	private static ICore createCore(IGraphManager graphManager,
			IAlgorithmManager algorithmManager, ITraversal traversal,
			IIteratorManager iteratorManager) throws Exception {
		try {
			return new Core(graphManager, algorithmManager, traversal,
					iteratorManager);
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * @param algorithmContext
	 * @return a new instance of type ITraversal
	 * @throws Exception
	 */
	private static ITraversal createTraveral(IGravisGraph gravisGraph,
			IAlgorithm algorithm) throws Exception {
		try {
			return new Traversal(gravisGraph, algorithm);
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * @return a new instance of type IGravisListIterator
	 * @throws Exception
	 */
	private static IGravisListIterator<ICommand> createListIterator()
			throws Exception {
		try {
			return new GravisListIterator<ICommand>();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @param listIterator
	 * @return a new instance of type IIteratorManager
	 * @throws Exception
	 */
	private static IIteratorManager createIteratorManager(
			IGravisListIterator<ICommand> listIterator) throws Exception {
		try {
			return new IteratorManager(listIterator);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * @param list
	 * @return a new instance of type IGravisListIterator
	 * @throws Exception
	 */
	public static IGravisListIterator<ICommand> createGravisListIterator(
			List<ICommand> list) throws Exception {
		try {
			return new GravisListIterator<ICommand>(list);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @param source
	 * @param message
	 * @return a new instance of type TraversalChangeEvent
	 */
	public static TraversalChangeEvent createTraversalChangeEvent(
			Object source, String message) {
		return new TraversalChangeEvent(source, message);
	}

	/**
	 * @param source
	 * @return TraversalChangeEvent
	 */
	public static TraversalChangeEvent createTraversalChangeEvent(Object source) {
		return new TraversalChangeEvent(source);
	}
}
