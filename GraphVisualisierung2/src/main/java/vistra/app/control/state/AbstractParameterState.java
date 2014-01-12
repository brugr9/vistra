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
	 * A field for a handler.
	 */
	protected ParameterStateHandler handler;

	/**
	 * Main constructor.
	 * 
	 * @param handler
	 *            a handler
	 */
	protected AbstractParameterState(IParameterStateHandler handler) {
		this.handler = (ParameterStateHandler) handler;
	}

	/**
	 * Handles idle.
	 * 
	 * @throws Exception
	 */
	void handleIdle() throws Exception {
		try {
			switch (this.handler.idle()) {
			case 0:
				this.handler.setState(new ParameterAlgorithmSelected(
						this.handler));
				break;
			case 1:
				this.handler
						.setState(new ParameterGraphSaved(this.handler));
				break;
			default:
				this.handler.setState(new ParameterGraphEdited(
						this.handler));
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
			this.handler.newGraph(EdgeType.UNDIRECTED);
			this.handler.setState(new ParameterGraphEdited(this.handler));
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
			this.handler.newGraph(EdgeType.DIRECTED);
			this.handler.setState(new ParameterGraphEdited(this.handler));
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
			int option = this.handler.openGraph();
			if (option == 0)
				this.handler
						.setState(new ParameterGraphSaved(this.handler));
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
			this.handler.saveGraph();
			this.handler.setState(new ParameterGraphSaved(this.handler));
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
			int option = this.handler.saveGraphAs();
			if (option == 0)
				this.handler
						.setState(new ParameterGraphSaved(this.handler));
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
			this.handler.editGraph();
			this.handler.setState(new ParameterGraphEdited(this.handler));
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
			int index = this.handler.selectAlgorithm();
			if (index > 0)
				this.handler.setState(new ParameterAlgorithmSelected(
						this.handler));
			else
				this.handler
						.setState(new ParameterGraphSaved(this.handler));
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
			this.handler.setState(new ParameterOff(this.handler));
		} catch (Exception e) {
			throw e;
		}
	}

}
