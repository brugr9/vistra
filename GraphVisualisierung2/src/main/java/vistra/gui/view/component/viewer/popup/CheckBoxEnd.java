package vistra.gui.view.component.viewer.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.IGuiModel;
import vistra.gui.control.IControl.EventSource;
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
	 * @param model
	 *            the gui model
	 */
	protected CheckBoxEnd(
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			IGuiModel model) {
		super(viewer, model.getResourceBundle().getString("finish.label"),
				model);
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CheckBoxEnd.this.setValue();
			}
		});
		this.setActionCommand(EventSource.FINISH.toString());
		this.addActionListener(model.getParameterStateHandler());
	}

	/**
	 * Sets the value.
	 */
	private void setValue() {
		if (this.vertex != null) {
			/* End */
			if (this.isSelected()) {
				IVertexLayout previousEnd = this.model.getEnd();
				if (previousEnd != this.vertex) {
					if (previousEnd != null)
						previousEnd.setEnd(false);
					this.model.setEnd(this.vertex);
				}
			}
			/* Start */
			if (this.isSelected() && this.vertex.isStart()) {
				this.vertex.setStart(false);
				this.model.setStart(null);
			}
			/**/
			this.vertex.setEnd(this.isSelected());
			this.viewer.repaint();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraphItemAndView(IItemLayout item) {
		if (item instanceof IVertexLayout) {
			this.vertex = (IVertexLayout) item;
			this.setSelected(this.vertex.isEnd());
		}
	}

}
