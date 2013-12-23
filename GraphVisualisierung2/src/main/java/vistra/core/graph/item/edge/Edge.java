package vistra.core.graph.item.edge;

import vistra.core.graph.GraphFactory;
import vistra.util.ColorPalette;

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
		this.state = new EdgeStateUnexplored(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleUnexplored() throws Exception {
		try {
			this.state.exit();
			this.state.handleUnexplored();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleDiscovery() throws Exception {
		try {
			this.state.exit();
			this.state.handleDiscovery();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleBack() throws Exception {
		try {
			this.state.exit();
			this.state.handleBack();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleForward() throws Exception {
		try {
			this.state.exit();
			this.state.handleForward();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleCross() throws Exception {
		try {
			this.state.exit();
			this.state.handleCross();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleDiscarded() throws Exception {
		try {
			this.state.exit();
			this.state.handleDiscarded();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleSolution() throws Exception {
		try {
			this.state.exit();
			this.state.handleSolution();
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
	void setViewUnexplored() throws Exception {
		try {
			this.setFontColor(ColorPalette.darkblue);
			this.setLineColor(ColorPalette.darkblue);
			this.setLineWidth(GraphFactory.STROKE_WIDTH_DEFAULT);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 * 
	 * @throws Exception
	 */
	void setViewDiscovery() throws Exception {
		try {
			this.setFontColor(ColorPalette.red);
			this.setLineColor(ColorPalette.red);
			this.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 * 
	 * @throws Exception
	 */
	void setViewBack() throws Exception {
		try {
			this.setFontColor(ColorPalette.darkgreen);
			this.setLineColor(ColorPalette.darkgreen);
			this.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 * 
	 * @throws Exception
	 */
	void setViewForward() throws Exception {
		try {
			this.setFontColor(ColorPalette.darkgreen);
			this.setLineColor(ColorPalette.darkgreen);
			this.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 * 
	 * @throws Exception
	 */
	void setViewCross() throws Exception {
		try {
			this.setFontColor(ColorPalette.darkgreen);
			this.setLineColor(ColorPalette.darkgreen);
			this.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.notifyObservers();
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
			this.setFontColor(ColorPalette.GRAY);
			this.setLineColor(ColorPalette.GRAY);
			this.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			// TODO
			// this.setFontColor(VistraColor.DARK_BLUE);
			// this.setLineColor(VistraColor.DARK_BLUE);
			// this.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			// this.setLineStyle(GraphFactory.STROKE_TAGGED)
			this.notifyObservers();
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
			this.setFontColor(ColorPalette.GREEN);
			this.setLineColor(ColorPalette.GREEN);
			this.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

}
