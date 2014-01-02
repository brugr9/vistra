package vistra.gui.view.mouse.popup;

import static vistra.gui.control.IControl.EventSource.I18N;
import static vistra.gui.control.IControl.EventSource.EDIT_GRAPH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.ResourceBundle;

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
 * An edge pop-up menu.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgePopup extends JPopupMenu implements IItemPopup {

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
	 * A field for a edge.
	 */
	private IEdgeLayout edge;
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
	public EdgePopup(JFrame top,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			IGuiModel model) {
		super("vertexPopup");
		this.viewer = viewer;
		this.model = (GuiModel) model;
		this.point = null;
		this.edge = null;
		/**/
		this.property = new JMenuItem("property");
		this.setRootFrame(top);
		//
		this.delete = new JMenuItem("delete");
		this.delete.setActionCommand(EDIT_GRAPH.toString());
		this.delete.addActionListener(model.getParameterStateHandler());
		this.delete.addActionListener(new DeleteActionListener());

		/**/
		this.add(this.property);
		this.addSeparator();
		this.add(this.delete);
	}

	/**
	 * @param rootFrame
	 */
	protected void setRootFrame(final JFrame top) {
		this.property.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EdgePopup.this.showDialog(top);
			}
		});
	}

	/**
	 * Shows the dialog.
	 * 
	 * @param owner
	 */
	private void showDialog(JFrame owner) {
		if (this.point != null && this.edge != null) {
			EdgeDialog dialog = new EdgeDialog(this.edge, owner, this.viewer,
					this.model);
			dialog.setLocation((int) this.point.getX() + owner.getX(),
					(int) this.point.getY() + owner.getY());
			dialog.setVisible(true);
		}
	}

	/**
	 * Deletes the item.
	 */
	private void delete() {
		if (this.edge != null) {
			this.viewer.getPickedEdgeState().pick(this.edge, false);
			this.viewer.getGraphLayout().getGraph().removeEdge(this.edge);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setItem(IItemLayout item) {
		if (item instanceof IVertexLayout) {
			this.edge = (IEdgeLayout) item;
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
				this.setLabel(b.getString("edge.label"));
				this.property.setText(b.getString("edit.label"));
				this.delete.setText(b.getString("delete.label"));
			}
			/**/
			this.setEnabled(m.isEditEnabled());
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
	private class DeleteActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			EdgePopup.this.delete();
		}
	}

}
