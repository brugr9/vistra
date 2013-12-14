package ch.bfh.bti7301.hs2013.gravis.gui.view.component;

import static ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource.DELETE_ALGORITHM;
import static ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource.DE_DE;
import static ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource.EN_US;
import static ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource.FR_FR;
import static ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource.I18N;
import static ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource.IMPORT_ALGORITHM;
import static ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource.NEW_GRAPH_DIRECTED;
import static ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource.NEW_GRAPH_UNDIRECTED;
import static ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource.OPEN_GRAPH;
import static ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource.SAVE_AS_GRAPH;
import static ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource.SAVE_GRAPH;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import ch.bfh.bti7301.hs2013.gravis.gui.IModel;
import ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource;

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
	 * A field for the menu 'new'.
	 */
	private final JMenu newMenu;
	/**
	 * A field for the menu item 'new undirected Graph'.
	 */
	private final JMenuItem undirectedGraphMenuItem;
	/**
	 * A field for the menu item 'new directed Graph'.
	 */
	private final JMenuItem directedGraphMenuItem;
	/**
	 * A field for the menu item 'open'.
	 */
	private final JMenuItem openMenuItem;
	/**
	 * A field for the menu item 'save'.
	 */
	private final JMenuItem saveMenuItem;
	/**
	 * A field for the menu item 'save as'.
	 */
	private final JMenuItem saveAsMenuItem;
	/**
	 * A field for the menu 'algorithm'.
	 */
	private final JMenu algorithmMenu;
	/**
	 * A field for the menu item 'import Algorithm'.
	 */
	private final JMenuItem importAlgorithmMenuItem;
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
	 * @param model
	 *            the model as in MVC
	 */
	public MenuBar(IModel model) {
		{// JMenu fileMenu
			this.fileMenu = new JMenu("fileMenu");
			// JMenuItem
			this.undirectedGraphMenuItem = new JMenuItem(
					"undirectedGraphMenuItem");
			this.directedGraphMenuItem = new JMenuItem("directedGraphMenuItem");
			this.openMenuItem = new JMenuItem("openMenuItem");
			this.saveMenuItem = new JMenuItem("saveMenuItem");
			this.saveAsMenuItem = new JMenuItem("saveAsMenuItem");
			this.importAlgorithmMenuItem = new JMenuItem(
					"importAlgorithmMenuItem");
			this.deleteAlgorithmMenuItem = new JMenuItem(
					"deleteAlgorithmMenuItem");
			this.quitMenuItem = new JMenuItem("quitMenuItem");
			// addActionListener
			this.undirectedGraphMenuItem.addActionListener(model
					.getParameterStateHandler());
			this.directedGraphMenuItem.addActionListener(model
					.getParameterStateHandler());
			this.openMenuItem.addActionListener(model
					.getParameterStateHandler());
			this.saveMenuItem.addActionListener(model
					.getParameterStateHandler());
			this.saveAsMenuItem.addActionListener(model
					.getParameterStateHandler());
			this.importAlgorithmMenuItem.addActionListener(model
					.getParameterStateHandler());
			this.deleteAlgorithmMenuItem.addActionListener(model
					.getParameterStateHandler());
			this.quitMenuItem.addActionListener(model.getQuitListener());
			// setActionCommand
			this.undirectedGraphMenuItem.setActionCommand(NEW_GRAPH_UNDIRECTED
					.toString());
			this.directedGraphMenuItem.setActionCommand(NEW_GRAPH_DIRECTED
					.toString());
			this.openMenuItem.setActionCommand(OPEN_GRAPH.toString());
			this.saveMenuItem.setActionCommand(SAVE_GRAPH.toString());
			this.saveAsMenuItem.setActionCommand(SAVE_AS_GRAPH.toString());
			this.importAlgorithmMenuItem.setActionCommand(IMPORT_ALGORITHM
					.toString());
			this.deleteAlgorithmMenuItem.setActionCommand(DELETE_ALGORITHM
					.toString());
			// add
			this.newMenu = new JMenu("newMenu");
			this.newMenu.add(this.undirectedGraphMenuItem);
			this.newMenu.add(this.directedGraphMenuItem);
			this.algorithmMenu = new JMenu("algorithmMenu");
			this.algorithmMenu.add(this.importAlgorithmMenuItem);
			this.algorithmMenu.add(this.deleteAlgorithmMenuItem);
			//
			this.fileMenu.add(this.newMenu);
			this.fileMenu.add(this.openMenuItem);
			this.fileMenu.add(this.saveMenuItem);
			this.fileMenu.add(this.saveAsMenuItem);
			this.fileMenu.add(this.algorithmMenu);
			this.fileMenu.add(this.quitMenuItem);
		}
		{// JMenu i18nMenu
			this.i18nMenu = new JMenu("i18nMenu");
			// JMenuItem
			this.deDEMenuItem = new JMenuItem("deDEMenuItem");
			this.frFRMenuItem = new JMenuItem("frFRMenuItem");
			this.enUSMenuItem = new JMenuItem("enUSMenuItem");
			// addActionListener
			this.deDEMenuItem.addActionListener(model.getI18nListener());
			this.frFRMenuItem.addActionListener(model.getI18nListener());
			this.enUSMenuItem.addActionListener(model.getI18nListener());
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
			this.helpMenuItem.addActionListener(model.getHelpListener());
			this.aboutMenuItem.addActionListener(model.getAboutListener());
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

		if (o instanceof IModel) {

			IModel m = (IModel) o;
			ResourceBundle b = m.getResourceBundle();

			try {

				if (arg == I18N) {

					{// JMenu fileMenu
						// setText
						this.fileMenu.setText(b.getString("file.label"));
						this.newMenu.setText(b.getString("new.label"));
						this.undirectedGraphMenuItem.setText(b
								.getString("undirected.label"));
						this.directedGraphMenuItem.setText(b
								.getString("directed.label"));
						this.openMenuItem.setText(b.getString("open.label"));
						this.saveMenuItem.setText(b.getString("save.label"));
						this.saveAsMenuItem
								.setText(b.getString("saveas.label"));
						this.algorithmMenu.setText(b
								.getString("algorithm.label"));
						this.importAlgorithmMenuItem.setText(b
								.getString("import.label"));
						this.deleteAlgorithmMenuItem.setText(b
								.getString("delete.label"));
						this.quitMenuItem.setText(b.getString("quit.label"));
						// setMnemonic
						this.fileMenu.setMnemonic(b.getString("file.mnemonic")
								.toCharArray()[0]);
						this.newMenu.setMnemonic(b.getString("new.mnemonic")
								.toCharArray()[0]);
						this.openMenuItem.setMnemonic(b.getString(
								"open.mnemonic").toCharArray()[0]);
						this.saveMenuItem.setMnemonic(b.getString(
								"save.mnemonic").toCharArray()[0]);
						this.saveAsMenuItem.setMnemonic(b.getString(
								"saveas.mnemonic").toCharArray()[0]);
						this.quitMenuItem.setMnemonic(b.getString(
								"quit.mnemonic").toCharArray()[0]);
						// setAccelerator
						this.openMenuItem.setAccelerator(KeyStroke
								.getKeyStroke(b.getString("open.accelerator")));
						this.saveMenuItem.setAccelerator(KeyStroke
								.getKeyStroke(b.getString("save.accelerator")));
						this.saveAsMenuItem
								.setAccelerator(KeyStroke.getKeyStroke(b
										.getString("saveas.accelerator")));
						this.quitMenuItem.setAccelerator(KeyStroke
								.getKeyStroke(b.getString("quit.accelerator")));
					}
					{// JMenu i18nMenu
						// setText
						this.i18nMenu.setText(b.getString("i18n.label"));
						// setMnemonic
						this.i18nMenu.setMnemonic(b.getString("i18n.mnemonic")
								.toCharArray()[0]);
						// setText
						this.deDEMenuItem.setText(b.getString("deDE.label"));
						this.frFRMenuItem.setText(b.getString("frFR.label"));
						this.enUSMenuItem.setText(b.getString("enUS.label"));
						// setMnemonic
						this.deDEMenuItem.setMnemonic(b.getString(
								"deDE.mnemonic").toCharArray()[0]);
						this.frFRMenuItem.setMnemonic(b.getString(
								"frFR.mnemonic").toCharArray()[0]);
						this.enUSMenuItem.setMnemonic(b.getString(
								"enUS.mnemonic").toCharArray()[0]);
					}
					{// JMenu infoMenu
						// setText
						this.infoMenu.setText(b.getString("info.label"));
						this.helpMenuItem.setText(b.getString("help.label"));
						this.aboutMenuItem.setText(b.getString("about.label"));
						// setMnemonic
						this.infoMenu.setMnemonic(b.getString("info.mnemonic")
								.toCharArray()[0]);
						this.helpMenuItem.setMnemonic(b.getString(
								"help.mnemonic").toCharArray()[0]);
						this.aboutMenuItem.setMnemonic(b.getString(
								"about.mnemonic").toCharArray()[0]);
						// setAccelerator
						this.helpMenuItem.setAccelerator(KeyStroke
								.getKeyStroke(b.getString("help.accelerator")));
						this.aboutMenuItem
								.setAccelerator(KeyStroke.getKeyStroke(b
										.getString("about.accelerator")));
					}

				} else if (arg == EventSource.PARAMETER_CHANGED) {
					this.saveAsMenuItem.setEnabled(m.isSaveEnabled());
				} else {

					// file
					this.fileMenu.setEnabled(m.isFileEnabled());
					this.newMenu.setEnabled(m.isNewMenuEnabled());
					this.undirectedGraphMenuItem.setEnabled(m
							.isUndirectedGraphEnabled());
					this.directedGraphMenuItem.setEnabled(m
							.isDirectedGraphEnabled());
					this.openMenuItem.setEnabled(m.isOpenEnabled());
					this.saveMenuItem.setEnabled(m.isSaveEnabled());
					this.saveAsMenuItem.setEnabled(m.isSaveAsEnabled());
					this.algorithmMenu.setEnabled(m.isAlgorithmMenuEnabled());
					this.importAlgorithmMenuItem.setEnabled(m
							.isImportAlgorithmEnabled());
					this.deleteAlgorithmMenuItem.setEnabled(m
							.isDeleteAlgorithmEnabled());
					this.quitMenuItem.setEnabled(m.isQuitEnabled());
					// i18n
					this.i18nMenu.setEnabled(m.isI18nEnabled());
					this.deDEMenuItem.setEnabled(m.isDeDEEnabled());
					this.frFRMenuItem.setEnabled(m.isFrFREnabled());
					this.enUSMenuItem.setEnabled(m.isEnUSEnabled());
					// info
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