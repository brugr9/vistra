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
public final class Control implements  IControl {

	/**
	 * A field for a Core.
	 */
	private final ICore core;
	/**
	 * A field for a Model as in MVC.
	 */
	private final Model model;
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
	 * @param model
	 *            a model
	 * @param i18nBaseName
	 *            a i18n base name
	 */
	public Control(ICore core, Model model, String i18nBaseName) {
		super();
		// Core
		this.core = core;
		// Model
		this.model = model;
		this.model.setI18nBaseName(i18nBaseName);
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
			this.model.setGraphComboModel(this.core.getGraphNames());
			this.model.setGraphComboModel(this.core.getAlgorithmNames());
			// protocol
			this.appendProtocol(model.getAboutMessageText() + "----\n");
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
			String oldEntry = this.model.getProtocolPanelText();
			if (oldEntry.equals(""))
				this.model.setProtocolPanelText(newEntry);
			else
				this.model.setProtocolPanelText(oldEntry + "\n" + newEntry);

			this.model.notifyObservers();
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
					this.model.getI18nBaseName(), locale);
			this.model.setResourceBundle(b);

			// Control
			JComponent.setDefaultLocale(locale);
			this.fileChooser = new JFileChooser();
			this.fileChooser.setLocale(locale);
			// app name
			this.model.setProgramName(b.getString("app.label"));
			{// MenuBar
				{// Label
					// Menu
					this.model.setFileMenuLabel(b.getString("file.label"));
					this.model.setI18nMenuLabel(b.getString("i18n.label"));
					this.model.setInfoMenuLabel(b.getString("info.label"));
					// MenuItem
					// (...)
					this.model.setImportAlgorithmLabel(b
							.getString("importAlgorithm.label"));
					this.model.setDeleteAlgorithmLabel(b
							.getString("deleteAlgorithm.label"));
					this.model.setImportGraphLabel(b
							.getString("importGraph.label"));
					this.model.setDeleteGraphLabel(b
							.getString("deleteGraph.label"));
					this.model.setQuitLabel(b.getString("quit.label"));
					// (...)
					this.model.setDeDEMenuItemLabel(b
							.getString("deDE.label"));
					this.model.setFrFRMenuItemLabel(b
							.getString("frFR.label"));
					this.model.setEnUSMenuItemLabel(b
							.getString("enUS.label"));
					// (...)
					this.model.setHelpMenuItemLabel(b
							.getString("help.label"));
					this.model.setAboutMenuItemLabel(b
							.getString("about.label"));
				}
				{// Mnemonic / Accelerator
					// Menu
					this.model.setFileMenuMnemonic(b.getString(
							"file.mnemonic").toCharArray()[0]);
					this.model.setI18nMenuMnemonic(b.getString(
							"i18n.mnemonic").toCharArray()[0]);
					this.model.setInfoMenuMnemonic(b.getString(
							"info.mnemonic").toCharArray()[0]);
					// MenuItem
					// Mnemonic
					this.model.setQuitMenuItemMnemonic(b.getString(
							"quit.mnemonic").toCharArray()[0]);
					this.model.setDeDEMenuItemMnemonic(b.getString(
							"deDE.mnemonic").toCharArray()[0]);
					this.model.setFrFRMenuItemMnemonic(b.getString(
							"frFR.mnemonic").toCharArray()[0]);
					this.model.setEnUSMenuItemMnemonic(b.getString(
							"enUS.mnemonic").toCharArray()[0]);
					this.model.setHelpMenuItemMnemonic(b.getString(
							"help.mnemonic").toCharArray()[0]);
					this.model.setAboutMenuItemMnemonic(b.getString(
							"about.mnemonic").toCharArray()[0]);
					// Accelerator
					this.model.setRenderMenuItemAccelerator(KeyStroke
							.getKeyStroke(b.getString("render.accelerator")));
					this.model.setQuitMenuItemAccelerator(KeyStroke
							.getKeyStroke(b.getString("quit.accelerator")));
					this.model.setHelpMenuItemAccelerator(KeyStroke
							.getKeyStroke(b.getString("help.accelerator")));
					this.model.setAboutMenuItemAccelerator(KeyStroke
							.getKeyStroke(b.getString("about.accelerator")));
				}
			}
			{// Parameter Panel
				this.model
						.setRenderPanelLabel(b.getString("settings.label"));
				this.model.setGraphLabel(b.getString("graph.label"));
				this.model.setAlgorithmLabel(b.getString("algorithm.label"));
			}
			{// Visualization Panel
				this.model.setVisualizationPanelLabel(b
						.getString("visualization.label"));
			}
			{// Player Panel
				this.model.setStepLabel(b.getString("setStep.label"));
				this.model.setDelayLabel(b.getString("setTime.label"));
				this.model.setProgressLabel(b.getString("progress.label"));

				this.model.setPlayerPanelLabel(b.getString("player.label"));
				this.model.setPlayButtonLabel(b.getString("play.label"));
				this.model.setPauseButtonLabel(b.getString("pause.label"));
				this.model.setStopButtonLabel(b.getString("stop.label"));

				this.model.setHomeButtonLabel(b.getString("home.label"));
				this.model.setBackwardButtonLabel(b
						.getString("backward.label"));
				this.model.setForwardButtonLabel(b
						.getString("forward.label"));
				this.model.setEndButtonLabel(b.getString("end.label"));
			}
			{// Protocol Panel
				this.model.setProtocolPanelLabel(b
						.getString("protocol.label"));
			}
			{// Pane
				this.model.setImportLabel(b.getString("import.label"));
				this.model.setDeleteLabel(b.getString("delete.label"));

				String title = this.model.getProgramName();
				this.model.setHelpMessageLabel(title + " - "
						+ b.getString("help.label"));
				this.model.setHelpMessageText(b.getString("help.message"));
				this.model.setAboutMessageLabel(title + " - "
						+ b.getString("about.label"));
				this.model.setAboutMessageText(title + "\n"
						+ b.getString("about.message"));
				this.model.setQuitMessageText(b.getString("quit.message"));
			}
			this.model.notifyObservers();
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

