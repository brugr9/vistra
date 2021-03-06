package vistra.framework.graph.item.state;

import net.datastructures.NodeStack;
import net.datastructures.Stack;
import vistra.framework.graph.item.LayoutVertex;
import vistra.framework.graph.ml.GraphWriter;
import vistra.framework.util.palette.ColorPalette;
import vistra.framework.util.palette.FontPalette;
import vistra.framework.util.palette.SigmaPalette;
import vistra.framework.util.palette.StrokePalette;

/**
 * A vertex state handler.
 * <p>
 * As being an item state handler, this handler has a stack as cellar at its
 * disposal. It is therefore able to hold the state history and to set a
 * previous state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see IItemStateHandler
 * @see EdgeStateHandler
 * 
 */
public class VertexStateHandler extends LayoutVertex implements
		IVertexStateHandler {

	/**
	 * A field for a stack of states.
	 */
	private Stack<AbstractVertexState> stateStack;

	/**
	 * Main constructor.
	 */
	public VertexStateHandler() {
		super();
		this.stateStack = new NodeStack<AbstractVertexState>();
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
			this.stateStack.top().exit();
			this.stateStack.top().handleUnexplored();
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
			this.stateStack.top().exit();
			this.stateStack.top().handleInitialised();
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
			this.stateStack.top().exit();
			this.stateStack.top().handleUpdated(value);
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
			this.stateStack.top().exit();
			this.stateStack.top().handleVisited();
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
			this.stateStack.top().exit();
			this.stateStack.top().handleSolution();
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
			this.stateStack.top().exit();
			this.stateStack.top().handlePreviousState();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Sets the state and does the entry.
	 * 
	 * @param state
	 *            the state to set
	 * @throws Exception
	 */
	void setState(AbstractVertexState state) throws Exception {
		try {
			this.stateStack.push(state);
			this.stateStack.top().entry();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Sets the previous state and does the entry.
	 * 
	 * @throws Exception
	 */
	void setPreviousState() throws Exception {
		try {
			this.stateStack.pop();
			this.stateStack.top().entry();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Property: Initializes a vertex value.
	 * 
	 * Extends setLayoutUpdated() by setting a value for infinity.
	 * 
	 * @throws Exception
	 */
	void setPropertyInitialised() throws Exception {
		try {
			this.setPropertyUpdated(SigmaPalette.infinity);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Property: Updates a vertex value.
	 * 
	 * @param value
	 *            the value to set
	 * @throws Exception
	 */
	void setPropertyUpdated(String value) throws Exception {
		try {
			this.setValue(value);
			this.setVisited(false);
			this.setFont(FontPalette.normal);
			this.setFontColor(ColorPalette.darkblue);
			this.setStroke(StrokePalette.unexplored);
			this.setStrokeColor(ColorPalette.darkblue);
			if (this.isEnd())
				this.setFillColor(ColorPalette.blue);
			else
				this.setFillColor(ColorPalette.orange);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Property: Sets the layout to unexplored vertex.
	 * <p>
	 * (see doc/vistra/adt/10GraphTraversal_handout.pdf, page 11)
	 * 
	 * @throws Exception
	 */
	void setPropertyUnexplored() throws Exception {
		try {
			this.setValue(GraphWriter.V_VALUE_DEFAULT);
			this.setVisited(false);
			this.setFont(FontPalette.normal);
			this.setFontColor(ColorPalette.darkblue);
			this.setStroke(StrokePalette.unexplored);
			this.setStrokeColor(ColorPalette.darkblue);
			this.setFillColor(ColorPalette.orange);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Property: Sets the layout as focus on vertex -- like 'visited' but with a
	 * kind of a 'spot light' on the vertex.
	 * 
	 * Extends setLayoutVisited() by setFillColor with a different color.
	 * 
	 * @throws Exception
	 */
	void setPropertyFocusOn() throws Exception {
		try {
			this.setPropertyVisited();
			this.setFillColor(ColorPalette.citron);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Property: Sets the layout as visited vertex.
	 * <p>
	 * (see doc/vistra/adt/10GraphTraversal_handout.pdf, page 11)
	 * 
	 * @throws Exception
	 */
	void setPropertyVisited() throws Exception {
		try {
			this.setVisited(true);
			this.setFont(FontPalette.normal);
			this.setFontColor(ColorPalette.darkblue);
			this.setStroke(StrokePalette.visited);
			this.setStrokeColor(ColorPalette.cherry);
			this.setFillColor(ColorPalette.blue);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Property: Sets the layout as solution member vertex.
	 * 
	 * @throws Exception
	 */
	void setPropertySolutionMember() throws Exception {
		try {
			this.setVisited(true);
			this.setFont(FontPalette.normal);
			this.setFontColor(ColorPalette.darkgrey);
			this.setStroke(StrokePalette.visited);
			this.setStrokeColor(ColorPalette.apple);
			this.setFillColor(ColorPalette.white);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

}
