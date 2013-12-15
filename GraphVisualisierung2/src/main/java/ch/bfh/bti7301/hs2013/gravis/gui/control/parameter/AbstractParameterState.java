/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui.control.parameter;

import ch.bfh.bti7301.hs2013.gravis.util.IState;
import ch.bfh.bti7301.hs2013.gravis.util.State;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An abstract parameter state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractParameterState extends State implements IState {

	/**
	 * A field for a context.
	 */
	protected ParameterStateHandler context;

	/**
	 * Main constructor.
	 * 
	 * @param parameterStateHandler
	 *            a parameter handler
	 */
	protected AbstractParameterState(
			IParameterStateHandler parameterStateHandler) {
		this.context = (ParameterStateHandler) parameterStateHandler;
	}

	/**
	 * Handles an interaction: idle.
	 * 
	 * @throws Exception
	 */
	void handleIdle() throws Exception {
		try {
			this.context.idle();
			this.context.setState(new ParameterIdle(this.context));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles an interaction: new undirected graph.
	 * 
	 * @throws Exception
	 */
	void handleNewGraphUndirected() throws Exception {
		try {
			this.context.newGraph(EdgeType.UNDIRECTED);
			this.context.setState(new ParameterIdle(this.context));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles an interaction: new directed graph.
	 * 
	 * @throws Exception
	 */
	void handleNewGraphDirected() throws Exception {
		try {
			this.context.newGraph(EdgeType.DIRECTED);
			this.context.setState(new ParameterIdle(this.context));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles an interaction: open graph.
	 * 
	 * @throws Exception
	 */
	void handleOpenGraph() throws Exception {
		try {
			int option = this.context.openGraph();
			if (option == 0)
				this.context.setState(new ParameterGraphSaved(this.context));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles an interaction: edit graph.
	 * 
	 * @throws Exception
	 */
	void handleGraphEvent() throws Exception {
		try {
			this.context.editGraph();
			this.context.setState(new ParameterGraphEdited(this.context));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles an interaction: save graph.
	 * 
	 * @throws Exception
	 */
	void handleSaveGraph() throws Exception {
		try {
			boolean ok = this.context.saveGraph();
			if (ok)
				this.context.setState(new ParameterGraphSaved(this.context));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles an interaction: save graph as.
	 * 
	 * @throws Exception
	 */
	void handleSaveGraphAs() throws Exception {
		try {
			int option = this.context.saveGraphAs();
			if (option == 0)
				this.context.setState(new ParameterGraphSaved(this.context));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles an interaction: edit graph.
	 * 
	 * @throws Exception
	 */
	void handleEditGraph() throws Exception {
		try {
			this.context.editGraph();
			this.context.setState(new ParameterGraphEdited(this.context));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles an interaction: import algorithm.
	 * 
	 * @throws Exception
	 */
	void handleImportAlgorithm() throws Exception {
		try {
			int option = this.context.importAlgorithm();
			if (option == 0)
				this.context.setState(new ParameterIdle(this.context));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles an interaction: delete algorithm.
	 * 
	 * @throws Exception
	 */
	void handleDeleteAlgorithm() throws Exception {
		try {
			int option = this.context.deleteAlgorithm();
			if (option == 0)
				this.context.setState(new ParameterIdle(this.context));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles an interaction: select algorithm.
	 * 
	 * @throws Exception
	 */
	void handleSelectAlgorithm() throws Exception {
		try {
			int index = this.context.selectAlgorithm();
			if (index == 0)
				this.context.setState(new ParameterIdle(this.context));
			else
				this.context.setState(new ParameterAlgorithmSelected(
						this.context));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles an interaction: off.
	 * 
	 * @throws Exception
	 */
	void handleOff() throws Exception {
		try {
			this.context.setState(new ParameterOff(this.context));
		} catch (Exception e) {
			throw e;
		}
	}

}
