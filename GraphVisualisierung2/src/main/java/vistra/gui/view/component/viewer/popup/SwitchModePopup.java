package vistra.gui.view.component.viewer.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.IGuiModel;
import vistra.gui.view.component.viewer.Viewer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;

/**
 * A switch-mode pop-up.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class SwitchModePopup extends JPopupMenu {

	private static final long serialVersionUID = 6897658442329318591L;

	/**
	 * A field for a visualization viewer.
	 */
	private final VisualizationViewer<IVertexLayout, IEdgeLayout> viewer;

	/**
	 * A field for a editing menu item.
	 */
	private JMenuItem editing;
	/**
	 * A field for a editing menu item.
	 */
	private JMenuItem picking;

	/**
	 * Main constructor.
	 * 
	 * @param viewer
	 *            an adapted visualization viewer
	 */
	public SwitchModePopup(Viewer viewer, IGuiModel model) {
		super("modus");
		this.viewer = viewer;

		// TODO i18n
		this.editing = new JMenuItem("editing");
		this.picking = new JMenuItem("picking");
		this.editing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwitchModePopup.this.editingMode();
			}
		});
		this.picking.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwitchModePopup.this.pickingMode();
			}
		});
		this.add(editing);
		this.add(picking);
		this.editing.setEnabled(false);
		this.picking.setEnabled(true);

	}

	/**
	 * Switches to editing mode.
	 */
	@SuppressWarnings("unchecked")
	private void editingMode() {
		((EditingModalGraphMouse<IVertexLayout, IEdgeLayout>) this.viewer
				.getGraphMouse()).setMode(Mode.EDITING);
		this.editing.setEnabled(false);
		this.picking.setEnabled(true);
	}

	/**
	 * Switches to picking mode.
	 */
	@SuppressWarnings("unchecked")
	private void pickingMode() {
		((EditingModalGraphMouse<IVertexLayout, IEdgeLayout>) this.viewer
				.getGraphMouse()).setMode(Mode.PICKING);
		this.editing.setEnabled(true);
		this.picking.setEnabled(false);
	}

}
