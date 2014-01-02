package vistra.gui.control.state;

import static vistra.gui.control.IControl.EventSource.ALGORITHM;
import static vistra.gui.control.IControl.EventSource.EDIT;
import static vistra.gui.control.IControl.EventSource.START;
import static vistra.gui.control.IControl.EventSource.END;

import static vistra.gui.control.IControl.EventSource.GRAPH;
import static vistra.gui.control.IControl.EventSource.MODE;
import static vistra.gui.control.IControl.EventSource.NEW_DIRECTED;
import static vistra.gui.control.IControl.EventSource.NEW_UNDIRECTED;
import static vistra.gui.control.IControl.EventSource.OPEN;
import static vistra.gui.control.IControl.EventSource.SAVE;
import static vistra.gui.control.IControl.EventSource.SAVE_AS;

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

import vistra.core.ICore;
import vistra.core.graph.IExtendedGraph;
import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.core.traversal.ITraversal;
import vistra.gui.GuiModel;
import vistra.gui.IGuiModel;
import vistra.gui.control.IControl.EventSource;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;

/**
 * An a parameter state handler. A parameter state machine handles a graph and
 * an algorithm as parameter for generating a traversal-object.
 * <p>
 * As a part of the graphic user interface control, this state handler is an
 * action listener (file menu and edit pop-up for the graph) and an item
 * listener (algorithm combo box), too. Furthermore, this handler listens on
 * graph-events (adding/deletion of edges and vertices).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see SbsStateHandler
 * @see AnimationStateHandler
 */
public final class ParameterStateHandler implements IParameterStateHandler {

	/**
	 * A field for a state.
	 */
	private AbstractParameterState state;
	/**
	 * A field for a core.
	 */
	private ICore core;
	/**
	 * A field for a model.
	 */
	private GuiModel model;
	/**
	 * A field for a top component.
	 */
	private Container top;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            a model
	 */
	public ParameterStateHandler(ICore core, IGuiModel model) {
		super();
		this.core = core;
		this.model = (GuiModel) model;
		this.top = null;
		this.state = new ParameterStateIdle(this);
	}

	/**
	 * Related to menu item.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			String c = e.getActionCommand();
			this.top = (Container) ((JComponent) e.getSource())
					.getTopLevelAncestor();

			if (c.equals(NEW_UNDIRECTED.toString())) {
				this.handleNewGraphUndirected();
			} else if (c.equals(NEW_DIRECTED.toString())) {
				this.handleNewGraphDirected();
			} else if (c.equals(OPEN.toString())) {
				this.handleOpenGraph();
			} else if (c.equals(SAVE.toString())) {
				this.handleSaveGraph();
			} else if (c.equals(SAVE_AS.toString())) {
				this.handleSaveGraphAs();
			} else if (c.equals(EDIT.toString())) {
				this.handleEditGraph();
			} else if (c.equals(START.toString())) {
				this.handleEditGraph();
			} else if (c.equals(END.toString())) {
				this.handleEditGraph();
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), this.model
					.getResourceBundle().getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}

	/**
	 * Related to the algorithm combo-box.
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
	public void handleGraphEvent(GraphEvent<IVertexLayout, IEdgeLayout> evt) {
		try {

			// item added
			// item deleted

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
	 * A state view setter: Sets the view for state: idle.
	 */
	void setViewIdle() {
		// Graph
		this.setGraphEditable(true);
		// Algorithm
		this.model.setAlgorithmsEnabled(false);
		this.model.notifyObservers(EventSource.ALGORITHM);
	}

	/**
	 * A state view setter: Sets the view for state: graph edited.
	 */
	void setViewGraphEdited() {
		// Graph
		this.setGraphSaved(false);
		// Algorithm
		this.model.setAlgorithmsEnabled(false);
		this.model.notifyObservers(EventSource.ALGORITHM);
	}

	/**
	 * A state view setter: Sets the view for state: graph saved.
	 */
	void setViewGraphSaved() {
		// Graph
		this.setGraphSaved(true);
		this.enableMenu(true);
		// Algorithm
		this.model.setAlgorithmsEnabled(true);
		this.model.notifyObservers(EventSource.ALGORITHM);
	}

	/**
	 * A state view setter: Sets the view for state: algorithm selected. Informs
	 * the user by option pane about having successfully rendered the traversal.
	 */
	void setViewAlgorithmSelected() {
		// Graph
		this.enableMenu(true);
		// Algorithm
		this.model.setAlgorithmsEnabled(true);
		this.model.notifyObservers(EventSource.ALGORITHM);
	}

	/**
	 * A state view setter: Sets the view for state: off.
	 */
	void setViewOff() {
		// Graph
		this.enableMenu(false);
		this.setGraphEditable(false);
		// Algorithm
		this.model.setAlgorithmsEnabled(false);
		this.model.notifyObservers(EventSource.ALGORITHM);
	}

	/**
	 * A helper method for state view setter: Handles enabling/disabling the
	 * menu elements.
	 * 
	 * @param enabled
	 *            the enabled to set
	 */
	private void enableMenu(boolean enabled) {
		this.model.setMenuEnabled(enabled);
		this.model.setSaveEnabled(!this.model.isGraphSaved());
		this.model.notifyObservers(EventSource.GRAPH);
	}

