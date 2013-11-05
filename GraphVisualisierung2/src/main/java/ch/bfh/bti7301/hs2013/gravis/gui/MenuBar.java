package ch.bfh.bti7301.hs2013.gravis.gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ch.bfh.bti7301.hs2013.gravis.gui.GuiControl.EventSource;

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
	 * @param guiControl
	 *            the controller as in MVC
	 */
	public MenuBar(GuiControl guiControl) {
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
			this.importGraphMenuItem.addActionListener(guiControl.ioListener);
			this.importAlgorithmMenuItem
					.addActionListener(guiControl.ioListener);
			this.deleteGraphMenuItem.addActionListener(guiControl.ioListener);
			this.deleteAlgorithmMenuItem
					.addActionListener(guiControl.ioListener);
			this.quitMenuItem.addActionListener(guiControl.quitListener);
			// setActionCommand
			this.importGraphMenuItem.setActionCommand(EventSource.IMPORT_GRAPH
					.toString());
			this.importAlgorithmMenuItem
					.setActionCommand(EventSource.IMPORT_ALGORITHM.toString());
			this.deleteGraphMenuItem.setActionCommand(EventSource.DELETE_GRAPH
					.toString());
			this.deleteAlgorithmMenuItem
					.setActionCommand(EventSource.DELETE_ALGORITHM.toString());
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
			this.deDEMenuItem.addActionListener(guiControl.i18nListener);
			this.frFRMenuItem.addActionListener(guiControl.i18nListener);
			this.enUSMenuItem.addActionListener(guiControl.i18nListener);
			// setActionCommand
			this.deDEMenuItem.setActionCommand(EventSource.DE_DE.toString());
			this.frFRMenuItem.setActionCommand(EventSource.FR_FR.toString());
			this.enUSMenuItem.setActionCommand(EventSource.EN_US.toString());
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
			this.helpMenuItem.addActionListener(guiControl.helpListener);
			this.aboutMenuItem.addActionListener(guiControl.aboutListener);
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
		GuiModel m = (GuiModel) o;
		try {
			{// JMenu fileMenu
				// setText
				this.fileMenu.setText(m.getFileMenuLabel());
				this.importAlgorithmMenuItem.setText(m
						.getImportAlgorithmLabel());
				this.deleteAlgorithmMenuItem.setText(m
						.getDeleteAlgorithmLabel());
				this.importGraphMenuItem.setText(m.getImportGraphLabel());
				this.deleteGraphMenuItem.setText(m.getDeleteGraphLabel());
				this.quitMenuItem.setText(m.getQuitLabel());
				// setMnemonic
				this.fileMenu.setMnemonic(m.getFileMenuMnemonic());
				this.quitMenuItem.setMnemonic(m.getQuitMenuItemMnemonic());
				// setAccelerator
				this.quitMenuItem
						.setAccelerator(m.getQuitMenuItemAccelerator());
				// setEnabled
				this.fileMenu.setEnabled(m.isFileMenuEnabled());
				this.importAlgorithmMenuItem.setEnabled(m
						.isImportAlgorithmMenuItemEnabled());
				this.deleteAlgorithmMenuItem.setEnabled(m
						.isDeleteAlgorithmMenuItemEnabled());
				this.importGraphMenuItem.setEnabled(m
						.isImportGraphMenuItemEnabled());
				this.deleteGraphMenuItem.setEnabled(m
						.isDeleteGraphMenuItemEnabled());
				this.quitMenuItem.setEnabled(m.isQuitMenuItemEnabled());
			}
			{// JMenu i18nMenu
				// setText
				this.i18nMenu.setText(m.getI18nMenuLabel());
				// setMnemonic
				this.i18nMenu.setMnemonic(m.getI18nMenuMnemonic());
				// setEnabled
				this.i18nMenu.setEnabled(m.isI18nMenuEnabled());
				{// JMenu i18nMenu
					// setText
					this.deDEMenuItem.setText(m.getDeDEMenuItemLabel());
					this.frFRMenuItem.setText(m.getFrFRMenuItemLabel());
					this.enUSMenuItem.setText(m.getEnUSMenuItemLabel());
					// setMnemonic
					this.deDEMenuItem.setMnemonic(m.getDeDEMenuItemMnemonic());
					this.frFRMenuItem.setMnemonic(m.getFrFRMenuItemMnemonic());
					this.enUSMenuItem.setMnemonic(m.getEnUSMenuItemMnemonic());
					// setEnabled
					this.deDEMenuItem.setEnabled(m.isDeDEMenuItemEnabled());
					this.frFRMenuItem.setEnabled(m.isFrFRMenuItemEnabled());
					this.enUSMenuItem.setEnabled(m.isEnUSMenuItemEnabled());
				}
			}
			{// JMenu infoMenu
				// setText
				this.infoMenu.setText(m.getInfoMenuLabel());
				this.helpMenuItem.setText(m.getHelpMenuItemLabel());
				this.aboutMenuItem.setText(m.getAboutMenuItemLabel());
				// setMnemonic
				this.infoMenu.setMnemonic(m.getInfoMenuMnemonic());
				this.helpMenuItem.setMnemonic(m.getHelpMenuItemMnemonic());
				this.aboutMenuItem.setMnemonic(m.getAboutMenuItemMnemonic());
				// setAccelerator
				this.helpMenuItem
						.setAccelerator(m.getHelpMenuItemAccelerator());
				this.aboutMenuItem.setAccelerator(m
						.getAboutMenuItemAccelerator());
				// setEnabled
				this.infoMenu.setEnabled(m.isInfoMenuEnabled());
				this.helpMenuItem.setEnabled(m.isHelpMenuItemEnabled());
				this.aboutMenuItem.setEnabled(m.isAboutMenuItemEnabled());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					m.getProgramName(), 1, null);
			e.printStackTrace();
		}
	}
}