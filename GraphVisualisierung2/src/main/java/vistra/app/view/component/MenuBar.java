package vistra.app.view.component;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import vistra.app.IModel;
import vistra.app.control.IControl.ControlEvent;
import vistra.framework.util.palette.I18nPalette;

/**
 * A menu bar.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class MenuBar extends JMenuBar implements Observer {

	private static final long serialVersionUID = 1L;

	/**
	 * A field for the menu 'file'.
	 */
	private final JMenu file;
	/**
	 * A field for the menu 'i18n'.
	 */
	private final JMenu i18n;
	/**
	 * A field for the menu 'help'.
	 */
	private final JMenu help;
	/**
	 * A field for the menu 'new graph'.
	 */
	private final JMenu newGraph;
	/**
	 * A field for the menu item 'new undirected graph'.
	 */
	private final JMenuItem undirected;
	/**
	 * A field for the menu item 'new directed graph'.
	 */
	private final JMenuItem directed;
	/**
	 * A field for the menu item 'open graph'.
	 */
	private final JMenuItem open;
	/**
	 * A field for the menu item 'save'.
	 */
	private final JMenuItem save;
	/**
	 * A field for the menu item 'save as'.
	 */
	private final JMenuItem saveAs;
	/**
	 * A field for the menu item 'quit'.
	 */
	private final JMenuItem quit;
	/**
	 * A field for the menu item 'deCH'.
	 */
	// private final JMenuItem deCH;
	/**
	 * A field for the menu item 'deDE'.
	 */
	private final JMenuItem deDE;
	/**
	 * A field for the menu item 'frFR'.
	 */
	private final JMenuItem frFR;
	/**
	 * A field for the menu item 'enGB'.
	 */
	// private final JMenuItem enGB;
	/**
	 * A field for the menu item 'enUS'.
	 */
	private final JMenuItem enUS;
	/**
	 * A field for the menu item 'shortcuts'.
	 */
	private final JMenuItem shortcuts;
	/**
	 * A field for the menu item 'about'.
	 */
	private final JMenuItem about;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model as in MVC
	 */
	public MenuBar(IModel model) {
		{// file
			this.file = new JMenu("fileMenu");
			this.open = new JMenuItem("open");
			this.save = new JMenuItem("save");
			this.saveAs = new JMenuItem("save");
			this.quit = new JMenuItem("quit");
			// listener
			this.open.addActionListener(model.getParameterStateHandler());
			this.save.addActionListener(model.getParameterStateHandler());
			this.saveAs.addActionListener(model.getParameterStateHandler());
			this.quit.addActionListener(model.getParameterStateHandler());
			// command
			this.open.setActionCommand(ControlEvent.open);
			this.save.setActionCommand(ControlEvent.save);
			this.saveAs.setActionCommand(ControlEvent.saveAs);
			this.quit.setActionCommand(ControlEvent.quit);
			{// graph
				this.newGraph = new JMenu("newGraph");
				this.undirected = new JMenuItem("undirected");
				this.directed = new JMenuItem("directed");
				// listener
				this.undirected.addActionListener(model
						.getParameterStateHandler());
				this.directed.addActionListener(model
						.getParameterStateHandler());
				// command
				this.undirected.setActionCommand(ControlEvent.newUndirected);
				this.directed.setActionCommand(ControlEvent.newDirected);
				// add
				this.newGraph.add(this.undirected);
				this.newGraph.add(this.directed);
			}
			// add
			this.file.add(this.newGraph);
			this.file.add(this.open);
			this.file.add(this.save);
			this.file.add(this.saveAs);
			this.file.add(this.quit);
		}
		{// i18n
			this.i18n = new JMenu("i18n");
			// this.deCH = new JMenuItem("deCH");
			this.deDE = new JMenuItem("deDE");
			this.frFR = new JMenuItem("frFR");
			// this.enGB = new JMenuItem("enGB");
			this.enUS = new JMenuItem("enUS");
			// listener
			// this.deCH.addActionListener(model.getI18nListener());
			this.deDE.addActionListener(model.getI18nListener());
			this.frFR.addActionListener(model.getI18nListener());
			// this.enGB.addActionListener(model.getI18nListener());
			this.enUS.addActionListener(model.getI18nListener());
			// command
			// this.deCH.setActionCommand(I18nPalette.deCH);
			this.deDE.setActionCommand(I18nPalette.deDE);
			this.frFR.setActionCommand(I18nPalette.frFR);
			// this.enGB.setActionCommand(I18nPalette.enGB);
			this.enUS.setActionCommand(I18nPalette.enUS);
			// add
			// this.i18n.add(this.deCH);
			this.i18n.add(this.deDE);
			this.i18n.add(this.frFR);
			// this.i18n.add(this.enGB);
			this.i18n.add(this.enUS);
		}
		{// info
			this.help = new JMenu("helpMenu");
			this.shortcuts = new JMenuItem("shortcutsMenuItem");
			this.about = new JMenuItem("aboutMenuItem");
			// listener
			this.shortcuts.addActionListener(model.getShortcutsListener());
			this.about.addActionListener(model.getAboutListener());
			// add
			this.help.add(this.shortcuts);
			this.help.add(this.about);
		}
		// add
		this.add(this.file);
		this.add(this.i18n);
		this.add(this.help);
	}

	/**
	 * Updates the menu bar.
	 */
	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof IModel) {

			IModel m = (IModel) o;
			ResourceBundle b = m.getResourceBundle();

			try {

				if (arg == ControlEvent.I18N) {

					{// JMenu fileMenu
						// setText
						this.file.setText(b.getString("file.label"));
						this.newGraph.setText(b.getString("new.label"));
						this.undirected
								.setText(b.getString("undirected.label"));
						this.directed.setText(b.getString("directed.label"));
						this.open.setText(b.getString("open.label"));
						this.save.setText(b.getString("save.label"));
						this.saveAs.setText(b.getString("saveas.label"));
						this.quit.setText(b.getString("quit.label"));
						// setMnemonic
						this.file.setMnemonic(b.getString("file.mnemonic")
								.toCharArray()[0]);
						this.newGraph.setMnemonic(b.getString("new.mnemonic")
								.toCharArray()[0]);
						this.undirected.setMnemonic(b.getString(
								"undirected.label").toCharArray()[0]);
						this.directed.setMnemonic(b.getString("directed.label")
								.toCharArray()[0]);
						this.open.setMnemonic(b.getString("open.mnemonic")
								.toCharArray()[0]);
						this.save.setMnemonic(b.getString("save.mnemonic")
								.toCharArray()[0]);
						this.saveAs.setMnemonic(b.getString("saveas.mnemonic")
								.toCharArray()[0]);
						this.quit.setMnemonic(b.getString("quit.mnemonic")
								.toCharArray()[0]);
						// setAccelerator
						this.open.setAccelerator(KeyStroke.getKeyStroke(b
								.getString("open.accelerator")));
						this.save.setAccelerator(KeyStroke.getKeyStroke(b
								.getString("save.accelerator")));
						this.saveAs.setAccelerator(KeyStroke.getKeyStroke(b
								.getString("saveas.accelerator")));
						this.quit.setAccelerator(KeyStroke.getKeyStroke(b
								.getString("quit.accelerator")));
					}
					{// JMenu i18nMenu
						// setText
						this.i18n.setText(b.getString("i18n.label"));
						// setMnemonic
						this.i18n.setMnemonic(b.getString("i18n.mnemonic")
								.toCharArray()[0]);
						// setText
						// this.deCH.setText(b.getString("deCH.label"));
						this.deDE.setText(b.getString("deDE.label"));
						this.frFR.setText(b.getString("frFR.label"));
						// this.enGB.setText(b.getString("enGB.label"));
						this.enUS.setText(b.getString("enUS.label"));
						// setMnemonic
						// this.deCH.setMnemonic(b.getString("deCH.mnemonic")
						// .toCharArray()[0]);
						this.deDE.setMnemonic(b.getString("deDE.mnemonic")
								.toCharArray()[0]);
						this.frFR.setMnemonic(b.getString("frFR.mnemonic")
								.toCharArray()[0]);
						// this.enGB.setMnemonic(b.getString("enGB.mnemonic")
						// .toCharArray()[0]);
						this.enUS.setMnemonic(b.getString("enUS.mnemonic")
								.toCharArray()[0]);
					}
					{// JMenu infoMenu
						// setText
						this.help.setText(b.getString("help.label"));
						this.shortcuts.setText(b.getString("shortcuts.label"));
						this.about.setText(b.getString("about.label"));
						// setMnemonic
						this.help.setMnemonic(b.getString("help.mnemonic")
								.toCharArray()[0]);
						this.shortcuts.setMnemonic(b.getString(
								"shortcuts.mnemonic").toCharArray()[0]);
						this.about.setMnemonic(b.getString("about.mnemonic")
								.toCharArray()[0]);
						// setAccelerator
						this.shortcuts.setAccelerator(KeyStroke.getKeyStroke(b
								.getString("shortcuts.accelerator")));
						this.about.setAccelerator(KeyStroke.getKeyStroke(b
								.getString("about.accelerator")));
					}

				} else if (arg == ControlEvent.GRAPH) {
					this.saveAs.setEnabled(m.isSaveEnabled());
				} else {

					// file
					this.file.setEnabled(m.isFileEnabled());
					this.newGraph.setEnabled(m.isNewEnabled());
					this.undirected.setEnabled(m.isUndirectedEnabled());
					this.directed.setEnabled(m.isDirectedEnabled());
					this.open.setEnabled(m.isOpenEnabled());
					this.save.setEnabled(m.isSaveEnabled());
					this.saveAs.setEnabled(m.isSaveAsEnabled());
					this.quit.setEnabled(m.isQuitEnabled());
					// i18n
					this.i18n.setEnabled(m.isI18nEnabled());
					// this.deCH.setEnabled(m.isDeCHEnabled());
					this.deDE.setEnabled(m.isDeDEEnabled());
					this.frFR.setEnabled(m.isFrFREnabled());
					// this.enGB.setEnabled(m.isEnGBEnabled());
					this.enUS.setEnabled(m.isEnUSEnabled());
					// info
					this.help.setEnabled(m.isHelpEnabled());
					this.shortcuts.setEnabled(m.isShortcutsEnabled());
					this.about.setEnabled(m.isAboutEnabled());

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(),
						b.getString("app.label"), 1, null);
				e.printStackTrace();
			}

		}

	}
}