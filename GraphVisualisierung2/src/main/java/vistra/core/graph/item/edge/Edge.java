package vistra.core.graph.item.edge;

import vistra.util.GraphPropertyConstants;
import vistra.util.GraphColor;

/**
 * An edge (state handler).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public class Edge extends AbstractEdgeModel implements IEdge {

	/**
	 * A field for an edge state.
	 */
	private AbstractEdgeState state;

	/**
	 * Main constructor.
	 * 
	 */
	public Edge() {
		super();
		this.state = new EdgeStateIdle(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleIdle() throws Exception {
		try {
			this.state.exit();
			this.state.handleInitialise();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleVisit() throws Exception {
		try {
			this.state.exit();
			this.state.handleVisit();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleDiscard() throws Exception {
		try {
			this.state.exit();
			this.state.handleDiscard();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleSolve() throws Exception {
		try {
			this.state.exit();
			this.state.handleSolve();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Sets a state.
	 * 
	 * @param state
	 *            the state to set
	 * @throws Exception
	 */
	void setState(AbstractEdgeState state) throws Exception {
		try {
			this.state = state;
			this.state.entry();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 * 
	 * @throws Exception
	 */
	void setViewIdle() throws Exception {
		try {
			this.setFontColor(GraphColor.DARK_BLUE);
			this.setLineColor(GraphColor.DARK_BLUE);
			this.setLineWidth(GraphPropertyConstants.STROKE_WIDTH_DEFAULT);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 * 
	 * @throws Exception
	 */
	void setViewVisited() throws Exception {
		try {
			this.setFontColor(GraphColor.RED);
			this.setLineColor(GraphColor.RED);
			this.setLineWidth(GraphPropertyConstants.STROKE_WIDTH_BOLD);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 * 
	 * @throws Exception
	 */
	void setViewDiscarded() throws Exception {
		try {
			this.setFontColor(GraphColor.LIGHT_GRAY);
			this.setLineColor(GraphColor.LIGHT_GRAY);
			this.setLineWidth(GraphPropertyConstants.STROKE_WIDTH_BOLD);
			// TODO
			// this.setFontColor(VistraColor.DARK_BLUE);
			// this.setLineColor(VistraColor.DARK_BLUE);
			// this.setLineWidth(GraphPropertyConstants.STROKE_WIDTH_BOLD);
			// this.setLineStyle(GraphPropertyConstants.STROKE_TAGGED)
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 * 
	 * @throws Exception
	 */
	void setViewSolution() throws Exception {
		try {
			this.setFontColor(GraphColor.LIGHT_GREEN);
			this.setLineColor(GraphColor.LIGHT_GREEN);
			this.setLineWidth(GraphPropertyConstants.STROKE_WIDTH_BOLD);
		} catch (Exception e) {
			throw e;
		}
	}

}
