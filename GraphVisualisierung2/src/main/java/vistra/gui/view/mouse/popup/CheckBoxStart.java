package vistra.gui.view.mouse.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.IGuiModel;
import vistra.gui.control.IControl.EventSource;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A check box for setting a start vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class CheckBoxStart extends AbstarctCheckBox implements IItemModifier {

	private static final long serialVersionUID = 6641658478963193492L;

	/**
	 * Main constructor.
	 * 
	 * @param viewer
	 *            a visualization viewer
	 * @param model
	 *            the gui model
	 */
	protected CheckBoxStart(
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			IGuiModel model) {
		super(viewer, model.getResourceBundle().getString("start.label"), model);
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CheckBoxStart.this.setValue();
			}
		});
		this.setActionCommand(EventSource.START.toString());
		this.addActionListener(model.getParameterStateHandler());
	}

	/**
	 * Sets the value.
	 */
	private void setValue() {
		if (this.vertex != null) {
			/* Start */
			if (this.isSelected()) {
				IVertexLayout previousStart = this.model.getStart();
				if (previousStart != this.vertex) {
					if (previousStart != null)
						previousStart.setStart(false);
					this.model.setStart(this.vertex);
				}
			}
			/* End */
			if (this.isSelected() && this.vertex.isEnd()) {
				this.vertex.setEnd(false);
				this.model.setEnd(null);
			}
			/**/
			this.vertex.setStart(this.isSelected());
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
			this.setSelected(this.vertex.isStart());
		}
	}

}
