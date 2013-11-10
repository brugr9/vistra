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
public final class Control implements IControl {

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
	protected final SteplengthListener steplengthListener;
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
	 */
	public Control(ICore core, Model model) {
		super();
		// Core
		this.core = core;
		// Model
		this.model = model;
		// Control
		this.fileChooser = new JFileChooser();
		this.i18nListener = new I18nListener();
		this.ioListener = new IOListener();
		this.graphSettingsListener = new GraphSettingsListener();
		this.algorithmSettingsListener = new AlgorithmSettingsListener();
		this.traversalListener = new TraversalListener();
		this.steplengthListener = new SteplengthListener();
		this.delaySettingsListener = new DelaySettingsListener();
		this.playerListener = new PlayerListener();
		this.helpListener = new HelpListener();
		this.aboutListener = new AboutListener();
		this.quitListener = new QuitListener();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception {
		try {
			this.model.setGraphs(this.core.getGraphNames());
			this.model.setAlgorithms(this.core.getAlgorithmNames());
			this.i18nListener.actionPerformed(null);
			this.appendProtocol(this.model.getResourceBundle().getString(
					"about.message")
					+ "\n----");
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
			String oldEntry = this.model.getProtocol();
			if (oldEntry.equals(""))
				this.model.setProtocol(newEntry);
			else
				this.model.setProtocol(oldEntry + "\n" + newEntry);

			this.model.notifyObservers();
		} catch (Exception ex) {
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
		this.model.setGraphsEnabled(true);
		this.model.setAlgorithmsEnabled(false);
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
		this.model.setPauseLabel(this.model.getResourceBundle().getString(
				"pause.label"));
		this.model.setPauseEvent(EventSource.PAUSE);
		this.model.setPauseEnabled(true);
		this.model.setStopEnabled(true);

		this.model.notifyObservers();

	}

	/**
	 * Sets the view elements to paused mode.
	 * 
	 */
	private void setViewPause() {

		this.model.setPauseLabel(this.model.getResourceBundle().getString(
				"resume.label"));
		this.model.setPauseEvent(EventSource.RESUME);

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
		this.model.setPauseEnabled(false);
		this.model.setStopEnabled(false);

		if (this.model.getProgress() == this.model.getProgressMaximum())
			this.setViewEnd();
		else if (this.model.getProgress() == 0)
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

		this.model.setProgress(0);
		this.model.setStepByStepEnabled(true);
		this.model.setToBeginningEnabled(false);
		this.model.setBackwardEnabled(false);

		this.model.notifyObservers();

	}

	/**
	 * Sets the view elements to end mode.
	 * 
	 */
	private void setViewEnd() {

		this.model.setProgress(this.model.getProgressMaximum());
		this.model.setStepByStepEnabled(true);
		this.model.setForwardEnabled(false);
		this.model.setToEndEnabled(false);

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
			Graph<IVertex, IEdge> graph = this.core.selectGraph("");

			// Gui
			this.model.setSelectedGraph(index);
			this.model.setAlgorithmsEnabled(true);
			this.selectAlgorithm(0);
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
			if (index == 0) {

			} else {

				this.setViewBusy();

				// Core
				// this.core.selectAlgorithm(index);
				this.core.executeTraverser(this.traversalListener);
				// Model
				this.model.setSelectedAlgorithm(index);
				// ViewType
				this.model.setProgress(0);
				this.model.setProgressMaximum(this.core.getGraphIteratorSize());
				this.setViewStop();
			}

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
				String language, country;

				if (e != null) {
					String c = e.getActionCommand();
					appendProtocol(c);

					if (c.equals(EventSource.DE_DE.toString())) {
						language = "de";
						country = "DE";
					} else if (c.equals(EventSource.FR_FR.toString())) {
						language = "fr";
						country = "FR";
					} else if (c.equals(EventSource.EN_US.toString())) {
						language = "en";
						country = "US";
					} else {
						language = System.getProperty("user.language");
						country = System.getProperty("user.country");
					}

				} else {
					language = System.getProperty("user.language");
					country = System.getProperty("user.country");
				}

				Locale locale = new Locale(language, country);

				JComponent.setDefaultLocale(locale);
				fileChooser.setLocale(locale);
				// model
				ResourceBundle b = ResourceBundle.getBundle(
						model.getI18nBaseName(), locale);
				model.setResourceBundle(b);
				model.notifyObservers();

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
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
				ResourceBundle b = model.getResourceBundle();

				// File chooser
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.setMultiSelectionEnabled(false);
				fileChooser.addChoosableFileFilter(core.getGraphFilter());
				fileChooser.addChoosableFileFilter(core.getAlgorithmFilter());
				// Parameter: Graph vs. algorithm
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
				// Event: Import vs. delete
				if (c.equals(EventSource.IMPORT_GRAPH.toString())
						|| c.equals(EventSource.IMPORT_ALGORITHM.toString())) {
					fileChooser.setApproveButtonText(b
							.getString("import.label"));
				} else {
					fileChooser.setApproveButtonText(b
							.getString("delete.label"));
					// TODO restrict access to workbench directory only
				}
				// Events
				if (c.equals(EventSource.IMPORT_GRAPH.toString())) {
					appendProtocol(b.getString("importGraph.label"));
					fileChooser
							.setDialogTitle(b.getString("importGraph.label"));
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION)
						importGraph(fileChooser.getSelectedFile());

				} else if (c.equals(EventSource.IMPORT_ALGORITHM.toString())) {
					appendProtocol(b.getString("importAlgorithm.label"));
					fileChooser.setDialogTitle(b
							.getString("importAlgorithm.label"));
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION)
						importAlgorithm(fileChooser.getSelectedFile());

				} else if (c.equals(EventSource.DELETE_GRAPH.toString())) {
					appendProtocol(b.getString("deleteGraph.label"));
					fileChooser
							.setDialogTitle(b.getString("deleteGraph.label"));
					fileChooser
							.setCurrentDirectory(core.getGraphWorkbenchDir());
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION) {
						deleteGraph(fileChooser.getSelectedFile());
						fileChooser.getUI().rescanCurrentDirectory(fileChooser);
					}

				} else if (c.equals(EventSource.DELETE_ALGORITHM.toString())) {
					appendProtocol(b.getString("deleteAlgorithm.label"));
					fileChooser.setDialogTitle(b
							.getString("deleteAlgorithm.label"));
					fileChooser.setCurrentDirectory(core
							.getAlgorithmWorkbenchDir());
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION) {
						deleteAlgorithm(fileChooser.getSelectedFile());
						fileChooser.getUI().rescanCurrentDirectory(fileChooser);
					}

				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
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
				model.setGraphs(core.getGraphNames());
				selectGraph(0);
				JOptionPane.showMessageDialog(null, model.getResourceBundle()
						.getString("import.graph.message"));
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
				model.setGraphs(core.getGraphNames());
				selectGraph(0);
				JOptionPane.showMessageDialog(null, model.getResourceBundle()
						.getString("delete.graph.message"));
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
				model.setAlgorithms(core.getAlgorithmNames());
				selectAlgorithm(0);
				JOptionPane.showMessageDialog(null, model.getResourceBundle()
						.getString("import.algorthm.message"));
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
				model.setAlgorithms(core.getAlgorithmNames());
				selectAlgorithm(0);
				JOptionPane.showMessageDialog(null, model.getResourceBundle()
						.getString("delete.algorthm.message"));
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
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
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
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
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
				String text = model.getResourceBundle().getString(
						"render.message");
				JOptionPane.showMessageDialog(null, text, model
						.getResourceBundle().getString("app.label"), 1, null);
				appendProtocol(text);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
				ex.printStackTrace();
			}
		}
	}

	/**
	 * A steplenth settings listener.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class SteplengthListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// nothing to do on gaining focus
		}

		@Override
		public void focusLost(FocusEvent e) {
			try {
				JFormattedTextField textField = (JFormattedTextField) e
						.getSource();
				int value = Integer.valueOf(textField.getText());
				model.setSteplength(value);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
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
				int value = Integer.valueOf(textField.getText());
				model.setDelay(value);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
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
				int step = model.getSteplength();
				int progress = model.getProgress();
				int min = 0;
				for (int i = 0; i < step; i++) {
					if (min < progress) {
						core.goBackward();
						model.setProgress(--progress);
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
				ex.printStackTrace();
			}
		}

		/**
		 * Sets the visualization forward.
		 * 
		 */
		private void goForward() {
			try {
				int step = model.getSteplength();
				int progress = model.getProgress();
				int max = model.getProgressMaximum();
				for (int i = 0; i < step; i++) {
					if (progress < max) {
						core.goForward();
						model.setProgress(++progress);
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
				ex.printStackTrace();
			}

		}

		@Override
		public void run() {
			while (true) {
				if (this.play) {
					try {
						int progress = model.getProgress();
						int max = model.getProgressMaximum();
						if (progress == max) {
							core.goToBeginning();
							progress = model.getProgress();
						}
						while (progress < max) {
							appendProtocol("step");
							goForward();
							progress = model.getProgress();
							Thread.sleep(model.getDelay() * 1000);
						}
						setViewStop();
						this.play = false;
					} catch (Exception ex) {
						setViewStop();
						this.play = false;
						JOptionPane.showMessageDialog(null, ex.toString(),
								model.getResourceBundle()
										.getString("app.label"), 1, null);
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
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
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
				JOptionPane.showMessageDialog(null, model.getResourceBundle()
						.getString("help.message"), model.getResourceBundle()
						.getString("help.label"), 1, null);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
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
				JOptionPane.showMessageDialog(null, model.getResourceBundle()
						.getString("about.message"), model.getResourceBundle()
						.getString("about.label"), 1, null);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
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
			int value = JOptionPane.showConfirmDialog(null, model
					.getResourceBundle().getString("quit.message"), model
					.getResourceBundle().getString("app.label"),
					JOptionPane.YES_NO_OPTION);
			if (value == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

}
