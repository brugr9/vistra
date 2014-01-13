package vistra.framework.graph.item.state;

import net.datastructures.NodeStack;
import net.datastructures.Stack;
import vistra.framework.graph.item.EdgeLayout;
import vistra.framework.util.palette.ColorPalette;
import vistra.framework.util.palette.FontPalette;
import vistra.framework.util.palette.StrokePalette;

/**
 * An edge state handler.
 * <p>
 * As being an item state handler, this handler has a stack as cellar at its
 * disposal. It is therefore able to hold the state history and to set a
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
	 * A field for a stack of states.
	 */
	private Stack<AbstractEdgeState> state;

	/**
	 * Main constructor.
	 */
	public EdgeStateHandler() {
		super();
		this.state = new NodeStack<AbstractEdgeState>();
		try {
			this.setState(new UnexploredEdgeState(this));
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
			this.state.top().exit();
			this.state.top().handleUnexplored();
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
			this.state.top().exit();
			this.state.top().handleBack();
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
			this.state.top().exit();
			this.state.top().handleForward();
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
			this.state.top().exit();
			this.state.top().handleCross();
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
			this.state.top().exit();
			this.state.top().handleDiscarded();
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
			this.state.top().exit();
			this.state.top().handleVisited();
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
			this.state.top().exit();
			this.state.top().handleSolution();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handlePreviousState() throws Exception {
		try {
			this.state.top().exit();
			this.state.top().handlePreviousState();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Pushes the state and does the top entry.
	 * 
	 * @param state
	 *            the state to set
	 * @throws Exception
	 */
	void setState(AbstractEdgeState state) throws Exception {
		try {
			this.state.push(state);
			this.state.top().entry();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Pops the previous state and does the top entry.
	 * 
	 * @throws Exception
	 */
	void setPreviousState() throws Exception {
		try {
			this.state.pop();
			this.state.top().entry();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Property: Sets the layout to unexplored-edge.
	 * 
	 * @throws Exception
	 */
	void setPropertyUnexplored() throws Exception {
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
	 * Property: Sets the layout as visited (discovery-edge).
	 * <p>
	 * (see doc/vistra/adt/11DiGraphs_handout.pdf, page 8)
	 * 
	 * @throws Exception
	 */
	void setPropertyVisited() throws Exception {
		try {
			this.setFont(FontPalette.normal);
			this.setFontColor(ColorPalette.red);
			this.setStroke(StrokePalette.visited);
			this.setStrokeColor(ColorPalette.red);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Property: Sets the layout as back-edge.
	 * <p>
	 * (see doc/vistra/adt/11DiGraphs_handout.pdf, page 8)
	 * 
	 * @throws Exception
	 */
	void setPropertyBack() throws Exception {
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
	 * Property: Sets the layout as forward-edge.
	 * <p>
	 * (see doc/vistra/adt/11DiGraphs_handout.pdf, page 8)
	 * 
	 * @throws Exception
	 */
	void setPropertyForward() throws Exception {
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
	 * Property: Sets the layout as cross-edge.
	 * <p>
	 * (see doc/vistra/adt/11DiGraphs_handout.pdf, page 8)
	 * 
	 * @throws Exception
	 */
	void setPropertyCross() throws Exception {
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
	 * Property: Sets the layout as discarded-edge.
	 * 
	 * @throws Exception
	 */
	void setPropertyDiscarded() throws Exception {
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
	 * Property: Sets the layout as solution-member-edge.
	 * 
	 * @throws Exception
	 */
	void setPropertySolution() throws Exception {
		try {
			this.setFont(FontPalette.normal);
			this.setFontColor(ColorPalette.green);
			this.setStroke(StrokePalette.visited);
			this.setStrokeColor(ColorPalette.green);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

}