	/**
	 * Doing: Sets the {@code AnimationStateHandler} off or idle.
	 * 
	 * @throws Exception
	 */
	void idle() throws Exception {
		if (this.model.isGraphFile() && this.model.isGraphSaved()
				&& this.model.getTraversal().size() > 0)
			this.model.getAnimationStateHandler().handleIdle();
		else
			this.model.getAnimationStateHandler().handleOff();
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
				IExtendedGraph graph = this.core.newGraph(edgeType);
				String name = this.model.getResourceBundle().getString(
						"defaultname");
				graph.setName(name);
				graph.addGraphEventListener(this);
				this.model.setGraph(graph);
				this.model.setGraphFile(false);
				this.model.setGraphSaved(true);
				this.model.setStart(null);
				this.model.setEnd(null);
				this.updateAlgorithms();
				this.model.setSelectedAlgorithmIndex(0);
				this.selectAlgorithm();
			}
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
				FileNameExtensionFilter filter = this.core.getGraphFilter();
				fileChooser.addChoosableFileFilter(filter);
				fileChooser.setFileFilter(filter);

				/* dialog */
				option = fileChooser.showOpenDialog(top);
				if (option == JFileChooser.APPROVE_OPTION) {
					File source = fileChooser.getSelectedFile();
					IExtendedGraph graph = this.core.openGraph(source);
					String name = source.getName();
					graph.setName(name);
					graph.addGraphEventListener(this);
					this.model.setGraph(graph);
					this.model.setGraphFile(true);
					this.model.setGraphSaved(true);
					this.model.setStart(null);
					this.model.setEnd(null);
					this.updateAlgorithms();
					this.model.setSelectedAlgorithmIndex(0);
					this.selectAlgorithm();
				}
			}
			return option;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing: Saves an already 'saved as' but edited graph.
	 * 
	 * @throws Exception
	 */
	void saveGraph() throws Exception {
		try {
			this.core.saveGraph();
			this.model.setGraphSaved(true);
			this.model.setAlgorithmsEnabled(true);
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
			FileNameExtensionFilter filter = this.core.getGraphFilter();
			fileChooser.addChoosableFileFilter(filter);
			fileChooser.setFileFilter(filter);
			// title
			fileChooser.setDialogTitle(this.model.getResourceBundle()
					.getString("saveas.label"));

			/* dialog */
			int option = fileChooser.showSaveDialog(this.top);
			if (option == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				this.core.saveGraphAs(file);
				this.model.setGraphFile(true);
				this.model.setGraphSaved(true);
				this.model.notifyObservers(GRAPH);
				this.model.setAlgorithmsEnabled(true);
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
			this.model.setGraphSaved(false);
			this.model.setSelectedAlgorithmIndex(0);
			this.selectAlgorithm();
			this.model.setAlgorithmsEnabled(false);
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

			/* deny user interaction */
			this.setState(new ParameterStateOff(this));
			/* Algorithm */
			int index = this.model.getSelectedAlgorithmIndex();
			this.core.selectAlgorithm(index);
			String description = this.core.getAlgorithmDescription();
			this.model.setAlgorithmDescription(description);
			/* Traversal */
			IExtendedGraph graph = this.model.getGraph();
			ITraversal traversal = this.core.traverse(graph);
			this.model.setTraversal(traversal);
			this.model.setProgress(0);

			return index;

		} catch (Exception e) {
			this.setState(new ParameterStateIdle(this));
			throw e;
		}

	}

	/**
	 * A helper method: Sets the view elements related to saving a graph.
	 * 
	 * @param saved
	 *            the saved status
	 * @throws Exception
	 */
	private void setGraphSaved(boolean saved) {
		this.model.setGraphSaved(saved);
		this.model.setSaveEnabled(!saved);
		this.model.notifyObservers(GRAPH);
		this.model.setAlgorithmsEnabled(saved);
		this.model.notifyObservers(ALGORITHM);
	}

	/**
	 * A helper method: Handles setting the graph editable.
	 * 
	 * @param enabled
	 *            the editable to set
	 */
	private void setGraphEditable(boolean editable) {
		if (editable) {
			this.model.setMode(Mode.EDITING);
			this.model.notifyObservers(MODE);
		}
		this.model.setEditingEnabled(editable);
		this.model.notifyObservers(GRAPH);
	}

	/**
	 * A helper method: Updates the algorithm list.
	 * 
	 * @throws Exception
	 */
	private void updateAlgorithms() throws Exception {
		try {
			EdgeType edgeType = this.model.getGraph().getEdgeType();
			this.core.updateSelectableNames(edgeType);
			String[] selectableNames = this.core.getSelectableNames();
			this.model.setAlgorithms(selectableNames);
			this.model.setSelectedAlgorithmIndex(0);
			this.selectAlgorithm();
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
			int option = JOptionPane.showConfirmDialog(top, message,
					b.getString("app.label"), JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			/* delegate */
			if (option == JOptionPane.YES_OPTION) {
				Class<? extends AbstractParameterState> state = this.state
						.getClass();
				if (state == ParameterStateGraphEdited.class)
					this.saveGraph();
				if (state == ParameterStateIdle.class)
					this.saveGraphAs();
			}
			return option;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing: Enables or disabled the traversal.
	 * 
	 * @param enabled
	 *            the enabled to set
	 * @throws Exception
	 */
	void enableTraversal(boolean enabled) throws Exception {
		try {
			if (enabled) {
				this.model.getAnimationStateHandler().handleIdle();
				ResourceBundle b = this.model.getResourceBundle();
				JOptionPane.showMessageDialog(null,
						b.getString("render.message"),
						b.getString("app.label"), 1, null);
			} else
				this.model.getAnimationStateHandler().handleOff();
		} catch (Exception e) {
			throw e;
		}
	}
}
