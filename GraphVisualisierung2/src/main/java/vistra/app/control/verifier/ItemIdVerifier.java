package vistra.app.control.verifier;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

import vistra.framework.graph.ILayoutGraph;
import vistra.framework.graph.item.ILayoutEdge;
import vistra.framework.graph.item.ILayoutItem;
import vistra.framework.graph.item.ILayoutVertex;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A graph item identifier verifier.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class ItemIdVerifier extends AbstractVerifier {

	/**
	 * A field for an item.
	 */
	private final ILayoutItem item;
	/**
	 * A field for a graph.
	 */
	private final ILayoutGraph graph;

	/**
	 * Main constructor.
	 * 
	 * @param lastGood
	 *            the last good
	 * @param item
	 *            a graph item
	 * @param viewer
	 *            a visualization viewer
	 */
	public ItemIdVerifier(String lastGood, ILayoutItem item,
			VisualizationViewer<ILayoutVertex, ILayoutEdge> viewer) {
		super(lastGood);
		this.item = item;
		this.graph = (ILayoutGraph) viewer.getGraphLayout().getGraph();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verify(JComponent input) {
		if (input instanceof JTextComponent) {
			String text = ((JTextComponent) input).getText().trim();
			return !text.isEmpty()
					&& (text.equals(this.item.getId()) || this.graph
							.unusedId(text));
		}
		return false;
	}

}