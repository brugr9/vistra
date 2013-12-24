package vistra.gui.view.component.viewer.popup.verifier;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

import vistra.core.graph.IGraphLayout;
import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.edge.IEdgeLayout;
import vistra.core.graph.item.vertex.IVertexLayout;
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
	private final IItemLayout graphItem;
	/**
	 * A field for a graph.
	 */
	private final Graph<IVertexLayout, IEdgeLayout> graph;

	/**
	 * Main constructor.
	 * 
	 * @param lastGood
	 * @param graphItem
	 *            a graph item
	 * @param vViewer
	 *            a visualization viewer
	 */
	public GraphItemIdVerifier(String lastGood, IItemLayout graphItem,
			VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer) {
		super(lastGood);
		this.graphItem = graphItem;
		this.graph = vViewer.getGraphLayout().getGraph();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verify(JComponent input) {

		if (input instanceof JTextComponent) {
			JTextComponent textField = (JTextComponent) input;
			IGraphLayout graph = (IGraphLayout) this.graph;

			return !textField.getText().trim().isEmpty()
					&& (textField.getText().equals(
							((IItemLayout) this.graphItem).getId()) || graph
							.unused(textField.getText().trim()));
		}

		return false;
	}

}