package vistra.gui.view.component.viewer.popup.verifier;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

import vistra.core.graph.IExtendedGraph;
import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.IVertexLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A graph item identifier verifier.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class GraphItemIdVerifier extends AbstractVerifier {

	/**
	 * A field for a graph item.
	 */
	private final IItemLayout item;
	/**
	 * A field for a graph.
	 */
	private final Graph<IVertexLayout, IEdgeLayout> graph;

	/**
	 * Main constructor.
	 * 
	 * @param lastGood
	 * @param item
	 *            a graph item
	 * @param vv
	 *            a visualization viewer
	 */
	public GraphItemIdVerifier(String lastGood, IItemLayout item,
			VisualizationViewer<IVertexLayout, IEdgeLayout> vv) {
		super(lastGood);
		this.item = item;
		this.graph = vv.getGraphLayout().getGraph();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verify(JComponent input) {

		if (input instanceof JTextComponent) {
			JTextComponent textField = (JTextComponent) input;
			IExtendedGraph graph = (IExtendedGraph) this.graph;

			return !textField.getText().trim().isEmpty()
					&& (textField.getText().equals(
							((IItemLayout) this.item).getId()) || graph
							.unused(textField.getText().trim()));
		}

		return false;
	}

}