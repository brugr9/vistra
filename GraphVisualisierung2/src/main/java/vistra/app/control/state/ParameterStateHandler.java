package vistra.app.control.state;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.app.IModel;
import vistra.app.Model;
import vistra.framework.IParameterManager;
import vistra.framework.graph.ILayoutGraph;
import vistra.framework.graph.item.ILayoutEdge;
import vistra.framework.graph.item.ILayoutVertex;
import vistra.framework.traversal.ITraversal;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;

/**
 * A parameter handler: handles a graph and an algorithm as parameter for
 * generating a traversal-object.
 * <p>
 * As part of the graphic user interface control, this state handler is an
 * action listener (graph I/O and item value editing), a graph-event listener
 * (adding/deletion of graph item) and an item listener (algorithm selection),
 * too.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see StepByStep
 * @see Animation
 */
public final class ParameterStateHandler implements IParameterStateHandler {

	/**
	 * A field for a state.
	 */
	private AbstractParameterState state;
	/**
	 * A field for a parameter manager.
	 */
	private IParameterManager parameterManager;
	/**
	 * A field for a model.
	 */
	private Model model;

	/**
	 * Main constructor.
	 * 
	 * @param parameterManager
	 *            a parameter manager
	 * @param model
	 *            a gui model
	 */
	public ParameterStateHandler(IParameterManager parameterManager,
			IModel model) {
		super();
		this.parameterManager = parameterManager;
		this.model = (Model) model;
		try {
			this.state = new ParameterOff(this);
			// as we like to start with a call for handleNewGraphUndirected() or
			// handleNewGraphDirected(),
			// setGraphSaved(true) denies the confirmSavingGraph():
			this.model.setGraphSaved(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Related to menu item.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			String c = e.getActionCommand();
			Container top = (Container) ((JComponent) e.getSource())
					.getTopLevelAncestor();
			this.model.setTop(top);

			if (c.equals(ParameterEvent.newUndirected)) {
				this.handleNewGraphUndirected();
			} else if (c.equals(ParameterEvent.newDirected)) {
				this.handleNewGraphDirected();
			} else if (c.equals(ParameterEvent.open)) {
				this.handleOpenGraph();
			} else if (c.equals(ParameterEvent.save)) {
				this.handleSaveGraph();
			} else if (c.equals(ParameterEvent.saveAs)) {
				this.handleSaveGraphAs();
			} else if (c.equals(ParameterEvent.edit)) {
				this.handleEditGraph();
			} else if (c.equals(ParameterEvent.start)) {
				// TODO this.handleEditStart();
			} else if (c.equals(ParameterEvent.end)) {
				// TODO this.handleEditEnd();
			} else if (c.equals(Mode.PICKING.toString())) {
				this.setMode(Mode.PICKING);
			} else if (c.equals(Mode.EDITING.toString())) {
				this.setMode(Mode.EDITING);
			} else if (c.equals(ParameterEvent.quit)) {
				this.quit();
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), this.model
					.getResourceBundle().getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}

	/**
	 * Related to algorithm combo-box.
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		try {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				/* get the value */
				@SuppressWarnings("unchecked")
				JComboBox<String> box = (JComboBox<String>) e.getSource();
				this.model.setSelectedAlgorithmIndex(box.getSelectedIndex());
				this.handleSelectAlgorithm();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), this.model
					.getResourceBundle().getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleGraphEvent(GraphEvent<ILayoutVertex, ILayoutEdge> evt) {
		try {
			// item added or item deleted
			this.handleEditGraph();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), this.model
					.getResourceBundle().getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleIdle() throws Exception {
		try {
			this.state.exit();
			this.state.handleIdle();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleNewGraphUndirected() throws Exception {
		try {
			this.state.exit();
			this.state.handleNewGraphUndirected();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleNewGraphDirected() throws Exception {
		try {
			this.state.exit();
			this.state.handleNewGraphDirected();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleOpenGraph() throws Exception {
		try {
			this.state.exit();
			this.state.handleOpenGraph();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleSaveGraph() throws Exception {
		try {
			this.state.exit();
			this.state.handleSaveGraph();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleSaveGraphAs() throws Exception {
		try {
			this.state.exit();
			this.state.handleSaveGraphAs();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleEditGraph() throws Exception {
		try {
			this.state.exit();
			this.state.handleEditGraph();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleSelectAlgorithm() throws Exception {
		try {
			this.state.exit();
			this.state.handleSelectAlgorithm();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleOff() throws Exception {
		try {
			this.state.exit();
			this.state.handleOff();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Sets a state.
	 * 
	 * @param state
	 *            the state to set
	 * @throws Exception
	 */
	void setState(AbstractParameterState state) throws Exception {
		try {
			this.state = state;
			this.state.entry();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Property: Sets the graph as saved or not saved.
	 * 
	 * @param saved
	 *            the saved to set
	 * @throws Exception
	 */
	void setGraphSaved(boolean saved) throws Exception {
		try {
			this.model.setGraphSaved(saved);
			if (this.model.isGraphFile())
				this.model.setSaveEnabled(!saved);
			this.model.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Property: Enables or disables selecting the algorithms.
	 * 
	 * @param enabled
	 *            the enabled to set
	 * @throws Exception
	 */
	void setEnableAlgorithms(boolean enabled) throws Exception {
		try {
			this.model.setAlgorithmsEnabled(enabled);
			this.model.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Property: Enables or disables the traversal.
	 * 
	 * @param enabled
	 *            the enabled to set
	 * @throws Exception
	 */
	void setEnableTraversal(boolean enabled) throws Exception {
		try {
			if (enabled) {
				this.model.getAnimation().handleIdle();
			} else {
				this.model.getAnimation().handleOff();
			}
			this.model.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Property: Enables or disables the menu.
	 * 
	 * @param enabled
	 *            the enabled to set
	 * @throws Exception
	 */
	void setEnableMenu(boolean enabled) throws Exception {
		try {
			this.model.setMenuEnabled(enabled);
			this.model.setSaveEnabled(!this.model.isGraphSaved());
			if (enabled)
				this.setMode(this.model.getMode());
			this.model.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * @return 0 if selected, 1 if saved, 2 if edited
	 * @throws Exception
	 */
	int idle() throws Exception {
		int selected = 0, saved = 1, edited = 2;
		if (this.model.isGraphSaved()) {
			if (this.model.getTraversal().isEmpty())
				return saved;
			else
				return selected;
		} else {
			return edited;
		}
	}

	/**
	 * Doing: Opens a new empty graph of type as given by parameter.
	 * 
	 * @param edgeType
	 *            the graph edge type
	 * @throws Exception
	 */
	void newGraph(EdgeType edgeType) throws Exception {
		try {
			int option = 0;
			if (!this.model.isGraphSaved())
				option = this.confirmSavingGraph();
			if (option != JOptionPane.CANCEL_OPTION) {
				/* Graph */
				ILayoutGraph graph = this.parameterManager.newGraph(edgeType);
				String name = this.model.getResourceBundle().getString(
						"defaultname");
				graph.setName(name);
				graph.addGraphEventListener(this);
				this.model.setGraph(graph);
				this.model.setStart(null);
				this.model.setEnd(null);
				this.model.setGraphSaved(false);
				this.model.setGraphFile(false);
				/* Algorithm */
				this.updateAlgorithms();
			}
			this.model.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing: Lets the user select a graph file by file-chooser and opens the
	 * graph.
	 * 
	 * @return the return state of the file chooser on popdown:
	 *         <ul>
	 *         <li>JFileChooser.CANCEL_OPTION = 1
	 *         <li>JFileChooser.APPROVE_OPTION = 0
	 *         <li>JFileChooser.ERROR_OPTION = -1 if an error occurs or the
	 *         dialog is dismissed
	 *         </ul>
	 * @throws Exception
	 */
	int openGraph() throws Exception {
		try {
			int option = 1;
			if (!this.model.isGraphSaved())
				option = this.confirmSavingGraph();
			if (option != JOptionPane.CANCEL_OPTION) {
				/* file chooser setup */
				JFileChooser fileChooser = newFileChooser();
				// filter
				FileNameExtensionFilter filter = this.parameterManager
						.getGraphFilter();
				fileChooser.addChoosableFileFilter(filter);
				fileChooser.setFileFilter(filter);

				/* dialog */
				option = fileChooser.showOpenDialog(this.model.getTop());
				if (option == JFileChooser.APPROVE_OPTION) {
					/* Graph */
					File source = fileChooser.getSelectedFile();
					ILayoutGraph graph = this.parameterManager
							.openGraph(source);
					graph.addGraphEventListener(this);
					this.model.setGraph(graph);
					this.model.setStart(null);
					this.model.setEnd(null);
					this.model.setGraphFile(true);
					/* Algorithm */
					this.updateAlgorithms();
					this.model.notifyObservers();
				}
			}
			return option;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing: Saves an edited graph.
	 * 
	 * @throws Exception
	 */
	void saveGraph() throws Exception {
		try {
			this.parameterManager.saveGraph();
			this.setGraphSaved(true);
			this.model.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing: Lets the user select a graph file name and a directory by
	 * file-chooser and saves a not yet saved graph as file.
	 * 
	 * @return the return state of the file chooser on popdown:
	 *         <ul>
	 *         <li>JFileChooser.CANCEL_OPTION = 1
	 *         <li>JFileChooser.APPROVE_OPTION = 0
	 *         <li>JFileChooser.ERROR_OPTION = -1 if an error occurs or the
	 *         dialog is dismissed
	 *         </ul>
	 * @throws Exception
	 */
	int saveGraphAs() throws Exception {
		try {
			/* file chooser setup */
			JFileChooser fileChooser = newFileChooser();
			fileChooser
					.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			// filter
			FileNameExtensionFilter filter = this.parameterManager
					.getGraphFilter();
			fileChooser.addChoosableFileFilter(filter);
			fileChooser.setFileFilter(filter);
			// title
			fileChooser.setDialogTitle(this.model.getResourceBundle()
					.getString("saveas.label"));
			/* dialog */
			int option = fileChooser.showSaveDialog(this.model.getTop());
			if (option == JFileChooser.APPROVE_OPTION) {
				/* Graph */
				File file = fileChooser.getSelectedFile();
				this.parameterManager.saveGraphAs(file);
				this.model.setGraphFile(true);
				this.setGraphSaved(true);
				/* Algorithm */
				this.model.setSelectedAlgorithmIndex(0);
				this.selectAlgorithm();
				this.model.notifyObservers();
			}
			return option;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing: Sets the graph as edited.
	 * 
	 * @throws Exception
	 */
	void editGraph() throws Exception {
		try {
			// revert traversal
			if (this.model.getTraversal().hasPrevious()) {
				this.model.getStepByStep().handleToBeginning();
			}
			// revert algorithm selection
			if (this.model.getSelectedAlgorithmIndex() > 0) {
				this.model.setSelectedAlgorithmIndex(0);
				this.selectAlgorithm();
				this.setEnableAlgorithms(false);
				this.setEnableTraversal(false);
				this.model.setProtocol(new StringBuilder());
			}
			// this.model.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing: Selects an algorithm, the traversal gets rendered.
	 * 
	 * @return the selected algorithm as index
	 * @throws Exception
	 */
	int selectAlgorithm() throws Exception {
		try {
			StringBuilder message = new StringBuilder();
			int index = this.model.getSelectedAlgorithmIndex();
			if (index == 0) {
				/* Graph */
				if (this.model.getProgress() > 0)
					((StepByStep) this.model.getStepByStep()).toBeginning();
			} else {
				// deny user interaction
				// TODO disable all interaction item (menu etc.)
				this.setMode(Mode.PICKING);
			}
			/* Graph */
			ILayoutGraph graph = this.model.getGraph();
			/* Algorithm */
			this.parameterManager.selectAlgorithm(index);
			String description = this.parameterManager
					.getAlgorithmDescription();
			this.model.setAlgorithmDescription(description);
			/* Traversal */
			ITraversal traversal = this.parameterManager
					.executeAlgorithm(graph);
			this.model.setTraversal(traversal);
			this.model.setProgress(0);
			if (index == 0) {
				this.setMode(Mode.EDITING);
			} else {
				ResourceBundle b = this.model.getResourceBundle();
				message.append(b.getString("render.message"));
				// JOptionPane.showMessageDialog(null, message.toString(),
				// b.getString("app.label"), 1, null);
				message.append(System.lineSeparator());
			}
			this.model.setProtocol(message);
			// done
			this.model.notifyObservers();
			return index;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A helper method: creates a file chooser.
	 * <ul>
	 * <li>files only
	 * <li>accept all file filter used: false
	 * <li>multi selection: false
	 * <li>choosable file filter removed
	 * <ul>
	 * 
	 * @return the file chooser
	 * @throws Exception
	 */
	private JFileChooser newFileChooser() throws Exception {
		try {
			JFileChooser fileChooser = new JFileChooser();
			// setup
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.setMultiSelectionEnabled(false);
			// filter
			fileChooser.removeChoosableFileFilter(fileChooser
					.getAcceptAllFileFilter());
			// done
			return fileChooser;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A helper method: Brings up a dialog asking for saving the graph with the
	 * options <i>Yes</i>, <i>No</i> and <i>Cancel</i>. If the option <i>Yes</i>
	 * is chosen, saving the graph will be delegated depending on the actual
	 * state set.
	 * 
	 * @return an integer indicating the option selected by the user:
	 *         <ul>
	 *         <li>JOptionPane.YES_NO_OPTION = 0
	 *         <li>JOptionPane.YES_NO_CANCEL_OPTION = 1
	 *         <li>JOptionPane.OK_CANCEL_OPTION = 2
	 *         </ul>
	 * 
	 * @throws Exception
	 */
	private int confirmSavingGraph() throws Exception {
		try {
			/* dialog */
			ResourceBundle b = this.model.getResourceBundle();
			String message = b.getString("graph.label") + ": "
					+ b.getString("save.label") + "?";
			int option = JOptionPane.showConfirmDialog(this.model.getTop(),
					message, b.getString("app.label"),
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			/* delegate */
			if (option == JOptionPane.YES_OPTION) {
				if (this.model.isGraphFile())
					this.saveGraph();
				else
					this.saveGraphAs();
			}
			return option;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A helper method: Sets the mouse mode.
	 * 
	 * @param mode
	 *            the mode to set
	 * @see Mode
	 */
	private void setMode(Mode mode) {
		this.model.setMode(mode);
		this.model.setMenuModeEnabled(false);
		if (mode == Mode.PICKING) {
			this.model.setSelectEditingModeEnabled(true);
		} else if (mode == Mode.EDITING) {
			this.model.setSelectPickingModeEnabled(true);
		}
		this.model.setSwitchModeEnabled(true);
		this.model.notifyObservers();
	}

	/**
	 * A helper method: Updates the algorithm list.
	 * 
	 * @throws Exception
	 */
	private void updateAlgorithms() throws Exception {
		try {
			EdgeType edgeType = this.model.getGraph().getEdgeType();
			this.parameterManager.updateSelectableAlgorithms(edgeType);
			String[] selectableNames = this.parameterManager
					.getSelectableAlgorithmNames();
			this.model.setAlgorithms(selectableNames);
			this.model.setSelectedAlgorithmIndex(0);
			this.selectAlgorithm();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A method for quitting the program.
	 */
	private void quit() {
		int option = 0;
		if (!this.model.isGraphSaved())
			try {
				option = this.confirmSavingGraph();
			} catch (Exception e) {
				e.printStackTrace();
			}
		if (option != JOptionPane.CANCEL_OPTION)
			System.exit(0);
	}

	/**
	 * Parameter events.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum ParameterEvent {

		//
		NEW_UNDIRECTED("newUndirected"),
		//
		NEW_DIRECTED("newDirected"),
		//
		OPEN("open"),
		//
		SAVE("save"),
		//
		SAVE_AS("saveAs"),
		//
		EDIT("edit"),
		//
		START("start"),
		//
		END("end"),
		//
		DELETE("delete"),
		//
		QUIT("quit"),

		;

		/**
		 * A field for a value.
		 */
		private String value;

		/**
		 * Main constructor.
		 * 
		 * @param value
		 *            a value
		 */
		ParameterEvent(String value) {
			this.value = value;
		}

		/**
		 * Returns the value.
		 * 
		 * @return the value
		 */
		public String getValue() {
			return this.value;
		}

		public static final String newUndirected = NEW_UNDIRECTED.getValue();
		public static final String newDirected = NEW_DIRECTED.getValue();
		public static final String open = OPEN.getValue();
		public static final String save = SAVE.getValue();
		public static final String saveAs = SAVE_AS.getValue();
		public static final String edit = EDIT.getValue();
		public static final String start = START.getValue();
		public static final String end = END.getValue();
		public static final String delete = DELETE.getValue();
		public static final String quit = QUIT.getValue();

	}

}
