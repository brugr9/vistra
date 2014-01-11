package vistra.app.control.state;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.app.IModel;
import vistra.app.Model;
import vistra.app.control.IControl.ActionCommandParameter;
import vistra.app.control.IControl.ActionCommandGeneral;
import vistra.framework.ICore;
import vistra.framework.graph.IExtendedGraph;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IVertexLayout;
import vistra.framework.traversal.ITraversal;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;

/**
 * An a parameter state handler. A graph and an algorithm are seen as parameters
 * for generating a traversal.
 * <p>
 * As a part of the graphic user interface control, this state handler is an
 * action listener (graph I/O and value editing), a graph-event listener
 * (adding/deletion of edges and vertices) and an item listener (algorithm
 * selection), too.
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
	private Model model;

	/**
	 * Main constructor.
	 * 
	 * @param core
	 *            a core
	 * @param model
	 *            a gui model
	 */
	public ParameterStateHandler(ICore core, IModel model) {
		super();
		this.core = core;
		this.model = (Model) model;
		try {
			this.state = new ParameterStateOff(this);
			this.setState(new ParameterStateOff(this));
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

			if (c.equals(ActionCommandParameter.newUndirected)) {
				this.handleNewGraphUndirected();
			} else if (c.equals(ActionCommandParameter.newDirected)) {
				this.handleNewGraphDirected();
			} else if (c.equals(ActionCommandParameter.open)) {
				this.handleOpenGraph();
			} else if (c.equals(ActionCommandParameter.save)) {
				this.handleSaveGraph();
			} else if (c.equals(ActionCommandParameter.saveAs)) {
				this.handleSaveGraphAs();
			} else if (c.equals(ActionCommandParameter.edit)) {
				this.handleEditGraph();
			} else if (c.equals(ActionCommandParameter.start)) {
				// TODO this.handleEditStart();
			} else if (c.equals(ActionCommandParameter.end)) {
				// TODO this.handleEditEnd();
			} else if (c.equals(Mode.PICKING.toString())) {
				this.setMode(Mode.PICKING);
				this.model.notifyObservers();
			} else if (c.equals(Mode.EDITING.toString())) {
				this.setMode(Mode.EDITING);
				this.model.notifyObservers();
			} else if (c.equals(ActionCommandGeneral.quit)) {
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
	 * State view setter: Sets the graph as saved or not saved.
	 * 
	 * @param saved
	 *            the saved to set
	 * @throws Exception
	 */
	void setViewGraphSaved(boolean saved) {
		this.model.setGraphSaved(saved);
		this.model.setSaveEnabled(!saved);
		this.model.notifyObservers();
	}

	/**
	 * State view setter: Enables or disables selecting the algorithms.
	 * 
	 * @param enabled
	 *            the enabled to set
	 */
	void setViewEnableAlgorithms(boolean enabled) {
		this.model.setAlgorithmsEnabled(enabled);
		this.model.notifyObservers();
	}

	/**
	 * State view setter: Enables or disables the traversal.
	 * 
	 * @param enabled
	 *            the enabled to set
	 * @throws Exception
	 */
	void setViewEnableTraversal(boolean enabled) throws Exception {
		try {
			if (enabled) {
				this.model.getAnimationStateHandler().handleIdle();
				ResourceBundle b = this.model.getResourceBundle();
				JOptionPane.showMessageDialog(null,
						b.getString("render.message"),
						b.getString("app.label"), 1, null);
			} else
				this.model.getAnimationStateHandler().handleOff();
			this.model.notifyObservers();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * State view setter: Enables or disables the menu.
	 * 
	 * @param enabled
	 *            the enabled to set
	 */
	void setViewEnableMenu(boolean enabled) {
		this.model.setMenuEnabled(enabled);
		this.model.setSaveEnabled(!this.model.isGraphSaved());
		this.model.notifyObservers();
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
				if (this.model.getGraph() != null)
					this.clearGraph();
				IExtendedGraph graph = this.core.newGraph(edgeType);
				String name = this.model.getResourceBundle().getString(
						"defaultname");
				//
				graph.setName(name);
				graph.addGraphEventListener(this);
				this.model.setGraph(graph);
				this.model.setStart(null);
				this.model.setEnd(null);
				this.model.setGraphFile(false);
				/* Mode */
				this.setMode(Mode.EDITING);
				/* Algorithm */
				this.updateAlgorithms();
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
				option = fileChooser.showOpenDialog(this.model.getTop());
				if (option == JFileChooser.APPROVE_OPTION) {
					// Graph
					if (this.model.getGraph() != null)
						this.clearGraph();
					File source = fileChooser.getSelectedFile();
					IExtendedGraph graph = this.core.openGraph(source);
					String name = source.getName();
					//
					graph.setName(name);
					graph.addGraphEventListener(this);
					this.model.setGraph(graph);
					this.model.setStart(null);
					this.model.setEnd(null);
					this.model.setGraphFile(false);
					/* Mode */
					this.setMode(Mode.PICKING);
					/* Algorithm */
					this.updateAlgorithms();
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
			this.core.saveGraph();
			this.model.setGraphSaved(true);
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
			int option = fileChooser.showSaveDialog(this.model.getTop());
			if (option == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				this.core.saveGraphAs(file);
				this.model.setGraphFile(true);
				this.model.setGraphSaved(true);
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
			if (this.model.isToBeginningEnabled())
				this.model.getSbsStateHandler().handleToBeginning();
			// revert algorithm selection
			if (this.model.isAlgorithmsEnabled()) {
				this.model.setSelectedAlgorithmIndex(0);
				this.handleSelectAlgorithm();
			}
			// revert saved status
			this.model.setGraphSaved(false);
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
			// TODO deny user interaction during render
			/* Graph */
			if (this.model.getProgress() > 0)
				((SbsStateHandler) this.model.getSbsStateHandler())
						.toBeginning();
			IExtendedGraph graph = this.model.getGraph();
			/* Algorithm */
			int index = this.model.getSelectedAlgorithmIndex();
			this.core.selectAlgorithm(index);
			String description = this.core.getAlgorithmDescription();
			this.model.setAlgorithmDescription(description);
			/* Traversal */
			ITraversal traversal = this.core.traverse(graph);
			this.model.setTraversal(traversal);
			this.model.setProgress(0);
			if (index > 0) {
				if (traversal.isEmpty())
					// TODO message eventually
					return 0;
				/* Mode */
				this.setMode(Mode.PICKING);
			} else {
				this.setMode(Mode.EDITING);
			}
			// done
			return index;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Removes all vertices and edges from the graph.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private void clearGraph() throws Exception {
		try {
			IExtendedGraph graph = this.model.getGraph();
			graph.removeGraphEventListener(this);
			Collection<IEdgeLayout> edges = graph.getEdges();
			Collection<IVertexLayout> vertices = graph.getVertices();
			for (IEdgeLayout e : edges)
				e = null;
			for (IVertexLayout v : vertices)
				v = null;
			graph = null;
			this.model.notifyObservers();
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
	 * A helper method: Sets the mode.
	 * 
	 * @param mode
	 *            the mode to set
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

}
