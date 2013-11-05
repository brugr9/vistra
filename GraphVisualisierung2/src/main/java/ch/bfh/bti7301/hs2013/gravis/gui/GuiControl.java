package ch.bfh.bti7301.hs2013.gravis.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.ICore;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import edu.uci.ics.jung.graph.Graph;

/**
 * A control as in MVC.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class GuiControl {

	/**
	 * A field for a Core.
	 */
	private final ICore core;
	/**
	 * A field for a GuiModel as in MVC.
	 */
	private final GuiModel guiModel;
	/**
	 * A field for a file chooser.
	 */
	private JFileChooser fileChooser;
	/**
	 * A field for an 'i18n' listener.
	 */
	protected final I18nListener i18nListener;
	/**
	 * A field for a 'data' listener.
	 */
	protected final IOListener ioListener;
	/**
	 * A field for a 'graph settings' listener.
	 */
	protected final GraphSettingsListener graphSettingsListener;
	/**
	 * A field for a 'algorithm settings' listener.
	 */
	protected final AlgorithmSettingsListener algorithmSettingsListener;
	/**
	 * A field for a 'traversal' listener.
	 */
	protected final TraversalListener traversalListener;
	/**
	 * A field for a 'step settings' listener.
	 */
	protected final StepSettingsListener stepSettingsListener;
	/**
	 * A field for a 'delay settings' listener.
	 */
	protected final DelaySettingsListener delaySettingsListener;
	/**
	 * A field for a 'player' listener.
	 */
	protected final PlayerListener playerListener;
	/**
	 * A field for a 'help' listener.
	 */
	protected final HelpListener helpListener;
	/**
	 * A field for an 'about' listener.
	 */
	protected final AboutListener aboutListener;
	/**
	 * A field for a 'quit' listener.
	 */
	protected final QuitListener quitListener;

	/**
	 * Main constructor.
	 * 
	 * @param core
	 *            a core
	 * @param guiModel
	 *            a model
	 * @param i18nBaseName
	 *            a i18n base name
	 */
	public GuiControl(ICore core, GuiModel guiModel, String i18nBaseName) {
		super();
		// Core
		this.core = core;
		// Model
		this.guiModel = guiModel;
		this.guiModel.setI18nBaseName(i18nBaseName);
		// Control
		this.fileChooser = new JFileChooser();
		this.i18nListener = new I18nListener();
		this.ioListener = new IOListener();
		this.graphSettingsListener = new GraphSettingsListener();
		this.algorithmSettingsListener = new AlgorithmSettingsListener();
		this.traversalListener = new TraversalListener();
		this.stepSettingsListener = new StepSettingsListener();
		this.delaySettingsListener = new DelaySettingsListener();
		this.playerListener = new PlayerListener();
		this.helpListener = new HelpListener();
		this.aboutListener = new AboutListener();
		this.quitListener = new QuitListener();
	}

	/**
	 * A method for initial ViewType settings on start-up,
	 * 
	 * @throws Exception
	 */
	protected void init() throws Exception {

		try {
			// i18n
			Locale locale = new Locale(System.getProperty("user.language"),
					System.getProperty("user.country"));
			this.setViewI18n(locale);
			// parameter
			this.guiModel.setGraphComboModel(this.core.getGraphNames());
			this.guiModel.setGraphComboModel(this.core.getAlgorithmNames());
			// protocol
			this.appendProtocol(guiModel.getAboutMessageText() + "----\n");
			// enable/disable elements
			this.setViewReady();
		} catch (Exception ex) {
			throw ex;
		}

	}

	/**
	 * Updates the protocol panel text.
	 * 
	 * @param newEntry
	 *            an entry to add
	 * @throws Exception
	 */
	private void appendProtocol(String newEntry) throws Exception {

		try {
			String oldEntry = this.guiModel.getProtocolPanelText();
			if (oldEntry.equals(""))
				this.guiModel.setProtocolPanelText(newEntry);
			else
				this.guiModel.setProtocolPanelText(oldEntry + "\n" + newEntry);

			this.guiModel.notifyObservers();
		} catch (Exception ex) {
			throw ex;
		}

	}

	/**
	 * Sets the language specific ViewType elements.
	 * 
	 * @param locale
	 *            the locale to set
	 * @throws Exception
	 */
	private void setViewI18n(Locale locale) throws Exception {

		try {
			// resource
			ResourceBundle b = ResourceBundle.getBundle(
					this.guiModel.getI18nBaseName(), locale);
			this.guiModel.setResourceBundle(b);

			// Control
			JComponent.setDefaultLocale(locale);
			this.fileChooser = new JFileChooser();
			this.fileChooser.setLocale(locale);
			// app name
			this.guiModel.setProgramName(b.getString("app.label"));
			{// MenuBar
				{// Label
					// Menu
					this.guiModel.setFileMenuLabel(b.getString("file.label"));
					this.guiModel.setI18nMenuLabel(b.getString("i18n.label"));
					this.guiModel.setInfoMenuLabel(b.getString("info.label"));
					// MenuItem
					// (...)
					this.guiModel.setImportAlgorithmLabel(b
							.getString("importAlgorithm.label"));
					this.guiModel.setDeleteAlgorithmLabel(b
							.getString("deleteAlgorithm.label"));
					this.guiModel.setImportGraphLabel(b
							.getString("importGraph.label"));
					this.guiModel.setDeleteGraphLabel(b
							.getString("deleteGraph.label"));
					this.guiModel.setQuitLabel(b.getString("quit.label"));
					// (...)
					this.guiModel.setDeDEMenuItemLabel(b
							.getString("deDE.label"));
					this.guiModel.setFrFRMenuItemLabel(b
							.getString("frFR.label"));
					this.guiModel.setEnUSMenuItemLabel(b
							.getString("enUS.label"));
					// (...)
					this.guiModel.setHelpMenuItemLabel(b
							.getString("help.label"));
					this.guiModel.setAboutMenuItemLabel(b
							.getString("about.label"));
				}
				{// Mnemonic / Accelerator
					// Menu
					this.guiModel.setFileMenuMnemonic(b.getString(
							"file.mnemonic").toCharArray()[0]);
					this.guiModel.setI18nMenuMnemonic(b.getString(
							"i18n.mnemonic").toCharArray()[0]);
					this.guiModel.setInfoMenuMnemonic(b.getString(
							"info.mnemonic").toCharArray()[0]);
					// MenuItem
					// Mnemonic
					this.guiModel.setQuitMenuItemMnemonic(b.getString(
							"quit.mnemonic").toCharArray()[0]);
					this.guiModel.setDeDEMenuItemMnemonic(b.getString(
							"deDE.mnemonic").toCharArray()[0]);
					this.guiModel.setFrFRMenuItemMnemonic(b.getString(
							"frFR.mnemonic").toCharArray()[0]);
					this.guiModel.setEnUSMenuItemMnemonic(b.getString(
							"enUS.mnemonic").toCharArray()[0]);
					this.guiModel.setHelpMenuItemMnemonic(b.getString(
							"help.mnemonic").toCharArray()[0]);
					this.guiModel.setAboutMenuItemMnemonic(b.getString(
							"about.mnemonic").toCharArray()[0]);
					// Accelerator
					this.guiModel.setRenderMenuItemAccelerator(KeyStroke
							.getKeyStroke(b.getString("render.accelerator")));
					this.guiModel.setQuitMenuItemAccelerator(KeyStroke
							.getKeyStroke(b.getString("quit.accelerator")));
					this.guiModel.setHelpMenuItemAccelerator(KeyStroke
							.getKeyStroke(b.getString("help.accelerator")));
					this.guiModel.setAboutMenuItemAccelerator(KeyStroke
							.getKeyStroke(b.getString("about.accelerator")));
				}
			}
			{// Parameter Panel
				this.guiModel
						.setRenderPanelLabel(b.getString("settings.label"));
				this.guiModel.setGraphLabel(b.getString("graph.label"));
				this.guiModel.setAlgorithmLabel(b.getString("algorithm.label"));
			}
			{// Visualization Panel
				this.guiModel.setVisualizationPanelLabel(b
						.getString("visualization.label"));
			}
			{// Player Panel
				this.guiModel.setStepLabel(b.getString("setStep.label"));
				this.guiModel.setDelayLabel(b.getString("setTime.label"));
				this.guiModel.setProgressLabel(b.getString("progress.label"));

				this.guiModel.setPlayerPanelLabel(b.getString("player.label"));
				this.guiModel.setPlayButtonLabel(b.getString("play.label"));
				this.guiModel.setPauseButtonLabel(b.getString("pause.label"));
				this.guiModel.setStopButtonLabel(b.getString("stop.label"));

				this.guiModel.setHomeButtonLabel(b.getString("home.label"));
				this.guiModel.setBackwardButtonLabel(b
						.getString("backward.label"));
				this.guiModel.setForwardButtonLabel(b
						.getString("forward.label"));
				this.guiModel.setEndButtonLabel(b.getString("end.label"));
			}
			{// Protocol Panel
				this.guiModel.setProtocolPanelLabel(b
						.getString("protocol.label"));
			}
			{// Pane
				this.guiModel.setImportLabel(b.getString("import.label"));
				this.guiModel.setDeleteLabel(b.getString("delete.label"));

				String title = this.guiModel.getProgramName();
				this.guiModel.setHelpMessageLabel(title + " - "
						+ b.getString("help.label"));
				this.guiModel.setHelpMessageText(b.getString("help.message"));
				this.guiModel.setAboutMessageLabel(title + " - "
						+ b.getString("about.label"));
				this.guiModel.setAboutMessageText(title + "\n"
						+ b.getString("about.message"));
				this.guiModel.setQuitMessageText(b.getString("quit.message"));
			}
			this.guiModel.notifyObservers();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

	}

	/**
	 * Sets the view elements to busy mode: disables all elements.
	 * 
	 */
	private void setViewBusy() {

		this.guiModel.setMenuEnabled(false);
		this.guiModel.setParameterEnabled(false);
		this.guiModel.setPlayerEnabled(false);

		this.guiModel.notifyObservers();

	}

	/**
	 * Sets the view elements to ready mode.
	 * 
	 */
	private void setViewReady() {

		this.guiModel.setMenuEnabled(true);
		this.guiModel.setGraphEnabled(true);
		this.guiModel.setAlgorithmEnabled(false);
		this.guiModel.setPlayerEnabled(false);

		this.guiModel.notifyObservers();
	}

	/**
	 * Sets the view elements to play mode.
	 * 
	 */
	private void setViewPlay() {

		this.guiModel.setMenuEnabled(false);
		this.guiModel.setParameterEnabled(false);

		// Player Panel
		this.guiModel.setPlayerEnabled(false);
		this.guiModel.setPauseButtonLabel(this.guiModel.getResourceBundle()
				.getString("pause.label"));
		this.guiModel.setPauseButtonActionCommand(EventSource.PAUSE.toString());
		this.guiModel.setPauseButtonEnabled(true);
		this.guiModel.setStopButtonEnabled(true);

		this.guiModel.notifyObservers();

	}

	/**
	 * Sets the view elements to paused mode.
	 * 
	 */
	private void setViewPause() {

		this.guiModel.setPauseButtonLabel(this.guiModel.getResourceBundle()
				.getString("resume.label"));
		this.guiModel
				.setPauseButtonActionCommand(EventSource.RESUME.toString());

		this.guiModel.notifyObservers();
	}

	/**
	 * Sets the view elements to stop mode.
	 * 
	 */
	private void setViewStop() {

		this.guiModel.setMenuEnabled(true);
		this.guiModel.setParameterEnabled(true);

		// Player Panel
		this.guiModel.setPlayerEnabled(true);
		this.guiModel.setPauseButtonEnabled(false);
		this.guiModel.setStopButtonEnabled(false);

		if (this.guiModel.getProgressValue() == this.guiModel
				.getProgressValueMaximum())
			this.setViewEnd();
		else if (this.guiModel.getProgressValue() == 0)
			this.setViewBeginning();
		else
			this.guiModel.setStepByStepEnabled(true);

		this.guiModel.notifyObservers();

	}

	/**
	 * Sets the view elements to beginning mode.
	 * 
	 */
	private void setViewBeginning() {

		this.guiModel.setProgressValue(0);
		this.guiModel.setStepByStepEnabled(true);
		this.guiModel.setHomeButtonEnabled(false);
		this.guiModel.setBackwardButtonEnabled(false);

		this.guiModel.notifyObservers();

	}

	/**
	 * Sets the view elements to end mode.
	 * 
	 */
	private void setViewEnd() {

		this.guiModel.setProgressValue(this.guiModel.getProgressValueMaximum());
		this.guiModel.setStepByStepEnabled(true);
		this.guiModel.setForwardButtonEnabled(false);
		this.guiModel.setEndButtonEnabled(false);

		this.guiModel.notifyObservers();

	}

	/**
	 * Selects a graph.
	 * 
	 * @param index
	 */
	private void selectGraph(int index) throws Exception {

		try {
			// Core
			// TODO mapping index -> name
			Graph<IVertex, IEdge> graph = this.core.selectGraph("");

			// Model
			this.guiModel.setGraphSelected(index);
			this.guiModel.setAlgorithmSelected(0);
			this.guiModel.setProgressValue(0);

			// ViewType
			this.guiModel.setAlgorithmEnabled(true);
			this.guiModel.setPlayerEnabled(false);

			this.guiModel.notifyObservers(graph);
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Selects an algorithm. By selecting an algorithm, the traversal gets
	 * rendered.
	 * 
	 * @param index
	 */
	private void selectAlgorithm(int index) throws Exception {

		try {
			this.setViewBusy();

			// Core
			// TODO mapping index -> name
			// this.core.selectAlgorithm(index);
			this.core.executeTraverser(this.traversalListener);
			// Model
			this.guiModel.setAlgorithmSelected(index);
			// ViewType
			this.guiModel.setProgressValue(0);
			this.guiModel.setProgressValueMaximum(this.core
					.getGraphIteratorSize());
			this.setViewStop();

		} catch (Exception e) {
			this.setViewReady();
			throw e;
		}

	}

	/**
	 * An i18n listener.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 */
	private final class I18nListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String c = e.getActionCommand();
				appendProtocol(c);
				Locale locale;

				if (c.equals(EventSource.DE_DE.toString()))
					locale = new Locale("de", "DE");
				else if (c.equals(EventSource.FR_FR.toString()))
					locale = new Locale("fr", "FR");
				else if (c.equals(EventSource.EN_US.toString()))
					locale = new Locale("en", "US");
				else
					locale = new Locale(System.getProperty("user.language"),
							System.getProperty("user.country"));

				setViewI18n(locale);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						guiModel.getProgramName(), 1, null);
				ex.printStackTrace();
			}
		}
	}

	/**
	 * A data listener.
	 * <p>
	 * Handles import and deletion of graphs or algorithms by getting the files
	 * from a file chooser.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 * @see {@url http://java-tutorial.org/jfilechooser.html }
	 * @see {@url
	 *      http://docs.oracle.com/javase/tutorial/uiswing/components
	 *      /filechooser .html }
	 */
	private final class IOListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {

				String c = e.getActionCommand();
				int option;
				JComponent top = (JComponent) ((JComponent) e.getSource())
						.getTopLevelAncestor();

				// File chooser
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.setMultiSelectionEnabled(false);
				fileChooser.addChoosableFileFilter(core.getGraphFilter());
				fileChooser.addChoosableFileFilter(core.getAlgorithmFilter());
				// Graph vs. algorithm
				if (c.equals(EventSource.IMPORT_GRAPH.toString())
						|| c.equals(EventSource.DELETE_GRAPH.toString())) {
					fileChooser.setFileFilter(core.getGraphFilter());
					fileChooser.removeChoosableFileFilter(core
							.getAlgorithmFilter());
				} else {
					fileChooser.setFileFilter(core.getAlgorithmFilter());
					fileChooser
							.removeChoosableFileFilter(core.getGraphFilter());
				}
				// Import vs. delete
				if (c.equals(EventSource.IMPORT_GRAPH.toString())
						|| c.equals(EventSource.IMPORT_ALGORITHM.toString())) {
					fileChooser.setApproveButtonText(guiModel.getImportLabel());
				} else {
					fileChooser.setApproveButtonText(guiModel.getDeleteLabel());
					// TODO restrict access to workbench directory only
				}
				// Events
				if (c.equals(EventSource.IMPORT_GRAPH.toString())) {
					appendProtocol(guiModel.getImportGraphLabel());
					fileChooser.setDialogTitle(guiModel.getImportGraphLabel());
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION)
						importGraph(fileChooser.getSelectedFile());

				} else if (c.equals(EventSource.IMPORT_ALGORITHM.toString())) {
					appendProtocol(guiModel.getImportAlgorithmLabel());
					fileChooser.setDialogTitle(guiModel
							.getImportAlgorithmLabel());
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION)
						importAlgorithm(fileChooser.getSelectedFile());

				} else if (c.equals(EventSource.DELETE_GRAPH.toString())) {
					appendProtocol(guiModel.getDeleteGraphLabel());
					fileChooser.setDialogTitle(guiModel.getDeleteGraphLabel());
					fileChooser
							.setCurrentDirectory(core.getGraphWorkbenchDir());
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION) {
						deleteGraph(fileChooser.getSelectedFile());
						fileChooser.getUI().rescanCurrentDirectory(fileChooser);
					}

				} else if (c.equals(EventSource.DELETE_ALGORITHM.toString())) {
					appendProtocol(guiModel.getDeleteAlgorithmLabel());
					fileChooser.setDialogTitle(guiModel
							.getDeleteAlgorithmLabel());
					fileChooser.setCurrentDirectory(core
							.getAlgorithmWorkbenchDir());
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION) {
						deleteAlgorithm(fileChooser.getSelectedFile());
						fileChooser.getUI().rescanCurrentDirectory(fileChooser);
					}

				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						guiModel.getProgramName(), 1, null);
				ex.printStackTrace();
			}

		}

		/**
		 * Imports a graph.
		 * 
		 * @param file
		 *            the file to import
		 * @throws Exception
		 */
		private void importGraph(File file) throws Exception {
			try {
				core.importGraph(file);
				guiModel.setGraphComboModel(core.getGraphNames());
				selectGraph(0);
				JOptionPane.showMessageDialog(null, guiModel
						.getResourceBundle().getString("import.graph.message"));
			} catch (Exception ex) {
				throw ex;
			}

		}

		/**
		 * Deletes a graph.
		 * 
		 * @param file
		 *            the file to delete
		 * @throws Exception
		 */
		private void deleteGraph(File file) throws Exception {

			try {
				core.deleteGraph(file);
				guiModel.setGraphComboModel(core.getGraphNames());
				selectGraph(0);
				JOptionPane.showMessageDialog(null, guiModel
						.getResourceBundle().getString("delete.graph.message"));
			} catch (Exception ex) {
				throw ex;
			}

		}

		/**
		 * Imports an algorithm.
		 * 
		 * @param file
		 *            the file to import
		 * @throws Exception
		 */
		private void importAlgorithm(File file) throws Exception {

			try {
				core.importAlgorithm(file);
				guiModel.setAlgorithmComboModel(core.getAlgorithmNames());
				selectAlgorithm(0);
				JOptionPane.showMessageDialog(
						null,
						guiModel.getResourceBundle().getString(
								"import.algorthm.message"));
			} catch (Exception ex) {
				throw ex;
			}

		}

		/**
		 * Deletes an algorithm.
		 * 
		 * @param file
		 *            the file to delete
		 * @throws Exception
		 */
		private void deleteAlgorithm(File file) throws Exception {

			try {
				core.deleteAlgorithm(file);
				guiModel.setAlgorithmComboModel(core.getAlgorithmNames());
				selectAlgorithm(0);
				JOptionPane.showMessageDialog(
						null,
						guiModel.getResourceBundle().getString(
								"delete.algorthm.message"));
			} catch (Exception ex) {
				throw ex;
			}

		}
	}

	/**
	 * A graph settings listener.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class GraphSettingsListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			try {
				@SuppressWarnings("unchecked")
				JComboBox<IGravisGraph> box = (JComboBox<IGravisGraph>) e
						.getSource();
				int index = box.getSelectedIndex();
				// String graphName = (String) box.getSelectedItem();
				selectGraph(index);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						guiModel.getProgramName(), 1, null);
				ex.printStackTrace();
			}
		}

	}

	/**
	 * An algorithm settings listener.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class AlgorithmSettingsListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			try {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					@SuppressWarnings("unchecked")
					JComboBox<IAlgorithm> box = (JComboBox<IAlgorithm>) e
							.getSource();
					int index = box.getSelectedIndex();
					selectAlgorithm(index);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						guiModel.getProgramName(), 1, null);
				ex.printStackTrace();
			}
		}
	}

	/**
	 * A traverser listener.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	// TODO interface
	private class TraversalListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			try {
				// TODO i18n
				String traversal = "Traversal: ready.";
				JOptionPane.showMessageDialog(null, traversal,
						guiModel.getProgramName(), 1, null);
				appendProtocol(traversal);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						guiModel.getProgramName(), 1, null);
				ex.printStackTrace();
			}
		}
	}

	/**
	 * A step settings listener.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class StepSettingsListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// nothing to do on gaining focus
		}

		@Override
		public void focusLost(FocusEvent e) {
			try {
				JFormattedTextField textField = (JFormattedTextField) e
						.getSource();
				int newValue = Integer.valueOf(textField.getText());
				guiModel.setStepValue(newValue);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						guiModel.getProgramName(), 1, null);
				ex.printStackTrace();
			}
		}

	}

	/**
	 * A delay settings listener.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class DelaySettingsListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// nothing to do on gaining focus
		}

		@Override
		public void focusLost(FocusEvent e) {
			try {
				JFormattedTextField textField = (JFormattedTextField) e
						.getSource();
				int newValue = Integer.valueOf(textField.getText());
				guiModel.setDelayValue(newValue);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						guiModel.getProgramName(), 1, null);
				ex.printStackTrace();
			}
		}

	}

	/**
	 * A thread as player action listener.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class PlayerListener extends Thread implements ActionListener {

		/**
		 * A field for a play status.
		 */
		private boolean play;

		/**
		 * Main constructor, marks this Thread as daemon.
		 */
		public PlayerListener() {
			this.setDaemon(true);
		}

		/**
		 * Sets the visualization backward.
		 * 
		 */
		private void goBackward() {
			try {
				int step = guiModel.getStepValue();
				int progress = guiModel.getProgressValue();
				int min = 0;
				for (int i = 0; i < step; i++) {
					if (min < progress) {
						core.goBackward();
						guiModel.setProgressValue(--progress);
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						guiModel.getProgramName(), 1, null);
				ex.printStackTrace();
			}
		}

		/**
		 * Sets the visualization forward.
		 * 
		 */
		private void goForward() {
			try {
				int step = guiModel.getStepValue();
				int progress = guiModel.getProgressValue();
				int max = guiModel.getProgressValueMaximum();
				for (int i = 0; i < step; i++) {
					if (progress < max) {
						core.goForward();
						guiModel.setProgressValue(++progress);
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						guiModel.getProgramName(), 1, null);
				ex.printStackTrace();
			}

		}

		@Override
		public void run() {
			while (true) {
				if (this.play) {
					try {
						int progress = guiModel.getProgressValue();
						int max = guiModel.getProgressValueMaximum();
						if (progress == max) {
							core.goToBeginning();
							progress = guiModel.getProgressValue();
						}
						while (progress < max) {
							appendProtocol("step");
							goForward();
							progress = guiModel.getProgressValue();
							Thread.sleep(guiModel.getDelayValue() * 1000);
						}
						setViewStop();
						this.play = false;
					} catch (Exception ex) {
						setViewStop();
						this.play = false;
						JOptionPane.showMessageDialog(null, ex.toString(),
								guiModel.getProgramName(), 1, null);
						ex.printStackTrace();
					}
				}
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String c = e.getActionCommand();
				appendProtocol(c);
				if (c.equals(EventSource.PLAY.toString())) {
					setViewPlay();
					this.play = true;
					this.start();
				} else if (c.equals(EventSource.PAUSE.toString())) {
					this.play = false;
					setViewPause();
				} else if (c.equals(EventSource.RESUME.toString())) {
					// setViewStop();
					setViewPlay();
					this.play = true;
				} else if (c.equals(EventSource.STOP.toString())) {
					this.play = false;
					setViewStop();
				} else if (c.equals(EventSource.BACKWARD.toString())) {
					setViewPlay();
					goBackward();
					setViewStop();
				} else if (c.equals(EventSource.FORWARD.toString())) {
					setViewPlay();
					goForward();
					setViewStop();
				} else if (c.equals(EventSource.GOTO_BEGINNING.toString())) {
					setViewPlay();
					core.goToBeginning();
					setViewStop();
				} else if (c.equals(EventSource.GOTO_END.toString())) {
					setViewPlay();
					core.goToEnd();
					setViewStop();
				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						guiModel.getProgramName(), 1, null);
				ex.printStackTrace();
			}
		}

	}

	/**
	 * A listener for getting some help and advice.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class HelpListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				JOptionPane.showMessageDialog(null,
						guiModel.getHelpMessageText(),
						guiModel.getHelpMessageLabel(), 1, null);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						guiModel.getProgramName(), 1, null);
				ex.printStackTrace();
			}
		}

	}

	/**
	 * A listener for getting some background information about the program.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class AboutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				JOptionPane.showMessageDialog(null,
						guiModel.getAboutMessageText(),
						guiModel.getAboutMessageLabel(), 1, null);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						guiModel.getProgramName(), 1, null);
				ex.printStackTrace();
			}
		}

	}

	/**
	 * A listener for quitting the program.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class QuitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int value = JOptionPane.showConfirmDialog(null,
					guiModel.getQuitMessageText(), guiModel.getQuitLabel(),
					JOptionPane.YES_NO_OPTION);
			if (value == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

	/**
	 * Constants for different kind of GUI events.
	 * 
	 * @author Patrick Kofmel (kofmp1@bfh.ch)
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	protected enum EventSource {
		// i18n
		DE_DE, FR_FR, EN_US,
		// data, graph
		IMPORT_GRAPH, DELETE_GRAPH,
		// data, algorithm
		IMPORT_ALGORITHM, DELETE_ALGORITHM,
		// player settings
		SET_DELAY, SET_STEP,
		// player
		GOTO_BEGINNING, BACKWARD, FORWARD, GOTO_END, PLAY, PAUSE, RESUME, STOP,
	}

}