		this.model.setMenuEnabled(false);
		this.model.setParameterEnabled(false);
		this.model.setPlayerEnabled(false);

		this.model.notifyObservers();

	}

	/**
	 * Sets the view elements to ready mode.
	 * 
	 */
	private void setViewReady() {

		this.model.setMenuEnabled(true);
		this.model.setGraphEnabled(true);
		this.model.setAlgorithmEnabled(false);
		this.model.setPlayerEnabled(false);

		this.model.notifyObservers();
	}

	/**
	 * Sets the view elements to play mode.
	 * 
	 */
	private void setViewPlay() {

		this.model.setMenuEnabled(false);
		this.model.setParameterEnabled(false);

		// Player Panel
		this.model.setPlayerEnabled(false);
		this.model.setPauseButtonLabel(this.model.getResourceBundle()
				.getString("pause.label"));
		this.model.setPauseButtonActionCommand(EventSource.PAUSE.toString());
		this.model.setPauseButtonEnabled(true);
		this.model.setStopButtonEnabled(true);

		this.model.notifyObservers();

	}

	/**
	 * Sets the view elements to paused mode.
	 * 
	 */
	private void setViewPause() {

		this.model.setPauseButtonLabel(this.model.getResourceBundle()
				.getString("resume.label"));
		this.model
				.setPauseButtonActionCommand(EventSource.RESUME.toString());

		this.model.notifyObservers();
	}

	/**
	 * Sets the view elements to stop mode.
	 * 
	 */
	private void setViewStop() {

		this.model.setMenuEnabled(true);
		this.model.setParameterEnabled(true);

		// Player Panel
		this.model.setPlayerEnabled(true);
		this.model.setPauseButtonEnabled(false);
		this.model.setStopButtonEnabled(false);

		if (this.model.getProgressValue() == this.model
				.getProgressValueMaximum())
			this.setViewEnd();
		else if (this.model.getProgressValue() == 0)
			this.setViewBeginning();
		else
			this.model.setStepByStepEnabled(true);

		this.model.notifyObservers();

	}

	/**
	 * Sets the view elements to beginning mode.
	 * 
	 */
	private void setViewBeginning() {

		this.model.setProgressValue(0);
		this.model.setStepByStepEnabled(true);
		this.model.setHomeButtonEnabled(false);
		this.model.setBackwardButtonEnabled(false);

		this.model.notifyObservers();

	}

	/**
	 * Sets the view elements to end mode.
	 * 
	 */
	private void setViewEnd() {

		this.model.setProgressValue(this.model.getProgressValueMaximum());
		this.model.setStepByStepEnabled(true);
		this.model.setForwardButtonEnabled(false);
		this.model.setEndButtonEnabled(false);

		this.model.notifyObservers();

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
			this.model.setGraphSelected(index);
			this.model.setAlgorithmSelected(0);
			this.model.setProgressValue(0);

			// ViewType
			this.model.setAlgorithmEnabled(true);
			this.model.setPlayerEnabled(false);

			this.model.notifyObservers(graph);
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
			this.model.setAlgorithmSelected(index);
			// ViewType
			this.model.setProgressValue(0);
			this.model.setProgressValueMaximum(this.core
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
						model.getProgramName(), 1, null);
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
					fileChooser.setApproveButtonText(model.getImportLabel());
				} else {
					fileChooser.setApproveButtonText(model.getDeleteLabel());
					// TODO restrict access to workbench directory only
				}
				// Events
				if (c.equals(EventSource.IMPORT_GRAPH.toString())) {
					appendProtocol(model.getImportGraphLabel());
					fileChooser.setDialogTitle(model.getImportGraphLabel());
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION)
						importGraph(fileChooser.getSelectedFile());

				} else if (c.equals(EventSource.IMPORT_ALGORITHM.toString())) {
					appendProtocol(model.getImportAlgorithmLabel());
					fileChooser.setDialogTitle(model
							.getImportAlgorithmLabel());
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION)
						importAlgorithm(fileChooser.getSelectedFile());

				} else if (c.equals(EventSource.DELETE_GRAPH.toString())) {
					appendProtocol(model.getDeleteGraphLabel());
					fileChooser.setDialogTitle(model.getDeleteGraphLabel());
					fileChooser
							.setCurrentDirectory(core.getGraphWorkbenchDir());
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION) {
						deleteGraph(fileChooser.getSelectedFile());
						fileChooser.getUI().rescanCurrentDirectory(fileChooser);
					}

				} else if (c.equals(EventSource.DELETE_ALGORITHM.toString())) {
					appendProtocol(model.getDeleteAlgorithmLabel());
					fileChooser.setDialogTitle(model
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
						model.getProgramName(), 1, null);
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
				model.setGraphComboModel(core.getGraphNames());
				selectGraph(0);
				JOptionPane.showMessageDialog(null, model
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
				model.setGraphComboModel(core.getGraphNames());
				selectGraph(0);
				JOptionPane.showMessageDialog(null, model
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
				model.setAlgorithmComboModel(core.getAlgorithmNames());
				selectAlgorithm(0);
				JOptionPane.showMessageDialog(
						null,
						model.getResourceBundle().getString(
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
				model.setAlgorithmComboModel(core.getAlgorithmNames());
				selectAlgorithm(0);
				JOptionPane.showMessageDialog(
						null,
						model.getResourceBundle().getString(
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
						model.getProgramName(), 1, null);
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
						model.getProgramName(), 1, null);
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
						model.getProgramName(), 1, null);
				appendProtocol(traversal);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						model.getProgramName(), 1, null);
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
				model.setStepValue(newValue);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						model.getProgramName(), 1, null);
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
				model.setDelayValue(newValue);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						model.getProgramName(), 1, null);
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
				int step = model.getStepValue();
				int progress = model.getProgressValue();
				int min = 0;
				for (int i = 0; i < step; i++) {
					if (min < progress) {
						core.goBackward();
						model.setProgressValue(--progress);
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						model.getProgramName(), 1, null);
				ex.printStackTrace();
			}
		}

		/**
		 * Sets the visualization forward.
		 * 
		 */
		private void goForward() {
			try {
				int step = model.getStepValue();
				int progress = model.getProgressValue();
				int max = model.getProgressValueMaximum();
				for (int i = 0; i < step; i++) {
					if (progress < max) {
						core.goForward();
						model.setProgressValue(++progress);
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						model.getProgramName(), 1, null);
				ex.printStackTrace();
			}

		}

		@Override
		public void run() {
			while (true) {
				if (this.play) {
					try {
						int progress = model.getProgressValue();
						int max = model.getProgressValueMaximum();
						if (progress == max) {
							core.goToBeginning();
							progress = model.getProgressValue();
						}
						while (progress < max) {
							appendProtocol("step");
							goForward();
							progress = model.getProgressValue();
							Thread.sleep(model.getDelayValue() * 1000);
						}
						setViewStop();
						this.play = false;
					} catch (Exception ex) {
						setViewStop();
						this.play = false;
						JOptionPane.showMessageDialog(null, ex.toString(),
								model.getProgramName(), 1, null);
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
						model.getProgramName(), 1, null);
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
						model.getHelpMessageText(),
						model.getHelpMessageLabel(), 1, null);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						model.getProgramName(), 1, null);
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
						model.getAboutMessageText(),
						model.getAboutMessageLabel(), 1, null);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(),
						model.getProgramName(), 1, null);
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
					model.getQuitMessageText(), model.getQuitLabel(),
					JOptionPane.YES_NO_OPTION);
			if (value == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

}
