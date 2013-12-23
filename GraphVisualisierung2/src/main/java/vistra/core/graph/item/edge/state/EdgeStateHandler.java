package vistra.core.graph.item.edge.state;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.edge.Edge;
import vistra.core.graph.item.edge.IEdgeLayout;
import vistra.util.ColorPalette;

/**
 * An edge state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public class EdgeStateHandler implements IEdgeStateHandler {

	/**
	 * A field for an edge state.
	 */
	private AbstractEdgeState state;

	/**
	 * A field for a layout.
	 */
	private Edge layout;

	/**
	 * Main constructor.
	 * 
	 * @param layout
	 *            a layout
	 */
	public EdgeStateHandler(IEdgeLayout layout) {
		this.layout = (Edge) layout;
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
	 * State view setter: Sets the look to unexplored.
	 * 
	 * @throws Exception
	 */
	void setViewUnexplored() throws Exception {
		try {
			this.layout.setFontColor(ColorPalette.darkblue);
			this.layout.setLineColor(ColorPalette.darkblue);
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_DEFAULT);
			this.layout.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the look as discovery.
	 * 
	 * @throws Exception
	 */
	void setViewDiscovery() throws Exception {
		try {
			this.layout.setFontColor(ColorPalette.red);
			this.layout.setLineColor(ColorPalette.red);
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.layout.notifyObservers();
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
			this.layout.setFontColor(ColorPalette.darkgreen);
			this.layout.setLineColor(ColorPalette.darkgreen);
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.layout.notifyObservers();
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
			this.layout.setFontColor(ColorPalette.darkgreen);
			this.layout.setLineColor(ColorPalette.darkgreen);
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.layout.notifyObservers();
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
			this.layout.setFontColor(ColorPalette.darkgreen);
			this.layout.setLineColor(ColorPalette.darkgreen);
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.layout.notifyObservers();
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
			this.layout.setFontColor(ColorPalette.GRAY);
			this.layout.setLineColor(ColorPalette.GRAY);
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			// TODO
			// this.layout.setFontColor(VistraColor.DARK_BLUE);
			// this.layout.setLineColor(VistraColor.DARK_BLUE);
			// this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			// this.layout.setLineStyle(GraphFactory.STROKE_TAGGED)
			this.layout.notifyObservers();
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
			this.layout.setFontColor(ColorPalette.GREEN);
			this.layout.setLineColor(ColorPalette.GREEN);
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.layout.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

}
