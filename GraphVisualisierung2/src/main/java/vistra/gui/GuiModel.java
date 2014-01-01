package vistra.gui;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.ResourceBundle;

import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;

import vistra.core.graph.IExtendedGraph;
import vistra.core.graph.item.IVertexLayout;
import vistra.core.traversal.ITraversal;
import vistra.gui.control.IControl.EventSource;
import vistra.gui.control.state.IAnimationStateHandler;
import vistra.gui.control.state.IParameterStateHandler;
import vistra.gui.control.state.ISbsStateHandler;

/**
 * A model as in MVC holding some fields and its getter and setter methods.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class GuiModel extends Observable implements IGuiModel {

	/* i18n */
	private ResourceBundle resourceBundle;
	private String shortcutsMessage;
	private String aboutMessage;

	/* Menu */
	// Action listener
	private ActionListener i18nListener;
	private ActionListener modeListener;
	private ActionListener shortcutsListener;
	private ActionListener aboutListener;
	private ActionListener quitListener;
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
	private boolean editEnabled;
	private boolean pickingEnabled;
	private boolean vertexEnabled;
	private boolean edgeEnabled;
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
	private IExtendedGraph graph;
	private IVertexLayout start;
	private IVertexLayout end;
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
	private ISbsStateHandler stepByStepStateHandler;
	private int steplength;
	private boolean steplengthEnabled;
	private boolean toBeginningEnabled;
	private boolean backwardEnabled;
	private boolean forwardEnabled;
	private boolean toEndEnabled;
	// Animation
	private IAnimationStateHandler animationStateHandler;
	private int delay;
	private boolean delayEnabled;
	private boolean playEnabled;
	private String pauseLabel;
	private EventSource pauseEvent;
	private boolean pauseEnabled;
	private boolean stopEnabled;

	/* Protocol */
	private StringBuilder protocol;

	/**
	 * Main constructor.
	 */
	public GuiModel() {
		super();

		/* i18n */
		this.resourceBundle = null;
		this.shortcutsMessage = "";
		this.aboutMessage = "";

		/* Menu */
		// Action listener
		this.i18nListener = null;
		this.modeListener = null;
		this.shortcutsListener = null;
		this.aboutListener = null;
		this.quitListener = null;
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
		this.editEnabled = false;
		this.pickingEnabled = false;
		this.vertexEnabled = false;
		this.edgeEnabled = false;
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
		this.parameterStateHandler = null;
		// Graph
		this.graph = null;
		this.start = null;
		this.end = null;
		this.graphFile = false;
		this.graphSaved = false;
		this.mode = null;
		// Algorithm
		this.algorithms = null;
		this.algorithmsEnabled = false;
		this.selectedAlgorithmIndex = 0;
		this.algorithmDescription = " ";

		/* Traversal */
		this.traversal = null;
		this.progress = 0;
		// Step-by-Step
		this.stepByStepStateHandler = null;
		this.steplength = 1;
		this.steplengthEnabled = false;
		this.toBeginningEnabled = false;
		this.backwardEnabled = false;
		this.forwardEnabled = false;
		this.toEndEnabled = false;
		// Animation
		this.animationStateHandler = null;
		this.delay = 1;
		this.delayEnabled = false;
		this.playEnabled = false;
		this.pauseLabel = "";
		this.pauseEvent = null;
		this.pauseEnabled = false;
		this.stopEnabled = false;

		/* Protocol */
		this.protocol = new StringBuilder();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMenuEnabled(boolean menuEnabled) {
		// Menu
		this.setMenuFileEnabled(menuEnabled);
		this.setMenuModeEnabled(menuEnabled);
		this.setMenuI18nEnabled(menuEnabled);
		this.setMenuHelpEnabled(menuEnabled);
	}

	/**
	 * {@inheritDoc}
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

		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMenuModeEnabled(boolean menuEnabled) {
		// Menu
		this.setSwitchModeEnabled(menuEnabled);
		// MenuItem
		this.setMenuEditEnabled(menuEnabled);
		this.setPickingEnabled(menuEnabled);

		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMenuEditEnabled(boolean menuEnabled) {
		// Menu
		this.setEditEnabled(menuEnabled);
		// MenuItem
		this.setVertexEnabled(menuEnabled);
		this.setEdgeEnabled(menuEnabled);

		this.setChanged();
	}

	/**
	 * {@inheritDoc}
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

		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMenuHelpEnabled(boolean menuEnabled) {
		// Menu
		this.setHelpEnabled(menuEnabled);
		// MenuItem
		this.setShortcutsEnabled(menuEnabled);
		this.setAboutEnabled(menuEnabled);

		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTraversalEnabled(boolean menuEnabled) {
		this.setStepByStepEnabled(menuEnabled);
		this.setAnimationEnabled(menuEnabled);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStepByStepEnabled(boolean menuEnabled) {
		// spinner
		this.setSteplengthEnabled(menuEnabled);
		// button
		this.setToBeginningEnabled(menuEnabled);
		this.setBackwardEnabled(menuEnabled);
		this.setForwardEnabled(menuEnabled);
		this.setToEndEnabled(menuEnabled);

		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAnimationEnabled(boolean menuEnabled) {
		// spinner
		this.setDelayEnabled(menuEnabled);
		// button
		this.setPlayEnabled(menuEnabled);
		this.setPauseEnabled(menuEnabled);
		this.setStopEnabled(menuEnabled);

		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getResourceBundle()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getShortcutsMessage()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getShortcutsMessage() {
		return shortcutsMessage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getAboutMessage()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAboutMessage() {
		return aboutMessage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getI18nListener()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ActionListener getI18nListener() {
		return i18nListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getModeListener()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ActionListener getModeListener() {
		return modeListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getShortcutsListener()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ActionListener getShortcutsListener() {
		return shortcutsListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getAboutListener()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ActionListener getAboutListener() {
		return aboutListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getQuitListener()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ActionListener getQuitListener() {
		return quitListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isFileEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isFileEnabled() {
		return fileEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isNewEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isNewEnabled() {
		return newEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isUndirectedEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isUndirectedEnabled() {
		return undirectedEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isDirectedEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDirectedEnabled() {
		return directedEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isOpenEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isOpenEnabled() {
		return openEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isSaveEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSaveEnabled() {
		return saveEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isSaveAsEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSaveAsEnabled() {
		return saveAsEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isQuitEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isQuitEnabled() {
		return quitEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isSwitchModeEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSwitchModeEnabled() {
		return switchModeEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isEditEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEditEnabled() {
		return editEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isPickingEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isPickingEnabled() {
		return pickingEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isVertexEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isVertexEnabled() {
		return vertexEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isEdgeEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEdgeEnabled() {
		return edgeEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isI18nEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isI18nEnabled() {
		return i18nEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isDeCHEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDeCHEnabled() {
		return deCHEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isDeDEEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDeDEEnabled() {
		return deDEEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isFrFREnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isFrFREnabled() {
		return frFREnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isEnGBEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnGBEnabled() {
		return enGBEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isEnUSEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnUSEnabled() {
		return enUSEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isHelpEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isHelpEnabled() {
		return helpEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isShortcutsEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isShortcutsEnabled() {
		return shortcutsEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isAboutEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAboutEnabled() {
		return aboutEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getParameterStateHandler()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IParameterStateHandler getParameterStateHandler() {
		return parameterStateHandler;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getGraph()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IExtendedGraph getGraph() {
		return graph;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getStart()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IVertexLayout getStart() {
		return start;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getEnd()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IVertexLayout getEnd() {
		return end;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isGraphFile()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isGraphFile() {
		return graphFile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isGraphSaved()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isGraphSaved() {
		return graphSaved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getAlgorithms()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getAlgorithms() {
		return algorithms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isAlgorithmsEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAlgorithmsEnabled() {
		return algorithmsEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getSelectedAlgorithmIndex()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSelectedAlgorithmIndex() {
		return selectedAlgorithmIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getAlgorithmDescription()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAlgorithmDescription() {
		return algorithmDescription;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getTraversal()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITraversal getTraversal() {
		return traversal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getProgress()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getProgress() {
		return progress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getStepByStepStateHandler()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ISbsStateHandler getStepByStepStateHandler() {
		return stepByStepStateHandler;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getSteplength()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSteplength() {
		return steplength;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isSteplengthEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSteplengthEnabled() {
		return steplengthEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isToBeginningEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isToBeginningEnabled() {
		return toBeginningEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isBackwardEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isBackwardEnabled() {
		return backwardEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isForwardEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isForwardEnabled() {
		return forwardEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isToEndEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isToEndEnabled() {
		return toEndEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getAnimationStateHandler()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IAnimationStateHandler getAnimationStateHandler() {
		return animationStateHandler;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getDelay()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDelay() {
		return delay;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isDelayEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDelayEnabled() {
		return delayEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isPlayEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isPlayEnabled() {
		return playEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getPauseLabel()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPauseLabel() {
		return pauseLabel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getPauseEvent()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public EventSource getPauseEvent() {
		return pauseEvent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isPauseEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isPauseEnabled() {
		return pauseEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#isStopEnabled()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isStopEnabled() {
		return stopEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getProtocol()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public StringBuilder getProtocol() {
		return protocol;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setResourceBundle(java.util.ResourceBundle)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setShortcutsMessage(java.lang.String)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setShortcutsMessage(String shortcutsMessage) {
		this.shortcutsMessage = shortcutsMessage;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setAboutMessage(java.lang.String)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAboutMessage(String aboutMessage) {
		this.aboutMessage = aboutMessage;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setI18nListener(java.awt.event.ActionListener)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setI18nListener(ActionListener i18nListener) {
		this.i18nListener = i18nListener;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setModeListener(java.awt.event.ActionListener)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setModeListener(ActionListener modeListener) {
		this.modeListener = modeListener;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vistra.gui.IGuiModel#setShortcutsListener(java.awt.event.ActionListener)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setShortcutsListener(ActionListener shortcutsListener) {
		this.shortcutsListener = shortcutsListener;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setAboutListener(java.awt.event.ActionListener)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAboutListener(ActionListener aboutListener) {
		this.aboutListener = aboutListener;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setQuitListener(java.awt.event.ActionListener)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setQuitListener(ActionListener quitListener) {
		this.quitListener = quitListener;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setFileEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFileEnabled(boolean fileEnabled) {
		this.fileEnabled = fileEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setNewEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNewEnabled(boolean newEnabled) {
		this.newEnabled = newEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setUndirectedEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUndirectedEnabled(boolean undirectedEnabled) {
		this.undirectedEnabled = undirectedEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setDirectedEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDirectedEnabled(boolean directedEnabled) {
		this.directedEnabled = directedEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setOpenEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setOpenEnabled(boolean openEnabled) {
		this.openEnabled = openEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setSaveEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSaveEnabled(boolean saveEnabled) {
		this.saveEnabled = saveEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setSaveAsEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSaveAsEnabled(boolean saveAsEnabled) {
		this.saveAsEnabled = saveAsEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setQuitEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setQuitEnabled(boolean quitEnabled) {
		this.quitEnabled = quitEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setSwitchModeEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSwitchModeEnabled(boolean switchModeEnabled) {
		this.switchModeEnabled = switchModeEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setEditEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEditEnabled(boolean editEnabled) {
		this.editEnabled = editEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setPickingEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPickingEnabled(boolean pickingEnabled) {
		this.pickingEnabled = pickingEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setVertexEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setVertexEnabled(boolean vertexEnabled) {
		this.vertexEnabled = vertexEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setEdgeEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEdgeEnabled(boolean edgeEnabled) {
		this.edgeEnabled = edgeEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setI18nEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setI18nEnabled(boolean i18nEnabled) {
		this.i18nEnabled = i18nEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setDeCHEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDeCHEnabled(boolean deCHEnabled) {
		this.deCHEnabled = deCHEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setDeDEEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDeDEEnabled(boolean deDEEnabled) {
		this.deDEEnabled = deDEEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setFrFREnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFrFREnabled(boolean frFREnabled) {
		this.frFREnabled = frFREnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setEnGBEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEnGBEnabled(boolean enGBEnabled) {
		this.enGBEnabled = enGBEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setEnUSEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEnUSEnabled(boolean enUSEnabled) {
		this.enUSEnabled = enUSEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setHelpEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setHelpEnabled(boolean helpEnabled) {
		this.helpEnabled = helpEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setShortcutsEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setShortcutsEnabled(boolean shortcutsEnabled) {
		this.shortcutsEnabled = shortcutsEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setAboutEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAboutEnabled(boolean aboutEnabled) {
		this.aboutEnabled = aboutEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vistra.gui.IGuiModel#setParameterStateHandler(vistra.gui.control.state
	 * .IParameterStateHandler)
	 */
	/**
	 * {@inheritDoc}
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
	 * @see vistra.gui.IGuiModel#setGraph(vistra.core.graph.IExtendedGraph)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraph(IExtendedGraph graph) {
		this.graph = graph;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setStart(vistra.core.graph.item.IVertexLayout)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStart(IVertexLayout start) {
		this.start = start;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setEnd(vistra.core.graph.item.IVertexLayout)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEnd(IVertexLayout end) {
		this.end = end;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setGraphFile(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraphFile(boolean graphFile) {
		this.graphFile = graphFile;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setGraphSaved(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraphSaved(boolean graphSaved) {
		this.graphSaved = graphSaved;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setAlgorithms(java.lang.String[])
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAlgorithms(String[] algorithms) {
		this.algorithms = algorithms;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setAlgorithmsEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAlgorithmsEnabled(boolean algorithmsEnabled) {
		this.algorithmsEnabled = algorithmsEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setSelectedAlgorithmIndex(int)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSelectedAlgorithmIndex(int selectedAlgorithmIndex) {
		this.selectedAlgorithmIndex = selectedAlgorithmIndex;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setAlgorithmDescription(java.lang.String)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAlgorithmDescription(String algorithmDescription) {
		this.algorithmDescription = algorithmDescription;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setTraversal(vistra.core.traversal.ITraversal)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTraversal(ITraversal traversal) {
		this.traversal = traversal;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setProgress(int)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setProgress(int progress) {
		this.progress = progress;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vistra.gui.IGuiModel#setStepByStepStateHandler(vistra.gui.control.state
	 * .ISbsStateHandler)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStepByStepStateHandler(
			ISbsStateHandler stepByStepStateHandler) {
		this.stepByStepStateHandler = stepByStepStateHandler;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setSteplength(int)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSteplength(int steplength) {
		this.steplength = steplength;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setSteplengthEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSteplengthEnabled(boolean steplengthEnabled) {
		this.steplengthEnabled = steplengthEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setToBeginningEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setToBeginningEnabled(boolean toBeginningEnabled) {
		this.toBeginningEnabled = toBeginningEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setBackwardEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setBackwardEnabled(boolean backwardEnabled) {
		this.backwardEnabled = backwardEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setForwardEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setForwardEnabled(boolean forwardEnabled) {
		this.forwardEnabled = forwardEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setToEndEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setToEndEnabled(boolean toEndEnabled) {
		this.toEndEnabled = toEndEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vistra.gui.IGuiModel#setAnimationStateHandler(vistra.gui.control.state
	 * .IAnimationStateHandler)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAnimationStateHandler(
			IAnimationStateHandler animationStateHandler) {
		this.animationStateHandler = animationStateHandler;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setDelay(int)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDelay(int delay) {
		this.delay = delay;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setDelayEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDelayEnabled(boolean delayEnabled) {
		this.delayEnabled = delayEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setPlayEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPlayEnabled(boolean playEnabled) {
		this.playEnabled = playEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setPauseLabel(java.lang.String)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPauseLabel(String pauseLabel) {
		this.pauseLabel = pauseLabel;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vistra.gui.IGuiModel#setPauseEvent(vistra.gui.control.IControl.EventSource
	 * )
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPauseEvent(EventSource pauseEvent) {
		this.pauseEvent = pauseEvent;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setPauseEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPauseEnabled(boolean pauseEnabled) {
		this.pauseEnabled = pauseEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setStopEnabled(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStopEnabled(boolean stopEnabled) {
		this.stopEnabled = stopEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setProtocol(java.lang.StringBuilder)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setProtocol(StringBuilder protocol) {
		this.protocol = protocol;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#getMode()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Mode getMode() {
		return mode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.gui.IGuiModel#setMode(edu.uci.ics.jung.visualization.control.
	 * ModalGraphMouse)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMode(Mode mode) {
		this.mode = mode;
		this.setChanged();
	}

}
