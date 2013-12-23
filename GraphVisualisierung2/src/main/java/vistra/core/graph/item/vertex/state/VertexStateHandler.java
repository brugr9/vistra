package vistra.core.graph.item.vertex.state;

import java.util.ArrayList;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.Vertex;
import vistra.util.ColorPalette;

/**
 * A vertex state handler.
 * 
 * As being an item state handler, this handler has a cellar able to collect the
 * state history.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexStateHandler implements IVertexStateHandler {

	/**
	 * A field for a state.
	 */
	private AbstractVertexState state;
	/**
	 * A field for states cellar.
	 */
	private ArrayList<AbstractVertexState> cellar;
	/**
	 * A field for a layout.
	 */
	private Vertex layout;

	/**
	 * Main constructor.
	 * 
	 * @param layout
	 *            a layout
	 */
	public VertexStateHandler(IVertex layout) {
		this.layout = (Vertex) layout;
		this.cellar = new ArrayList<AbstractVertexState>();
		this.state = null;
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
			AbstractVertexState state = this.cellar.remove(index);
			this.state = state;
			this.state.entry();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the look to unexplored.
	 * <p>
	 * (see doc/vistra/adt/10GraphTraversal_handout.pdf, page 11)
	 * 
	 * @throws Exception
	 */
	void setViewUnexplored() throws Exception {
		try {
			this.layout.setFillColor(ColorPalette.orange);
			this.layout.setFontColor(ColorPalette.darkblue);
			this.layout.setLineColor(ColorPalette.darkblue);
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_DEFAULT);
			this.layout.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the look as focussed -- like 'visited' but with a
	 * kind a 'spot' on the vertex.
	 * 
	 * @throws Exception
	 */
	void setViewFocussed() throws Exception {
		try {
			this.layout.setFillColor(ColorPalette.yellow);
			this.layout.setFontColor(ColorPalette.darkblue);
			this.layout.setLineColor(ColorPalette.red);
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.layout.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the look as visited.
	 * <p>
	 * (see doc/vistra/adt/10GraphTraversal_handout.pdf, page 11)
	 * 
	 * @throws Exception
	 */
	void setViewVisited() throws Exception {
		try {
			this.layout.setFillColor(ColorPalette.blue);
			this.layout.setFontColor(ColorPalette.darkblue);
			this.layout.setLineColor(ColorPalette.red);
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.layout.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the look as solution.
	 * 
	 * @throws Exception
	 */
	void setViewSolved() throws Exception {
		try {
			this.layout.setFillColor(ColorPalette.white);
			this.layout.setFontColor(ColorPalette.green);
			this.layout.setLineColor(ColorPalette.green);
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.layout.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

}
