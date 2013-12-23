package vistra.core.graph.item.vertex;

import vistra.core.graph.GraphFactory;
import vistra.util.ColorPalette;

/**
 * A vertex (state handler).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public class VertexStateHandler implements IVertexStateHandler {

	/**
	 * A field for a vertex state.
	 */
	private AbstractVertexState state;

	/**
	 * A field for a model.
	 */
	private Vertex model;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            a model
	 */
	public VertexStateHandler(IVertex model) {
		this.model = (Vertex) model;
		this.state = new VertexStateUnexplored(this);
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
	 */
	void setState(AbstractVertexState state) throws Exception {
		try {
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
	 */
	void setViewUnexplored() throws Exception {
		try {
			this.model.setFillColor(ColorPalette.orange);
			this.model.setFontColor(ColorPalette.darkblue);
			this.model.setLineColor(ColorPalette.darkblue);
			this.model.setLineWidth(GraphFactory.STROKE_WIDTH_DEFAULT);
			this.model.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the look as focussed -- like 'visited' but with a
	 * kind a 'spot' on the vertex.
	 */
	void setViewFocussed() throws Exception {
		try {
			this.model.setFillColor(ColorPalette.yellow);
			this.model.setFontColor(ColorPalette.darkblue);
			this.model.setLineColor(ColorPalette.red);
			this.model.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.model.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the look as visited.
	 * <p>
	 * (see doc/vistra/adt/10GraphTraversal_handout.pdf, page 11)
	 */
	void setViewVisited() throws Exception {
		try {
			this.model.setFillColor(ColorPalette.blue);
			this.model.setFontColor(ColorPalette.darkblue);
			this.model.setLineColor(ColorPalette.red);
			this.model.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.model.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the look as solution.
	 */
	void setViewSolved() throws Exception {
		try {
			this.model.setFillColor(ColorPalette.white);
			this.model.setFontColor(ColorPalette.green);
			this.model.setLineColor(ColorPalette.green);
			this.model.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.model.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

}
