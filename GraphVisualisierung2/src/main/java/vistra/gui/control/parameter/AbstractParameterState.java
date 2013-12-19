package vistra.gui.control.parameter;

import vistra.util.IState;
import vistra.util.State;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An abstract parameter state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractParameterState extends State implements IState {

	/**
	 * A field for a state handler.
	 */
	protected ParameterStateHandler stateHandler;

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	protected AbstractParameterState(IParameterStateHandler stateHandler) {
		this.stateHandler = (ParameterStateHandler) stateHandler;
	}

	/**
	 * Handles an interaction: idle.
	 * 
	 * @throws Exception
	 */
	void handleIdle() throws Exception {
		try {
			this.stateHandler.idle();
			this.stateHandler.setState(new ParameterIdle(this.stateHandler));
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
			this.stateHandler.newGraph(EdgeType.UNDIRECTED);
			this.stateHandler.setState(new ParameterIdle(this.stateHandler));
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
			this.stateHandler.newGraph(EdgeType.DIRECTED);
			this.stateHandler.setState(new ParameterIdle(this.stateHandler));
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
			int option = this.stateHandler.openGraph();
			if (option == 0)
				this.stateHandler.setState(new ParameterGraphSaved(
						this.stateHandler));
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
			this.stateHandler.saveGraph();
			this.stateHandler.setState(new ParameterGraphSaved(
					this.stateHandler));
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
			int option = this.stateHandler.saveGraphAs();
			if (option == 0)
				this.stateHandler.setState(new ParameterGraphSaved(
						this.stateHandler));
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
			this.stateHandler.editGraph();
			this.stateHandler.setState(new ParameterGraphEdited(
					this.stateHandler));
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
			int option = this.stateHandler.importAlgorithm();
			if (option == 0)
				this.stateHandler
						.setState(new ParameterIdle(this.stateHandler));
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
			int option = this.stateHandler.deleteAlgorithm();
			if (option == 0)
				this.stateHandler
						.setState(new ParameterIdle(this.stateHandler));
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
			int index = this.stateHandler.selectAlgorithm();
			if (index == 0)
				this.stateHandler
						.setState(new ParameterIdle(this.stateHandler));
			else
				this.stateHandler.setState(new ParameterAlgorithmSelected(
						this.stateHandler));
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
			this.stateHandler.setState(new ParameterOff(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

}
