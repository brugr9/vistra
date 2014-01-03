package vistra.core.graph.item.state;

import java.util.ArrayList;

import vistra.core.graph.item.EdgeLayout;
import vistra.util.ColorPalette;
import vistra.util.FontPalette;
import vistra.util.StrokePalette;

/**
 * An edge state handler.
 * <p>
 * As being an item state handler, this handler has a cellar at its disposal. It
 * is therefore able to hold the state history and to set a previous state.
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
	public void handleDiscoveryEdge() throws Exception {
		try {
			this.state.exit();
			this.state.handleDiscoveryEdge();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleBackEdge() throws Exception {
		try {
			this.state.exit();
			this.state.handleBackEdge();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleForwardEdge() throws Exception {
		try {
			this.state.exit();
			this.state.handleForwardEdge();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleCrossEdge() throws Exception {
		try {
			this.state.exit();
			this.state.handleCrossEdge();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleDiscardedEdge() throws Exception {
		try {
			this.state.exit();
			this.state.handleDiscardedEdge();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleSolutionMember() throws Exception {
		try {
			this.state.exit();
			this.state.handleSolutionMember();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Sets a state and adds it to the cellar.
	 * 
	 * @param state
	 *            the state to set
	 * @throws Exception
	 */
	void setState(AbstractEdgeState state) throws Exception {
		try {
			this.state = state;
			this.state.entry();
			// begin cellar
			this.cellar.add(state);
			// end cellar
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPreviousState() throws Exception {
		try {
			this.state.exit();
			// begin cellar
			int index = this.cellar.size() - 1;
			this.state = this.cellar.remove(index);
			// end cellar
			this.state.entry();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A layout modifier: Sets the layout to unexplored-edge.
	 * 
	 * @throws Exception
	 */
	void setLayoutUnexplored() throws Exception {
		try {
			this.setFont(FontPalette.normal);
			this.setFontColor(ColorPalette.darkblue);
			this.setStroke(StrokePalette.unexplored);
			this.setStrokeColor(ColorPalette.darkblue);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A layout modifier: Sets the layout as discovery-edge.
	 * <p>
	 * (see doc/vistra/adt/11DiGraphs_handout.pdf, page 8)
	 * 
	 * @throws Exception
	 */
	void setLayoutDiscovery() throws Exception {
		try {
			this.setFont(FontPalette.emphasised);
			this.setFontColor(ColorPalette.red);
			this.setStroke(StrokePalette.visited);
			this.setStrokeColor(ColorPalette.red);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A layout modifier: Sets the layout as back-edge.
	 * <p>
	 * (see doc/vistra/adt/11DiGraphs_handout.pdf, page 8)
	 * 
	 * @throws Exception
	 */
	void setLayoutBack() throws Exception {
		try {
			this.setFont(FontPalette.normal);
			this.setFontColor(ColorPalette.darkgreen);
			this.setStroke(StrokePalette.back);
			this.setStrokeColor(ColorPalette.darkgreen);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A layout modifier: Sets the layout as forward-edge.
	 * <p>
	 * (see doc/vistra/adt/11DiGraphs_handout.pdf, page 8)
	 * 
	 * @throws Exception
	 */
	void setLayoutForward() throws Exception {
		try {
			this.setFont(FontPalette.normal);
			this.setFontColor(ColorPalette.darkgreen);
			this.setStroke(StrokePalette.forward);
			this.setStrokeColor(ColorPalette.darkgreen);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A layout modifier: Sets the layout as cross-edge.
	 * <p>
	 * (see doc/vistra/adt/11DiGraphs_handout.pdf, page 8)
	 * 
	 * @throws Exception
	 */
	void setLayoutCross() throws Exception {
		try {
			this.setFont(FontPalette.normal);
			this.setFontColor(ColorPalette.darkgreen);
			this.setStroke(StrokePalette.cross);
			this.setStrokeColor(ColorPalette.darkgreen);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A layout modifier: Sets the layout as discarded-edge.
	 * 
	 * @throws Exception
	 */
	void setLayoutDiscarded() throws Exception {
		try {
			this.setFont(FontPalette.normal);
			this.setFontColor(ColorPalette.darkblue);
			this.setStroke(StrokePalette.discarded);
			this.setStrokeColor(ColorPalette.darkblue);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A layout modifier: Sets the layout as solution-member-edge.
	 * 
	 * @throws Exception
	 */
	void setLayoutSolutionMember() throws Exception {
		try {
			this.setFont(FontPalette.emphasised);
			this.setFontColor(ColorPalette.green);
			this.setStroke(StrokePalette.visited);
			this.setStrokeColor(ColorPalette.green);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

}
