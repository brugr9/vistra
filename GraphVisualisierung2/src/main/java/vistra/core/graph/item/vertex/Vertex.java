package vistra.core.graph.item.vertex;

import vistra.core.graph.GraphFactory;
import vistra.util.ColorPalette;

/**
 * A vertex (state handler).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public class Vertex extends AbstractVertexModel implements IVertex {

	/**
	 * A field for a vertex state.
	 */
	private AbstractVertexState state;

	/**
	 * Main constructor.
	 * 
	 */
	public Vertex() {
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
	public void handleVisit() throws Exception {
		try {
			this.state.exit();
			this.state.handleVisit();
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
			this.setFillColor(ColorPalette.orange);
			this.setFontColor(ColorPalette.darkblue);
			this.setLineColor(ColorPalette.darkblue);
			this.setLineWidth(GraphFactory.STROKE_WIDTH_DEFAULT);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the look as visit -- like 'visited' but with a
	 * kind of 'spot' on the vertex.
	 */
	void setViewVisit() throws Exception {
		try {
			this.setFillColor(ColorPalette.yellow);
			this.setFontColor(ColorPalette.darkblue);
			this.setLineColor(ColorPalette.red);
			this.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
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
			this.setFillColor(ColorPalette.blue);
			this.setFontColor(ColorPalette.darkblue);
			this.setLineColor(ColorPalette.red);
			this.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the look as solution.
	 */
	void setViewSolved() throws Exception {
		try {
			this.setFillColor(ColorPalette.white);
			this.setFontColor(ColorPalette.green);
			this.setLineColor(ColorPalette.green);
			this.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
		} catch (Exception e) {
			throw e;
		}
	}

}
