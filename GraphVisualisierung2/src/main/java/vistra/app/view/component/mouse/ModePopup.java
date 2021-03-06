package vistra.app.view.component.mouse;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import vistra.app.IModel;
import vistra.app.Model;
import vistra.app.control.ActionListenerI18n.I18nEvent;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;

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
	 * 
	 * @param model
	 *            a gui model
	 */
	public ModePopup(IModel model) {
		super();
		this.picking = new JMenuItem("picking");
		this.editing = new JMenuItem("editing");
		//
		this.picking.addActionListener(((Model) model).getParameterStateHandler());
		this.editing.addActionListener(((Model) model).getParameterStateHandler());
		//
		this.picking.setActionCommand(Mode.PICKING.toString());
		this.editing.setActionCommand(Mode.EDITING.toString());
		//
		this.add(picking);
		this.add(editing);
	}

	/**
	 * Updates the pop-up.
	 */
	@Override
	public void update(Observable o, Object arg) {

		IModel m = (Model) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			if (arg == I18nEvent.I18N) {
				this.picking.setText(b.getString("picking.label"));
				this.editing.setText(b.getString("edit.label"));
			} else {
				this.picking.setEnabled(m.isSelectPickingModeEnabled());
				this.editing.setEnabled(m.isSelectEditingModeEnabled());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}
}
