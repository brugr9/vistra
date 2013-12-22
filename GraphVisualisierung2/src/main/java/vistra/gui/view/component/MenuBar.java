package vistra.gui.view.component;

import static vistra.gui.control.IControl.EventSource.DE_DE;
import static vistra.gui.control.IControl.EventSource.EN_US;
import static vistra.gui.control.IControl.EventSource.FR_FR;
import static vistra.gui.control.IControl.EventSource.I18N;
import static vistra.gui.control.IControl.EventSource.NEW_GRAPH_DIRECTED;
import static vistra.gui.control.IControl.EventSource.NEW_GRAPH_UNDIRECTED;
import static vistra.gui.control.IControl.EventSource.OPEN_GRAPH;
import static vistra.gui.control.IControl.EventSource.SAVE_GRAPH;
import static vistra.gui.control.IControl.EventSource.SAVE_GRAPH_AS;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import vistra.gui.IModel;
import vistra.gui.control.IControl.EventSource;

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
	 * A field for the menu 'information'.
	 */
	private final JMenu info;
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
	 * A field for the menu item 'DE_DE'.
	 */
	private final JMenuItem deDE;
	/**
	 * A field for the menu item 'FR_FR'.
	 */
	private final JMenuItem frFR;
	/**
	 * A field for the menu item 'EN_US'.
	 */
	private final JMenuItem enUS;
	/**
	 * A field for the menu item 'help'.
	 */
	private final JMenuItem help;
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
			// addActionListener
			this.open.addActionListener(model.getParameterStateHandler());
			this.save.addActionListener(model.getParameterStateHandler());
			this.saveAs.addActionListener(model.getParameterStateHandler());
			this.quit.addActionListener(model.getQuitListener());
			this.open.setActionCommand(OPEN_GRAPH.toString());
			this.save.setActionCommand(SAVE_GRAPH.toString());
			this.saveAs.setActionCommand(SAVE_GRAPH_AS.toString());
			{// graph
				this.newGraph = new JMenu("newGraph");
				this.undirected = new JMenuItem("undirected");
				this.directed = new JMenuItem("directed");
				// addActionListener
				this.undirected.addActionListener(model
						.getParameterStateHandler());
				this.directed.addActionListener(model
						.getParameterStateHandler());
				// setActionCommand
				this.undirected.setActionCommand(NEW_GRAPH_UNDIRECTED
						.toString());
				this.directed.setActionCommand(NEW_GRAPH_DIRECTED.toString());
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
			this.deDE = new JMenuItem("deDE");
			this.frFR = new JMenuItem("frFR");
			this.enUS = new JMenuItem("enUS");
			// addActionListener
			this.deDE.addActionListener(model.getI18nListener());
			this.frFR.addActionListener(model.getI18nListener());
			this.enUS.addActionListener(model.getI18nListener());
			// setActionCommand
			this.deDE.setActionCommand(DE_DE.toString());
			this.frFR.setActionCommand(FR_FR.toString());
			this.enUS.setActionCommand(EN_US.toString());
			// add
			this.i18n.add(this.deDE);
			this.i18n.add(this.frFR);
			this.i18n.add(this.enUS);
		}
		{// info
			this.info = new JMenu("infoMenu");
			this.help = new JMenuItem("helpMenuItem");
			this.about = new JMenuItem("aboutMenuItem");
			// addActionListener
			this.help.addActionListener(model.getHelpListener());
			this.about.addActionListener(model.getAboutListener());
			// add
			this.info.add(this.help);
			this.info.add(this.about);
		}
		// add
		this.add(this.file);
		this.add(this.i18n);
		this.add(this.info);
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
						this.deDE.setText(b.getString("deDE.label"));
						this.frFR.setText(b.getString("frFR.label"));
						this.enUS.setText(b.getString("enUS.label"));
						// setMnemonic
						this.deDE.setMnemonic(b.getString("deDE.mnemonic")
								.toCharArray()[0]);
						this.frFR.setMnemonic(b.getString("frFR.mnemonic")
								.toCharArray()[0]);
						this.enUS.setMnemonic(b.getString("enUS.mnemonic")
								.toCharArray()[0]);
					}
					{// JMenu infoMenu
						// setText
						this.info.setText(b.getString("info.label"));
						this.help.setText(b.getString("help.label"));
						this.about.setText(b.getString("about.label"));
						// setMnemonic
						this.info.setMnemonic(b.getString("info.mnemonic")
								.toCharArray()[0]);
						this.help.setMnemonic(b.getString("help.mnemonic")
								.toCharArray()[0]);
						this.about.setMnemonic(b.getString("about.mnemonic")
								.toCharArray()[0]);
						// setAccelerator
						this.help.setAccelerator(KeyStroke.getKeyStroke(b
								.getString("help.accelerator")));
						this.about.setAccelerator(KeyStroke.getKeyStroke(b
								.getString("about.accelerator")));
					}

				} else if (arg == EventSource.GRAPH) {
					this.saveAs.setEnabled(m.isSaveGraphEnabled());
				} else {

					// file
					this.file.setEnabled(m.isFileEnabled());
					this.newGraph.setEnabled(m.isNewMenuEnabled());
					this.undirected.setEnabled(m.isUndirectedGraphEnabled());
					this.directed.setEnabled(m.isDirectedGraphEnabled());
					this.open.setEnabled(m.isOpenGraphEnabled());
					this.save.setEnabled(m.isSaveGraphEnabled());
					this.saveAs.setEnabled(m.isSaveGraphAsEnabled());
					this.quit.setEnabled(m.isQuitEnabled());
					// i18n
					this.i18n.setEnabled(m.isI18nEnabled());
					this.deDE.setEnabled(m.isDeDEEnabled());
					this.frFR.setEnabled(m.isFrFREnabled());
					this.enUS.setEnabled(m.isEnUSEnabled());
					// info
					this.info.setEnabled(m.isInfoEnabled());
					this.help.setEnabled(m.isHelpEnabled());
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