package vistra.core.graph.item.edge.state;

import java.awt.Font;
import java.util.ArrayList;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.edge.Edge;
import vistra.core.graph.item.edge.IEdgeLayout;
import vistra.util.ColorPalette;

/**
 * An edge state handler.
 * 
 * As being an item state handler, this handler has a cellar able to collect the
 * state history.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeStateHandler implements IEdgeStateHandler {

	/**
	 * A field for a state.
	 */
	private AbstractEdgeState state;
	/**
	 * A field for a states cellar.
	 */
	private ArrayList<AbstractEdgeState> cellar;
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
		this.cellar = new ArrayList<AbstractEdgeState>();
		this.state = null;
		try {
			this.setState(new EdgeStateUnexplored(this));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			this.cellar.add(state);
			this.state = state;
			this.state.entry();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleSetPreviousState() throws Exception {
		try {
			this.state.exit();
			int index = this.cellar.size() - 1;
			AbstractEdgeState state = this.cellar.remove(index);
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
			this.layout.setFontSyle(Font.PLAIN);
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
			this.layout.setFontSyle(Font.BOLD);
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
			this.layout.setFontSyle(Font.PLAIN);
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
			this.layout.setFontSyle(Font.PLAIN);
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
			this.layout.setFontSyle(Font.PLAIN);
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
			this.layout.setFontSyle(Font.PLAIN);
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
			this.layout.setFontSyle(Font.BOLD);
			this.layout.setFontColor(ColorPalette.GREEN);
			this.layout.setLineColor(ColorPalette.GREEN);
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.layout.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

}