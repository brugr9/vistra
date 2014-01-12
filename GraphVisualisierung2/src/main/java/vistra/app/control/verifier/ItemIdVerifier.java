package vistra.app.control.verifier;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

import vistra.framework.graph.IExtendedGraph;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IItemLayout;
import vistra.framework.graph.item.IVertexLayout;
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
	private final IItemLayout item;
	/**
	 * A field for a graph.
	 */
	private final IExtendedGraph graph;

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
	public ItemIdVerifier(String lastGood, IItemLayout item,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer) {
		super(lastGood);
		this.item = item;
		this.graph = (IExtendedGraph) viewer.getGraphLayout().getGraph();
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