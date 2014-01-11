package vistra.app.control.state;

import vistra.framework.util.AbstractState;
import vistra.framework.util.IState;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An abstract parameter state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ParameterStateHandler
 * 
 */
abstract class AbstractParameterState extends AbstractState implements IState {

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
	 * Handles idle.
	 * 
	 * @throws Exception
	 */
	void handleIdle() throws Exception {
		// TODO: method needed?
		try {
			switch (this.stateHandler.idle()) {
			case 0:
				this.stateHandler.setState(new ParameterStateAlgorithmSelected(
						this.stateHandler));
				break;
			case 1:
				this.stateHandler.setState(new ParameterStateGraphSaved(
						this.stateHandler));
				break;
			default:
				this.stateHandler.setState(new ParameterStateGraphEdited(
						this.stateHandler));
				break;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles new undirected graph.
	 * 
	 * @throws Exception
	 */
	void handleNewGraphUndirected() throws Exception {
		try {
			this.stateHandler.newGraph(EdgeType.UNDIRECTED);
			this.stateHandler.setState(new ParameterStateGraphEdited(
					this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles new directed graph.
	 * 
	 * @throws Exception
	 */
	void handleNewGraphDirected() throws Exception {
		try {
			this.stateHandler.newGraph(EdgeType.DIRECTED);
			this.stateHandler.setState(new ParameterStateGraphEdited(
					this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles open graph.
	 * 
	 * @throws Exception
	 */
	void handleOpenGraph() throws Exception {
		try {
			int option = this.stateHandler.openGraph();
			if (option == 0)
				this.stateHandler.setState(new ParameterStateGraphSaved(
						this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles save graph.
	 * 
	 * @throws Exception
	 */
	void handleSaveGraph() throws Exception {
		try {
			this.stateHandler.saveGraph();
			this.stateHandler.setState(new ParameterStateGraphSaved(
					this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles save graph as.
	 * 
	 * @throws Exception
	 */
	void handleSaveGraphAs() throws Exception {
		try {
			int option = this.stateHandler.saveGraphAs();
			if (option == 0)
				this.stateHandler.setState(new ParameterStateGraphSaved(
						this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles edit graph.
	 * 
	 * @throws Exception
	 */
	void handleEditGraph() throws Exception {
		try {
			this.stateHandler.editGraph();
			this.stateHandler.setState(new ParameterStateGraphEdited(
					this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles select algorithm.
	 * 
	 * @throws Exception
	 */
	void handleSelectAlgorithm() throws Exception {
		try {
			int index = this.stateHandler.selectAlgorithm();
			if (index == 0)
				this.stateHandler.setState(new ParameterStateGraphSaved(
						this.stateHandler));
			else
				this.stateHandler.setState(new ParameterStateAlgorithmSelected(
						this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles off.
	 * 
	 * @throws Exception
	 */
	void handleOff() throws Exception {
		try {
			this.stateHandler
					.setState(new ParameterStateOff(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

}
