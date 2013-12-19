/**
 * 
 */
package vistra.gui.control.parameter;

import static vistra.gui.control.IControl.EventSource.DELETE_ALGORITHM;
import static vistra.gui.control.IControl.EventSource.EDIT_GRAPH;
import static vistra.gui.control.IControl.EventSource.GRAPH;
import static vistra.gui.control.IControl.EventSource.IMPORT_ALGORITHM;
import static vistra.gui.control.IControl.EventSource.NEW_GRAPH_DIRECTED;
import static vistra.gui.control.IControl.EventSource.NEW_GRAPH_UNDIRECTED;
import static vistra.gui.control.IControl.EventSource.OPEN_GRAPH;
import static vistra.gui.control.IControl.EventSource.SAVE_GRAPH;
import static vistra.gui.control.IControl.EventSource.SAVE_GRAPH_AS;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import vistra.common.IAlgorithm;
import vistra.core.ICore;
import vistra.core.graph.GraphFactory;
import vistra.core.graph.zobsolete.IGravisGraph;
import vistra.core.graph.zobsolete.IObservableGraph;
import vistra.core.graph.zobsolete.item.edge.IEdge;
import vistra.core.graph.zobsolete.item.vertex.IVertex;
import vistra.core.traversal.Traversal;
import vistra.gui.Model;
import vistra.gui.control.IControl.EventSource;
import vistra.gui.util.SingleRootFileSystemView;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A parameter state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public final class ParameterStateHandler implements IParameterStateHandler {

	/**
	 * A field for a core.
	 */
	private ICore core;
	/**
	 * A field for a model.
	 */
	private Model model;
	/**
	 * A field for a state.
	 */
	private AbstractParameterState state;
	/**
	 * A field for a top component.
	 */
	private JComponent top;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            a gravis gui model
	 */
	public ParameterStateHandler(ICore core, Model model) {
		super();
		this.core = core;
		this.model = model;
		this.top = null;
		this.setState(new ParameterIdle(this));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			String c = e.getActionCommand();
			this.top = (JComponent) ((JComponent) e.getSource())
					.getTopLevelAncestor();

			if (c.equals(NEW_GRAPH_UNDIRECTED.toString())) {
				this.handleNewGraphUndirected();
			} else if (c.equals(NEW_GRAPH_DIRECTED.toString())) {
				this.handleNewGraphDirected();
			} else if (c.equals(OPEN_GRAPH.toString())) {
				this.handleOpenGraph();
			} else if (c.equals(SAVE_GRAPH.toString())) {
				this.handleSaveGraph();
			} else if (c.equals(SAVE_GRAPH_AS.toString())) {
				this.handleSaveGraphAs();
			} else if (c.equals(EDIT_GRAPH.toString())) {
				this.handleEditGraph();
			} else if (c.equals(IMPORT_ALGORITHM.toString())) {
				this.handleImportAlgorithm();
			} else if (c.equals(DELETE_ALGORITHM.toString())) {
				this.handleDeleteAlgorithm();
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
	public void itemStateChanged(ItemEvent e) {
		try {

			if (e.getStateChange() == ItemEvent.SELECTED) {
				/* get the value */
				@SuppressWarnings("unchecked")
				JComboBox<IAlgorithm> box = (JComboBox<IAlgorithm>) e
						.getSource();
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
	public void handleGraphEvent(GraphEvent<IVertex, IEdge> evt) {
		try {
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
	public void handleImportAlgorithm() throws Exception {
		try {
			this.state.exit();
			this.state.handleImportAlgorithm();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleDeleteAlgorithm() throws Exception {
		try {
			this.state.exit();
			this.state.handleDeleteAlgorithm();
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
	void setState(AbstractParameterState state) {
		this.state = state;
		this.state.entry();
	}

	/**
	 * Doing: Enables the possibility to edit the graph.
	 * 
	 * @throws Exception
	 */
	void idle() throws Exception {
		if (this.model.getTraversal() == null)
			this.model.getAnimationStateHandler().handleOff();
		else
			this.model.getAnimationStateHandler().handleIdle();
		this.setGraphSaved(true);
		this.setGraphEditable(true);
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
				option = this.confirmSavingTheGraph();
			if (option != JOptionPane.CANCEL_OPTION) {
				IObservableGraph graph = GraphFactory
						.createObservableGraph();
				String name = this.model.getResourceBundle().getString(
						"defaultname");
				graph.setId(name);
				graph.setDescription(" ");
				graph.setEdgeType(edgeType);
				this.model.setGraph(graph);
				this.setGraphSaved(false);
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
				option = this.confirmSavingTheGraph();
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
					this.model.setGraph(this.core.openGraph(source));
					this.setGraphSaved(true);
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
			IGravisGraph graph = this.model.getGraph();
			this.core.save(graph);
			this.setGraphSaved(true);
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
				IGravisGraph graph = this.model.getGraph();
				this.core.saveAs(graph, file);
				this.setGraphSaved(true);
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
			this.setGraphSaved(false);
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
			/* get the selected algorithm as index */
			int index = this.model.getSelectedAlgorithmIndex();

			/* State machine animation (and step-by-step): off */
			this.enableTraversalPlayer(false);
			/* reset the progress */
			this.model.setProgress(0);

			if (index == 0) {
				/* settings */
				this.model.setAlgorithmDescription(" ");
				this.model.setTraversal(null);
				this.model.setProgressMaximum(0);
			} else {
				/* deny user interaction */
				this.setState(new ParameterOff(this));
				/* get the traversal */
				IGravisGraph graph = this.model.getGraph();
				IAlgorithm algorithm = this.core.selectAlgorithm(index);
				Traversal traversal = this.core.renderTraversal(graph,
						algorithm);
				/* settings */
				String name = algorithm.getName();
				String description = algorithm.getDescription();
				StringBuilder stringBuilder = this.model.getStringBuilder();
				stringBuilder.append(name + System.lineSeparator());
				stringBuilder.append(description + System.lineSeparator());
				this.model.setStringBuilder(stringBuilder);
				this.model.setAlgorithmDescription(description);
				this.model.setTraversal(traversal);
				this.model.setProgressMaximum(traversal.size());
			}

			return index;

		} catch (Exception e) {
			this.setState(new ParameterIdle(this));
			throw e;
		}

	}

	/**
	 * Doing: Imports an algorithm and updates the list of algorithms.
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
	int importAlgorithm() throws Exception {
		try {
			ResourceBundle b = this.model.getResourceBundle();
			/* file chooser setup */
			JFileChooser fileChooser = newFileChooser();
			// filter
			FileNameExtensionFilter filter = this.core.getAlgorithmFilter();
			fileChooser.addChoosableFileFilter(filter);
			fileChooser.setFileFilter(filter);
			// title
			fileChooser.setDialogTitle(b.getString("importAlgorithm.label"));

			/* dialog */
			int option = fileChooser.showDialog(this.top,
					b.getString("import.label"));
			if (option == JFileChooser.APPROVE_OPTION) {
				File source = fileChooser.getSelectedFile();
				EdgeType[] edgeTypes = this.core.importAlgorithm(source);
				boolean ok = this.updateAlgorithms(edgeTypes);
				String message = b.getString("importAlgorthm.message");
				JOptionPane.showMessageDialog(null, message,
						b.getString("app.label"), 1, null);
			}
			return option;

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing: Deletes an algorithm and updates the list of algorithms.
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
	int deleteAlgorithm() throws Exception {
		try {
			ResourceBundle b = this.model.getResourceBundle();
			/* file chooser setup */
			JFileChooser fileChooser = newFileChooser();
			// filter
			FileNameExtensionFilter filter = this.core.getAlgorithmFilter();
			fileChooser.addChoosableFileFilter(filter);
			fileChooser.setFileFilter(filter);
			// restrict access to workbench directory only
			File root = this.core.getAlgorithmWorkbenchDir();
			FileSystemView fsv = new SingleRootFileSystemView(root);
			fileChooser.setFileSystemView(fsv);
			fileChooser.updateUI();
			fileChooser.setCurrentDirectory(root);
			// title
			fileChooser.setDialogTitle(b.getString("deleteAlgorithm.label"));

			/* dialog */
			int option = fileChooser.showDialog(this.top,
					b.getString("delete.label"));
			if (option == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				EdgeType[] edgeTypes = this.core.deleteAlgorithm(file);
				boolean ok = this.updateAlgorithms(edgeTypes);
				String message = b.getString("deleteAlgorthm.message");
				JOptionPane.showMessageDialog(null, message, this.model
						.getResourceBundle().getString("app.label"), 1, null);
			}
			return option;

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
	private int confirmSavingTheGraph() throws Exception {
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
				if (state == ParameterGraphEdited.class)
					this.saveGraph();
				if (state == ParameterIdle.class)
					this.saveGraphAs();
			}
			return option;
		} catch (Exception e) {
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
	private void setGraphSaved(boolean saved) throws Exception {
		try {
			this.model.setGraphSaved(saved);
			this.model.setSaveGraphEnabled(!saved);
			this.model.setAlgorithmsEnabled(saved);
			this.model.notifyObservers(GRAPH);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A helper method: Handles setting the graph editable.
	 * 
	 * @param enabled
	 *            the editable to set
	 */
	private void setGraphEditable(boolean editable) {
		this.model.setEditGraphEnabled(editable);
		this.model.notifyObservers(EDIT_GRAPH);
	}

	/**
	 * A helper method: Updates the algorithm list by comparing the edge type of
	 * the current graph with the edge types as given. The edge types given as
	 * parameter are the capabilities of an imported or deleted algorithm.
	 * 
	 * @param edgeTypes
	 *            the edge types to compare
	 * @return <code>true</code> if updated
	 * @throws Exception
	 */
	private boolean updateAlgorithms(EdgeType[] capabilities) throws Exception {
		try {
			boolean update = false;
			IGravisGraph graph = this.model.getGraph();
			EdgeType edgeType = graph.getEdgeType();

			for (EdgeType capability : capabilities) {
				if (capability == edgeType) {
					update = true;
					break;
				}
			}
			if (update) {
				this.model.setAlgorithms(this.core.getAlgorithms(edgeType));
				this.model.setSelectedAlgorithmIndex(0);
				this.selectAlgorithm();
			}
			return update;
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
	 * A state view setter: Sets the view for state: idle.
	 */
	void setViewIdle() {
		this.enableMenu(true);
		this.model.setAlgorithmsEnabled(false);
		this.model.notifyObservers(EventSource.ALGORITHM);
	}

	/**
	 * A state view setter: Sets the view for state: graph edited.
	 */
	void setViewGraphEdited() {
		this.enableMenu(true);
		if (this.model.isAlgorithmsEnabled()) {
			this.model.setAlgorithmsEnabled(false);
			this.model.notifyObservers(EventSource.ALGORITHM);
		}
	}

	/**
	 * A state view setter: Sets the view for state: graph saved.
	 */
	void setViewGraphSaved() {
		this.enableMenu(true);
		this.model.setAlgorithmsEnabled(true);
		this.model.notifyObservers(EventSource.ALGORITHM);
	}

	/**
	 * A state view setter: Sets the view for state: algorithm selected. Informs
	 * the user by option pane about having successfully rendered the traversal.
	 */
	void setViewAlgorithmSelected() {
		this.enableMenu(true);
		this.model.setAlgorithmsEnabled(true);
		this.model.notifyObservers(EventSource.ALGORITHM);
		/* enable traversal player */
		this.model.getAnimationStateHandler().handleIdle();
		/* render message */
		ResourceBundle b = this.model.getResourceBundle();
		JOptionPane.showMessageDialog(null, b.getString("render.message"),
				b.getString("app.label"), 1, null);
	}

	/**
	 * A state view setter: Sets the view for state: off.
	 */
	void setViewOff() {
		this.enableMenu(false);
		this.model.setAlgorithmsEnabled(false);
		this.model.notifyObservers(EventSource.ALGORITHM);
		this.setGraphEditable(false);
	}

	/**
	 * A helper method for state view setter: Handles enabling/disabling the
	 * menu elements. Does <b>not</b> tell the model to notify
	 * <code>Observer</code>s.
	 * 
	 * @param enabled
	 *            the enabled to set
	 */
	private void enableMenu(boolean enabled) {
		this.model.setMenuEnabled(enabled);
		this.model.setSaveGraphEnabled(!this.model.isGraphSaved());
	}

	/**
	 * Doing: Enables or disabled the traversal player.
	 * 
	 * @param enabled
	 *            the enabled to set
	 * @throws Exception
	 */
	void enableTraversalPlayer(boolean enabled) throws Exception {
		try {
			if (enabled)
				this.model.getAnimationStateHandler().handleIdle();
			else
				this.model.getAnimationStateHandler().handleOff();
		} catch (Exception e) {
			throw e;
		}
	}

}
