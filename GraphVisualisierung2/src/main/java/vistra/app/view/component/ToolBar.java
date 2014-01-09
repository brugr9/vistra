package vistra.app.view.component;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import vistra.app.IModel;
import vistra.app.control.IControl.ControlEvent;

/**
 * A tool bar.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class ToolBar extends JToolBar implements Observer {

	private static final long serialVersionUID = 6258055836589992888L;

	/**
	 * A field for a button 'new undirected graph'.
	 */
	private final JButton newUndirected;
	/**
	 * A field for a button 'new directed graph'.
	 */
	private final JButton newDirected;
	/**
	 * A field for a button 'open graph'.
	 */
	private final JButton open;
	/**
	 * A field for a button 'save'.
	 */
	private final JButton save;
	/**
	 * A field for a button 'save as'.
	 */
	private final JButton saveAs;
	/**
	 * A field for a button 'editing'.
	 */
	private final JButton editing;
	/**
	 * A field for a button 'picking'.
	 */
	private final JButton picking;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model as in MVC
	 */
	public ToolBar(IModel model) {

		Class<? extends ToolBar> c = this.getClass();
		/* file */
		this.newUndirected = new JButton(new ImageIcon(
				c.getResource("newUndirected.png")));
		this.newDirected = new JButton(new ImageIcon(
				c.getResource("newDirected.png")));
		this.open = new JButton(new ImageIcon(c.getResource("open.png")));
		this.save = new JButton(new ImageIcon(c.getResource("save.png")));
		this.saveAs = new JButton(new ImageIcon(c.getResource("saveAs.png")));
		this.editing = new JButton(new ImageIcon(
				c.getResource("mode_editing.png")));
		this.picking = new JButton(new ImageIcon(
				c.getResource("mode_picking.png")));
		// listener
		this.newUndirected.addActionListener(model.getParameterStateHandler());
		this.newDirected.addActionListener(model.getParameterStateHandler());
		this.open.addActionListener(model.getParameterStateHandler());
		this.save.addActionListener(model.getParameterStateHandler());
		this.saveAs.addActionListener(model.getParameterStateHandler());
		this.editing.addActionListener(model.getParameterStateHandler());
		this.picking.addActionListener(model.getParameterStateHandler());
		// command
		this.newUndirected.setActionCommand(ControlEvent.newUndirected);
		this.newDirected.setActionCommand(ControlEvent.newDirected);
		this.open.setActionCommand(ControlEvent.open);
		this.save.setActionCommand(ControlEvent.save);
		this.saveAs.setActionCommand(ControlEvent.saveAs);
		this.editing.setActionCommand(ControlEvent.editing);
		this.picking.setActionCommand(ControlEvent.picking);

		// add
		this.add(this.newUndirected);
		this.add(this.newDirected);
		this.add(this.open);
		this.addSeparator();
		this.add(this.save);
		this.add(this.saveAs);
		this.addSeparator();
		this.add(this.editing);
		this.add(this.picking);
	}

	/**
	 * Updates the tool bar.
	 */
	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof IModel) {

			IModel m = (IModel) o;
			ResourceBundle b = m.getResourceBundle();

			try {

				if (arg == ControlEvent.I18N) {

					{// file
						// setText
						// this.undirected
						// .setText(b.getString("undirected.label"));
						// this.directed.setText(b.getString("directed.label"));
						// this.open.setText(b.getString("open.label"));
						// this.save.setText(b.getString("save.label"));
						// this.saveAs.setText(b.getString("saveas.label"));
						// setToolTipText
						this.newUndirected.setToolTipText(b
								.getString("undirected.label"));
						this.newDirected.setToolTipText(b
								.getString("directed.label"));
						this.open.setToolTipText(b.getString("open.label"));
						//
						this.save.setToolTipText(b.getString("save.label"));
						this.saveAs.setToolTipText(b.getString("saveas.label"));
						// setMnemonic
						this.newUndirected.setMnemonic(b.getString(
								"undirected.label").toCharArray()[0]);
						this.newDirected.setMnemonic(b.getString(
								"directed.label").toCharArray()[0]);
						this.open.setMnemonic(b.getString("open.mnemonic")
								.toCharArray()[0]);
						//
						this.save.setMnemonic(b.getString("save.mnemonic")
								.toCharArray()[0]);
						this.saveAs.setMnemonic(b.getString("saveas.mnemonic")
								.toCharArray()[0]);
					}
					{// mode
						this.editing.setToolTipText(b.getString("mode.label")
								+ ": " + b.getString("edit.label"));
						this.picking.setToolTipText(b.getString("mode.label")
								+ ": " + b.getString("picking.label"));
					}
				} else if (arg == ControlEvent.MODE) {
					this.editing.setEnabled(m.isEditingEnabled());
					this.picking.setEnabled(m.isPickingEnabled());
				}
				this.newUndirected.setEnabled(m.isUndirectedEnabled());
				this.newDirected.setEnabled(m.isDirectedEnabled());
				this.open.setEnabled(m.isOpenEnabled());
				this.save.setEnabled(m.isSaveEnabled());
				this.saveAs.setEnabled(m.isSaveAsEnabled());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(),
						b.getString("app.label"), 1, null);
				e.printStackTrace();
			}

		}

	}

}
