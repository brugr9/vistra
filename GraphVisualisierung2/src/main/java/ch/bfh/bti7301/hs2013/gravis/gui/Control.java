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

import ch.bfh.bti7301.hs2013.gravis.core.ICore;
import ch.bfh.bti7301.hs2013.gravis.core.TraversalChangeEvent;
import ch.bfh.bti7301.hs2013.gravis.core.TraversalChangeListener;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;

/**
 * A control as in MVC.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class Control implements IControl {

	/**
	 * A field for a core.
	 */
	private final ICore core;
	/**
	 * A field for a model as in MVC.
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
	 * A field for a 'select graph' listener.
	 */
	protected final SelectGraphListener selectGraphListener;
	/**
	 * A field for a 'select algorithm' listener.
	 */
	protected final SelectAlgorithmListener selectAlgorithmListener;
	/**
	 * A field for a 'traversal' listener.
	 */
	protected final TraversalListener traversalListener;
	/**
	 * A field for a 'set steplength' listener.
	 */
	protected final SetSteplengthListener setSteplengthListener;
	/**
	 * A field for a 'set delay' listener.
	 */
	protected final SetDelayListener setDelayListener;
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
		this.selectGraphListener = new SelectGraphListener();
		this.selectAlgorithmListener = new SelectAlgorithmListener();
		this.traversalListener = new TraversalListener();
		this.setSteplengthListener = new SetSteplengthListener();
		this.setDelayListener = new SetDelayListener();
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
			this.model.setGraphs(this.core.getGraphs());
			this.model.setPauseEvent(EventSource.PAUSE);
			this.i18nListener.actionPerformed(null);
			this.appendProtocol(this.model.getResourceBundle().getString(
					"about.message")
					+ "\n----");
			this.setViewChoiceGraph();
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
	 * Sets the view elements ready for graph choice.
	 * 
	 */
	private void setViewChoiceGraph() {

		this.model.setMenuEnabled(true);
		this.model.setGraphsEnabled(true);
		this.model.setAlgorithmsEnabled(false);
		this.model.setPlayerEnabled(false);

		this.model.notifyObservers();
	}

	/**
	 * Sets the view elements ready for algorithm choice.
	 * 
	 */
	private void setViewChoiceAlgorithm() {

		// this.model.setMenuEnabled(true);
		// this.model.setGraphsEnabled(true);
		this.model.setAlgorithmsEnabled(true);
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

		// as shown in sd-select-graph
		try {
			// graph
			IGravisGraph graph = this.core.selectGraph(index);
			this.model.setGraph(graph);
			this.model.setSelectedGraph(index);
			// algorithm
			String[] names = this.core.getAlgorithms();
			this.model.setAlgorithms(names);
			this.model.setSelectedAlgorithm(0);
			// view
			if (index == 0) {
				this.setViewChoiceGraph();
			} else {
				this.setViewChoiceAlgorithm();
			}
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

			this.model.setSelectedAlgorithm(index);
			this.model.setProgress(0);

			if (index == 0) {
				this.model.setProgressMaximum(0);
				this.model.setPlayerEnabled(false);
				this.model.notifyObservers();
			} else {
				this.setViewBusy();
				this.core.selectAlgorithm(index);
				this.core.executeTraverser(this.traversalListener);
				this.model.setProgressMaximum(this.core.getGraphIteratorSize());
				this.setViewStop();
			}

		} catch (Exception e) {
			this.setViewChoiceGraph();
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
				model.notifyObservers(EventSource.I18N);

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

				ResourceBundle b = model.getResourceBundle();
				String c = e.getActionCommand();
				JComponent top = (JComponent) ((JComponent) e.getSource())
						.getTopLevelAncestor();
				int option = 0;
				String msg = "";

				{// File chooser settings
					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fileChooser.setAcceptAllFileFilterUsed(false);
					fileChooser.setMultiSelectionEnabled(false);
					fileChooser.addChoosableFileFilter(core.getGraphFilter());
					fileChooser.addChoosableFileFilter(core
							.getAlgorithmFilter());
					// Graph vs. algorithm
					if (c.equals(EventSource.IMPORT_GRAPH.toString())
							|| c.equals(EventSource.DELETE_GRAPH.toString())) {
						fileChooser.setFileFilter(core.getGraphFilter());
						fileChooser.removeChoosableFileFilter(core
								.getAlgorithmFilter());
					} else if (c
							.equals(EventSource.IMPORT_ALGORITHM.toString())
							|| c.equals(EventSource.DELETE_ALGORITHM.toString())) {
						fileChooser.setFileFilter(core.getAlgorithmFilter());
						fileChooser.removeChoosableFileFilter(core
								.getGraphFilter());
					}
					// Import vs. delete
					if (c.equals(EventSource.IMPORT_GRAPH.toString())
							|| c.equals(EventSource.IMPORT_ALGORITHM.toString())) {
						fileChooser.setApproveButtonText(b
								.getString("import.label"));
					} else if (c.equals(EventSource.DELETE_GRAPH.toString())
							|| c.equals(EventSource.DELETE_ALGORITHM.toString())) {
						fileChooser.setApproveButtonText(b
								.getString("delete.label"));
						// TODO restrict access to workbench directory only
					}
				}
				// Events
				if (c.equals(EventSource.IMPORT_GRAPH.toString())) {
					// Import graph
					appendProtocol(b.getString("importGraph.label"));
					fileChooser
							.setDialogTitle(b.getString("importGraph.label"));
					// as shown in sd-import-graph
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION) {
						File source = fileChooser.getSelectedFile();
						String[] names = core.importGraph(source);
						model.setGraphs(names);
						selectGraph(0);
						msg = b.getString("import.graph.message");
					}
				} else if (c.equals(EventSource.IMPORT_ALGORITHM.toString())) {
					// Import algorithm
					appendProtocol(b.getString("importAlgorithm.label"));
					fileChooser.setDialogTitle(b
							.getString("importAlgorithm.label"));
					// as shown in sd-import-algorithm
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION) {
						File source = fileChooser.getSelectedFile();
						String[] names = core.importAlgorithm(source);
						model.setAlgorithms(names);
						selectAlgorithm(0);
						msg = b.getString("import.algorthm.message");
					}
				} else if (c.equals(EventSource.DELETE_GRAPH.toString())) {
					// Delete graph
					appendProtocol(b.getString("deleteGraph.label"));
					fileChooser
							.setDialogTitle(b.getString("deleteGraph.label"));
					fileChooser
							.setCurrentDirectory(core.getGraphWorkbenchDir());
					// as shown in sd-delete-graph
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();
						String[] names = core.deleteGraph(file);
						model.setGraphs(names);
						selectGraph(0);
						msg = b.getString("delete.graph.message");
					}
				} else if (c.equals(EventSource.DELETE_ALGORITHM.toString())) {
					// Delete algorithm
					appendProtocol(b.getString("deleteAlgorithm.label"));
					fileChooser.setDialogTitle(b
							.getString("deleteAlgorithm.label"));
					fileChooser.setCurrentDirectory(core
							.getAlgorithmWorkbenchDir());
					// as shown in sd-delete-algorithm
					option = fileChooser.showDialog(top, null);
					if (option == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();
						String[] names = core.deleteAlgorithm(file);
						model.setAlgorithms(names);
						selectAlgorithm(0);
						msg = b.getString("delete.algorthm.message");
					}
				}

				fileChooser.getUI().rescanCurrentDirectory(fileChooser);
				appendProtocol(msg);
				JOptionPane.showMessageDialog(null, msg);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
				ex.printStackTrace();
			}

		}
	}

	/**
	 * A select graph listener.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class SelectGraphListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent event) {
			try {
				@SuppressWarnings("unchecked")
				JComboBox<IGravisGraph> box = (JComboBox<IGravisGraph>) event
						.getSource();
				// as shown in sd-select-graph
				int index = box.getSelectedIndex();
				selectGraph(index);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
				ex.printStackTrace();
			}
		}

	}

	/**
	 * A select algorithm listener.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class SelectAlgorithmListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			try {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					@SuppressWarnings("unchecked")
					JComboBox<IAlgorithm> box = (JComboBox<IAlgorithm>) e
							.getSource();
					// as shown in sd-select-algorithm
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
	private class TraversalListener implements TraversalChangeListener {

		@Override
		public void stateChanged(TraversalChangeEvent e) {
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
	 * A set steplenth listener.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class SetSteplengthListener implements FocusListener {

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
				model.notifyObservers(EventSource.SET_STEPLENGTH);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
				ex.printStackTrace();
			}
		}

	}

	/**
	 * A set delay listener.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class SetDelayListener implements FocusListener {

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
				model.notifyObservers(EventSource.SET_DELAY);
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
