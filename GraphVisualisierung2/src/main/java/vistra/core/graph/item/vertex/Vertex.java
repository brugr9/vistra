package vistra.core.graph.item.vertex;

import vistra.util.GraphPropertyConstants;
import vistra.util.GraphColor;

/**
 * A vertex (state handler).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public class Vertex extends AbstractVertexModel implements IVertex {

	/**
	 * A field for a vertex state.
	 */
	private AbstractVertexState state;

	/**
	 * Main constructor.
	 * 
	 */
	public Vertex() {
		this.state = new VertexStateIdle(this);
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
	public void handleActivate() throws Exception {
		try {
			this.state.exit();
			this.state.handleActivate();
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
	 */
	void setState(AbstractVertexState state) throws Exception {
		try {
			this.state = state;
			this.state.entry();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 */
	void setViewIdle() throws Exception {
		try {
			this.setBgColor(GraphColor.LIGHT_ORANGE);
			this.setFontColor(GraphColor.DARK_BLUE);
			this.setLineColor(GraphColor.DARK_BLUE);
			this.setLineWidth(GraphPropertyConstants.STROKE_WIDTH_DEFAULT);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 */
	void setViewActivated() throws Exception {
		try {
			this.setBgColor(GraphColor.LIGHT_YELLOW);
			this.setFontColor(GraphColor.RED);
			this.setLineColor(GraphColor.RED);
			this.setLineWidth(GraphPropertyConstants.STROKE_WIDTH_BOLD);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 */
	void setViewVisited() throws Exception {
		try {
			this.setBgColor(GraphColor.LIGHT_ORANGE);
			this.setFontColor(GraphColor.RED);
			this.setLineColor(GraphColor.RED);
			this.setLineWidth(GraphPropertyConstants.STROKE_WIDTH_BOLD);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 */
	void setViewSolved() throws Exception {
		try {
			this.setBgColor(GraphColor.WHITE);
			this.setFontColor(GraphColor.LIGHT_GREEN);
			this.setLineColor(GraphColor.LIGHT_GREEN);
			this.setLineWidth(GraphPropertyConstants.STROKE_WIDTH_BOLD);
		} catch (Exception e) {
			throw e;
		}
	}

}
