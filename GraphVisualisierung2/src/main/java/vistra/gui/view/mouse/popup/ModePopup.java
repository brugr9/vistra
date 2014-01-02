package vistra.gui.view.mouse.popup;

import static vistra.gui.control.IControl.EventSource.I18N;
import static vistra.gui.control.IControl.EventSource.MODE;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;

import vistra.gui.IGuiModel;

/**
 * A mode pop-up.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ModalGraphMouse
 */
public class ModePopup extends JPopupMenu implements Observer {

	private static final long serialVersionUID = 6897658442329318591L;

	/**
	 * A field for an editing menu item.
	 */
	private JMenuItem editing;
	/**
	 * A field for a picking menu item.
	 */
	private JMenuItem picking;

	/**
	 * Main constructor.
	 */
	public ModePopup(IGuiModel model) {
		super();
		this.picking = new JMenuItem("picking");
		this.editing = new JMenuItem("editing");
		this.picking.addActionListener(model.getModeListener());
		this.editing.addActionListener(model.getModeListener());
		this.picking.setActionCommand(Mode.PICKING.toString());
		this.editing.setActionCommand(Mode.EDITING.toString());
		this.add(picking);
		this.add(editing);
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
				this.picking.setText(b.getString("picking.label"));
				this.editing.setText(b.getString("edit.label"));
			}
			if (arg == MODE) {
				this.picking.setEnabled(m.isPickingEnabled());
				this.editing.setEnabled(m.isEditingEnabled());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}
}
