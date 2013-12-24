package vistra.core.graph.item.vertex.state;

import java.awt.Font;
import java.util.ArrayList;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.vertex.IVertexLayout;
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
public class VertexStateHandler implements IVertexStateHandler {

	/**
	 * A field for a state.
	 */
	private AbstractVertexState state;
	/**
	 * A field for a cellar.
	 */
	private ArrayList<AbstractVertexState> cellar;
	/**
	 * A field for a layout.
	 */
	private VertexLayout layout;

	/**
	 * Main constructor.
	 * 
	 * @param layout
	 *            a layout
	 */
	public VertexStateHandler(IVertexLayout layout) {
		this.layout = (VertexLayout) layout;
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
	 * State view setter: Sets the layout to unexplored vertex.
	 * <p>
	 * (see doc/vistra/adt/10GraphTraversal_handout.pdf, page 11)
	 * 
	 * @throws Exception
	 */
	void setViewUnexplored() throws Exception {
		try {
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_DEFAULT);
			this.layout.setLineColor(ColorPalette.darkblue);
			this.layout.setFillColor(ColorPalette.orange);
			this.layout.setFontColor(ColorPalette.darkblue);
			this.layout.setFontSyle(Font.PLAIN);
			this.layout.notifyObservers();
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
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.layout.setLineColor(ColorPalette.red);
			this.layout.setFillColor(ColorPalette.yellow);
			this.layout.setFontColor(ColorPalette.darkblue);
			this.layout.setFontSyle(Font.BOLD);
			this.layout.notifyObservers();
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
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.layout.setLineColor(ColorPalette.red);
			this.layout.setFillColor(ColorPalette.blue);
			this.layout.setFontColor(ColorPalette.darkblue);
			this.layout.setFontSyle(Font.BOLD);
			this.layout.notifyObservers();
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
			this.layout.setLineWidth(GraphFactory.STROKE_WIDTH_BOLD);
			this.layout.setLineColor(ColorPalette.green);
			this.layout.setFillColor(ColorPalette.white);
			this.layout.setFontColor(ColorPalette.green);
			this.layout.setFontSyle(Font.BOLD);
			this.layout.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

}
