package vistra.core.graph.item.state;

import java.util.ArrayList;

import vistra.core.graph.item.VertexLayout;
import vistra.util.ColorPalette;
import vistra.util.FontPalette;
import vistra.util.Sigma;
import vistra.util.StrokePalette;

/**
 * A vertex state handler.
 * <p>
 * As being an item state handler, this handler has a cellar at its disposal. It
 * is therefore able to hold the state history and to set a previous state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see IItemStateHandler
 * @see EdgeStateHandler
 * 
 */
public class VertexStateHandler extends VertexLayout implements
		IVertexStateHandler {

	/**
	 * A field for a state.
	 */
	private AbstractVertexState state;
	/**
	 * A field for a cellar.
	 */
	private ArrayList<AbstractVertexState> cellar;

	/**
	 * Main constructor.
	 */
	public VertexStateHandler() {
		super();
		this.state = null;
		this.cellar = new ArrayList<AbstractVertexState>();
		try {
			this.setState(new UnexploredVertexState(this));
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
	public void handleInitialised() throws Exception {
		try {
			this.state.exit();
			this.state.handleInitialised();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleUpdated(String value) throws Exception {
		try {
			this.state.exit();
			this.state.handleUpdated(value);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleFocusOn() throws Exception {
		try {
			this.state.exit();
			this.state.handleFocusOn();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleVisited() throws Exception {
		try {
			this.state.exit();
			this.state.handleVisited();
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
	 * Sets a state and adds it to the cellar.
	 * 
	 * @param state
	 *            the state to set
	 * @throws Exception
	 */
	void setState(AbstractVertexState state) throws Exception {
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
	 * A layout modifier: Initialises a vertex value.
	 * 
	 * @throws Exception
	 */
	void setLayoutInitialised() throws Exception {
		try {
			this.setLayoutUpdated(Sigma.INFINITY);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A layout modifier: Updates a vertex value.
	 * 
	 * @param value
	 *            the value to set
	 * @throws Exception
	 */
	void setLayoutUpdated(String value) throws Exception {
		try {
			this.setValue(value);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A layout modifier: Sets the layout to unexplored vertex.
	 * <p>
	 * (see doc/vistra/adt/10GraphTraversal_handout.pdf, page 11)
	 * 
	 * @throws Exception
	 */
	void setLayoutUnexplored() throws Exception {
		try {
			if (this.isStart())
				this.setLayoutVisited();
			else if (this.isEnd())
				this.setLayoutVisited();
			else {
				this.setFont(FontPalette.normal);
				this.setFontColor(ColorPalette.darkblue);
				this.setStroke(StrokePalette.unexplored);
				this.setStrokeColor(ColorPalette.darkblue);
				this.setFillColor(ColorPalette.orange);
				this.notifyObservers();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A layout modifier: Sets the layout as focus on vertex -- like 'visited'
	 * but with a kind of a 'spot light' on the vertex.
	 * 
	 * @throws Exception
	 */
	void setLayoutFocusOn() throws Exception {
		try {
			if (this.isEnd())
				this.setLayoutSolution();
			else {
				this.setFont(FontPalette.normal);
				this.setFontColor(ColorPalette.darkblue);
				this.setStroke(StrokePalette.visited);
				this.setStrokeColor(ColorPalette.red);
				this.setFillColor(ColorPalette.citron);
				this.notifyObservers();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A layout modifier: Sets the layout as visited vertex.
	 * <p>
	 * (see doc/vistra/adt/10GraphTraversal_handout.pdf, page 11)
	 * 
	 * @throws Exception
	 */
	void setLayoutVisited() throws Exception {
		try {
			if (this.isStart())
				this.setLayoutFocusOn();
			else if (this.isEnd())
				this.setLayoutSolution();
			else {
				this.setFont(FontPalette.normal);
				this.setFontColor(ColorPalette.darkblue);
				this.setStroke(StrokePalette.visited);
				this.setStrokeColor(ColorPalette.red);
				this.setFillColor(ColorPalette.blue);
				this.notifyObservers();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A layout modifier: Sets the layout as solution member vertex.
	 * 
	 * @throws Exception
	 */
	void setLayoutSolution() throws Exception {
		try {
			this.setFont(FontPalette.emphasised);
			this.setFontColor(ColorPalette.green);
			this.setStroke(StrokePalette.visited);
			this.setStrokeColor(ColorPalette.green);
			this.setFillColor(ColorPalette.white);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A helper method.
	 * 
	 * @return {@code true} if already visited
	 */
	@Override
	public boolean isVisited() {
		// TODO
		if (this.state instanceof UnexploredVertexState
				|| this.state instanceof InitialisedVertexState)
			return false;
		else
			return true;
	}

}
