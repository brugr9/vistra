package vistra.app.view.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import vistra.app.IModel;
import vistra.app.Model;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IItemLayout;
import vistra.framework.graph.item.IVertexLayout;
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
	 * A field for a top frame.
	 */
	private JFrame top;
	/**
	 * A field for a visualization viewer.
	 */
	private final VisualizationViewer<IVertexLayout, IEdgeLayout> viewer;
	/**
	 * A field for a model.
	 */
	private Model model;
	/**
	 * A field for a point.
	 */
	private Point2D point;
	/**
	 * A field for a edge.
	 */
	private IEdgeLayout edge;
	/**
	 * A field for a dialog menu item.
	 */
	private JMenuItem dialog;
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
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer, IModel model) {
		super("edgePopup");
		/**/
		this.top = top;
		this.viewer = viewer;
		this.model = (Model) model;
		this.point = null;
		this.edge = null;
		/**/
		this.dialog = new JMenuItem("dialog");
		this.dialog.addActionListener(new DialogActionListener());
		this.delete = new JMenuItem("delete");
		this.delete.addActionListener(new DeleteActionListener());
		/**/
		this.add(this.dialog);
		this.addSeparator();
		this.add(this.delete);
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
	public void setPopupLocation(Point2D point) {
		if (point != null)
			this.point = point;
	}

	/**
	 * Updates the pop-up.
	 */
	@Override
	public void update(Observable o, Object arg) {

		IModel m = (IModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			// if (arg == ControlNotify.I18N) {
			this.setLabel(b.getString("edge.label"));
			this.dialog.setText(b.getString("edit.label"));
			this.delete.setText(b.getString("delete.label"));

			// } else {
			this.setEnabled(m.isEditEdgeEnabled());
			this.dialog.setEnabled(m.isEditEdgeEnabled());
			this.delete.setEnabled(m.isEditEdgeEnabled());
			// }
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
	private class DialogActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (point != null && edge != null) {
				EdgeDialog dialog = new EdgeDialog(top, viewer, model, edge);
				dialog.setLocation((int) point.getX() + top.getX(),
						(int) point.getY() + top.getY());
				dialog.setVisible(true);
			}
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
			if (edge != null) {
				viewer.getPickedEdgeState().pick(edge, false);
				viewer.getGraphLayout().getGraph().removeEdge(edge);
			}
		}
	}

}
