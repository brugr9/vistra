package vistra.core.graph.item.vertex.state;

import java.awt.Font;
import java.util.ArrayList;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.VertexLayout;
import vistra.util.ColorPalette;

/**
 * A vertex state handler.
 * 
 * As being an item state handler, this handler has a cellar at it's disposal
 * and is therefore able to hold the state history therefore.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
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
	 * 
	 * @param vertex
	 *            a vertex
	 */
	public VertexStateHandler(IVertex vertex) {
		super((VertexLayout) vertex);
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
	 * State view setter: Sets the layout to unexplored vertex.
	 * <p>
	 * (see doc/vistra/adt/10GraphTraversal_handout.pdf, page 11)
	 * 
	 * @throws Exception
	 */
	void setViewUnexplored() throws Exception {
		try {
			this.setLineWidth(GraphFactory.STROKE_WIDTH_DEFAULT);
			this.setLineColor(ColorPalette.darkblue);
			this.setFillColor(ColorPalette.orange);
			this.setFontColor(ColorPalette.darkblue);
			this.setFontSyle(Font.PLAIN);
			this.notifyObservers();
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
			this.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.setLineColor(ColorPalette.red);
			this.setFillColor(ColorPalette.yellow);
			this.setFontColor(ColorPalette.darkblue);
			this.setFontSyle(Font.BOLD);
			this.notifyObservers();
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
			this.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.setLineColor(ColorPalette.red);
			this.setFillColor(ColorPalette.blue);
			this.setFontColor(ColorPalette.darkblue);
			this.setFontSyle(Font.BOLD);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Sets the layout as solution member vertex.
	 * 
	 * @throws Exception
	 */
	void setViewSolved() throws Exception {
		try {
			this.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.setLineColor(ColorPalette.green);
			this.setFillColor(ColorPalette.white);
			this.setFontColor(ColorPalette.green);
			this.setFontSyle(Font.BOLD);
			this.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

}
