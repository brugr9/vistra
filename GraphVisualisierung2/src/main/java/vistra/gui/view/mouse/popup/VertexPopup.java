package vistra.gui.view.mouse.popup;

import static vistra.gui.control.IControl.EventSource.I18N;
import static vistra.gui.control.IControl.EventSource.EDIT_GRAPH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.GuiModel;
import vistra.gui.IGuiModel;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A vertex pop-up menu.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexPopup extends JPopupMenu implements IItemPopup {

	private static final long serialVersionUID = 3273304014704565148L;

	/**
	 * A field for a visualization viewer.
	 */
	private final VisualizationViewer<IVertexLayout, IEdgeLayout> viewer;
	/**
	 * A field for a model.
	 */
	private GuiModel model;
	/**
	 * A field for a point.
	 */
	private Point2D point;
	/**
	 * A field for a vertex.
	 */
	private IVertexLayout vertex;
	/**
	 * A field for a start check box.
	 */
	private JCheckBoxMenuItem start;
	/**
	 * A field for an end check box.
	 */
	private JCheckBoxMenuItem end;
	/**
	 * A field for a property menu item.
	 */
	private JMenuItem property;
	/**
	 * A field for a delete menu item.
	 */
	private JMenuItem delete;

	/**
	 * Main constructor.
	 * 
	 * @param top
	 *            the top frame
	 * @param viewer
	 *            the visualization viewer
	 * @param model
	 *            the gui model
	 */
	public VertexPopup(JFrame top,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			IGuiModel model) {
		super("vertexPopup");
		this.viewer = viewer;
		this.model = (GuiModel) model;
		this.point = null;
		this.vertex = null;
		/**/
		this.start = new JCheckBoxMenuItem("start");
		this.start.setActionCommand(EDIT_GRAPH.toString());
		this.start.addActionListener(model.getParameterStateHandler());
		this.start.addActionListener(new StartActionListener());
		//
		this.end = new JCheckBoxMenuItem("end");
		this.end.setActionCommand(EDIT_GRAPH.toString());
		this.end.addActionListener(model.getParameterStateHandler());
		this.end.addActionListener(new EndActionListener());
		//
		this.property = new JMenuItem("property");
		this.setRootFrame(top);
		//
		this.delete = new JMenuItem("delete");
		this.delete.setActionCommand(EDIT_GRAPH.toString());
		this.delete.addActionListener(model.getParameterStateHandler());
		this.delete.addActionListener(new DeleteActionListener());

		/**/
		this.add(this.start);
		this.add(this.end);
		this.addSeparator();
		this.add(this.property);
		this.addSeparator();
		this.add(this.delete);
	}

	/**
	 * Sets the start value.
	 */
	private void setStart() {
		if (this.vertex != null) {
			if (this.start.isSelected()) {
				IVertexLayout previousStart = this.model.getStart();
				if (previousStart != null)
					previousStart.setStart(false);
				this.model.setStart(this.vertex);

				if (this.vertex.isEnd()) {
					this.vertex.setEnd(false);
					this.model.setEnd(null);
				}
			}
			this.vertex.setStart(this.start.isSelected());
		}
	}

	/**
	 * Sets the end value.
	 */
	private void setEnd() {
		if (this.vertex != null) {
			if (this.end.isSelected()) {
				IVertexLayout previousEnd = this.model.getEnd();
				if (previousEnd != null)
					previousEnd.setEnd(false);
				this.model.setEnd(this.vertex);

				if (this.vertex.isStart()) {
					this.vertex.setStart(false);
					this.model.setStart(null);
				}
			}
			this.vertex.setEnd(this.end.isSelected());
		}
	}

	/**
	 * @param rootFrame
	 */
	protected void setRootFrame(final JFrame top) {
		this.property.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VertexPopup.this.showDialog(top);
			}
		});
	}

	/**
	 * Shows the dialog.
	 * 
	 * @param owner
	 */
	private void showDialog(JFrame owner) {
		if (this.point != null && this.vertex != null) {
			VertexDialog dialog = new VertexDialog(this.vertex, owner,
					this.viewer, this.model);
			dialog.setLocation((int) this.point.getX() + owner.getX(),
					(int) this.point.getY() + owner.getY());
			dialog.setVisible(true);
		}
	}

	/**
	 * Deletes the item.
	 */
	private void delete() {
		if (this.vertex != null) {
			this.viewer.getPickedVertexState().pick(this.vertex, false);
			this.viewer.getGraphLayout().getGraph().removeVertex(this.vertex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setItem(IItemLayout item) {
		if (item instanceof IVertexLayout) {
			this.vertex = (IVertexLayout) item;
			this.start.setSelected(this.vertex.isStart());
			this.end.setSelected(this.vertex.isEnd());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setItemLocation(Point2D point) {
		if (point != null) {
			this.point = point;
		}
	}

	/**
	 * Updates the pop-up.
	 */
	@Override
	public void update(Observable o, Object arg) {

		IGuiModel m = (IGuiModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			if (arg == I18N) {
				this.setLabel(b.getString("vertex.label"));
				this.start.setText(b.getString("start.label"));
				this.end.setText(b.getString("finish.label"));
				this.property.setText(b.getString("edit.label"));
				this.delete.setText(b.getString("delete.label"));
			}
			/**/
			this.setEnabled(m.isEditEnabled());
			this.start.setEnabled(m.isEditEnabled());
			this.end.setEnabled(m.isEditEnabled());
			this.property.setEnabled(m.isEditEnabled());
			this.delete.setEnabled(m.isEditEnabled());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private class StartActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			VertexPopup.this.setStart();
		}
	}

	/**
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private class EndActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			VertexPopup.this.setEnd();
		}
	}

	/**
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private class DeleteActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			VertexPopup.this.delete();
		}
	}

}