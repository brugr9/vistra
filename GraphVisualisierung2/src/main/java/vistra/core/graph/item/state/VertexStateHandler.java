package vistra.core.graph.item.state;

import java.awt.Font;
import java.util.ArrayList;

import vistra.core.graph.item.VertexLayout;
import vistra.util.ColorPalette;
import vistra.util.StrokeStyle;

/**
 * A vertex state handler.
 * <p>
 * As being an item state handler, this handler has a cellar at its disposal. It
 * is therefore able to hold the state history of the vertex and handles setting
 * a previous state.
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
			this.setState(new VertexStateUnexplored(this));
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
	public void handleUpdated(int value) throws Exception {
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
	public void handleFocussed() throws Exception {
		try {
			this.state.exit();
			this.state.handleFocussed();
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
	public void handleSolutionMember() throws Exception {
		try {
			this.state.exit();
			this.state.handleSolutionMember();
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
	void setState(AbstractVertexState state) throws Exception {
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
	 * State value setter: Initialises a vertex value.
	 * 
	 * @throws Exception
	 */
	void setValueInitialised() throws Exception {
		try {
			this.setValueUpdated(Integer.MAX_VALUE);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State value setter: Updates a vertex value.
	 * 
	 * @param value
	 *            the value to set
	 * @throws Exception
	 */
	void setValueUpdated(int value) throws Exception {
		try {
			this.setValue(value);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the layout to unexplored vertex.
	 * <p>
	 * (see doc/vistra/adt/10GraphTraversal_handout.pdf, page 11)
	 * 
	 * @throws Exception
	 */
	void setViewUnexplored() throws Exception {
		try {
			if (this.isStart())
				this.setViewFocussed();
			else if (this.isEnd())
				this.setViewSolution();
			else {
				this.setFont(Font.PLAIN);
				this.setFontColor(ColorPalette.darkblue);
				this.setStroke(StrokeStyle.UNEXPLORED.getStorke());
				this.setStrokeColor(ColorPalette.darkblue);
				this.setFillColor(ColorPalette.orange);
				this.notifyObservers();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the layout as focussed vertex -- like 'visited'
	 * but with a kind a 'spot' on the vertex.
	 * 
	 * @throws Exception
	 */
	void setViewFocussed() throws Exception {
		try {
			if (this.isEnd())
				this.setViewSolution();
			else {
				this.setFont(Font.BOLD);
				this.setFontColor(ColorPalette.darkblue);
				this.setStroke(StrokeStyle.VISITED.getStorke());
				this.setStrokeColor(ColorPalette.red);
				this.setFillColor(ColorPalette.orange);
				this.notifyObservers();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the layout as visited vertex.
	 * <p>
	 * (see doc/vistra/adt/10GraphTraversal_handout.pdf, page 11)
	 * 
	 * @throws Exception
	 */
	void setViewVisited() throws Exception {
		try {
			if (this.isStart())
				this.setViewFocussed();
			else if (this.isEnd())
				this.setViewSolution();
			else {
				this.setFont(Font.BOLD);
				this.setFontColor(ColorPalette.darkblue);
				this.setStroke(StrokeStyle.VISITED.getStorke());
				this.setStrokeColor(ColorPalette.red);
				this.setFillColor(ColorPalette.blue);
				this.notifyObservers();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the layout as solution member vertex.
	 * 
	 * @throws Exception
	 */
	void setViewSolution() throws Exception {
		try {
			this.setFont(Font.BOLD);
			this.setFontColor(ColorPalette.green);
			this.setStroke(StrokeStyle.VISITED.getStorke());
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
		if (this.state instanceof VertexStateVisited
				|| this.state instanceof VertexStateSolutionMember)
			return true;
		else if (this.state instanceof VertexStateFocussed)
			return true;
		else
			return false;

	}

}
