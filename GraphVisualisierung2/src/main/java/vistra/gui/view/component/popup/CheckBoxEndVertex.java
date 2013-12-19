package vistra.gui.view.component.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vistra.core.graph.zobsolete.item.IGraphItem;
import vistra.core.graph.zobsolete.item.edge.IEdge;
import vistra.core.graph.zobsolete.item.vertex.IVertex;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A check box for setting an end vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class CheckBoxEndVertex extends AbstarctCheckBox implements IItemModifier {

	private static final long serialVersionUID = 6641658478963193492L;

	/**
	 * Main constructor.
	 * 
	 * @param viewer
	 *            a visualization viewer
	 */
	protected CheckBoxEndVertex(VisualizationViewer<IVertex, IEdge> viewer) {
		super(viewer, "End");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CheckBoxEndVertex.this.setValue();
			}
		});
	}

	/**
	 * Sets the value.
	 */
	private void setValue() {
		if (this.vertex != null) {
			this.vertex.setEnd(this.isSelected());
			this.viewer.repaint();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraphItemAndView(IGraphItem item) {
		if (item instanceof IVertex) {
			this.vertex = (IVertex) item;
			this.setSelected(this.vertex.isEnd());
		}
	}

}
