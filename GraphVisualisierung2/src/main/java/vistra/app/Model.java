package vistra.app;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.ResourceBundle;

import vistra.app.control.state.IAnimation;
import vistra.app.control.state.IParameterStateHandler;
import vistra.app.control.state.IStepByStep;
import vistra.framework.graph.ILayoutGraph;
import vistra.framework.graph.item.ILayoutVertex;
import vistra.framework.traversal.ITraversal;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;

/**
 * A model as in MVC holding some fields and its getter and setter methods.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class Model extends Observable implements IModel {

	private Container top;

	/* i18n */
	private ResourceBundle resourceBundle;
	private String shortcutsMessage;
	private String aboutMessage;

	/* Menu */
	// Action listener
	private ActionListener i18nListener;
	private ActionListener shortcutsListener;
	private ActionListener aboutListener;
	// File
	private boolean fileEnabled;
	private boolean newEnabled;
	private boolean undirectedEnabled;
	private boolean directedEnabled;
	private boolean openEnabled;
	private boolean saveEnabled;
	private boolean saveAsEnabled;
	private boolean quitEnabled;
	// Edit
	private boolean switchModeEnabled;
	private boolean selectEditingModeEnabled;
	private boolean selectPickingModeEnabled;
	private boolean editVertexEnabled;
	private boolean editEdgeEnabled;
	// I18n
	private boolean i18nEnabled;
	private boolean deCHEnabled;
	private boolean deDEEnabled;
	private boolean frFREnabled;
	private boolean enGBEnabled;
	private boolean enUSEnabled;
	// Info
	private boolean helpEnabled;
	private boolean shortcutsEnabled;
	private boolean aboutEnabled;

	/* Parameter */
	private IParameterStateHandler parameterStateHandler;
	// Graph
	private ILayoutGraph graph;
	private ILayoutVertex start;
	private ILayoutVertex end;
	private ILayoutVertex focus;
	private boolean graphFile;
	private boolean graphSaved;
	private Mode mode;
	// Algorithm
	private String[] algorithms;
	private boolean algorithmsEnabled;
	private int selectedAlgorithmIndex;
	private String algorithmDescription;

	/* Traversal */
	private ITraversal traversal;
	private int progress;
	// Step-by-Step
	private IStepByStep stepByStep;
	private int steplength;
	private boolean steplengthEnabled;
	private boolean toBeginningEnabled;
	private boolean backwardEnabled;
	private boolean forwardEnabled;
	private boolean toEndEnabled;
	// Animation
	private IAnimation animation;
	private int delay;
	private boolean delayEnabled;
	private boolean playEnabled;
	private String pauseLabel;
	private String pauseActionCommand;
	private boolean pauseEnabled;
	private boolean stopEnabled;

	/* Protocol */
	private StringBuilder protocol;

	/**
	 * Main constructor.
	 */
	public Model() {
		super();

		this.top = null;

		/* i18n */
		this.resourceBundle = null;
		this.shortcutsMessage = "";
		this.aboutMessage = "";

		/* Menu */
		// File
		this.fileEnabled = false;
		this.newEnabled = false;
		this.undirectedEnabled = false;
		this.directedEnabled = false;
		this.openEnabled = false;
		this.saveEnabled = false;
		this.saveAsEnabled = false;
		this.quitEnabled = false;
		// Edit
		this.switchModeEnabled = false;
		this.selectEditingModeEnabled = false;
		this.selectPickingModeEnabled = false;
		this.editVertexEnabled = false;
		this.editEdgeEnabled = false;
		// i18n
		this.i18nEnabled = false;
		this.deCHEnabled = false;
		this.deDEEnabled = false;
		this.frFREnabled = false;
		this.enGBEnabled = false;
		this.enUSEnabled = false;
		// Info
		this.helpEnabled = false;
		this.shortcutsEnabled = false;
		this.aboutEnabled = false;

		/* Parameter */
		// Graph
		this.graph = null;
		this.start = null;
		this.end = null;
		this.focus = null;
		this.graphFile = false;
		this.graphSaved = false;
		this.mode = null;
		// Algorithm
		this.algorithms = null;
		this.algorithmsEnabled = false;
		this.selectedAlgorithmIndex = 0;
		this.algorithmDescription = "";

		/* Traversal */
		this.traversal = null;
		this.progress = 0;
		// Step-by-Step
		this.steplength = 1;
		this.steplengthEnabled = false;
		this.toBeginningEnabled = false;
		this.backwardEnabled = false;
		this.forwardEnabled = false;
		this.toEndEnabled = false;
		// Animation
		this.delay = 1;
		this.delayEnabled = false;
		this.playEnabled = false;
		this.pauseLabel = "";
		this.pauseActionCommand = null;
		this.pauseEnabled = false;
		this.stopEnabled = false;

		/* Protocol */
		this.protocol = new StringBuilder();

		/**/
		// Action listener
		this.i18nListener = null;
		this.shortcutsListener = null;
		this.aboutListener = null;
		// State handler
		this.animation = null;
		this.stepByStep = null;
		this.parameterStateHandler = null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setMenuEnabled(boolean)
	 */
	@Override
	public void setMenuEnabled(boolean menuEnabled) {
		// Menu
		this.setMenuFileEnabled(menuEnabled);
		this.setMenuModeEnabled(menuEnabled);
		this.setMenuEditEnabled(menuEnabled);
		this.setMenuI18nEnabled(menuEnabled);
		this.setMenuHelpEnabled(menuEnabled);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setMenuFileEnabled(boolean)
	 */
	@Override
	public void setMenuFileEnabled(boolean menuEnabled) {
		// Menu
		this.setFileEnabled(menuEnabled);
		// MenuItem
		this.setNewEnabled(menuEnabled);
		this.setUndirectedEnabled(menuEnabled);
		this.setDirectedEnabled(menuEnabled);
		this.setOpenEnabled(menuEnabled);
		this.setSaveEnabled(menuEnabled);
		this.setSaveAsEnabled(menuEnabled);
		this.setQuitEnabled(menuEnabled);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setMenuModeEnabled(boolean)
	 */
	@Override
	public void setMenuModeEnabled(boolean menuEnabled) {
		// Menu
		this.setSwitchModeEnabled(menuEnabled);
		// MenuItem
		this.setSelectEditingModeEnabled(menuEnabled);
		this.setSelectPickingModeEnabled(menuEnabled);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setMenuEditEnabled(boolean)
	 */
	@Override
	public void setMenuEditEnabled(boolean menuEnabled) {
		this.setEditVertexEnabled(menuEnabled);
		this.setEditEdgeEnabled(menuEnabled);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setMenuI18nEnabled(boolean)
	 */
	@Override
	public void setMenuI18nEnabled(boolean menuEnabled) {
		// Menu
		this.setI18nEnabled(menuEnabled);
		// MenuItem
		this.setDeCHEnabled(menuEnabled);
		this.setDeDEEnabled(menuEnabled);
		this.setFrFREnabled(menuEnabled);
		this.setEnGBEnabled(menuEnabled);
		this.setEnUSEnabled(menuEnabled);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setMenuHelpEnabled(boolean)
	 */
	@Override
	public void setMenuHelpEnabled(boolean menuEnabled) {
		// Menu
		this.setHelpEnabled(menuEnabled);
		// MenuItem
		this.setShortcutsEnabled(menuEnabled);
		this.setAboutEnabled(menuEnabled);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setTraversalEnabled(boolean)
	 */
	@Override
	public void setTraversalEnabled(boolean menuEnabled) {
		this.setSbsEnabled(menuEnabled);
		this.setAnimationEnabled(menuEnabled);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setSbsEnabled(boolean)
	 */
	@Override
	public void setSbsEnabled(boolean menuEnabled) {
		// spinner
		this.setSteplengthEnabled(menuEnabled);
		// button
		this.setToBeginningEnabled(menuEnabled);
		this.setBackwardEnabled(menuEnabled);
		this.setForwardEnabled(menuEnabled);
		this.setToEndEnabled(menuEnabled);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setAnimationEnabled(boolean)
	 */
	@Override
	public void setAnimationEnabled(boolean menuEnabled) {
		// spinner
		this.setDelayEnabled(menuEnabled);
		// button
		this.setPlayEnabled(menuEnabled);
		this.setPauseEnabled(menuEnabled);
		this.setStopEnabled(menuEnabled);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getTop()
	 */
	@Override
	public Container getTop() {
		return this.top;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setTop(java.awt.Container)
	 */
	@Override
	public void setTop(Container top) {
		this.top = top;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getResourceBundle()
	 */
	@Override
	public ResourceBundle getResourceBundle() {
		return this.resourceBundle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setResourceBundle(java.util.ResourceBundle)
	 */
	@Override
	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getShortcutsMessage()
	 */
	@Override
	public String getShortcutsMessage() {
		return this.shortcutsMessage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setShortcutsMessage(java.lang.String)
	 */
	@Override
	public void setShortcutsMessage(String shortcutsMessage) {
		this.shortcutsMessage = shortcutsMessage;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getAboutMessage()
	 */
	@Override
	public String getAboutMessage() {
		return this.aboutMessage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setAboutMessage(java.lang.String)
	 */
	@Override
	public void setAboutMessage(String aboutMessage) {
		this.aboutMessage = aboutMessage;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getI18nListener()
	 */
	@Override
	public ActionListener getI18nListener() {
		return this.i18nListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setI18nListener(java.awt.event.ActionListener)
	 */
	@Override
	public void setI18nListener(ActionListener i18nListener) {
		this.i18nListener = i18nListener;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getShortcutsListener()
	 */
	@Override
	public ActionListener getShortcutsListener() {
		return this.shortcutsListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vistra.app.IModel#setShortcutsListener(java.awt.event.ActionListener)
	 */
	@Override
	public void setShortcutsListener(ActionListener shortcutsListener) {
		this.shortcutsListener = shortcutsListener;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getAboutListener()
	 */
	@Override
	public ActionListener getAboutListener() {
		return this.aboutListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setAboutListener(java.awt.event.ActionListener)
	 */
	@Override
	public void setAboutListener(ActionListener aboutListener) {
		this.aboutListener = aboutListener;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isFileEnabled()
	 */
	@Override
	public boolean isFileEnabled() {
		return this.fileEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setFileEnabled(boolean)
	 */
	@Override
	public void setFileEnabled(boolean fileEnabled) {
		this.fileEnabled = fileEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isNewEnabled()
	 */
	@Override
	public boolean isNewEnabled() {
		return this.newEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setNewEnabled(boolean)
	 */
	@Override
	public void setNewEnabled(boolean newEnabled) {
		this.newEnabled = newEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isUndirectedEnabled()
	 */
	@Override
	public boolean isUndirectedEnabled() {
		return this.undirectedEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setUndirectedEnabled(boolean)
	 */
	@Override
	public void setUndirectedEnabled(boolean undirectedEnabled) {
		this.undirectedEnabled = undirectedEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isDirectedEnabled()
	 */
	@Override
	public boolean isDirectedEnabled() {
		return this.directedEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setDirectedEnabled(boolean)
	 */
	@Override
	public void setDirectedEnabled(boolean directedEnabled) {
		this.directedEnabled = directedEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isOpenEnabled()
	 */
	@Override
	public boolean isOpenEnabled() {
		return this.openEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setOpenEnabled(boolean)
	 */
	@Override
	public void setOpenEnabled(boolean openEnabled) {
		this.openEnabled = openEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isSaveEnabled()
	 */
	@Override
	public boolean isSaveEnabled() {
		return this.saveEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setSaveEnabled(boolean)
	 */
	@Override
	public void setSaveEnabled(boolean saveEnabled) {
		this.saveEnabled = saveEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isSaveAsEnabled()
	 */
	@Override
	public boolean isSaveAsEnabled() {
		return this.saveAsEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setSaveAsEnabled(boolean)
	 */
	@Override
	public void setSaveAsEnabled(boolean saveAsEnabled) {
		this.saveAsEnabled = saveAsEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isQuitEnabled()
	 */
	@Override
	public boolean isQuitEnabled() {
		return this.quitEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setQuitEnabled(boolean)
	 */
	@Override
	public void setQuitEnabled(boolean quitEnabled) {
		this.quitEnabled = quitEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isSwitchModeEnabled()
	 */
	@Override
	public boolean isSwitchModeEnabled() {
		return this.switchModeEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setSwitchModeEnabled(boolean)
	 */
	@Override
	public void setSwitchModeEnabled(boolean switchModeEnabled) {
		this.switchModeEnabled = switchModeEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isSelectEditingModeEnabled()
	 */
	@Override
	public boolean isSelectEditingModeEnabled() {
		return this.selectEditingModeEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setSelectEditingModeEnabled(boolean)
	 */
	@Override
	public void setSelectEditingModeEnabled(boolean selectEditingModeEnabled) {
		this.selectEditingModeEnabled = selectEditingModeEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isSelectPickingModeEnabled()
	 */
	@Override
	public boolean isSelectPickingModeEnabled() {
		return this.selectPickingModeEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setSelectPickingModeEnabled(boolean)
	 */
	@Override
	public void setSelectPickingModeEnabled(boolean selectPickingModeEnabled) {
		this.selectPickingModeEnabled = selectPickingModeEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isEditVertexEnabled()
	 */
	@Override
	public boolean isEditVertexEnabled() {
		return this.editVertexEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setEditVertexEnabled(boolean)
	 */
	@Override
	public void setEditVertexEnabled(boolean editVertexEnabled) {
		this.editVertexEnabled = editVertexEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isEditEdgeEnabled()
	 */
	@Override
	public boolean isEditEdgeEnabled() {
		return this.editEdgeEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setEditEdgeEnabled(boolean)
	 */
	@Override
	public void setEditEdgeEnabled(boolean editEdgeEnabled) {
		this.editEdgeEnabled = editEdgeEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isI18nEnabled()
	 */
	@Override
	public boolean isI18nEnabled() {
		return this.i18nEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setI18nEnabled(boolean)
	 */
	@Override
	public void setI18nEnabled(boolean i18nEnabled) {
		this.i18nEnabled = i18nEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isDeCHEnabled()
	 */
	@Override
	public boolean isDeCHEnabled() {
		return this.deCHEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setDeCHEnabled(boolean)
	 */
	@Override
	public void setDeCHEnabled(boolean deCHEnabled) {
		this.deCHEnabled = deCHEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isDeDEEnabled()
	 */
	@Override
	public boolean isDeDEEnabled() {
		return this.deDEEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setDeDEEnabled(boolean)
	 */
	@Override
	public void setDeDEEnabled(boolean deDEEnabled) {
		this.deDEEnabled = deDEEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isFrFREnabled()
	 */
	@Override
	public boolean isFrFREnabled() {
		return this.frFREnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setFrFREnabled(boolean)
	 */
	@Override
	public void setFrFREnabled(boolean frFREnabled) {
		this.frFREnabled = frFREnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isEnGBEnabled()
	 */
	@Override
	public boolean isEnGBEnabled() {
		return this.enGBEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setEnGBEnabled(boolean)
	 */
	@Override
	public void setEnGBEnabled(boolean enGBEnabled) {
		this.enGBEnabled = enGBEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isEnUSEnabled()
	 */
	@Override
	public boolean isEnUSEnabled() {
		return this.enUSEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setEnUSEnabled(boolean)
	 */
	@Override
	public void setEnUSEnabled(boolean enUSEnabled) {
		this.enUSEnabled = enUSEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isHelpEnabled()
	 */
	@Override
	public boolean isHelpEnabled() {
		return this.helpEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setHelpEnabled(boolean)
	 */
	@Override
	public void setHelpEnabled(boolean helpEnabled) {
		this.helpEnabled = helpEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isShortcutsEnabled()
	 */
	@Override
	public boolean isShortcutsEnabled() {
		return this.shortcutsEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setShortcutsEnabled(boolean)
	 */
	@Override
	public void setShortcutsEnabled(boolean shortcutsEnabled) {
		this.shortcutsEnabled = shortcutsEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isAboutEnabled()
	 */
	@Override
	public boolean isAboutEnabled() {
		return this.aboutEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setAboutEnabled(boolean)
	 */
	@Override
	public void setAboutEnabled(boolean aboutEnabled) {
		this.aboutEnabled = aboutEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getParameterStateHandler()
	 */
	@Override
	public IParameterStateHandler getParameterStateHandler() {
		return this.parameterStateHandler;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setParameterStateHandler(vistra.app.control.state.
	 * IParameterStateHandler)
	 */
	@Override
	public void setParameterStateHandler(
			IParameterStateHandler parameterStateHandler) {
		this.parameterStateHandler = parameterStateHandler;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getGraph()
	 */
	@Override
	public ILayoutGraph getGraph() {
		return this.graph;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setGraph(vistra.framework.graph.ILayoutGraph)
	 */
	@Override
	public void setGraph(ILayoutGraph graph) {
		this.graph = graph;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getStart()
	 */
	@Override
	public ILayoutVertex getStart() {
		return this.start;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vistra.app.IModel#setStart(vistra.framework.graph.item.ILayoutVertex)
	 */
	@Override
	public void setStart(ILayoutVertex start) {
		this.start = start;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getEnd()
	 */
	@Override
	public ILayoutVertex getEnd() {
		return this.end;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setEnd(vistra.framework.graph.item.ILayoutVertex)
	 */
	@Override
	public void setEnd(ILayoutVertex end) {
		this.end = end;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getFocus()
	 */
	@Override
	public ILayoutVertex getFocus() {
		return this.focus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vistra.app.IModel#setFocus(vistra.framework.graph.item.ILayoutVertex)
	 */
	@Override
	public void setFocus(ILayoutVertex focus) {
		this.focus = focus;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isGraphFile()
	 */
	@Override
	public boolean isGraphFile() {
		return this.graphFile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setGraphFile(boolean)
	 */
	@Override
	public void setGraphFile(boolean graphFile) {
		this.graphFile = graphFile;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isGraphSaved()
	 */
	@Override
	public boolean isGraphSaved() {
		return this.graphSaved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setGraphSaved(boolean)
	 */
	@Override
	public void setGraphSaved(boolean graphSaved) {
		this.graphSaved = graphSaved;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getMode()
	 */
	@Override
	public Mode getMode() {
		return this.mode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setMode(edu.uci.ics.jung.visualization.control.
	 * ModalGraphMouse.Mode)
	 */
	@Override
	public void setMode(Mode mode) {
		this.mode = mode;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getAlgorithms()
	 */
	@Override
	public String[] getAlgorithms() {
		return this.algorithms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setAlgorithms(java.lang.String[])
	 */
	@Override
	public void setAlgorithms(String[] algorithms) {
		this.algorithms = algorithms;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isAlgorithmsEnabled()
	 */
	@Override
	public boolean isAlgorithmsEnabled() {
		return this.algorithmsEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setAlgorithmsEnabled(boolean)
	 */
	@Override
	public void setAlgorithmsEnabled(boolean algorithmsEnabled) {
		this.algorithmsEnabled = algorithmsEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getSelectedAlgorithmIndex()
	 */
	@Override
	public int getSelectedAlgorithmIndex() {
		return this.selectedAlgorithmIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setSelectedAlgorithmIndex(int)
	 */
	@Override
	public void setSelectedAlgorithmIndex(int selectedAlgorithmIndex) {
		this.selectedAlgorithmIndex = selectedAlgorithmIndex;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getAlgorithmDescription()
	 */
	@Override
	public String getAlgorithmDescription() {
		return this.algorithmDescription;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setAlgorithmDescription(java.lang.String)
	 */
	@Override
	public void setAlgorithmDescription(String algorithmDescription) {
		this.algorithmDescription = algorithmDescription;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getTraversal()
	 */
	@Override
	public ITraversal getTraversal() {
		return this.traversal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setTraversal(vistra.framework.ITraversal)
	 */
	@Override
	public void setTraversal(ITraversal traversal) {
		this.traversal = traversal;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getProgress()
	 */
	@Override
	public int getProgress() {
		return this.progress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setProgress(int)
	 */
	@Override
	public void setProgress(int progress) {
		this.progress = progress;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getStepByStep()
	 */
	@Override
	public IStepByStep getStepByStep() {
		return this.stepByStep;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vistra.app.IModel#setStepByStep(vistra.app.control.state.IStepByStep)
	 */
	@Override
	public void setStepByStep(IStepByStep stepByStep) {
		this.stepByStep = stepByStep;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getSteplength()
	 */
	@Override
	public int getSteplength() {
		return this.steplength;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setSteplength(int)
	 */
	@Override
	public void setSteplength(int steplength) {
		this.steplength = steplength;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isSteplengthEnabled()
	 */
	@Override
	public boolean isSteplengthEnabled() {
		return this.steplengthEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setSteplengthEnabled(boolean)
	 */
	@Override
	public void setSteplengthEnabled(boolean steplengthEnabled) {
		this.steplengthEnabled = steplengthEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isToBeginningEnabled()
	 */
	@Override
	public boolean isToBeginningEnabled() {
		return this.toBeginningEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setToBeginningEnabled(boolean)
	 */
	@Override
	public void setToBeginningEnabled(boolean toBeginningEnabled) {
		this.toBeginningEnabled = toBeginningEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isBackwardEnabled()
	 */
	@Override
	public boolean isBackwardEnabled() {
		return this.backwardEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setBackwardEnabled(boolean)
	 */
	@Override
	public void setBackwardEnabled(boolean backwardEnabled) {
		this.backwardEnabled = backwardEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isForwardEnabled()
	 */
	@Override
	public boolean isForwardEnabled() {
		return this.forwardEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setForwardEnabled(boolean)
	 */
	@Override
	public void setForwardEnabled(boolean forwardEnabled) {
		this.forwardEnabled = forwardEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isToEndEnabled()
	 */
	@Override
	public boolean isToEndEnabled() {
		return this.toEndEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setToEndEnabled(boolean)
	 */
	@Override
	public void setToEndEnabled(boolean toEndEnabled) {
		this.toEndEnabled = toEndEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getAnimation()
	 */
	@Override
	public IAnimation getAnimation() {
		return this.animation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setAnimation(vistra.app.control.state.IAnimation)
	 */
	@Override
	public void setAnimation(IAnimation animation) {
		this.animation = animation;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getDelay()
	 */
	@Override
	public int getDelay() {
		return this.delay;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setDelay(int)
	 */
	@Override
	public void setDelay(int delay) {
		this.delay = delay;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isDelayEnabled()
	 */
	@Override
	public boolean isDelayEnabled() {
		return this.delayEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setDelayEnabled(boolean)
	 */
	@Override
	public void setDelayEnabled(boolean delayEnabled) {
		this.delayEnabled = delayEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isPlayEnabled()
	 */
	@Override
	public boolean isPlayEnabled() {
		return this.playEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setPlayEnabled(boolean)
	 */
	@Override
	public void setPlayEnabled(boolean playEnabled) {
		this.playEnabled = playEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getPauseLabel()
	 */
	@Override
	public String getPauseLabel() {
		return this.pauseLabel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setPauseLabel(java.lang.String)
	 */
	@Override
	public void setPauseLabel(String pauseLabel) {
		this.pauseLabel = pauseLabel;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getPauseActionCommand()
	 */
	@Override
	public String getPauseActionCommand() {
		return this.pauseActionCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setPauseActionCommand(java.lang.String)
	 */
	@Override
	public void setPauseActionCommand(String pauseActionCommand) {
		this.pauseActionCommand = pauseActionCommand;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isPauseEnabled()
	 */
	@Override
	public boolean isPauseEnabled() {
		return this.pauseEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setPauseEnabled(boolean)
	 */
	@Override
	public void setPauseEnabled(boolean pauseEnabled) {
		this.pauseEnabled = pauseEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#isStopEnabled()
	 */
	@Override
	public boolean isStopEnabled() {
		return this.stopEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setStopEnabled(boolean)
	 */
	@Override
	public void setStopEnabled(boolean stopEnabled) {
		this.stopEnabled = stopEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#getProtocol()
	 */
	@Override
	public StringBuilder getProtocol() {
		return this.protocol;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.app.IModel#setProtocol(java.lang.StringBuilder)
	 */
	@Override
	public void setProtocol(StringBuilder protocol) {
		this.protocol = protocol;
		this.setChanged();
	}

}
