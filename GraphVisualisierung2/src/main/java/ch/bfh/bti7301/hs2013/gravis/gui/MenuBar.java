package ch.bfh.bti7301.hs2013.gravis.gui;

import static ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource.DELETE_ALGORITHM;
import static ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource.DELETE_GRAPH;
import static ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource.DE_DE;
import static ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource.EN_US;
import static ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource.FR_FR;
import static ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource.IMPORT_ALGORITHM;
import static ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource.IMPORT_GRAPH;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

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
	private final JMenu fileMenu;
	/**
	 * A field for the menu 'i18n'.
	 */
	private final JMenu i18nMenu;
	/**
	 * A field for the menu 'information'.
	 */
	private final JMenu infoMenu;
	/**
	 * A field for the menu item 'import Graph'.
	 */
	private final JMenuItem importGraphMenuItem;
	/**
	 * A field for the menu item 'import Algorithm'.
	 */
	private final JMenuItem importAlgorithmMenuItem;
	/**
	 * A field for the menu item 'delete Graph'.
	 */
	private final JMenuItem deleteGraphMenuItem;
	/**
	 * A field for the menu item 'delete Algorithm'.
	 */
	private final JMenuItem deleteAlgorithmMenuItem;
	/**
	 * A field for the menu item 'quit'.
	 */
	private final JMenuItem quitMenuItem;
	/**
	 * A field for the menu item 'DE_DE'.
	 */
	private final JMenuItem deDEMenuItem;
	/**
	 * A field for the menu item 'FR_FR'.
	 */
	private final JMenuItem frFRMenuItem;
	/**
	 * A field for the menu item 'EN_US'.
	 */
	private final JMenuItem enUSMenuItem;
	/**
	 * A field for the menu item 'help'.
	 */
	private final JMenuItem helpMenuItem;
	/**
	 * A field for the menu item 'about'.
	 */
	private final JMenuItem aboutMenuItem;

	/**
	 * Main constructor.
	 * 
	 * @param control
	 *            the controller as in MVC
	 */
	public MenuBar(Control control) {
		{// JMenu fileMenu
			this.fileMenu = new JMenu("fileMenu");
			// JMenuItem
			this.importGraphMenuItem = new JMenuItem("importGraphMenuItem");
			this.importAlgorithmMenuItem = new JMenuItem(
					"importAlgorithmMenuItem");
			this.deleteGraphMenuItem = new JMenuItem("deleteGraphMenuItem");
			this.deleteAlgorithmMenuItem = new JMenuItem(
					"deleteAlgorithmMenuItem");
			this.quitMenuItem = new JMenuItem("quitMenuItem");
			// addActionListener
			this.importGraphMenuItem.addActionListener(control.ioListener);
			this.importAlgorithmMenuItem.addActionListener(control.ioListener);
			this.deleteGraphMenuItem.addActionListener(control.ioListener);
			this.deleteAlgorithmMenuItem.addActionListener(control.ioListener);
			this.quitMenuItem.addActionListener(control.quitListener);
			// setActionCommand
			this.importGraphMenuItem.setActionCommand(IMPORT_GRAPH.toString());
			this.importAlgorithmMenuItem.setActionCommand(IMPORT_ALGORITHM
					.toString());
			this.deleteGraphMenuItem.setActionCommand(DELETE_GRAPH.toString());
			this.deleteAlgorithmMenuItem.setActionCommand(DELETE_ALGORITHM
					.toString());
			// add
			this.fileMenu.add(this.importAlgorithmMenuItem);
			this.fileMenu.add(this.deleteAlgorithmMenuItem);
			this.fileMenu.add(this.importGraphMenuItem);
			this.fileMenu.add(this.deleteGraphMenuItem);
			this.fileMenu.add(this.quitMenuItem);
		}
		{// JMenu i18nMenu
			this.i18nMenu = new JMenu("i18nMenu");
			// JMenuItem
			this.deDEMenuItem = new JMenuItem("deDEMenuItem");
			this.frFRMenuItem = new JMenuItem("frFRMenuItem");
			this.enUSMenuItem = new JMenuItem("enUSMenuItem");
			// addActionListener
			this.deDEMenuItem.addActionListener(control.i18nListener);
			this.frFRMenuItem.addActionListener(control.i18nListener);
			this.enUSMenuItem.addActionListener(control.i18nListener);
			// setActionCommand
			this.deDEMenuItem.setActionCommand(DE_DE.toString());
			this.frFRMenuItem.setActionCommand(FR_FR.toString());
			this.enUSMenuItem.setActionCommand(EN_US.toString());
			// add
			this.i18nMenu.add(this.deDEMenuItem);
			this.i18nMenu.add(this.frFRMenuItem);
			this.i18nMenu.add(this.enUSMenuItem);
		}
		{// JMenu infoMenu
			this.infoMenu = new JMenu("infoMenu");
			// JMenuItem
			this.helpMenuItem = new JMenuItem("helpMenuItem");
			this.aboutMenuItem = new JMenuItem("aboutMenuItem");
			// addActionListener
			this.helpMenuItem.addActionListener(control.helpListener);
			this.aboutMenuItem.addActionListener(control.aboutListener);
			// setActionCommand
			this.helpMenuItem.setActionCommand("help");
			this.aboutMenuItem.setActionCommand("about");
			// add
			this.infoMenu.add(this.helpMenuItem);
			this.infoMenu.add(this.aboutMenuItem);
		}
		// add
		this.add(this.fileMenu);
		this.add(this.i18nMenu);
		this.add(this.infoMenu);
	}

	/**
	 * Updates the menu bar.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Model) {

			Model m = (Model) o;
			ResourceBundle b = m.getResourceBundle();

			try {

				// TODO arg
				// if (arg == EventSource.I18N)

				{// JMenu fileMenu
					// setText
					this.fileMenu.setText(b.getString("file.label"));
					this.importAlgorithmMenuItem.setText(b
							.getString("importAlgorithm.label"));
					this.deleteAlgorithmMenuItem.setText(b
							.getString("deleteAlgorithm.label"));
					this.importGraphMenuItem.setText(b
							.getString("importGraph.label"));
					this.deleteGraphMenuItem.setText(b
							.getString("deleteGraph.label"));
					this.quitMenuItem.setText(b.getString("quit.label"));
					// setMnemonic
					this.fileMenu.setMnemonic(b.getString("file.mnemonic")
							.toCharArray()[0]);
					this.quitMenuItem.setMnemonic(b.getString("quit.mnemonic")
							.toCharArray()[0]);
					// setAccelerator
					this.quitMenuItem.setAccelerator(KeyStroke.getKeyStroke(b
							.getString("quit.accelerator")));
				}
				{// JMenu i18nMenu
					// setText
					this.i18nMenu.setText(b.getString("i18n.label"));
					// setMnemonic
					this.i18nMenu.setMnemonic(b.getString("i18n.mnemonic")
							.toCharArray()[0]);
					{// JMenu i18nMenu
						// setText
						this.deDEMenuItem.setText(b.getString("deDE.label"));
						this.frFRMenuItem.setText(b.getString("frFR.label"));
						this.enUSMenuItem.setText(b.getString("enUS.label"));
						// setMnemonic
						this.deDEMenuItem.setMnemonic(b.getString(
								"deDE.mnemonic").toCharArray()[0]);
						this.deDEMenuItem.setMnemonic(b.getString(
								"frFR.mnemonic").toCharArray()[0]);
						this.deDEMenuItem.setMnemonic(b.getString(
								"enUS.mnemonic").toCharArray()[0]);
					}
				}
				{// JMenu infoMenu
					// setText
					this.infoMenu.setText(b.getString("info.label"));
					this.helpMenuItem.setText(b.getString("help.label"));
					this.aboutMenuItem.setText(b.getString("about.label"));
					// setMnemonic
					this.infoMenu.setMnemonic(b.getString("info.mnemonic")
							.toCharArray()[0]);
					this.helpMenuItem.setMnemonic(b.getString("help.mnemonic")
							.toCharArray()[0]);
					this.aboutMenuItem.setMnemonic(b
							.getString("about.mnemonic").toCharArray()[0]);
					// setAccelerator
					this.helpMenuItem.setAccelerator(KeyStroke.getKeyStroke(b
							.getString("help.accelerator")));
					this.aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(b
							.getString("about.accelerator")));
				}

				// TODO arg
				// if (arg == ...)
				{
					this.fileMenu.setEnabled(m.isFileEnabled());
					this.importAlgorithmMenuItem.setEnabled(m
							.isImportAlgorithmEnabled());
					this.deleteAlgorithmMenuItem.setEnabled(m
							.isDeleteAlgorithmEnabled());
					this.importGraphMenuItem.setEnabled(m
							.isImportGraphEnabled());
					this.deleteGraphMenuItem.setEnabled(m
							.isDeleteGraphEnabled());
					this.quitMenuItem.setEnabled(m.isQuitEnabled());
					this.i18nMenu.setEnabled(m.isI18nEnabled());
					this.deDEMenuItem.setEnabled(m.isDeDEEnabled());
					this.frFRMenuItem.setEnabled(m.isFrFREnabled());
					this.enUSMenuItem.setEnabled(m.isEnUSEnabled());
					this.infoMenu.setEnabled(m.isInfoEnabled());
					this.helpMenuItem.setEnabled(m.isHelpEnabled());
					this.aboutMenuItem.setEnabled(m.isAboutEnabled());
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(),
						b.getString("app.label"), 1, null);
				e.printStackTrace();
			}
		}
	}
}