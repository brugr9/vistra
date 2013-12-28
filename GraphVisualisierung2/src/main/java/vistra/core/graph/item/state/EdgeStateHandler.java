package vistra.core.graph.item.state;

import java.awt.Font;
import java.util.ArrayList;

import vistra.core.graph.item.EdgeLayout;
import vistra.core.graph.item.ItemLayoutConstants;
import vistra.util.ColorPalette;

/**
 * An edge state handler.
 * <p>
 * As being an item state handler, this handler has a cellar at its disposal. It
 * is therefore able to hold the state history of the edge and handles setting a
 * previous state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see IItemStateHandler
 * @see VertexStateHandler
 * 
 */
public class EdgeStateHandler extends EdgeLayout implements IEdgeStateHandler {

	/**
	 * A field for a state.
	 */
	private AbstractEdgeState state;
	/**
	 * A field for a cellar.
	 */
	private ArrayList<AbstractEdgeState> cellar;

	/**
	 * Main constructor.
	 */
	public EdgeStateHandler() {
		super();
		this.state = null;
		this.cellar = new ArrayList<AbstractEdgeState>();
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
			this.state = this.cellar.remove(index);
			this.state.entry();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the layout to unexplored edge.
	 * 
	 * @throws Exception
	 */
	void setViewUnexplored() throws Exception {
		try {
			this.setFontStyle(Font.PLAIN);
			this.setFontColor(ColorPalette.darkblue);
			this.setLineColor(ColorPalette.darkblue);
			this.setLineWidth(ItemLayoutConstants.STROKE_WIDTH_DEFAULT);
			this.setDash(ItemLayoutConstants.E_SOLID);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the layout as discovery edge.
	 * <p>
	 * (see doc/vistra/adt/11DiGraphs_handout.pdf, page 8)
	 * 
	 * @throws Exception
	 */
	void setViewDiscovery() throws Exception {
		try {
			this.setFontStyle(Font.BOLD);
			this.setFontColor(ColorPalette.red);
			this.setLineColor(ColorPalette.red);
			this.setLineWidth(ItemLayoutConstants.STROKE_WIDTH_BOLD);
			this.setDash(ItemLayoutConstants.E_SOLID);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the layout as back edge.
	 * <p>
	 * (see doc/vistra/adt/11DiGraphs_handout.pdf, page 8)
	 * 
	 * @throws Exception
	 */
	void setViewBack() throws Exception {
		try {
			this.setFontStyle(Font.PLAIN);
			this.setFontColor(ColorPalette.darkgreen);
			this.setLineColor(ColorPalette.darkgreen);
			this.setLineWidth(ItemLayoutConstants.STROKE_WIDTH_BOLD);
			this.setDash(ItemLayoutConstants.E_DASHED);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the layout as forward edge.
	 * <p>
	 * (see doc/vistra/adt/11DiGraphs_handout.pdf, page 8)
	 * 
	 * @throws Exception
	 */
	void setViewForward() throws Exception {
		try {
			this.setFontStyle(Font.PLAIN);
			this.setFontColor(ColorPalette.darkgreen);
			this.setLineColor(ColorPalette.darkgreen);
			this.setLineWidth(ItemLayoutConstants.STROKE_WIDTH_BOLD);
			this.setDash(ItemLayoutConstants.E_DASH_SHORT);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the layout as cross edge.
	 * <p>
	 * (see doc/vistra/adt/11DiGraphs_handout.pdf, page 8)
	 * 
	 * @throws Exception
	 */
	void setViewCross() throws Exception {
		try {
			this.setFontStyle(Font.PLAIN);
			this.setFontColor(ColorPalette.darkgreen);
			this.setLineColor(ColorPalette.darkgreen);
			this.setLineWidth(ItemLayoutConstants.STROKE_WIDTH_BOLD);
			this.setDash(ItemLayoutConstants.E_DASH_POINT);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the layout as discarded edge.
	 * 
	 * @throws Exception
	 */
	void setViewDiscarded() throws Exception {
		try {
			this.setFontStyle(Font.PLAIN);
			this.setFontColor(ColorPalette.darkblue);
			this.setLineColor(ColorPalette.darkblue);
			this.setLineWidth(ItemLayoutConstants.STROKE_WIDTH_BOLD);
			this.setDash(ItemLayoutConstants.E_DASHED);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the layout as solution member edge.
	 * 
	 * @throws Exception
	 */
	void setViewSolution() throws Exception {
		try {
			this.setFontStyle(Font.BOLD);
			this.setFontColor(ColorPalette.GREEN);
			this.setLineColor(ColorPalette.GREEN);
			this.setLineWidth(ItemLayoutConstants.STROKE_WIDTH_BOLD);
			this.setDash(ItemLayoutConstants.E_SOLID);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

}