package vistra.gui.view.component.viewer.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vistra.core.graph.item.ILayoutItem;
import vistra.core.graph.item.edge.ILayoutEdge;
import vistra.core.graph.item.vertex.ILayoutVertex;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A check box for setting an end vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class CheckBoxEnd extends AbstarctCheckBox implements IItemModifier {

	private static final long serialVersionUID = 6641658478963193492L;

	/**
	 * Main constructor.
	 * 
	 * @param viewer
	 *            a visualization viewer
	 */
	protected CheckBoxEnd(VisualizationViewer<ILayoutVertex, ILayoutEdge> viewer) {
		super(viewer, "End");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CheckBoxEnd.this.setValue();
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
	public void setGraphItemAndView(ILayoutItem item) {
		if (item instanceof ILayoutVertex) {
			this.vertex = (ILayoutVertex) item;
			this.setSelected(this.vertex.isEnd());
		}
	}

}
